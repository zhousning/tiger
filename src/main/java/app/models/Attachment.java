package app.models;

public class Attachment {
	private Integer id;
	private String file;
	private Question question;
	
	public Attachment() {
		super();
	}

	public Attachment(String file) {
		super();
		this.file = file;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
	
}
