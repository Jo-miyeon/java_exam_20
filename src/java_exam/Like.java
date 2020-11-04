package java_exam;

public class Like {	
	private int parentId;//원글 번호
	private int id;//조아요 번호
	private int likeFlag; //체크햇나안햇나
	private int checkMemberId; //체크유저번호 멤버id

	public Like(int parentId, int checkMemberId) {
		this.parentId=parentId;
		this.checkMemberId=checkMemberId;
	}

	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLikeFlag() {
		return likeFlag;
	}
	public void setLikeFlag(int likeFlag) {
		this.likeFlag = likeFlag;
	}
	public int getCheckMemberId() {
		return checkMemberId;
	}
	public void setCheckMemberId(int checkMemberId) {
		this.checkMemberId = checkMemberId;
	}
}
