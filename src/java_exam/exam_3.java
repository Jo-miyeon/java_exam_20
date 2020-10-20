package java_exam;

import java.util.ArrayList;
import java.util.Scanner;

public class exam_3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str;
		ArrayList<String> titles = new ArrayList<>();
		ArrayList<String> bodies = new ArrayList<>();
		ArrayList<Integer> ids = new ArrayList<>();
		ArrtayList<Article> articles = new ArrayList<>();
		
		int no=1;
		int targetId;
		while(true) {
			System.out.print("명령어를 입력해주세요:");
			str=sc.nextLine();
			if(str.equals("exit")) {
				break;
			}else if(str.equals("add")) {
				
				Article a = new Article();
				a.id=no;
				no++;
				System.out.print("게시물 제목을 입력해주세요:");
				String title = sc.nextLine();
				a.title = title;
				System.out.print("게시물 내용을 입력해주세요:");
				String body = sc.nextLine();
				a.body = body;
				
				articles.add(a);
				System.out.println("게시물이 등록되었습니다.");
			
		
			}else if(str.equals("list")) {
				for(int i=0;i<ids.size();i++) {
					System.out.println("번호:"+ids.get(i));
					System.out.println("제목:"+titles.get(i));
					System.out.println("내용:"+bodies.get(i));
					System.out.println("=====================");
				}
			}else if(str.equals("update")) {
				System.out.print("수정할 게시물번호 선택해주세요: ");
				targetId = sc.nextInt();
				for(int i=0;i<ids.size();i++) {
					int id = ids.get(i);
					if(id==targetId) {
						System.out.print("게시물 제목을 입력해주세요:");
						String newTitle = sc.nextLine();
						titles.add(newTitle);
						System.out.print("게시물 내용을 입력해주세요:");
						String newBody = sc.nextLine();
						bodies.add(newBody);
						System.out.println("게시물이 등록되었습니다.");
						titles.set(i,newTitle);
						bodies.set(i,newBody);
						break;
					}
				}
			}else if(str.equals("delete")) {
				System.out.print("삭제할 게시물번호를 선택해주세요: ");
				targetId = sc.nextInt();
				int existFlag=2;//1.있음 2.없음
				
				for(int i=0; i<ids.size(); i++) {
					int id = ids.get(i);
					if(id==targetId) {
						existFlag=1;
						ids.remove(i);
						titles.remove(i);
						bodies.remove(i);
					}
				}
				if(existFlag==2) {
					System.out.println("게시물이 존재하지 않습니다");//for문밖ㅇㅔ서 해야함
				}else {
					System.out.println("게시물이 삭제되었습니다.");
					for(int i=0;i<ids.size();i++) {
						System.out.println("번호:"+ids.get(i));
						System.out.println("제목:"+titles.get(i));
						System.out.println("내용:"+bodies.get(i));
						System.out.println("=====================");
					}
				}
			}
		} 
	}
}
