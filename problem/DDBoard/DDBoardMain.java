package problem.DDBoard;

import java.util.Scanner;

public class DDBoardMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//BoardDAO bDao = new BoardDAO();
		BBdao dao = new BBdao();
		int code = 0;// 사용자가 선택한 프로그램 번호 , 지역변수니까 밖에다가 초기화

		while (true) {
			System.out.println("◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆");
			System.out.println("◆◆더블디 게시판");
			// bDao.BoardSelect();
			System.out.println("◆◆1.게시글 등록");
			System.out.println("◆◆2.게시글 수정");
			System.out.println("◆◆3.게시글 삭제");
			System.out.println("◆◆4.게시글 조회");
			System.out.println("◆◆5.게시글 검색");
			System.out.println("◆◆6.게시글 정렬");
			System.out.println("◆◆7.상세 게시글");
			System.out.println("◆◆8.만든이");
			System.out.println("◆◆9.프로그램 종료");
			System.out.println("◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆");

			while (true) {
				System.out.println("◆◆번호>>>");
				code = sc.nextInt();
				if (code >= 1 && code <= 9) {
					break;
				} else {
					System.out.println("◆◆1---9번 입력해주세요");// 컨티뉴위에
					continue;
				}
				

			} // 번호입력 와일

			
			
		if (code == 1) {
				System.out.println("◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆");
				System.out.println("◆◆등록할 게시글 입력");
				System.out.println("◆◆타이틀 입력>>");
				sc.nextLine();
				String title = sc.nextLine();
				System.out.println("◆◆내용 입력>>");
				String content = sc.nextLine();
				System.out.println("◆◆작성자 입력>>");
				String writer = sc.nextLine();
				BoardDTO bDto = new BoardDTO(title, content, writer);
				//bDao.BoardInsert(bDto);
				dao.BoardInsert(title, content, writer);
			
				
			} else if (code == 2) {
				System.out.println("◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆");
				System.out.println("수정할 게시글 넘버");
				int ano = sc.nextInt();
				System.out.println("◆◆수정할 게시글 제목>>");
				sc.nextLine();
				String title = sc.nextLine();
				System.out.println("◆◆수정할 게시글 내용>>");
				String content = sc.nextLine();
				System.out.println("◆◆수정할 게시글 작성자>>");
				String writer = sc.nextLine();
				BoardDTO bDto = new BoardDTO(ano, title, content, writer);
				//bDao.BoardUpdate(bDto);
				dao.BoardUpdate(ano, title, content, writer);

			} else if (code == 3) {
				System.out.println("◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆");
				System.out.println("◆◆삭제할 게시글 입력");
				System.out.println("◆◆게시글번호>>>");
				int ano = sc.nextInt();
			//	bDao.BoardDelete(ano);
				dao.BoardDelete(ano);
				
			} else if (code == 4) {
				System.out.println("◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆");
				System.out.println("◆◆게시글을 조회합니다.");
				//bDao.BoardSelect();

			} else if (code == 5) {
				System.out.println("◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆");
				System.out.println("◆◆검색할 키워드>>>");
				sc.nextLine();
				String keyword = sc.nextLine();
			//	bDao.BoardSearch(keyword);
			} else if (code == 6) {
				System.out.println("◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆");
				System.out.println("◆◆조회순으로 정렬됩니다.");
				//bDao.Boardsort();
			} else if (code == 7) {
				System.out.println("◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆");
				System.out.println("◆◆보고싶은 게시글번호를 입력하세요");
				System.out.println("◆◆게시글번호>>>");
				int ano = sc.nextInt();
				//bDao.BoardView(ano);
				
			} else if (code == 8) {
				System.out.println("◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆");
				System.out.println("◆◆Name: DDBoard");
				System.out.println("◆◆Version:1.7");
				System.out.println("◆◆Use: JAVA, ORACLE");
				System.out.println("◆◆Date: 2019.12.17");
				System.out.println("◆◆만든사람 연승");
				System.out.println("◆◆blackpulv@hanmail.net");
			} else if (code == 9) {
				System.out.println("◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆");
				System.out.println("◆◆프로그램 종료");
				System.exit(0);
			}

		} // 큰와일
	}// 메인
}// 클래스
