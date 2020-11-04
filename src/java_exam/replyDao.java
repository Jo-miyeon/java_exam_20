package java_exam;
import java.util.ArrayList;

public class replyDao {
	private ArrayList<reply> replies;
	private int no=1;
	
	public replyDao() {
		replies = new ArrayList<>();
	}
	public void insertReply(reply a) {
		a.setId(no);
		no++;
		replies.add(a);
	}
	public ArrayList<reply> getReplies() {
		return replies;
	}
	public ArrayList<reply> getRepliesByParentId(int parentId) {
		ArrayList<reply> searchedReplies = new ArrayList<>();
		for(int i=0;i<replies.size();i++) {
			reply reply2 = replies.get(i);
			if(reply2.getParentId()==parentId) {
				searchedReplies.add(reply2);
			}
		}
		return replies;
	}
	
}
