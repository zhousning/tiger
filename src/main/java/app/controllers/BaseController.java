package app.controllers;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

import org.springframework.beans.propertyeditors.PropertiesEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;


public class BaseController {
	
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

}
