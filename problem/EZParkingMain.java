	/*
		 * desc: Array를 사용하여 주차공간을 만들고
		 * 		차량을 입고 또는 출고하는 주차타와 프로그램
		 * writer: nys
		 * date: 2019.12.03
		 */
package problem;

import java.util.Scanner;

public class EZParkingMain {
	 public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);
		 Parking park = new Parking(); // 생성자 1.객체생성 2.기획기능
		 
		 
		 while(true) {
			 System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
			 System.out.println("★EZ Parking ver1.5");
			 System.out.print("★Car Number>>");
			 int car = sc.nextInt(); // 주차타워를 이용할 차량번호
			
			 int code = 0; // 사용자가 선택한 번호  원래 와일문 안에 있었는데 밖으로 빼줌
			 while(true) {//와일은 반복횟수가 안정해졌을떄
				 System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
				 System.out.println("★ 1.차량입고");
				 System.out.println("★ 2.차량출고");
				 System.out.println("★ 3.취소");
				 System.out.print("★선택>>");
				 code = sc.nextInt();//입고, 출고, 취소를 선택하는 번호
						 
				 if(code > 3 || code < 1) {//고객이 번호 잘못눌렀을경우
					 System.out.println("★올바른 값을 입력하세요");
					 continue;
				 } else {//code가 1,2,3인경우
					 break;
				 }
			 }//while
			 if(code == 1) {//차량입고
				
					 park.inParking(car);//인파킹을 찾는데 car값을 넣어라
				 
				 
			 }else if(code == 2) {// 챠량출고
				park.outparking(car);
				// continue;
				 
			 }else if(code == 3) {//취소
				 car = 0; //기존에 입력한 차량번호 Clear
				 System.out.println("★취소되었습니다. 다음에 이용해주세요.");
				// continue;
			 }//else if 닫음
		 }//맨위 while
		 
		
	
	 }//main
	
}//class
