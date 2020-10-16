package java_exam_2;

import java.util.Scanner;

public class exam_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str;
		String title = null;
		String body = null;
		while(true) {
			str=sc.nextLine();
			if(str.equals("exit")) {
				break;
			}else if(str.equals("add")) {
				System.out.print("게시물 제목을 입력해주세요:");
				title = sc.nextLine();
				System.out.print("게시물 내용을 입력해주세요:");
				body = sc.nextLine();
				System.out.println("게시물이 등록되었습니다.");
			}else if(str.equals("list")) {
				System.out.println("제목:"+title);
				System.out.println("내용:"+body);
			}
		} 
	}
}
