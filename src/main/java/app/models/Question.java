package app.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Question {
	private Integer id;
	private String title;
	private String content;
	private String answer;
	private String analysis;
	private Date createTime;
	private Date utilityTime;
	private String type;
	private Integer status;
	private Level level;
	private Subject subject;
	private User user;
	private ExamPoint examPoint;
	private Set<Attachment> attachments = new HashSet<Attachment>();
	
	
	@Override
	public String toString() {
		return "Question [title=" + title + ", content=" + content + ", answer=" + answer + ", analysis=" + analysis
				+ ", createTime=" + createTime + ", utilityTime=" + utilityTime + ", status=" + status + "]";
	}
	
	public Question(String title, String content, String answer, String analysis, Date createTime, Date utilityTime,
			Integer status) {
		super();
		this.title = title;
		this.content = content;
		this.answer = answer;
		this.analysis = analysis;
		this.createTime = createTime;
		this.utilityTime = utilityTime;
		this.status = status;
	}
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getAnalysis() {
		return analysis;
	}
	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUtilityTime() {
		return utilityTime;
	}
	public void setUtilityTime(Date utilityTime) {
		this.utilityTime = utilityTime;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Level getLevel() {
		return level;
	}
	public void setLevel(Level level) {
		this.level = level;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public ExamPoint getExamPoint() {
		return examPoint;
	}
	public void setExamPoint(ExamPoint examPoint) {
		this.examPoint = examPoint;
	}
	public Set<Attachment> getAttachments() {
		return attachments;
	}
	public void setAttachments(Set<Attachment> attachments) {
		this.attachments = attachments;
	}
	
	

}
