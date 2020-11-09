package java_exam;

import java.util.ArrayList;
import java.util.Scanner;

public class Paging {
	public static void main(String[] args) {
		ArrayList<Article> articles = new ArrayList<>();

		for (int i = 1; i <= 50; i++) {
			Article a1 = new Article();
			a1.setId(i);
			a1.setTitle("제목" + i);
			a1.setBody("내용" + i);
			articles.add(a1);
		}
		Scanner sc = new Scanner(System.in);
		int currentPageNo = 123;
		int totalCntOfItems = articles.size();
		int startPageNo = 1;
		int itemsCntPerPage = 3;
		int pageCntPerBlock = 5;
		int endPageNo = (int)Math.ceil((double)totalCntOfItems/itemsCntPerPage);
		
		
		if(currentPageNo<startPageNo) {
			currentPageNo = startPageNo;
		}
		if(currentPageNo>endPageNo) {
			currentPageNo = endPageNo;
		}
		int currentPageBlock = (int)Math.ceil((double)currentPageNo/pageCntPerBlock);
		int startPageNoInBlock = (currentPageBlock-1)*pageCntPerBlock+1;
		int endPageNoInBlock = startPageNoInBlock+pageCntPerBlock-1;
		
		if(endPageNoInBlock>endPageNo) {
			endPageNoInBlock = endPageNo;
		}
		int startIndex = (currentPageNo-1)*itemsCntPerPage;
		int endIndex = startIndex + itemsCntPerPage;
		
		if(endIndex>totalCntOfItems) {
			endIndex = totalCntOfItems;
		}
		for(int i=startIndex; i<endIndex; i++) {
			System.out.println("번호:"+articles.get(i).getId());
		}
	}
}
