package java_exam;

import java.util.ArrayList;

public class LikeDao {
	private ArrayList<Like> likes;
	private int no=1;
	
	public void insertLike(Like l) {
		l.setId(no);
	}
}
