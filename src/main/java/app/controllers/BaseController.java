package app.controllers;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.PropertiesEditor;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import app.models.Level;
import app.models.Role;
import app.models.User;
import app.services.LevelService;
import app.services.RoleService;
import app.services.SubjectService;
import app.services.UsersService;

@Controller
public class BaseController {
	
	@Autowired
	RoleService roleService;	

	@Autowired
	SubjectService subjectService;
	
	@Autowired
	UsersService userService;
	
	@Autowired
	ResourceBundleMessageSource messageSource;
	
	@Autowired
	LevelService levelService;
	
/*	protected String multipleType = messageSource.getMessage("questions.multiple.code", null, null);
	protected String essayType = messageSource.getMessage("questions.essay.code", null, null);*/
	
	/*
	 * setAsText 表单提交到controller的时候执行
	 * getAsText controller到表单的时候执行，没有转换的必要可以不写
	 */

	/*@InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new MyDateEditor());
        binder.registerCustomEditor(Double.class, new DoubleEditor()); 
        binder.registerCustomEditor(Integer.class, new IntegerEditor());
        binder.registerCustomEditor(Long.class, new LongEditor());
        binder.registerCustomEditor(String.class, new StringEditor());
    }*/

    private class MyDateEditor extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;
            try {
            	date = format.parse(text);
            } catch (ParseException e) {
                format = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    date = format.parse(text);
                } catch (ParseException e1) {
                }
            }
            setValue(date);
        }
    }
    
    public class StringEditor extends PropertiesEditor  {    
        @Override    
        public void setAsText(String text) throws IllegalArgumentException { 
            if (text == null || text.equals("")) {    
                text = "";    
            }    
            setValue(text);
        }
        
      /* @Override    
        public String getAsText() {    
            return (getValue() != null) ? getValue().toString() : "";    
        }*/
    }  
    
    public class DoubleEditor extends PropertiesEditor  {    
        @Override    
        public void setAsText(String text) throws IllegalArgumentException { 
            if (text == null || text.equals("")) {    
                text = "0";    
            }    
            setValue(Double.parseDouble(text));    
        }    
        
       /* @Override    
        public String getAsText() {    
            return (getValue() != null) ? getValue().toString() : "";    
        }    */
    }  
    
    public class IntegerEditor extends PropertiesEditor {    
        @Override    
        public void setAsText(String text) throws IllegalArgumentException {  
            if (text == null || text.equals("")) {    
                text = "0";    
            }    
            setValue(Integer.parseInt(text));    
        }    
        
       /* @Override    
        public String getAsText() {    
            return (getValue() != null) ? getValue().toString() : "";    
        }   */ 
    }  
    
    public class LongEditor extends PropertiesEditor {    
        @Override    
        public void setAsText(String text) throws IllegalArgumentException {  
            if (text == null || text.equals("")) {    
                text = "";    
            }    
            setValue(Long.parseLong(text));    
        }    
        
       /* @Override    
        public String getAsText() {    
            return (getValue() != null) ? getValue().toString() : "";    
        }   */ 
    }  
    
    protected void initRole(User user) {
		Role role = roleService.findByName(messageSource.getMessage("roles.default", null, null));
		Set<Role> roles = new HashSet<Role>();
		roles.add(role);
		user.setRoles(roles);
	}
    
    protected User currentUser() {
    	Subject currentUser = SecurityUtils.getSubject();
		String principal = currentUser.getPrincipal().toString();
		User user = userService.getUserByEmail(principal);
		return user;
	}
    
	protected void currentUserSubjcets(Map<String, Object> map) {
		Set<app.models.Subject> subjects = currentUser().getSubjects();
		map.put("subjects", subjects);
	}
	
	protected void currentUserQuestions(Map<String, Object> map) {
		Set<app.models.Question> questions = currentUser().getQuestions();
		map.put("questions", questions);
	}
	
	protected void levels(Map<String, Object> map) {
		List<Level> levels = levelService.findAll();
		map.put("levels", levels);
	}

}
