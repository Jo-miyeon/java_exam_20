package java_exam;

import java.util.ArrayList;
import java.util.Scanner;

public class exam_3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str;
		ArrayList<Article> articles = new ArrayList<>(); //arraylist하나로 쓸수있다,
		
		int no=1;
		int targetId;
		while(true) {
			
			System.out.print("명령어를 입력해주세요:");
			str=sc.nextLine();
			if(str.equals("exit")) {
				System.out.println("종료되었습니다.");
				break;
			}else if(str.equals("add")) {
				Article a = new Article();
				a.setId(no); //아이디 타이틀등을 따로 저장안해도됨
				no++;
				System.out.print("게시물 제목을 입력해주세요:");
				String title = sc.nextLine();
				a.setTitle(title);
				
				System.out.print("게시물 내용을 입력해주세요:");
				String body = sc.nextLine();
				a.setBody(body);
				
				articles.add(a);
				System.out.println("게시물이 등록되었습니다.");
			
		
			}else if(str.equals("list")) {
				for(int i=0;i<articles.size();i++) {
					Article article = articles.get(i); //i번째 articles를 변수에 저장
					System.out.println("번호:"+article.getId());
					System.out.println("제목:"+article.getTitle());
					//System.out.println("내용:"+article.getBody());
					System.out.println("=====================");
				}
			}else if(str.equals("update")) {
				System.out.print("수정할 게시물번호 선택해주세요: ");
				targetId = sc.nextInt();
				for(int i=0;i<articles.size();i++) {
					Article article = articles.get(i);
					int id = articles.get(i).getId();
					
					if(id==targetId) {
						System.out.print("게시물 제목을 입력해주세요:");
						String newTitle = sc.nextLine();

						System.out.print("게시물 내용을 입력해주세요:");
						String newBody = sc.nextLine();
						
						System.out.println("게시물이 등록되었습니다.");
						
						Article newArticle = new Article();
						newArticle.setId(id);
						newArticle.setTitle(newTitle);
						newArticle.setBody(newBody);
						
						articles.set(i, newArticle);
						break;
					}
				}
			}else if(str.equals("delete")) {
				System.out.print("삭제할 게시물번호를 선택해주세요: ");
				targetId = sc.nextInt();
				int existFlag=2;//1.있음 2.없음
				
				for(int i=0; i<articles.size(); i++) {
					int id = articles.get(i).getId();
					if(id==targetId) {
						existFlag=1;
						articles.remove(i);
						break;
					}
				}
				if(existFlag==2) {
					System.out.println("게시물이 존재하지 않습니다.");
				}else {
					System.out.println("게시물이 삭제되었습니다.");
					for(int i=0;i<articles.size();i++) {
						Article article = articles.get(i);
						System.out.println("번호:"+article.getId());
						System.out.println("제목:"+article.getTitle());
						//System.out.println("내용:"+article.getBody());
						System.out.println("=====================");
					}
				}
			}else if(str.equals("read")) {
				System.out.println("원하는 게시물의 번호를 선택해주세요:");
				targetId = sc.nextInt();
				int existFlag = 2;
				for(int i=0;i<articles.size();i++) {
					int id = articles.get(i).getId();
					Article article = articles.get(i);
					if(id==targetId) {
						existFlag=1;
						System.out.println("====="+article.getId()+"번 게시물====");
						System.out.println("제목:"+article.getTitle());
						System.out.println("내용:"+article.getBody());
						System.out.println("===================");
					}
				}if(existFlag==2) {
					System.out.println("게시물이 존재하지 않습니다.");
				}
			}
		} 
	}
}
