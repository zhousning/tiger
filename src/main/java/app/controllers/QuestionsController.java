package app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import app.models.Question;
import app.services.QuestionService;

@Controller
@RequestMapping("/questions")
public class QuestionsController extends BaseController {

	@Autowired
	QuestionService questionService;
	
	@ModelAttribute
	public void getquestion(@RequestParam(value="id", required=false) Integer id, Map<String, Object> map) {
		if (id != null) {
			System.out.println(questionService.findById(id).toString());
			map.put("question", questionService.findById(id));
		}
	}
	
	@RequestMapping("")
	public String index(Map<String, Object> map) {
		map.put("questions", questionService.findAll());
		return "questions/index";
	}
	
	@RequestMapping("/new")
	public String fresh(Map<String, Object> map) {
		map.put("question", new Question());
		return "questions/new";
	}
	
	@RequestMapping(value="/{id}")
	public String show(@PathVariable("id") Integer id, Map<String, Object> map) {
		map.put("question", questionService.findById(id));
		return "questions/show";
	}
	
	@RequestMapping("/{id}/edit")
	public String edit(@PathVariable("id") Integer id, Map<String, Object> map) {	
		map.put("question", questionService.findById(id));
		return "questions/edit";
	}

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Integer id) {
		questionService.deleteById(id);
		return "redirect:/questions";
	}
	
	//创建完返回id
	@RequestMapping(value="", method=RequestMethod.POST)
	public String create(@Valid Question question, Errors result, Map<String, Object> map) {
		if(result.getErrorCount() > 0){
			for(FieldError error:result.getFieldErrors()){
				System.out.println(error.getField() + ":" + error.getDefaultMessage());
			}		
			//若验证出错, 则转向定制的页面
			return "/questions/new";
		}
		questionService.save(question);
		return "redirect:/questions/" + question.getId().toString();
	}
	
	@RequestMapping(value="", method=RequestMethod.PUT)
	public String update(@Valid Question question, Errors result, Map<String, Object> map) {
		if(result.getErrorCount() > 0){
			for(FieldError error:result.getFieldErrors()){
				System.out.println(error.getField() + ":" + error.getDefaultMessage());
			}		
			return "/questions/edit";
		}
		questionService.update(question);
		return "redirect:/questions/" + question.getId().toString();
	}

}
