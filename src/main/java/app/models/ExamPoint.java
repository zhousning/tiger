package app.models;

import java.util.HashSet;
import java.util.Set;

public class ExamPoint {
	private Integer id;
	private String name;
	private Set<Question> questions = new HashSet<Question>();
	private Subject subject;
	
	
	public ExamPoint() {
		super();
	}

	public ExamPoint(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	
	
}
