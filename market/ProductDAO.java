package market;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapCnfig;

public class ProductDAO {
	SqlSessionFactory sqlSessionFactory = SqlMapCnfig.getSqlSession();
	SqlSession sqlSession;
	int result;
	List<ProductDTO> list;
	Boolean flag; // default : false

	// 제품 등록또는 추가시 추가기능 작동시 기존에 등록괸 제품인지 최초입고제품인지 판별하는 기능
	public boolean pdtAlready(String pname) {
		sqlSession = sqlSessionFactory.openSession();
		try {
			flag = false;
			result = sqlSession.selectOne("pdt.already", pname);

			if (result > 0) {
				flag = true;// 0인 경우에만 트루로받는다
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return flag;
	}

	public void cntPlusPdt(String pname, int cnt) {
		sqlSession = sqlSessionFactory.openSession(true);
		HashMap<String, Object> map = new HashMap<>();
		map.put("pname", pname);
		map.put("cnt", cnt);
		map.put("flag" , "plus");
		try {
			result = sqlSession.update("pdt.cntChange", map);
			if (result > 0) {
				System.out.println("상품이 추가되었습니다.");

			} else {
				System.out.println("상품이 추가되지 않았습니다.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

	}

	public void insertPdt(ProductDTO pDto) {
		sqlSession = sqlSessionFactory.openSession(true);

		try {
			result = sqlSession.insert("pdt.insertPdt", pDto);
			if (result > 0) {
				System.out.println("♬♪♬♪등록성공");

			} else {
				System.out.println("♬♪♬♪등록실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	public void marketUpdate(int pno, String pname, int price) {
		sqlSession = sqlSessionFactory.openSession(true);
		HashMap<String, Object> map = new HashMap<>();
		map.put("pno", pno);
		map.put("pname", pname);
		map.put("price", price);

		try {
			result = sqlSession.update("pdt.marketUpdate", map);
			if (result > 0) {
				System.out.println("♬♪♬♪수정완료");
			} else {
				System.out.println("♬♪♬♪수정실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

	}
	
	public void marketDelete(String pname) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			result = sqlSession.delete("pdt.marketDelete", pname);
			if(result > 0) {
				System.out.println("♬♪♬♪삭제성공");
			}else {
				System.out.println("♬♪♬♪삭제실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
	}

	public void marketSelect() {
		sqlSession = sqlSessionFactory.openSession();
		try {
			list = sqlSession.selectList("pdt.Select");
			for (ProductDTO line : list) {
				System.out.println(line.toString());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
	}
	
	public void marketSearch(String keyword) {
		sqlSession = sqlSessionFactory.openSession();
		try {
			list = sqlSession.selectList("pdt.marcketSearch", keyword);
			for (ProductDTO line : list) {
				System.out.println(line.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
	}
	//제품 전체조회(재고>1)
	public List<ProductDTO> selectUsePdt() {
		sqlSession = sqlSessionFactory.openSession();
		try {
			//list.clear();
			list = sqlSession.selectList("pdt.selectUsePdt");
			printList(list);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return list;
	}
	
	//상품 판매시 재고를 마이너스하는 함수
								//순서대로 들어오니까 이름이 달라도 괜찮다. 순서만 똑같이 맞추자 
	public void cntMinusPdt(String pname, int cnt) {
		sqlSession = sqlSessionFactory.openSession(true);
		HashMap<String, Object>map = new HashMap<>();
		map.put("pname", pname);
		map.put("cnt", cnt);
		map.put("flag", "minus");
		
		
		try {
			sqlSession.update("pdt.cntchange", map);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
	}
	
//	public void saleCnt(ProductDTO pDto) {
//		sqlSession = sqlSessionFactory.openSession(true);
//		try {
//			result = sqlSession.update("pdt.saleCnt", arg1)
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			sqlSession.close();
//		}
//	}
//	
	public void printList(List<ProductDTO>list) {
		int i = 1;
		System.out.println("♬♪♬♬♪♬♬♪♬♬♪♬♬♪♬♬♪♬♬♪♬♬♪♬♬♪♬♬♪♬");
		System.out.println("번호\t 제품번호\t 제품명 \t 제조사\t 가격\t");
		for (ProductDTO line : list) {
			System.out.println("♬♪♬" + i + line.toString() );
			i += 1;
		}
	}
	
	
}// class
