package problem.DDbank;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSessionFactory;

import jdbc.DBManager;
import problem.DDBoard.BoardDTO;

public class BankDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<BankDTO>list = new ArrayList<>();
	BoardDTO bDto;
	int result;
	
	public void BankUpdate(BankDTO bDto) {
		try {
			conn = DBManager.getConnection();
			String sql = "UPDATE tbl_bank SET "
				       + "money = money + ? "
				       + "WHERE bno = ?";
					
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bDto.getMoney());
			pstmt.setInt(2, bDto.getBno());
			result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("입금완료~~~~");
			}else {
				System.out.println("입금실패~~~~");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		
	}

	
	public void BankInsert(BankDTO bDto) {
		try {
			conn = DBManager.getConnection();
			String sql = "INSERT INTO tbl_bank(bno,bname,pw) "
						+ "VALUES(seq_bank.NEXTVAL,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bDto.getBname());
			pstmt.setString(2, bDto.getPw());
			int result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("◆◆개설성공!!");
				
			}else {
				System.out.println("◆◆개설실패~~~");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
	}
	public void BankSelect() {
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_bank";
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
			   	 int bno = rs.getInt("bno"); 
			     String bname = rs.getString("bname"); 
			     String pw = rs.getString("pw");
			     int money = rs.getInt("money"); 
			     Date regdate = rs.getDate("regdate"); 
			     BankDTO bDto = new BankDTO(bno, bname, pw, money, regdate);
			     list.add(bDto);
			}
			for (BankDTO line : list) {
				System.out.println(line.toString());
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
	}
	public void BankSearch(String bname) {
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_bank "
						+ "WHERE bname LIKE?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+bname+"%");
			rs = pstmt.executeQuery();
			
			list.clear();
			while(rs.next()) {
				 int bno = rs.getInt("bno"); 
			     bname = rs.getString("bname"); 
			     String pw = rs.getString("pw");
			     int money = rs.getInt("money"); 
			     Date regdate = rs.getDate("regdate");
			     BankDTO bDto = new BankDTO(bno, bname, pw, money, regdate);
			     list.add(bDto);
			}
			for (BankDTO line : list) {
				System.out.println(line.toString());
			}
					
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		
		
	}
	//메서드 3개만들기
	//1.인증메서드 비넘버 비번
	//2.입력한 값이 통장에 있는지 확인하는 메서드 셀렉트
	//3. 출금실행 
	
	public int Bankcheck(BankDTO bDto) {
		int result =0;
		try {
			conn = DBManager.getConnection();
			 String sql = "SELECT bno, pw "
					    + "FROM tbl_bank "
						+ "WHERE bno = ? "
						+ "and pw = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bDto.getBno());
			pstmt.setString(2, bDto.getPw());
			rs = pstmt.executeQuery();
			if(rs.next()) {
			  result = 1;
			
			}
			
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		return result;
	}
	
	//잔액확인
	public int BankCash(BankDTO bDto) {
		int money = 0;
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * "
					   +"FROM tbl_bank "
					   +"WHERE bno = ?"
					   +"and pw = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bDto.getBno());
			pstmt.setString(2, bDto.getPw());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				money = rs.getInt("money");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		return money;
	}
	
	public void BankUpdate2(BankDTO bDto) {
		try {
			conn = DBManager.getConnection();
			String sql = "UPDATE tbl_bank SET "
						+ "money = money - ? "
						+ "WHERE bno = ? "
						+ "and pw = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bDto.getMoney());
			pstmt.setInt(2, bDto.getBno());
			pstmt.setString(3, bDto.getPw());
			result = pstmt.executeUpdate();
			if(result >0) {
				System.out.println("◆◆◆출금완료◆◆◆");
				
			}else {
				System.out.println("◆◆◆출금실패◆◆◆");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		
	}
	
	public boolean checkUser(int bno, String pw) {
		boolean flag = false;
		sqlSession = SqlSessionFactory.opensession();
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return flag;
	}
	
	
	
	
	
	
	
}//CLASS
