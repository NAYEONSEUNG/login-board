package problem;

public class Parking {
	int[] space = new int[5]; // 주차공간 5대
	int carCnt = 0; // 현재 주차된 차량수 뒤에 0빼고 int carCnt; 라고 해도된다.

//	public int duplication(int car) { // 중복차량 검사기
//		int result = 0; // 0:입고 1:입고취소
//		for (int i = 0; i < space.length; i++) {
//			if (car == space[i]) {
//				System.out.println("중복된 번호가 있습니다.\n 다른번호로 입고하세요");
//				result =1;
//				return result;
//			} // if
//		}
//		return result;
//	}// duplication 종료

	// 1.주차타워 현황
	public void viewParking() {
		System.out.println("==================");
		for (int j = 0; j < space.length; j++) {// length 배열의 최대치
			System.out.println("  ||" + (j + 1) + "층:" + space[j] + "||");
		} // for j
		System.out.println("==================");
	}// 뷰파킹

	// 2.주차타워입고 차량번호들어간 상태 int car에
	public void inParking(int car) {
		// 차량입고 비즈니스 로직
		// 1.주차공간이 여유가 있는지 체크!
		// full:2번타워를 이용하세요~ 끝냄
		// ok: 2번으로 넘어감
		// 2.차량번호 중복체크
		// 중복: 차량번호를 다시 입력해주세요~끝
		// ok: 3번으로 넘어감
		// 3. 주차타워에 차량을 입고!
		// ok:입고완료!, 주차현황 출력!

		// 현재 주차타워에 빈공간이 없는 경우
		if (carCnt == space.length) {// 설명하기!!!!!!!! 숫자가아닌 space.length를 넣어주면 위에 배열에[]수를 넣으면 자동으로 바뀐다.
			System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
			System.out.println("★공간이 부족합니다. 2번타워를 이용해주세요.");
			return; // 중괄호만나거나 return이 나오면 메서드는 끝나라는 말 , 근데 public void인데 리턴을 써도 에러가 안뜬다.
					// 왜냐하면 리턴으로 값을 안보내겠다는 말이다. 메서드 실행종료
					// 리턴문 자체를 안쓰겠다는게 아니라. 순수 메서드 끝
		}

		// 중복차량유무체크
		// int flag = searchCar(car);
		if (searchCar(car)) {// 중복차량
			System.out.println("이미 주차중인 차량번호입니다.");
			System.out.println("차량번호를 확인하시고 다시 입고하세요");
			return;
		}
//		for(int i=0; i<space.length; i++) {
//			if(space[i] == car) {
//				System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
//				System.out.println("★중복된 차량");
//				return;
//			}
//			
//		}

		// 주차공간을 순회하면서 비어있는 (입고할 공간)을 찾음
		for (int i = 0; i < space.length; i++) {
			// 비어있는 공간을 찾음(값이0이면 비어있음)
			if (space[i] == 0) {
				space[i] = car;
				carCnt += 1;
				// carCnt = carCnt + 1;
				viewParking();
				break;// 반복문 빠져나와라
			} // if
		} // for i
	}// 인파킹 메서드 끝나면 다시 돌아가!

	// 3. 주차타워 출고
	public void outparking(int car) {
		// 주차타워에 차량이 0대인 경우
		if (carCnt == 0) {
			System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
			System.out.println("★주차중인차량이 없습니다. 확인하세요");
			return;
		}

		for (int i = 0; i < space.length; i++) {
			// 주차된차량번호와 내가입력한 차량번호가 같을때
			if (space[i] == car) {
				space[i] = 0; // 출고 => 공간0
				carCnt -= 1; // 현재주차차량 -1
				System.out.println("차량이 출고되었습니다.");
				System.out.println("★" + (i + 1) + "층:" + car + "출고완료!");
				viewParking();
				return;
			}
		}

		// 입력한 차량번호가 해당 주차타워에 없음!!
		System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
		System.out.println("★없는차량입니다. 다시입력하세요");
	}// 아웃파킹

	// 4.검색 : 현재차량번호가 기존에 등록된 차량번호와 중복체크
	public boolean searchCar(int car) {
		boolean flag = false; // 중복유무판별(0:정상, 1:중복
		for (int i = 0; i < space.length; i++) {
			if (space[i] == car) {
				flag = true;
			}
		}
		return flag;

	}

}// class
