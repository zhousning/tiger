package app.controllers;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.PropertiesEditor;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import app.models.Role;
import app.models.User;
import app.services.RoleService;
import app.services.SubjectService;
import app.services.UsersService;


public class BaseController {
	
	@Autowired
	RoleService roleService;	

	@Autowired
	SubjectService subjectService;
	
	@Autowired
	UsersService userService;
	
	@Autowired
	ResourceBundleMessageSource messageSource;
	
	/*
	 * setAsText 表单提交到controller的时候执行
	 * getAsText controller到表单的时候执行，没有转换的必要可以不写
	 */

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new MyDateEditor());
        binder.registerCustomEditor(Double.class, new DoubleEditor()); 
        binder.registerCustomEditor(Integer.class, new IntegerEditor());
    }

    private class MyDateEditor extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
    
    public void initRole(User user) {
		Role role = roleService.findByName(messageSource.getMessage("roles.default", null, null));
		Set<Role> roles = new HashSet<Role>();
		roles.add(role);
		user.setRoles(roles);
	}

}
