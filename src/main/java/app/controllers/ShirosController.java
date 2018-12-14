package app.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import app.daos.UserMapper;
import app.models.User;
import app.services.UsersService;

@Controller 
@RequestMapping("/users")
public class ShirosController {
	
	@Autowired
	UsersService userService;
	
	@ModelAttribute
	public void getUser(@RequestParam(value="id", required=false) Integer id, Map<String, Object> map) {
		if (id != null) {
			System.out.println(userService.getUserById(id).toString());
			map.put("user", userService.getUserById(id));
		}
	}
	
	@RequestMapping("/sign_up")
	public String registrationsNew(Map<String, Object> map) {
		map.put("user", new User());
		return "users/registrations/new";
	}
	
	@RequestMapping(value="/sign_up", method=RequestMethod.POST)
	public String registrationsCreate(@Valid User user, Errors result, Map<String, Object> map) {
		if(result.getErrorCount() > 0){
			for(FieldError error:result.getFieldErrors()){
				System.out.println(error.getField() + ":" + error.getDefaultMessage());
			}
			//若验证出错, 则转向定制的页面
			return "/users/registrations/new";
		}
		//使用邮箱注册，如果改成其他需要修改以下两行内容
		String principal = user.getEmail();
		User selectUser = userService.getUserByEmail(principal);
		if (selectUser == null) {
			String hashAlgorithmName = "MD5";
			Object credentials = user.getPassword();
			Object salt = ByteSource.Util.bytes(principal);;
			int hashIterations = 1024;
			
			Object password = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
			user.setPassword(password.toString());
			User userObject = userService.insert(user);
			return "redirect:/users/sign_in";
		} else {
			//throw new ConstraintViolationException(constraintViolations)
			return "/users/registrations/new";
		}	
	}
	
	@RequestMapping("/sign_in")
	public String sessionsNew(Map<String, Object> map) {
		map.put("user", new User());
		return "/users/sessions/new";
	}
	
	@RequestMapping(value="/sign_in", method=RequestMethod.POST)
	public String sessionsCreate(User user, Map<String, Object> map){
		Subject currentUser = SecurityUtils.getSubject();
		
		if (!currentUser.isAuthenticated()) {
        	// 把用户名和密码封装为 UsernamePasswordToken 对象
            UsernamePasswordToken token = new UsernamePasswordToken(user.getEmail(), user.getPassword());
            // rememberme
            //token.setRememberMe(true);
            try {
            	// 执行登录. 
                currentUser.login(token);
            } 
            // 所有认证时异常的父类. 
            catch (AuthenticationException ae) {
            	System.out.println("登录失败: " + ae.getMessage());
        		return "/users/sessions/new";
            }
        }

		return "redirect:/home";
	}
}
