package problem;

import java.util.Scanner;

public class ReversPrint000 {

	//조건
	//1.사용자가 임의의 정수를 입력
	//2.사용자가 입력한 정수를 1부터 끝까지 출력
	//출력 예제
	//입력>> 5
	//1
	//2
	//3
	//4
	//5
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력>>");
		int num = sc.nextInt();
				
		for(int i = num ; i >= 1  ; i--) {   //시작값을 num으로 먼저 입력, 끝값을 1로 입력
			System.out.println(i);
		}

		
		
		
		
		

	}
	
}

