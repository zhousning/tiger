package app.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subject {
	private Integer id;  
	private String name;
	private Integer leaderId;
	private Set<User> users = new HashSet<User>();
	private Set<Question> questions = new HashSet<Question>();
	private Set<ExamPoint> examPoints = new HashSet<ExamPoint>();
	
	public Subject(){}
	
	
	public Subject(String name) {
		super();
		this.name = name;
	}
	
	

	public Set<Question> getQuestions() {
		return questions;
	}


	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Set<User> getUsers() {
		return users;
	}


	public void setUsers(Set<User> users) {
		this.users = users;
	}


	public Integer getLeaderId() {
		return leaderId;
	}


	public void setLeaderId(Integer leaderId) {
		this.leaderId = leaderId;
	}


	public Set<ExamPoint> getExamPoints() {
		return examPoints;
	}


	public void setExamPoints(Set<ExamPoint> examPoints) {
		this.examPoints = examPoints;
	}


	

}