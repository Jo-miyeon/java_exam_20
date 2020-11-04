package java_exam;

public class reply {
	private String body;
	private int id;
	private String nickname;
	private String regDate;
	private int ParentId;
	
	public reply(String body, int id, String nickname, String regDate, int parentId) {
		super();
		this.body = body;
		this.id = id;
		this.nickname = nickname;
		this.regDate = regDate;
		ParentId = parentId;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public int getParentId() {
		return ParentId;
	}
	public void setParentId(int parentId) {
		ParentId = parentId;
	}
	
}
