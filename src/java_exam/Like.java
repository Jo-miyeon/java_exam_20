package java_exam;

public class Like {	
	private int parentId;//누구의 조아요를 체크인지 해제인지
	private int id;
	private int likeFlag; //체크햇나안햇나
	private int checkMemberId;
	
	
	public Like(int parentId, int id, int likeFlag, int checkMemberId) {
		this.parentId = parentId;
		this.id = id;
		this.likeFlag = likeFlag;
		this.checkMemberId = checkMemberId;
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
