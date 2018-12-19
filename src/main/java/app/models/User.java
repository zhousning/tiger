package app.models;

import java.util.HashSet;
import java.util.Set;

public class User {
    private Integer id;

    private String name;

    private Integer phone;

    private String email;

    private String password;
    
	private Set<Role> roles = new HashSet<Role>();
	
	private Set<Subject> subjects = new HashSet<Subject>();
	
	private Set<Question> questions = new HashSet<Question>();


    
    @Override
   	public String toString() {
   		return "User [name=" + name + ", phone=" + phone + ", email=" + email + ", password=" + password + "]";
   	}

   	public User() {
   		super();
   	}

   	public User(String name, String email, String password) {
   		super();
   		this.name = name;
   		this.email = email;
   		this.password = password;
   	}

   	public User(String name, Integer phone, String email, String password) {
   		super();
   		this.name = name;
   		this.phone = phone;
   		this.email = email;
   		this.password = password;
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
        this.name = name == null ? null : name.trim();
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}



	
}