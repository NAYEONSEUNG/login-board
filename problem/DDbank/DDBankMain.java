package problem.DDbank;
//			1.프로그램 전체반복

//			2. 1~6까지 번호만 허용(나머지 무한반복 다시입력)
//			3. 계좌개설만들기(INSERT)
//			4. 계좌조회만들기(SELECT)
//			5. 사용자 검색 만들기(이름으로)
//			6. 프로그램 종료기능 만들기

import java.util.Scanner;

public class DDBankMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BankDAO bDao = new BankDAO();
		int code = 0;
		int result = 0;
		while (true) {
			System.out.println("◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆");
			System.out.println("◆◆숑숑은행");
			System.out.println("◆◆1.계좌개설");
			System.out.println("◆◆2.입금");
			System.out.println("◆◆3.출금");
			System.out.println("◆◆4.계좌조회");
			System.out.println("◆◆5.사용자검색");
			System.out.println("◆◆6.프로그램 종료"); 
			System.out.println("◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆");
			while (true) {
				System.out.println("◆◆번호>>>");
				code = sc.nextInt();

				if (code >= 1 && code <= 6) {
					break;
				} else {
					System.out.println("1~6 다시입력해주세요");
					continue;
				}

			} // 작은와일

			if (code == 1) {
				System.out.println("◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆");
				System.out.println("◆◆개설할 계좌입력");
				System.out.print("◆◆예금주입력>>");
				sc.nextLine();
				String bname = sc.nextLine();
				System.out.print("◆◆비밀번호 입력>>");
				String pw = sc.nextLine();
				BankDTO bDto = new BankDTO(bname, pw);
				bDao.BankInsert(bDto);

			} else if (code == 2) {
				System.out.println("◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆");
				System.out.print("◆◆입금계좌>>");
				int bno = sc.nextInt();
				System.out.print("◆◆입금할 금액입력>>>");
				int money = sc.nextInt();
				BankDTO bDto = new BankDTO(bno, money);
				bDao.BankUpdate(bDto);

			} else if (code == 3) {
				System.out.println("◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆");
				System.out.println("◆◆출금하겠습니다.");
				System.out.println("◆◆출금계좌명>>");
				int bno = sc.nextInt();
				System.out.println("◆◆비밀번호입력>>>");
				sc.nextLine();
				String pw = sc.nextLine();
				BankDTO bDto = new BankDTO(bno, pw);
				result = bDao.Bankcheck(bDto);
				if (result > 0) {
					System.out.println("반갑습니다!");
					System.out.println("◆◆출금할 금액입력>>");
					int money = sc.nextInt();
					bDto = new BankDTO(bno, pw);
					int gold = bDao.BankCash(bDto);// 잔액

					if (gold >= money) {
						bDto = new BankDTO(bno, pw, money);
						bDao.BankUpdate2(bDto);
					} else {
						System.out.println("잔액이부족합니다.");

					}

				} else {
					System.out.println("다시 확인해 주세요!");
				}

			} else if (code == 4) {
				System.out.println("◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆");
				System.out.println("◆◆계좌를 조회하겠습니다.");
				bDao.BankSelect();

			} else if (code == 5) {
				System.out.println("◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆");
				System.out.println("◆◆계좌를 검색하겠습니다.");
				System.out.println("◆◆예금주명 입력>>>");
				sc.nextLine();
				String bname = sc.nextLine();
				bDao.BankSearch(bname);

			} else if (code == 6) {

			}

		} // 큰와일
	}// main

}// class
