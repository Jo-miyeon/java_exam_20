package java_exam;

import java.util.ArrayList;

public class Article {
	private int id;
	private String title;
	private String body;
	private int mid;
	private int page_view=0;
	
	public Article() {
		
	}
	public Article(int id,String title,String body,int mid,int page_view) {
		this.id=id;
		this.body=body;
		this.title=title;
		this.mid=mid;
		this.page_view=page_view;
	}
	
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
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
