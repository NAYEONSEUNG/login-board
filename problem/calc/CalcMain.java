package problem.calc;

import java.util.Scanner;

//사칙연산이 가능한 계산기 프로그램
public class CalcMain {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			Calculater calc = new Calculater();
			//ctrl + shift 방향기  누르면 방향키 방향대로 복 붙이 된다.
			//alt + 방향키  위아래 글들이 옮겨진다.
			while(true) {	
				System.out.println("▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
				System.out.println("▦ 더하고 나누고 Ver1.0");
				System.out.print("▦ 숫자>>");
				int first = sc.nextInt();
				System.out.print("▦ 연산자(+,-,x,/)>>");
				sc.nextLine();//한줄개행을 막을수있다.
				String oper = sc.nextLine();
				System.out.print("▦숫자>>");
				int second = sc.nextInt();
				
				//System.out.println(first + "," +oper+"," + second);
				int result = 0;
			
				if(oper.equals("+")) {
					result = calc.sum(first, second);
					
				}else if (oper.equals("-")) {
					result = calc.sub(first, second);
					
				}else if (oper.equals("*")) {
					result = calc.multi(first, second);
					
				}else if (oper.equals("/")) {
					result = calc.div(first, second);
				}
				//결과출력
				System.out.println(first + oper + second+"="+result);
		}//while
			
		}//main
}//class
