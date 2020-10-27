package java_exam;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class exam_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str;
		ArticleDao dao = new ArticleDao();

		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyy년MM월dd일");
		SimpleDateFormat time = new SimpleDateFormat("hh시mm분ss초");

		int targetId;
		while (true) {
			System.out.print("명령어를 입력해주세요:");
			str = sc.next();
			if (str.equals("exit")) {
				System.out.println("종료되었습니다.");
				break;
			} else if (str.equals("add")) {

				Article a = new Article();

				System.out.print("게시물 제목을 입력해주세요:");
				String title = sc.next();
				a.setTitle(title);

				System.out.print("게시물 내용을 입력해주세요:");
				String body = sc.next();
				a.setBody(body);

				System.out.print("게시물 작성자를 입력해주세요:");
				String written = sc.next();
				a.setWritten(written);

				dao.insertArticle(a);
				System.out.println("게시물이 등록되었습니다.");

			} else if (str.equals("list")) {
				ArrayList<Article> articles = dao.getArticles();
				for (int i = 0; i < articles.size(); i++) {
					Article article = articles.get(i); // i번째 articles를 변수에 저장
					System.out.println("번호:" + article.getId());
					System.out.println("제목:" + article.getTitle());
					System.out.println("=====================");
				}
			} else if (str.equals("update")) {
				System.out.print("수정할 게시물번호 선택해주세요: ");
				targetId = sc.nextInt();
				Article target = dao.getAricleById(targetId);
				if (target == null) {
					System.out.print("게시물이 없습니다.");
				} else {
					System.out.print("게시물 제목을 입력해주세요:");
					String newTitle = sc.next();

					System.out.print("게시물 내용을 입력해주세요:");
					String newBody = sc.next();

					target.setTitle(newTitle);
					target.setBody(newBody);

					System.out.println("게시물이 등록되었습니다.");
				}
			} else if (str.equals("delete")) {
				System.out.print("삭제할 게시물번호를 선택해주세요: ");
				targetId = sc.nextInt();
				ArrayList<Article> articles = dao.getArticles();
				Article target = dao.getAricleById(targetId);
				if (target == null) {
					System.out.println("게시물이 존재하지 않습니다.");
				} else {
					dao.removeArticle(target);
					System.out.println("게시물이 삭제되었습니다.");
					for (int i = 0; i < articles.size(); i++) {
						Article article = articles.get(i);
						System.out.println("번호:" + article.getId());
						System.out.println("제목:" + article.getTitle());
						System.out.println("=====================");
					}
				}
			} else if (str.equals("read")) {
				System.out.println("원하는 게시물의 번호를 선택해주세요:");
				targetId = sc.nextInt();
				Article target = dao.getAricleById(targetId);
				if (target == null) {
					System.out.println("게시물이 존재하지 않습니다.");
				} else {
					target.setPage_view(target.getPage_view() + 1);
					System.out.println("=====" + target.getId() + "번 게시물=====");
					System.out.println("제목:" + target.getTitle());
					System.out.println("내용:" + target.getBody());
					System.out.println("작성자:" + target.getWritten());
					System.out.println("등록날짜:" + date.format(today));
					System.out.println("등록시간:" + time.format(today));
					System.out.println("조회수:" + target.getPage_view());
					System.out.println("=====================");
				}
				System.out.println("상세보기 기능을 선택해주세요(1. 댓글 등록, 2. 좋아요, 3. 수정, 4. 삭제, 5. 목록으로) :");
				int read_func = sc.nextInt();
				if (read_func == 1) {
					System.out.print("댓글 내용을 입력해주세요 : ");
					String reply = sc.next();
					String[] array_reply = new String[reply.length()];
					System.out.println("댓글이 등록되었습니다.");

					System.out.println("=====" + target.getId() + "번 게시물=====");
					System.out.println("제목:" + target.getTitle());
					System.out.println("내용:" + target.getBody());
					System.out.println("작성자:" + target.getWritten());
					System.out.println("작성일:" + date.format(today));
					System.out.println("작성시간:" + time.format(today));
					System.out.println("조회수:" + target.getPage_view());
					System.out.println("=====================");

					for (int i = 0; i < array_reply.length; i++) {
						System.out.println("========댓글=========");
						System.out.println("내용:" + reply);
						System.out.println("작성자:" + target.getWritten());
						System.out.println("작성일:" + date.format(today));
						System.out.println("=====================");
					}
				}
			} else if (str.equals("search")) {
				ArrayList<Article> articles = dao.getArticles();
				System.out.print("검색항목을 선택해주세요 1.제목, 2.내용, 3.제목+내용, 4.작성자:");
				int sr = sc.nextInt();
				if (sr == 1) {
					System.out.print("검색 키워드를 입력해주세요:");
					String sr2 = sc.next();
					for (int i = 0; i < articles.size(); i++) {
						Article article = articles.get(i);
						if (article.getTitle().contains(sr2)) {
							System.out.println("번호:" + article.getId());
							System.out.println("제목:" + article.getTitle());
							System.out.println("=====================");
						}
					}
				} else if (sr == 2) {
					System.out.print("검색 키워드를 입력해주세요:");
					String sr2 = sc.next();
					for (int i = 0; i < articles.size(); i++) {
						Article article = articles.get(i);
						if (article.getBody().contains(sr2)) {
							System.out.println("번호:" + article.getId());
							System.out.println("제목:" + article.getTitle());
							System.out.println("=====================");
						}
					}
				}
			}
		}
	}

	private static int array_reply() {
		// TODO Auto-generated method stub
		return 0;
	}
}
