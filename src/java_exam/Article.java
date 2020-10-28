package java_exam;

public class Article {
	private int id;
	private String title;
	private String body;
	private String written;
	private int page_view=0;
	private String sign_up_id;
	private String sign_up_pw;
	private String sign_up_nn;
	private String sign_in_id;
	private String sign_in_pw;
	
	public String getSign_up_id() {
		return sign_up_id;
	}
	public void setSign_up_id(String sign_up_id) {
		this.sign_up_id = sign_up_id;
	}
	public String getSign_up_pw() {
		return sign_up_pw;
	}
	public void setSign_up_pw(String sign_up_pw) {
		this.sign_up_pw = sign_up_pw;
	}
	public String getSign_up_nn() {
		return sign_up_nn;
	}
	public void setSign_up_nn(String sign_up_nn) {
		this.sign_up_nn = sign_up_nn;
	}
	public Article() {
		
	}
	public Article(int id,String title,String body,String written,int page_view,String sign_up_id,String sign_up_pw,String sign_up_nn,String sign_in_id,String sign_in_pw) {
		this.id=id;
		this.body=body;
		this.title=title;
		this.written=written;
		this.page_view=page_view;
		this.sign_up_id=sign_up_id;
		this.sign_up_pw=sign_up_pw;
		this.sign_up_nn=sign_up_nn;
		this.sign_in_id=sign_in_id;
		this.sign_in_pw=sign_in_pw;
	}
	public String getSign_in_id() {
		return sign_in_id;
	}
	public void setSign_in_id(String sign_in_id) {
		this.sign_in_id = sign_in_id;
	}
	public String getSign_in_pw() {
		return sign_in_pw;
	}
	public void setSign_in_pw(String sign_in_pw) {
		this.sign_in_pw = sign_in_pw;
	}
	public String getWritten() {
		return written;
	}
	public void setWritten(String written) {
		this.written = written;
	}
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPage_view() {
		return page_view;
	}
	public void setPage_view(int page_view) {
		this.page_view = page_view;
	}

	
}
