package java_exam;

import java.util.ArrayList;

public class LikeDao {
	private ArrayList<Like> likes;
	private int no=1;
	
	public LikeDao() {
		likes = new ArrayList<>();
	}
	public void insertLike(Like like) {
		like.setId(no);
		no++;
		likes.add(like);
	}
	public ArrayList<Like> getLikes() {
		return likes;
	}
	public ArrayList<Like> getLikesByParentId(int parentId) {
		ArrayList<Like> searchedLikes = new ArrayList<>();
		for(int i=0;i<likes.size();i++) {
			Like like = likes.get(i);
			if(like.getParentId()==parentId) {
				searchedLikes.add(like);
			}
		}
		return likes;
	}
	
	public void removeLike(Like l) {//삭제
		likes.remove(l);
	}
	public Like getLikeByArticleAndMemberId(int aid, int mid) {
		// TODO Auto-generated method stub
		for(int i=0; i<likes.size();i++) {
			Like like = likes.get(i);
			if(like.getParentId()==aid && like.getCheckMemberId()==mid) {
				return like;
			}
		}
		return null;
	}
	
}
