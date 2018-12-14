package app.controllers;

import java.util.Map;

import javax.jws.soap.SOAPBinding.Use;
import javax.validation.Valid;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestScope;


import app.models.User;
import app.services.UsersService;

@Controller
@RequestMapping("/users")
public class UsersController {

	@Autowired
	UsersService userService;
	
	@ModelAttribute
	public void getUser(@RequestParam(value="id", required=false) Integer id, Map<String, Object> map) {
		if (id != null) {
			System.out.println(userService.getUserById(id).toString());
			map.put("user", userService.getUserById(id));
		}
	}
	
	@RequestMapping("")
	public String index(Map<String, Object> map) {
		map.put("users", userService.getUsers());
		return "users/index";
	}

	@RequestMapping(value="/{id}")
	public String show(@PathVariable("id") Integer id, Map<String, Object> map) {
		map.put("user", userService.getUserById(id));
		return "users/show";
	}
	
	@RequestMapping("/{id}/edit")
	public String edit(@PathVariable("id") Integer id, Map<String, Object> map) {	
		map.put("user", userService.getUserById(id));
		return "users/edit";
	}

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Integer id) {
		userService.deleteById(id);
		return "redirect:/users";
	}
	
	@RequestMapping(value="", method=RequestMethod.PUT)
	public String update(@Valid User user, Errors result, Map<String, Object> map) {
		if(result.getErrorCount() > 0){
			for(FieldError error:result.getFieldErrors()){
				System.out.println(error.getField() + ":" + error.getDefaultMessage());
			}		
			return "/users/edit";
		}
		userService.updateUser(user);
		return "redirect:/users/" + user.getId().toString();
	}
	
	@RequestMapping("/new")
	public String fresh(Map<String, Object> map) {
		map.put("user", new User());
		return "users/new";
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public String create(@Valid User user, Errors result, Map<String, Object> map) {
		if(result.getErrorCount() > 0){
			for(FieldError error:result.getFieldErrors()){
				System.out.println(error.getField() + ":" + error.getDefaultMessage());
			}
			//若验证出错, 则转向定制的页面
			return "/users/new";
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
			return "redirect:/users";
		} else {
			//throw new ConstraintViolationException(constraintViolations)
			return "/users/new";
		}	
	}

}
