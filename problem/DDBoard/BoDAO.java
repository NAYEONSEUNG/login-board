package problem.DDBoard;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapCnfig;

public class BoDAO {
	SqlSessionFactory sqlSessionFactory = SqlMapCnfig.getSqlSession();
	SqlSession sqlSession;
	List<BoardDTO> list;
	int result;

	public void BoardInsert(String title, String content, String writer) {
		sqlSession = sqlSessionFactory.openSession(true);
		HashMap<String, Object> map = new HashMap<>();//
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
		} finally {
			sqlSession.close();
		}
	}

	public void BoardUpdate(int ano, String title, String content, String writer) {
		sqlSession = sqlSessionFactory.openSession(true);
		HashMap<String, Object> map = new HashMap<>();
		map.put("ano", ano);
		map.put("title", title);
		map.put("content", content);
		map.put("writer", writer);

		try {
			result = sqlSession.update("update", map);
			if (result > 0) {
				System.out.println("수정성공");

			} else {
				System.out.println("수정실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

	}

	public void BoardDelete(int ano) {
		sqlSession = sqlSessionFactory.openSession(true);
		System.out.println(ano);
		try {
			result = sqlSession.delete("board.delete", ano);
			if (result > 0) {
				System.out.println("삭제성공!");
			} else {

				System.out.println("삭제실패...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	public void BoardSelect() {

		try {
			sqlSession = sqlSessionFactory.openSession();
			list = sqlSession.selectList("Select");
			for (BoardDTO line : list) {
				System.out.println(line.toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();

		}

	}

	public void BoardSerarch(String keyword) {
		try {
			sqlSession = sqlSessionFactory.openSession();
			list = sqlSession.selectList("search", keyword);

			for (BoardDTO line : list) {
				System.out.println(line.toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

	}

	public void BoardSort() {
		try {
			sqlSession = sqlSessionFactory.openSession();
			list = sqlSession.selectList("sort");

			for (BoardDTO line : list) {
				System.out.println(line.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

	}

	public void BoardView(int ano) {
		try {
			sqlSession = sqlSessionFactory.openSession();
			list = sqlSession.selectList("view",ano); //셀렉트 하면 줄이나 표의 형태로오니까 
			result = viewCntPlus(ano);
		  if(result > 0) {
			  System.out.println("조회성공");
			  for (BoardDTO line : list) {
				System.out.println(line.toString());
			}
		  }else {
			  System.out.println("조회 실패");
		  }

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			sqlSession.close();
		}

	}

	public int viewCntPlus(int ano) {
		try {
			sqlSession = sqlSessionFactory.openSession(true);
			result = sqlSession.update("viewcnt", ano);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return result;
	}
	
	public String getWriter(int ano) {
		String writer = "";
		try {
			sqlSession = sqlSessionFactory.openSession();
		     writer = sqlSession.selectOne("getwriter",ano);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return writer;
	}

}// 클래스
