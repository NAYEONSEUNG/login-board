package problem.calc;

public class Calculater {
	int result; //  결과를 저장할 변수
	
	//덧셈기능
	 public int sum(int first, int second){
	      //메인페이지에있는 더하기한테 리턴값 보낸다.
	      return first + second;
	 }//sum
	
	 //뺄셈기능
	 public int sub(int first, int second){
		 return first - second;
		
	 }
	 
	 //곱셈기능
	 public int multi(int first, int second){
		 return first * second;
		
	 }
	 
	 //나눗셈기능
	 public int div(int first, int second){
		 return first / second;
		 
	 }
	 
}//class
