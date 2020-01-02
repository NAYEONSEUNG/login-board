package problem;

import java.util.Scanner;

public class BigSmall02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("번호1>>");
		int num1 = sc.nextInt();
		System.out.print("번호2>>");
		int num2 = sc.nextInt();
		System.out.print("번호3>>");
		int num3 = sc.nextInt();
		//넘1이 제일 커야됨   넘1>넘2   넘1>3   넘2>넘3
		int temp = 0;
		
		//num1은 항상 num2보다 큰 경우
			if(num1 < num2 ) {//넘1이 넘2보다 작을때 실행
			temp = num1;//
			num1 = num2;//
			num2 = temp;//
			
			}
		//num1은 항상 num3보다 큰 경우
		   if(num1 < num3) {//넘1이 넘3보다 작을때 실행
			temp = num1;
			num1 = num3;
			num3 = temp;
			
		    }
		//num2는 항상 num3보다 큰 경우   
		    if(num2 < num3) {
			temp = num2;
			num2 = num3;
			num3 = temp;
			
		    
//		  }
//			if(num1 < num2 ) {//넘1이 넘2보다 작을때 실행
//				temp = num1;//
//				num1 = num2;//
//				num2 = temp;//
//				
//				}
//			
//				if(num2 < num3) {
//				temp = num2;
//				num2 = num3;
//				num3 = temp;
//				
//			    }
//			    
//			    if(num1 < num3) {//넘1이 넘3보다 작을때 실행
//				temp = num1;
//				num1 = num3;
//				num3 = temp;
			
	
		}
		    System.out.println(num1 + "," + num2 + "," + num3);
			
			System.out.println(num1 + ">" + num2 + ">" + num3);
		

	}//메인

}//클래스
