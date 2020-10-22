package java_exam;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class exam_3 {
	static ArrayList<Article> articles;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str;
		articles = new ArrayList<>();
		//Article a1 = new Article(1, "제목1", "내용1","익명");
		
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat ("yyyy년MM월dd일");
		SimpleDateFormat time = new SimpleDateFormat ("hh시mm분ss초");
		
		
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
				
				System.out.print("게시물 작성자를 입력해주세요:");
				String written = sc.nextLine();
				a.setWritten(written);
				
				articles.add(a);
				
				System.out.println("게시물이 등록되었습니다.");
			
		
			}else if(str.equals("list")) {
				for(int i=0;i<articles.size();i++) {
					Article article = articles.get(i); //i번째 articles를 변수에 저장
					System.out.println("번호:"+article.getId());
					System.out.println("제목:"+article.getTitle());
					System.out.println("=====================");
				}
			}else if(str.equals("update")) {
				System.out.print("수정할 게시물번호 선택해주세요: ");
				targetId = sc.nextInt();
				Article target = getAricleById(targetId);
					if(target==null) {
						System.out.print("게시물이 없습니다.");
					}else {
						System.out.print("게시물 제목을 입력해주세요:");
						String newTitle = sc.nextLine();
						System.out.print("게시물 내용을 입력해주세요:");
						String newBody = sc.nextLine();
						System.out.println("게시물이 등록되었습니다.");
						
						target.setTitle(newTitle);
						target.setBody(newBody);
						break;
					}
				}else if(str.equals("delete")) {
				System.out.print("삭제할 게시물번호를 선택해주세요: ");
				targetId = sc.nextInt();
				Article target = getAricleById(targetId);
				if(target==null) {
					System.out.println("게시물이 존재하지 않습니다.");
				}else {
					articles.remove(target);
					System.out.println("게시물이 삭제되었습니다.");
					for(int i=0;i<articles.size();i++) {
						Article article = articles.get(i);
						System.out.println("번호:"+article.getId());
						System.out.println("제목:"+article.getTitle());
						System.out.println("=====================");
						}
					}
				}else if(str.equals("read")) {
				System.out.println("원하는 게시물의 번호를 선택해주세요:");
				targetId = sc.nextInt();
				Article target = getAricleById(targetId);
				if(target==null) {
					System.out.println("게시물이 존재하지 않습니다.");
				}else {
					target.setPage_view(target.getPage_view()+1);
					System.out.println("====="+target.getId()+"번 게시물=====");
					System.out.println("제목:"+target.getTitle());
					System.out.println("내용:"+target.getBody());
					System.out.println("작성자:"+target.getWritten());
					System.out.println("등록날짜:"+date.format(today));
					System.out.println("등록시간:"+time.format(today));
					System.out.println("조회수:"+target.getPage_view());
					System.out.println("=====================");
				}
			}
		}
	}
	private static Article getAricleById(int targetId) {
		for(int i=0;i<articles.size();i++) {
			int id=articles.get(i).getId();
			if(id==targetId) {
				return articles.get(i);
			}
		}
		return null;
	}
}
