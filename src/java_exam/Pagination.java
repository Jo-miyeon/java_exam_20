package java_exam;

public class Pagination {
	private int currentPageNo = 1;
	private int totalCntOfItems;
	private int startPageNo = 1;
	private int itemsCntPerPage = 3;
	private int pageCntPerBlock = 5;
	private int currentPageBlcok = 1;
	
	public int getCurrentPageNo() {
		return currentPageNo;
	}
	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}
	public int getTotalCntOfItems() {
		return totalCntOfItems;
	}
	public void setTotalCntOfItems(int totalCntOfItems) {
		this.totalCntOfItems = totalCntOfItems;
	}
	public int getStartPageNo() {
		return startPageNo;
	}
	public void setStartPageNo(int startPageNo) {
		this.startPageNo = startPageNo;
	}
	public int getItemsCntPerPage() {
		return itemsCntPerPage;
	}
	public void setItemsCntPerPage(int itemsCntPerPage) {
		this.itemsCntPerPage = itemsCntPerPage;
	}
	public int getPageCntPerBlock() {
		return pageCntPerBlock;
	}
	public void setPageCntPerBlock(int pageCntPerBlock) {
		this.pageCntPerBlock = pageCntPerBlock;
	}
	public int getCurrentPageBlcok() {
		return currentPageBlcok;
	}
	public void setCurrentPageBlcok(int currentPageBlcok) {
		this.currentPageBlcok = currentPageBlcok;
	}
}
