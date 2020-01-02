package problem.DDBoard;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapCnfig;

public class BBdao{
	SqlSessionFactory sqlSessionFactory = SqlMapCnfig.getSqlSession();
	SqlSession sqlSession;

	public void BoardInsert(String title, String content, String writer) {
		sqlSession = sqlSessionFactory.openSession(true);
	HashMap<String, String>map = new HashMap<>();
	map.put("title", title);
	map.put("content", content);
	map.put("writer", writer);
	

		try {
			int result = sqlSession.insert("insert", map);
			if (result > 0) {
				System.out.println("등록성공");
			} else {
				System.out.println("등록실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void BoardUpdate(int ano, String title, String content, String writer) {
		sqlSession = sqlSessionFactory.openSession(true);
		HashMap<String, Object>map = new HashMap<>();
		map.put("ano", ano);
		map.put("title", title);
		map.put("content", content);
		map.put("writer", writer);
		
		try {
			int result = sqlSession.update("update", map);
			if (result > 0) {
				System.out.println("수정성공");

			} else {
				System.out.println("수정실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void BoardDelete(int ano) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			int result = sqlSession.delete("ano");
			if(result > 0) {
				System.out.println("삭제성공");
			}else {
				System.out.println("삭제실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}// 클라스
