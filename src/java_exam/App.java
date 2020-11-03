package java_exam;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class App {
	replyDao replydao = new replyDao();
	MemberDao memberDao = new MemberDao();
	ArticleDao dao = new ArticleDao();
	Member loginedMember = null;

	public void start() {
		Scanner sc = new Scanner(System.in);

		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyy년MM월dd일");
		SimpleDateFormat time = new SimpleDateFormat("hh시mm분ss초");

		while (true) {
			if (loginedMember == null) {
				System.out.print("명령어를 입력해주세요:");
			} else {
				System.out.print("명령어를 입력해주세요 [" + loginedMember.getSign_up_id() + "(" + loginedMember.getSign_up_nn()
						+ ")" + "] :");
			}
			String str = sc.nextLine();
			if (str.equals("exit")) {
				System.out.println("종료되었습니다.");
				break;
			} else if (str.equals("help")) {
				System.out.println("article [add: 게시물 추가 / list : 게시물 목록 조회 / read : 게시물 조회 / search : 검색]");
				System.out.println(
						"member [signup : 회원가입 / signin : 로그인 / findpass : 비밀번호 찾기 / findid : 아이디 찾기 / logout : 로그아웃 / myinfo : 나의 정보 확인및 수정]");
			} else if (str.equals("member signup")) {
				Member m = new Member();
				System.out.println("====회원가입을 진행합니다====");
				System.out.print("아이디를 입력해주세요:");
				String sign_up_id = sc.nextLine();
				m.setSign_up_id(sign_up_id);
				System.out.print("비밀번호를 입력해주세요:");
				String sign_up_pw = sc.nextLine();
				m.setSign_up_pw(sign_up_pw);
				System.out.print("닉네임을 입력해주세요:");
				String sign_up_nn = sc.nextLine();
				m.setSign_up_nn(sign_up_nn);
				memberDao.insertMember(m);
				System.out.println("====회원가입이 완료되었습니다.====");
			} else if (str.equals("member signin")) {
				System.out.print("아이디:");
				String sign_in_id = sc.nextLine();
				System.out.print("비밀번호:");
				String sign_in_pw = sc.nextLine();

				Member member = memberDao.getMemberByLoginIdAndLoingPw(sign_in_id, sign_in_pw);
				if (member == null) {
					System.out.print("비밀번호를 틀렸거나 잘못된 회원정보입니다.");
				} else {
					loginedMember = member;
					System.out.println(loginedMember.getSign_up_nn() + "님 안녕하세요!");
				}
			} else if (str.equals("member logout")) {
				if (!isLogin()) {
					continue;
				}
				loginedMember = null;
				System.out.println("로그아웃 되셨습니다.");
			} else if (str.equals("article add")) {
				if (!isLogin()) {
					continue;
				}
				Article a = new Article();

				System.out.print("게시물 제목을 입력해주세요:");
				String title = sc.nextLine();
				a.setTitle(title);

				System.out.print("게시물 내용을 입력해주세요:");
				String body = sc.nextLine();
				a.setBody(body);
				a.setMid(loginedMember.getId());
				dao.insertArticle(a);
				System.out.println("게시물이 등록되었습니다.");
			} else if (str.equals("article list")) {
				ArrayList<Article> articles = dao.getArticles();
				printArticles(articles);
			} else if (str.equals("article update")) {
				System.out.print("수정할 게시물번호 선택해주세요: ");
				int targetId = Integer.parseInt(sc.nextLine());
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
			} else if (str.equals("article delete")) {
				System.out.print("삭제할 게시물번호를 선택해주세요: ");
				int targetId = Integer.parseInt(sc.nextLine());
				ArrayList<Article> articles = dao.getArticles();
				Article target = dao.getAricleById(targetId);
				if (target == null) {
					System.out.println("게시물이 존재하지 않습니다.");
				} else {
					dao.removeArticle(target);
				}
			} else if (str.equals("article read")) {
				System.out.println("원하는 게시물의 번호를 선택해주세요:");
				int targetId = Integer.parseInt(sc.nextLine());
				Article target = dao.getAricleById(targetId);
				if (target == null) {
					System.out.println("게시물이 존재하지 않습니다.");
				} else {
					target.setPage_view(target.getPage_view() + 1);
					printArticle(target);

				}
				System.out.println("상세보기 기능을 선택해주세요(1. 댓글 등록, 2. 좋아요, 3. 수정, 4. 삭제, 5. 목록으로) :");
				int read_func = Integer.parseInt(sc.nextLine());
				if (read_func == 1) {
					System.out.print("댓글 내용을 입력해주세요 : ");
					String reply = sc.next();
					String[] array_reply = new String[reply.length()];
					System.out.println("댓글이 등록되었습니다.");
					printArticle(target);

					for (int i = 0; i < array_reply.length; i++) {
						System.out.println("========댓글=========");
						System.out.println("내용:" + reply);
						//System.out.println("작성자:" + target.getWritten());
						System.out.println("작성일:" + date.format(today));
						System.out.println("=====================");
					}
				}else if(read_func==2) {
					//좋아요 체크
					target.getId()
					if(likeFlag==0){
						
						System.out.println("해당 게시물을 좋아합니다.");
					}else if(likeFlag==1) {
						System.out.println("해당 게시물의 좋아요를 해제합니다.");
					}
				}else if(read_func==3) {
					if(!isLogin() || !isMyArticle(target)) {
						continue;
						
					}else{
						System.out.print("게시물 제목을 입력해주세요:");
						String newTitle = sc.next();

						System.out.print("게시물 내용을 입력해주세요:");
						String newBody = sc.next();

						target.setTitle(newTitle);
						target.setBody(newBody);

						System.out.println("게시물이 등록되었습니다.");
					}
				}else if(read_func==4) {
					if(!isLogin() || !isMyArticle(target)) {
						continue;
						
					}else {
						dao.removeArticle(target);
						break;
					}
				}else if(read_func==5) {
					break;
				}
			} else if (str.equals("article search")) {
				ArrayList<Article> articles = dao.getArticles();
				System.out.print("검색항목을 선택해주세요 1.제목, 2.내용, 3.제목+내용, 4.작성자:");
				int sr = Integer.parseInt(sc.nextLine());
				if (sr == 1) {
					System.out.print("검색 키워드를 입력해주세요:");
					String sr2 = sc.nextLine();
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
					String sr2 = sc.nextLine();
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
	private void printArticles(ArrayList<Article> articleList) {
		for(int i=0;i<articleList.size();i++) {
			Article article = articleList.get(i);
			System.out.println("번호 : " + article.getId());
			System.out.println("제목 : " + article.getTitle());
			Member regMember = memberDao.getMemberById(article.getMid());
			System.out.println("작성자 : " + regMember.getSign_up_nn());
			System.out.println("조회수 : " + article.getPage_view());
			System.out.println("===================");
		}
	}
	private void printArticle(Article target) {
		System.out.println("=====" + target.getId() + "번 게시물=====");
		System.out.println("제목:" + target.getTitle());
		System.out.println("내용:" + target.getBody());
		System.out.println("작성자:" + target.getMid());
		// System.out.println("등록날짜:" + date.format(today));
		// System.out.println("등록시간:" + time.format(today));
		System.out.println("조회수:" + target.getPage_view());
		System.out.println("좋아요"+target.getLike());
		System.out.println("=====================");
	}

	private boolean isLogin() {
		if (loginedMember == null) {
			System.out.println("로그인이 필요한 기능입니다.");
			return false;
		} else {
			return true;
		}
	}
	private boolean isMyArticle(Article article) {
		if(loginedMember.getId() != article.getMid()) {
			System.out.println("자신의 게시물만 수정가능합니다.");
			return false;
		}
		return true;
	}
}
