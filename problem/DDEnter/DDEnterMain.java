package problem.DDEnter;

import java.util.Scanner;

public class DDEnterMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			// 1.화면에 출력하는 부분
			System.out.println("○○○○○○○○○○○○○○○○○○○○○○○○○○○○○○○○○○○○");
			System.out.println("○○더블디 엔터 관리 시스템");
			System.out.println("○○ 1. 아티스트 등록");
			System.out.println("○○ 2. 아티스트 수정");
			System.out.println("○○ 3. 아티스트 해지");
			System.out.println("○○ 4. 아티스트 조회");
			System.out.println("○○ 5. 아티스트 검색");
			System.out.println("○○ 6. 프로그램 종료");
			System.out.println("○○○○○○○○○○○○○○○○○○○○○○○○○○○○○○○○○○○○");

			// 2.사용자가 실행할 프로그램을 입력받는 부분
			int code = 0;// 원래 int code = sc.nextint 였는데 와일 밖에 빼줘야 다쓸수 있으니까 따로 빼서 씀
			while (true) { // 1을 코드에 담음
				System.out.print("번호>>");
				code = sc.nextInt();

				// 1-6인경우에만 무한반복을 빠져나감
				if (code > 6 || code < 1) { //
					// if (code >= 1 && code <= 6) 엔드는 두개다 확인해야된다.
					System.out.println("옳바른값 입력 ㄱㄱ");
					continue;
				} else {
					break;// 정상적인 값이오면 빠져나가고 가장 가까운 곳으로 빠져나가자
				}
			} // while 번호다시 입력하는 와일
				// 사용자가 입력한 값 1-6인경우
			MemberDAO mDao = new MemberDAO(); // 멤버디에이오 클래스를 가서 객체를 생성할것이다.
			if (code == 1) { // 객체생성하고 생성자메서드까지 갔다와야함
				System.out.println("○○○○○○○○○○○○○○○○○○○○○○○○○○○○○○○○○○");
				System.out.println("○○계약할 아티스트 정보를 입력해주세요.");
				System.out.println("○○이름>> ");
				sc.nextLine();// 1 누른거 받아주는 기능
				String aname = sc.nextLine();
				System.out.println("○○분야>> ");
				String major = sc.nextLine();
				System.out.println("○○그룹유무(y/n)>> ");
				String groupyn = sc.nextLine();
				System.out.println("○○그룹이름>> ");
				String groupnm = sc.nextLine();
				System.out.println("○○연봉>> ");
				int sal = sc.nextInt();// 이 라인까지 사용자에게 입력을 받음

				MemberDTO mDto = new MemberDTO(aname, major, groupyn, groupnm, sal);// 다섯개 담는 가방
				mDao.memInsert(mDto);
				
				
			} else if (code == 2) {// 엘스이프는 하나 타면 밑에놈은 ㄴㄴ한다.
				System.out.println("○○○○○○○○○○○○○○○○○○○○○○○○○○○○○○○○○○");
				System.out.println("○○수정할 아티스트번호를 입력해주세요");
				System.out.println("○○번호>>");
				sc.nextLine();
				String ano = sc.nextLine();
				System.out.println("○○이름>>");
				String aname = sc.nextLine();
				System.out.println("○○전공>>");
				String major = sc.nextLine();
				System.out.println("○○그룹유무(y/n)>>");
				String groupyn = sc.nextLine();
				System.out.println("○○그룹이름>>>");
				String groupnm = sc.nextLine();
				System.out.println("○○연봉>>>");
				int sal = sc.nextInt();
				
				MemberDTO mDto = new MemberDTO(ano, aname, major, groupyn, groupnm, sal);
						
				mDao.memUpdate(mDto);
				
			} else if (code == 3) { // 소속아티스트 삭제
				System.out.println("○○○○○○○○○○○○○○○○○○○○○○○○○○○○○○○○○○");
				System.out.println("○○삭제할 아티스트 번호를 입력");
				System.out.print("○○번호>>");
				sc.nextLine();// 개행
				String ano = sc.nextLine();
				mDao.memDelete(ano);
				
			} else if (code == 4) {
				System.out.println("○○○○○○○○○○○○○○○○○○○○○○○○○○○○○○○○○○○");
				System.out.println("○○회사에 소속된 아티스트명단");
				mDao.memSelect();
			
			} else if (code == 5) {
				System.out.println("○○○○○○○○○○○○○○○○○○○○○○○○○○○○○○○○○○○");
				System.out.println("○○검색할 아티스트의 이름을 입력");
				System.out.print("○○>>>이름");
				sc.nextLine();
				String aname = sc.nextLine();
				mDao.memSearch(aname);
				
			} else if (code == 6) {
				System.out.println("<프로그램종료>");
				System.exit(0); // 종료
			}

		} // while 맨위
	}// main
}// class
