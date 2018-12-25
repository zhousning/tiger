package app.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

import app.models.ExamPaper;
import app.models.Question;
import app.models.Subject;
import app.services.ExamPaperService;
import app.services.QuestionService;
import app.works.ExportDoc;

@Controller
@RequestMapping("/examPapers")
public class ExamPaperController extends BaseController {

	@Autowired
	ExamPaperService examPaperService;
	
	@Autowired
	QuestionService questionService;
	
	@ModelAttribute
	public void getexamPaper(@RequestParam(value="id", required=false) Integer id, Map<String, Object> map) {
		if (id != null) {
			System.out.println(examPaperService.findById(id).toString());
			map.put("examPaper", examPaperService.findById(id));
		}
	}
	
	@RequestMapping("/{id}/export_doc")
	public void exportDoc(@PathVariable("id") Integer id) throws Exception {
        ExportDoc maker = new ExportDoc("UTF-8");
        ExamPaper examPaper = examPaperService.findById(id);
        Set<Question> questions = examPaper.getQuestions();
        List<Object> multiples = new ArrayList<Object>();
        List<Object> essays = new ArrayList<Object>();
        Map<String, List<String>> examPointsMap = new HashMap<String, List<String>>();
        
        Integer sectAIndex = 0;
        Integer sectBIndex = 0;
        Iterator<Question> iterator = questions.iterator();
        while (iterator.hasNext()) {
			Question question = (Question) iterator.next();
			String tag = "";
			if (question.getType().equals(messageSource.getMessage("questions.multiple.code", null, null))) {
				Map<String, Object> map = new HashMap();
				sectAIndex += 1;
				map.put("index", sectAIndex.toString());
				map.put("question", question);
				multiples.add(map);
				
				tag = "A" + sectAIndex.toString();				
			} else {
				Map<String, Object> map = new HashMap();
				sectBIndex += 1;
				map.put("index", sectBIndex.toString());
				map.put("question", question);
				multiples.add(map);
				essays.add(question);
				
				tag = "B" + sectBIndex.toString();				
			}
			String examPoint = question.getExamPoint().getName();
			if (examPointsMap.containsKey(examPoint)) {
				examPointsMap.get(examPoint).add(tag);
			} else {
				List<String> list = new ArrayList<String>();
				examPointsMap.put(examPoint, list);
			}
		}
        
        Map<String, Object> template = new HashMap<String, Object>();
        template.put("paper", examPaper);
        template.put("subject", examPaper.getSubject());
        template.put("multiples", multiples);
        template.put("essays", essays);
        template.put("examPoints", examPointsMap);
        
        maker.exportDoc("D:\\test13.doc", template);
	}
	
	@RequestMapping("")
	public String index(Map<String, Object> map) {
		map.put("examPapers", examPaperService.findAll());
		return "examPapers/index";
	}
	
	@RequestMapping("/new")
	public String fresh(Map<String, Object> map) {
		currentUserSubjcets(map);
		map.put("examPaper", new ExamPaper());
		return "examPapers/new";
	}
	
	@RequestMapping(value="/{id}")
	public String show(@PathVariable("id") Integer id, Map<String, Object> map) {
		map.put("examPaper", examPaperService.findById(id));
		return "examPapers/show";
	}
	
	@RequestMapping("/{id}/edit")
	public String edit(@PathVariable("id") Integer id, Map<String, Object> map) {	
		currentUserSubjcets(map);
		map.put("examPaper", examPaperService.findById(id));
		return "examPapers/edit";
	}

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Integer id) {
		examPaperService.deleteById(id);
		return "redirect:/examPapers";
	}
	
	//创建完返回id
	@RequestMapping(value="", method=RequestMethod.POST)
	public String create(@Valid ExamPaper examPaper, @RequestParam(value="subject.id", required=false) Integer subjectId, Errors result, Map<String, Object> map) {
		if(result.getErrorCount() > 0){
			for(FieldError error:result.getFieldErrors()){
				System.out.println(error.getField() + ":" + error.getDefaultMessage());
			}		
			currentUserSubjcets(map);
			return "/examPapers/new";
		}
		if (subjectId != null) {
			Subject subject = subjectService.findById(subjectId);
			examPaper.setSubject(subject);
		}
		examPaperService.save(examPaper);
		return "redirect:/examPapers/" + examPaper.getId().toString() + "/sample_new";
	}
	
	
	@RequestMapping(value="", method=RequestMethod.PUT)
	public String update(@Valid ExamPaper examPaper, @RequestParam(value="subject.id", required=false) Integer subjectId, Errors result, Map<String, Object> map) {
		if(result.getErrorCount() > 0){
			for(FieldError error:result.getFieldErrors()){
				System.out.println(error.getField() + ":" + error.getDefaultMessage());
			}
			currentUserSubjcets(map);
			return "/examPapers/edit";
		}
		if (subjectId != null) {
			Subject subject = subjectService.findById(subjectId);
			examPaper.setSubject(subject);
		}
		examPaperService.update(examPaper);
		return "redirect:/examPapers/" + examPaper.getId().toString() + "/sample_new";
	}
	
	
	@RequestMapping(value="/{id}/sample_new")
	public String sampleNew(@PathVariable("id") Integer id, Map<String, Object> map) {
		ExamPaper examPaper = examPaperService.findById(id);
		prepareQuestions(examPaper, map);
		prepareExamPaperQuestion(examPaper, map);
		map.put("examPaper", examPaper);
		return "/examPapers/sample";
	}
	
	private void prepareQuestions(ExamPaper examPaper, Map<String, Object> map) {
		Subject subject = examPaper.getSubject();
		Set<Question> subjectQuestions = subject.getQuestions();
		List<Question> questions = new ArrayList<Question>();
		Iterator<Question> iterator = subjectQuestions.iterator();
		while (iterator.hasNext()) {
			Question question = (Question) iterator.next();
			if (question.getStatus().equals(messageSource.getMessage("question.status.approved", null, null))) {
				questions.add(question);
			}
		}
		map.put("questions", questions);
	}
	
	private void prepareExamPaperQuestion(ExamPaper examPaper, Map<String, Object> map) {
		List<Integer> questionIds = new ArrayList<Integer>();
		Set<Question> examQuestions = examPaper.getQuestions();
		Iterator<Question> qstIterator = examQuestions.iterator();
		while (qstIterator.hasNext()) {
			Question question = (Question) qstIterator.next();
			questionIds.add(question.getId());
		}
		examPaper.setQuestionIds(questionIds);
	}
	
	@RequestMapping(value="/sample_update", method=RequestMethod.PUT)
	public String sampleUpdate(@Valid ExamPaper examPaper,  @RequestParam(value = "questionIds", required = false) Integer[] questionIds, Errors result, Map<String, Object> map) {
		if(result.getErrorCount() > 0){
			for(FieldError error:result.getFieldErrors()){
				System.out.println(error.getField() + ":" + error.getDefaultMessage());
			}
			return "redirect:/examPapers/" + examPaper.getId().toString() + "/sample_new";
		}
		if (questionIds != null) {
			List<Question> questions = questionService.findByIds(questionIds);
			examPaper.setQuestions(new HashSet<Question>(questions));
		}
		examPaperService.update(examPaper);
		return "redirect:/examPapers/" + examPaper.getId().toString();
	}

}
