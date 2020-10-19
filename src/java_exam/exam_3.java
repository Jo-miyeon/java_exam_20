package java_exam;

import java.util.ArrayList;
import java.util.Scanner;

public class exam_3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str;
		ArrayList<String> titles = new ArrayList<>();
		ArrayList<String> bodies = new ArrayList<>();
		int size=0;
		while(true) {
			System.out.print("명령어를 입력해주세요:");
			str=sc.nextLine();
			if(str.equals("exit")) {
				break;
			}else if(str.equals("add")) {
				System.out.print("게시물 제목을 입력해주세요:");
				String title = sc.nextLine();
				titles.add(title);
				System.out.print("게시물 내용을 입력해주세요:");
				String body = sc.nextLine();
				bodies.add(body);
				System.out.println("게시물이 등록되었습니다.");
				size++;
		
			}else if(str.equals("list")) {
				for(int i=0;i<size;i++) {  
					System.out.println("제목:"+titles.get(i));
					System.out.println("내용:"+bodies.get(i));
				}
			}else if(str.equals("update")) {
				System.out.print("수정할 게시물 선택: ");
				String targetTitle = sc.next(); //수정할 제목을 선택
				for(int i=0;i<titles.size();i++) {
					String title = titles.get(i);
					if(titles.get(i).equals(targetTitle)) {
						System.out.print("게시물 제목을 입력해주세요:");
						String newTitle = sc.nextLine();
						titles.add(newTitle);
						System.out.print("게시물 내용을 입력해주세요:");
						String newBody = sc.nextLine();
						bodies.add(newBody);
						System.out.println("게시물이 등록되었습니다.");
						titles.set(i,newTitle);
						titles.set(i,newBody);
					}
				}
			}
		} 
	}
}
