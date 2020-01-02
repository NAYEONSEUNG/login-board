package problem;

import java.util.Scanner;

public class BigSmall01 {

	public static void main(String [ ] args) {
		//사용자가 2개의 값을 입력
		//--입력--
		//번호1>>5
		//번호2>>7
		//--조건--
		//번호1 < 번호2 보다 작으면
		//번호1에 값과 번호 2의 값을 서로 교환하여
		//번호1이 항상 큰수를 가지게 만든다.
		//--출력--
		//번호1 > 번호2
		Scanner sc = new Scanner(System.in);
		System.out.print("번호1>>");
		int num1 = sc.nextByte();
		System.out.print("번호2>>");
		int num2 = sc.nextByte();
		int temp = 0; //저장소를 하난더 만들어줌, 티비들 손이 없다.
		//치환할때
		
		if(num1 < num2) { //num1이 num2보다 작을때 실행
			temp = num1; // 넘1을 temp저장소에 보관
			num1 = num2;// 넘2를 넘1에 보관
			num2 = temp;//temp를 넘2에 보관
			
			System.out.println(num1 + " > " + num2);
		
				
		
		}else 
			System.out.println(num1 +" > " + num2);
	
		
	//	System.out.println(num1 + "," + num2);
				
		
		
		
	}//메인
}//클래스
