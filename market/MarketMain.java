package market;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class MarketMain {
	// 내부저장소
	// 관리자 계정 ID와 PW선언
	String id = "admin"; // 전역변수
	String pw = "1234";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ProductDAO pDao = new ProductDAO();
		MarketMain mm = new MarketMain();
		int code = 0;
		Boolean flag = false;
		SaleDAO sDao = new SaleDAO();

		String userid = "";// 지역변수 선언
		String userpw = "";
		System.out.println("♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪");
		System.out.println("♬♪  상점 시스템 버전1.0♬♪");

		// do{ } 반복전에 최초 1회 실행 ,조건문이 true면 계속 반복
		// while() 괄호안에 true면 계속 반복

//		do {
//			System.out.println("♬♪[메시지] 로그인하세요");
//			System.out.print("♬♪아이디>>");
//			userid = sc.nextLine();
//			System.out.print("♬♪비밀번호>>");
//			userpw = sc.nextLine();
//		} while (mm.login(userid, userpw)); 
		// 로그인체크
		// static은 공용의 개념 스태틱과 인스턴스 개념이 ㅈㄴ 중요

		// 로그인 성공 업무시작
		while (true) {
			while (true) {
				System.out.println("♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪");
				System.out.println("♬♪ 1. 제품 판매 ");
				System.out.println("♬♪ 2. 제품 등록&추가 ");
				System.out.println("♬♪ 3. 제품 수정 ");
				System.out.println("♬♪ 4. 제품  삭제");
				System.out.println("♬♪ 5. 제품 조회 ");
				System.out.println("♬♪ 6. 제품 검색 ");
				System.out.println("♬♪ 7. 일일 매출현황 ");
				System.out.println("♬♪ 8. 프로그램 종료 ");
				System.out.println("♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪");
				System.out.print("♬♪ 번호>>");
				code = sc.nextInt();

				if (code >= 1 && code <= 8) {
					break;
				} else {
					System.out.println("1~~8까지만 입력 하세요");
					continue;
				}
			} // 번호 입력 와일

			if (code == 1) {
				
				String sname;
				int cnt;
				int tprice;
				/*
				 * 1. 문자열형에 판매할 제품 담고 제품이 (오라클 디비에) 있는지 확인 2. 제품이 존재하면 판매할 량을 인트형에 담고 디비에 존재하는
				 * cnt(재고) 값과 비교하여 재고가 판매할 량보다 많으면 판매 3. 제품이 존재하고 재고가 판매량보다 많으면 판매량과 디비에 존재하는
				 * 가격을 곱하여 판매금액 설정 tbl_product
				 * 
				 * 4. tbl_sale에 판매 아이템, 판매량,판매금액 인서트 5. code7에서 sum(tprice) 셀렉트
				 * 
				 */
				System.out.println("♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪");
				System.out.println("♬♪  구매하고싶은 제품의 번호와 수량을 입력하세요");
				List<ProductDTO> list = pDao.selectUsePdt();
				// 현재 등록된 제품중 재고가 1보다 큰것(즉 수량이 0인 제품을 제외)
				// pDao.selectUsePdt(); 
				while (true) {
					System.out.println("♬♪♬구매할 제품번호");
					int buyCode = sc.nextInt();
					System.out.println("♬♪♬구매할 수량>>");
					cnt = sc.nextInt();
					
					// tbl_sale에 판매한 기록을저장
					// 판매하는 제품명, 수량, 총가격

					int price = list.get(buyCode - 1).getPrice();
					// 판매하려는 제품명
					sname = list.get(buyCode - 1).getPname();
				    tprice = price * cnt;// 1개가격 x 구매수량
					int nowCnt = list.get(buyCode - 1).getCnt();
					if (nowCnt >= cnt) {
						break;
					} else {
						System.out.println("재고가 부족합니다.");
					}
                 }
					// tbl_sale에 판매한 기록을 저장(판매하는 제품명, 수량, 총가격)
					HashMap<String, Object> map = new HashMap<>();
					map.put("sname", sname);
					map.put("cnt", cnt);
					map.put("tprice", tprice);
					int result = sDao.insertSale(map);
					if (result > 0) {
						// tbl_product에서 재고를 마이너스
						pDao.cntMinusPdt(sname, cnt);
						System.out.println("♬♪♬판매성공");
					} else {
						System.out.println("♬♪♬판매실패");
					}
				
			} else if (code == 2) {
				System.out.println("♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪");
				System.out.print("♬♪  제품명>>");// 기존 디비에 있는지 확인하고 없으면 인서트 있으면 업데이트 등록및 추가하고싶은 제품이름 쓰세요, 입력한것을 디비에서 조회,
				sc.nextLine();
				String pname = sc.nextLine();
				// 2
				System.out.println(pname);
				// System.out.println(pDao.pdtAlready(pname));
				if (pDao.pdtAlready(pname)) {
					// 기존에 등록된 제품임으로 추가(update)기능
					// 입고수량 입력받아서 UPDATE
					System.out.println("제품 수량을 입력하세요>>");
					int cnt = sc.nextInt();
					pDao.cntPlusPdt(pname, cnt);
				} else {
					// 최초 등록된 제품임으로 등록(insert)기능
					// 제조회사, 가격, 입고수량 입력받아서 INSERT
					// System.out.println("상품명입력>>");
					// pname = sc.nextLine();
					System.out.println("제조회사>>");
					String company = sc.nextLine();
					System.out.println("가격>>");
					int price = sc.nextInt();
					System.out.println("수량>>");
					int cnt = sc.nextInt();
					ProductDTO pDto = new ProductDTO(pname, company, price, cnt);

					pDao.insertPdt(pDto);
				}

			} else if (code == 3) {
				System.out.println("♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪");
				System.out.println("♬♪  제품을 수정합니다.");
				System.out.println("♬♪  제품번호>>");
				int pno = sc.nextInt();
				System.out.println("♬♪제품명>>.");
				sc.nextLine();
				String pname = sc.nextLine();
				System.out.println("♬♪가격>>");
				int price = sc.nextInt();
				pDao.marketUpdate(pno, pname, price);

			} else if (code == 4) {
				System.out.println("♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪");
				System.out.println("♬♪♬  제품을 삭제합니다");
				System.out.println("♬♪♬♪ 제품명>>");
				sc.nextLine();
				String pname = sc.nextLine();
				pDao.marketDelete(pname);

			} else if (code == 5) {
				System.out.println("♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪");
				System.out.println("♬♪♬ 전체 제품조회");
				pDao.marketSelect();

			} else if (code == 6) {
				System.out.println("♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪");
				System.out.println("♬♪♬♪♬ 제품검색합니다.");
				System.out.println("♬♪♬♪♬ 제품명>>>");
				sc.nextLine();
				String keyword = sc.nextLine();
				pDao.marketSearch(keyword);

			} else if (code == 7) {
				System.out.println("♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪");
				System.out.println("♬♪♬일일매출현황입니다");
				sDao.dashBoard();
				
			} else if (code == 8) {
				System.out.println("♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪♬♪");
				System.out.println("♬♪프로그램을 종료합니다");
				System.exit(0);
			}

		}

	}// main

	public boolean login(String userid, String userpw) {
		Boolean flag = true;// 로그인 유무 true:실패 false:성공
		if (userid.contentEquals(id) && userpw.equals(pw)) {// 로그인 성공 false false면 false
			flag = false;
			System.out.println("♬♪환영합니다 관리자님");
		} else {
			System.out.println("♬♪[메시지]로그인 실패");
		}
		return flag;
	}// boolean login

}// class
