package java_exam;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

//data access object
public class ArticleDao {
	private ArrayList<Article> articles;//데이터를저장해놓은곳 데이터집합소
	private int no = 1; //바로접근할수없도록
	public ArticleDao() { //articledao를 만드는순간 객체자체가세팅되서옴,,(?)
		articles = new ArrayList<>();
	}
	public void writeJsonFile(JSONObject jobj) {
		try {
			long id = (long)jobj.get("id");

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public JSONObject articleToJsonFile(Article article) {
		JSONObject obj = new JSONObject();
		String jsonText;
		obj.put("id", article.getId());
		obj.put("title",article.getTitle());
		obj.put("boby", article.getBody());
		obj.put("mid", article.getMid());
		obj.put("hit", article.getPage_view());
		return obj;
		
	}
	public void insertArticle(Article a) {
		a.setId(no); // 아이디 타이틀등을 따로 저장안해도됨
		no++;
		articles.add(a);
	}
	public void removeArticle(Article a) {//삭제
		articles.remove(a);
	}
	
	public Article getAricleById(int targetId) {
		for (int i = 0; i < articles.size(); i++) {
			int id = articles.get(i).getId();
			if (id == targetId) {
				return articles.get(i);
			}
		}
		return null;
	}
	public  ArrayList<Article> getArticles() {
		return articles;
	}
}
