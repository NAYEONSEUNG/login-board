package problem;

public class TotalSum {

	// 1~100까지 짝수만 더해서 출력하시오
	// 시작값: 1
	// 종료값: 100
	// 계속 덧셈을 해서 누적: total
	public static void main(String[] args) {

		int total = 0; // 짝수 덧셈결과의 누적
		int total1 = 0; // 홀수 덧셈결과의 누적
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) {

				total = total + i;
			}else { 
				total1 = total1 +i;
			}

			//if (i % 2 == 1) {

			//	total1 = total1 + i;

			//}

		}
		System.out.println("1 ~ 100까지 짝수 총합은" + total);
		System.out.println("1 ~ 100까지 홀수 총합은" + total1);

	}// 메인

}// 클래스
