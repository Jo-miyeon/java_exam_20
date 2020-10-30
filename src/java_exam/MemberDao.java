package java_exam;

import java.util.ArrayList;

public class MemberDao {
	private ArrayList<Member> members;
	private int no=1;
	
	public MemberDao() {
		members = new ArrayList<>();
	}
	public void insertMember(Member m) {
		m.setId(no);
		no++;
		members.add(m);
	}
	public  ArrayList<Member> getMembers() {
		return members;
	}
}
