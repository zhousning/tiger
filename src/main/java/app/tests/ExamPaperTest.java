package app.tests;


import static org.hamcrest.CoreMatchers.nullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mysql.fabric.xmlrpc.base.Data;

import antlr.build.Tool;
import app.models.Attachment;
import app.models.ExamPaper;
import app.models.Question;
import app.models.Role;
import app.models.Subject;
import app.models.User;
import app.services.ExamPaperService;
import app.services.QuestionService;
import app.services.SubjectService;
import app.services.UsersService;
import net.sf.jsqlparser.statement.delete.Delete;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class ExamPaperTest {
	
	
	@Autowired
	QuestionService questionService;
	@Autowired
	UsersService userService;
	@Autowired
	ExamPaperService examPaperService; 
	@Autowired
	ResourceBundleMessageSource messageSource;
	
	@Test
	public void Tool() throws IOException {    
		Integer id = 1;
		Integer myInteger = 1;
		System.out.println(id == myInteger);
	}
	

	@Test
	public void create() throws ParseException {
		Attachment attachment = new Attachment("341341");
		Question question = new Question("title2", "content", "answer", "analysis", new Date(), new Date(), "2");
		Set<Attachment> attachments = new HashSet<Attachment>();
		attachments.add(attachment);
		question.setAttachments(attachments);
/*		User user = userService.getUserById(7);
		question.setUser(user);*/
		questionService.save(question);
	}
	
	@Test
	public void Delete() {
		Question question = questionService.findById(9);
		questionService.delete(question);
	}
	
	@Test
	public void show() {
		User user = userService.getUserById(2);
		Set<Question> questions = user.getQuestions();
		Iterator<Question> iterator = questions.iterator();
		while (iterator.hasNext()) {
			Question question = (Question) iterator.next();
			System.out.println(question.getTitle());
		}
	}
	
	@Test
	public void index() {
		ExamPaper examPaper = examPaperService.findById(1);
		Subject subject = examPaper.getSubject();
		Set<Question> subjectQuestions = subject.getQuestions();
		List<Question> questions = new ArrayList<Question>();
		Iterator<Question> iterator = subjectQuestions.iterator();
		while (iterator.hasNext()) {
			Question question = (Question) iterator.next();
			System.out.println(question.getStatus().equals(messageSource.getMessage("question.status.approved", null, null)));
			if (question.getStatus() == messageSource.getMessage("question.status.approved", null, null)) {
				System.out.println(question.getTitle());
			}
		}
	}
}