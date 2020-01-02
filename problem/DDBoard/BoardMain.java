package problem.DDBoard;

import java.util.Scanner;

public class BoardMain {
 static String session="NO";
 static String userid = "";
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        int code = 0 ;// 사용자가 선택한 프로그램 번호
        BoDAO  bbdao = new BoDAO();//게시글 관련 기능 
        MemberDAO mDao = new MemberDAO();// 회원관련기능
        
       
        
        while(true) {
        	System.out.println("=====================");
        	System.out.println("==게시판");
        	System.out.println("==0.로그인");
        	System.out.println("==1.게시글 등록");
        	System.out.println("==2.게시글 수정");
        	System.out.println("==3.게시글 삭제");
        	System.out.println("==4.게시글 조회");
        	System.out.println("==5.게시글 검색");
        	System.out.println("==6.게시글 정렬");
        	System.out.println("==7.상세게시글");
        	System.out.println("==8만든이");
        	System.out.println("==9프로그램종료");
        	
        	if(BoardMain.session.equals("YES")) {
        		System.out.println(BoardMain.userid+"\"님환영합니다");
        	}
        	
        	
        	
         while(true) {
        	 System.out.println("번호>>>");
        	 code = sc.nextInt();
        	 if(code >= 0 && code <=7) {
        		 break;
        	 }else {
        		 System.out.println("0---7까지만 입력하세요");
        		 continue;
        	 }
         }//번호와일
         if(code == 0) {
        	 System.out.println("=======================");
        	 System.out.println("==로그인할 ID와 PW를 입력하세요");
        	 System.out.println("==ID >>");
        	 sc.nextLine();
        	 String id = sc.nextLine();
        	 System.out.println("==PW >>");
        	 String pw = sc.nextLine();
        	 
        	 mDao.login(id,pw);
         
         
        } else if(code == 1) {
        	 if(BoardMain.session.equals("NO")) {//로그인 노
        		 System.out.println("==로그인이 필요한 기능입니다.");
        		 continue;
        	 }
        	 System.out.println("=======================");
        	 System.out.println("등록할게시글입력");
        	 System.out.print("타이틀입력>>");
        	 sc.nextLine();
        	 String title = sc.nextLine();
        	 System.out.print("내용입력>>");
        	 String content = sc.nextLine();
             
        	 String writer = BoardMain.userid;
        	 bbdao.BoardInsert(title, content, writer);
        	 
         }else if(code == 2) {
        	 if(BoardMain.session.equals("NO")) {//로그인 노
        		 System.out.println("==로그인이 필요한 기능입니다.");
        		 continue;
        	 }
        	 System.out.println("======================");
        	 System.out.println("수정할게시글>> 번호");
             int ano = sc.nextInt();      
             if(!(BoardMain.userid == bbdao.getWriter(ano))){
         		System.out.println("수정할수 없습니다.");
         		 continue;
         		 
         	 }
             System.out.println("제목>>");
             sc.nextLine();
             String title = sc.nextLine();
             System.out.println("내용>>");
             String content = sc.nextLine();
             System.out.println("작성자>>");
             String writer = sc.nextLine();
             bbdao.BoardUpdate(ano, title, content, writer);
             
             
         }else if(code == 3) {
        	 if(BoardMain.session.equals("NO")) {//로그인 노
        		 System.out.println("==로그인이 필요한 기능입니다.");
        		 continue;
        	 }
        	// int ano = sc.nextInt();
        	 System.out.println("=====================");
        	 System.out.println("삭제할 게시글 번호>>");
        	 int ano = sc.nextInt();
        	 bbdao.getWriter(ano);
        	 if(!(BoardMain.userid == bbdao.getWriter(ano))){
        		System.out.println("삭제할수 없습니다.");
        		 continue;
        		 
        	 }
        	 bbdao.BoardDelete(ano);
        	 
         }else if(code == 4) {
        	 System.out.println("=================");
        	 System.out.println("조회합니다");
        	 bbdao.BoardSelect();
        	 
         }else if(code == 5) {
        	 System.out.println("===================");
        	 System.out.println("검색할 키워드>>>");
        	 sc.nextLine();
        	 String keyword = sc.nextLine();
        	 bbdao.BoardSerarch(keyword);
        	 
         }else if(code == 6) {
        	 System.out.println("==============================================");
        	 System.out.println("조회순으로 정렬합니다.");
        	 bbdao.BoardSort();
         }else if(code == 7) {
        	 System.out.println("===============================");
        	 System.out.println("보고싶은 게시글 번호");
        	 System.out.println("번호>>");
        	 int ano = sc.nextInt();
        	bbdao.BoardView(ano);
         }
        
        }//큰와일
	}
}
