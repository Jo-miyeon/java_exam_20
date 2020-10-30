package java_exam;

public class Article {
	private int id;
	private String title;
	private String body;
	private String written;
	private int page_view=0;
	
	public Article() {
		
	}
	public Article(int id,String title,String body,String written,int page_view) {
		this.id=id;
		this.body=body;
		this.title=title;
		this.written=written;
		this.page_view=page_view;
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
