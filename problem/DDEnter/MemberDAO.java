package problem.DDEnter;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberDAO {// DB를 타는 작업이니까 DAO를 쓴다. 1-6기능들을 모아논 클래서
	Connection conn;// 전역변수로 등록 초기화까지 다해줌
	PreparedStatement pstmt;// 전역변수 니까
	ArrayList<MemberDTO> list = new ArrayList<>(); //멤버디티오값말고는 아무것도 못오게 할거다
	
	// 1.아티스트 등록
	public void memInsert(MemberDTO mDto) {
		try {
			conn = DBManager.getConnection(); // conn이라는 변수, 연결정보를 가지고 있음
			String sql = "INSERT INTO tbl_enter(ano, aname, major, groupyn, groupnm, sal) "
					+ "VALUES(seq_enter.NEXTVAL, ?,?,?,?,?)";// sql변수에 담는것들
			pstmt = conn.prepareStatement(sql);// 프리페어방식을 써야 물음표 채울수 있다.
			pstmt.setString(1, mDto.getAname());// 가방에 있는것을 가져온다 겟을 사용해서
			pstmt.setString(2, mDto.getMajor());
			pstmt.setString(3, mDto.getGroupyn());
			pstmt.setString(4, mDto.getGroupnm());
			pstmt.setInt(5, mDto.getSal());

			int result = pstmt.executeUpdate();
			System.out.println("○○" + mDto.getAname() + "아티스트와 계약을 성공");
			System.out.println("○○등록 등록");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// 예외를 타던안타던 무조건 실행

		}
	}

	// 2.아티스트 수정
	public void memUpdate(MemberDTO mDto) {
		try {
			// 1.드라이버로드
			// 2.connecteion
			// 3.sql작성(preparedstatement)
			// 4.sql실행
			// 5.close(연결끊기)
			conn = DBManager.getConnection();
			String sql = "UPDATE tbl_enter " + "SET aname = ?," + "major = ?," + "groupyn = ?, " + "groupnm = ?,"
					+ "sal = ? " + "WHERE ano = ?";// 물음표 바인딩변수
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mDto.getAname());
			pstmt.setString(2, mDto.getMajor());
			pstmt.setString(3, mDto.getGroupyn());
			pstmt.setString(4, mDto.getGroupnm());
			pstmt.setInt(5, mDto.getSal());
			pstmt.setString(6, mDto.getAno());

			int result = pstmt.executeUpdate();// sql실행
			if (result > 0) {
				System.out.println("○○ " + mDto.getAname() + "아티스트 수정하였습니다.");
			} else {
				System.out.println("○○ 수정을 실패하였습니다 ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 연결끊기
			try {

			} catch (Exception e2) {
				e2.printStackTrace();

			}
		}
	}

	// 3.아티스트 삭제
	public void memDelete(String ano) {
		try {// 예외처리
				// 1.드라이버 로드, 2.DB 연결
			conn = DBManager.getConnection();
			// 3.SQL문작성(PrepareStatement 방식)
			String sql = "DELETE FROM tbl_enter " + "WHERE ano = ?";
			pstmt = conn.prepareStatement(sql);
			// 3.1 미완성 SQL문 완성(바인딩변수 사용)
			pstmt.setString(1, ano);
			// 4.SQL문 실행!!
			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("○○" + "아티스트와 계약을해지하였습니다.");
			} else {
				System.out.println("○○삭제에 실패하였습니다. 관리자에게 문의해 주세요");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
	}

	// 4.아티스트 조회
	public void memSelect() {
		try {
			conn=DBManager.getConnection();
			String sql = "SELECT * FROM tbl_enter";
			pstmt = conn.prepareStatement(sql);
			
			//4.sql실행
			//ResultSet 은 SELECT문 결과를 담음 
			ResultSet rs = pstmt.executeQuery();// select문
			
			while(rs.next()) { // 값이 있으면 트루   반복문 한번 돌때마다 한줄씩 담긴다.
				String ano = rs.getString("ano");//DB에있는 컬럼을 빼오는작업
				String aname = rs.getString("aname");
				String major = rs.getString("major");
				String groupyn = rs.getString("groupyn");
				String groupnm = rs.getString("groupnm");
				int sal = rs.getInt("sal");
				Date regdate = rs.getDate("regdate");
				MemberDTO mDto = new MemberDTO(ano, aname, major, groupyn, groupnm, sal, regdate);
				list.add(mDto);
			}
			//향상된 포문
			for(MemberDTO line : list) {
				System.out.println(line.toString());//이거 한줄이면 아래 8줄 필요가 없다.
//				System.out.print(line.getAname()+"\t");
//				System.out.print(line.getAno()+"\t");
//				System.out.print(line.getMajor()+"\t");
//				System.out.print(line.getGroupyn()+"\t");
//				System.out.print(line.getGroupnm()+"\t");
//				System.out.print(line.getSal()+"\t");
//				System.out.print(line.getRegdate());
//				System.out.println();
				
			}
			
			//ResultSet은 db관련객체
			//java전용 arrayList에 ResultSet에 데이터를
			//옮겨 담는 작업이 필용하다
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
	}

	// 5.아티스트 검색
	public void memSearch(String aname) {
		
		try {
		conn = DBManager.getConnection();
		String sql = "SELECT * FROM tbl_enter "
				+"WHERE aname LIKE ?";//이름 한글자만 입력해도 찾아준다. || 이표시는 절대값이라 생각하자
										// '%'||?||'%' ;
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "%"+aname+"%");
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String ano = rs.getString("ano");//DB에있는 컬럼을 빼오는작업
			aname = rs.getString("aname");//지역변수 중복이 되니까 앞에 string을 지워줌
			String major = rs.getString("major");
			String groupyn = rs.getString("groupyn");
			String groupnm = rs.getString("groupnm");
			int sal = rs.getInt("sal");
			Date regdate = rs.getDate("regdate");
			MemberDTO mDto = new MemberDTO(ano, aname, major, groupyn, groupnm, sal, regdate);
			list.add(mDto);//리스트에 검색한 값이 담김
			
		}
		for (MemberDTO line : list) {
			System.out.println(line.toString());
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		} 
			
		
	}
}
