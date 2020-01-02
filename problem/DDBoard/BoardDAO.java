package problem.DDBoard;
//boardSelect(){
//	ArrayList<BoardDTO>list = ArrayList<>();
//	boardSelect(){
//		list.clear();
//	} 리스트는 1회만 생성하고 메서드 실행시마다 리스트에 값을 전부
//}		삭제하고 값을 담음.
//dao에 필요한 메서들부터 쫙 생성
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import jdbc.DBManager;


public class BoardDAO {//게시글 관련 애들이 모여있는데 데이터베이스 사용하네
		Connection conn;
		PreparedStatement pstmt;
		ResultSet rs;
		ArrayList<BoardDTO>list = new ArrayList<>();
		BoardDTO bDto;
		int result;
	public void BoardInsert(BoardDTO bDto) {
		try {
			conn = DBManager.getConnection();//드라이버로드, 커넥션생성
			String sql = "INSERT INTO tbl_board (ano, title, content, writer) "
						+ "VALUES (seq_board.NEXTVAL, ?,?,?)";//질의어작성
			pstmt = conn.prepareStatement(sql); //질의어 준비  이거없으면 널값이 들어온다.
			
			pstmt.setString(1,bDto.getTitle());//미완성된질의어 (?부분 삽입)
			pstmt.setString(2,bDto.getContent());
			pstmt.setString(3,bDto.getWriter());
			
			//질의어 실행
			int result = pstmt.executeUpdate();
			//실행한 질의어 결과값으로 실행성공여부 확인
			if(result > 0) {
				System.out.println("등록성공");
			}else {
				System.out.println("등록실패");
			}
		
			//커넥션 끊기
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
	} 
	public void BoardUpdate(BoardDTO bDto) {
		System.out.println(bDto.toString());
		try {
			conn = DBManager.getConnection();
			String sql="UPDATE tbl_board SET "
					 + "title = ?, "
					 + "content = ?, "
					 + "writer = ? "
					 + "WHERE ano =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bDto.getTitle());
			pstmt.setString(2, bDto.getContent());
			pstmt.setString(3, bDto.getWriter());
			pstmt.setInt(4, bDto.getAno());
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("수정성공");
			}else {
				System.out.println("수정실패");
			}
			
						 
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
	}
	public void BoardDelete(int ano) {
		try {
			conn = DBManager.getConnection();
			String sql = "DELETE FROM tbl_board "
						+"WHERE ano = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ano);
			int result = pstmt.executeUpdate();
			
			if(result >0) {
				System.out.println("삭제성공");
				
			}else {
				System.out.println("삭제실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
	}
	
	public void BoardSelect() {//상세게시글 출력
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_board " 
					   + "ORDER BY ano DESC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list.clear();
			while(rs.next()) {
				int ano = rs.getInt("ano");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				Date regdate = rs.getDate("regdate");
				BoardDTO bDto = new BoardDTO(ano, title, content, writer, regdate);//꺼낸것을 한줄로 담는다
				list.add(bDto);//한줄짜리를 다시 리스트에 담고
				
			}
			printQuery(list);
			
		} catch (Exception e) {
		e.printStackTrace();
		}finally {
			
		}
   }
	public void BoardSearch(String keyword) {
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_board "
						+ "WHERE title LIKE ?  or "
						+	"content LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"%" + keyword + "%");
			pstmt.setString(2,"%" + keyword + "%");
			rs = pstmt.executeQuery();
			
			list.clear();
			while(rs.next()) {
				int ano = rs.getInt("ano");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				Date regdate = rs.getDate("regdate");
				BoardDTO bDto = new BoardDTO(ano, title, content, writer, regdate);//꺼낸것을 한줄로 담는다
				list.add(bDto);//한줄짜리를 다시 리스트에 담고
				
			}
			System.out.println("\""+keyword + "\"로 검색한결과 총" + list.size() + "검색되었습니다.");// ' \" ' 역슬러시 쌍따옴표는 출력문이다.
			printQuery(list);
			
				
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
	}
	public void BoardView(int ano) {
		int result = viewCntPlus(ano);
		if(!(result >0)) {//
			System.out.println("조회수 증가 실패, 관리자에게 문의");
			return;
		}
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * "
					    +"FROM tbl_board "
					    +"WHERE ano = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ano);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ano = rs.getInt("ano");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				Date regdate = rs.getDate("regdate");
				int viewcnt = rs.getInt("viewcnt");
				bDto = new BoardDTO(ano, title, content, writer, viewcnt, regdate);
			}
			
			System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
			System.out.println("★★게시글번호"+ano);
			System.out.println("★★작성일자"+bDto.getRegdate());
			System.out.println("★★제목|"+bDto.getTitle());
			System.out.println("★★내용|"+bDto.getContent());
			System.out.println("★★작성자|"+bDto.getWriter());
			System.out.println("★★조회수:"+bDto.getViewcnt());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				rs.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void Boardsort() {
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_board "
					   + "ORDER BY viewcnt DESC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list.clear();
			while(rs.next()) {
				  int ano = rs.getInt("ano"); 
				  String title = rs.getString("title");
				  String content = rs.getString("content"); 
				  String writer = rs.getString("writer");
				  int viewcnt = rs.getInt("viewcnt");
				  Date regdate = rs.getDate("regdate");
				  BoardDTO bDto = new BoardDTO(ano, title, content, writer, viewcnt, regdate);
				  list.add(bDto);
			}
			System.out.println("=================================");
			System.out.println("번호\t제목\t\t\t내용\t작성자\t작성일자\t");
				for (BoardDTO line : list) {
					System.out.println(line.toString());
				}
					
					
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		  try {
			conn.close();
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
			
		
	}
	
	public int viewCntPlus(int ano) {//상세게시글 조회수 + 1 증가
		try {
			conn = DBManager.getConnection();
			String sql = "UPDATE tbl_board "
						+"SET viewcnt = viewcnt + 1 "
						+"WHERE ano = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,ano);//물음표 수만큼 pstmt._____나온다
			
			result = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				
		}
	    return result;//조회수 안ㄴ올라가면 상세게시ㅠ판도 안보여줄라겨
	}
	
	//조회된 결과를 출력하는 함수
	public void printQuery(ArrayList<BoardDTO>list) {
		System.out.println("========================================");
		System.out.println("번호\t제목\t\t내용\t작성자\t작성일자\t");
		System.out.println("========================================");
		for (BoardDTO line : list) {
			System.out.println(line.toString());
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}//class
