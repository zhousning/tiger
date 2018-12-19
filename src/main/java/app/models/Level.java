package app.models;

import java.util.HashSet;
import java.util.Set;

public class Level {
	private Integer id;
	private String name;
	private Set<Question> questions = new HashSet<Question>();
	
	public Level() {
		super();
	}
	
	public Level(String name) {
		super();
		this.name = name;
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
	public Set<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
	
	

}
