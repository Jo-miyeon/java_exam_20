package java_exam;

import java.util.ArrayList;

public class MemberDao {
	private ArrayList<Member> members;
	private int no = 1;

	public MemberDao() {
		members = new ArrayList<>();
	}

	public void insertMember(Member m) {
		m.setId(no);
		no++;
		members.add(m);
	}

	public ArrayList<Member> getMembers() {
		return members;
	}

	public Member getMemberByLoginIdAndLoingPw(String sign_in_id, String sign_in_pw) {
		for (int i = 0; i < members.size(); i++) {
			Member m = members.get(i);
			if (m.getSign_up_id().contains(sign_in_id) && m.getSign_up_pw().contains(sign_in_pw)) {
				return m;
			}
		}
		return null;
	}
	public Member getMemberById(int id) {
		for(int i=0;i<members.size();i++) {
			Member m = members.get(i);
			if(m.getId()==id) {
				return m;
			}
		}
	return null;
}
}
