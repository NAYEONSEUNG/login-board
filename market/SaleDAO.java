package market;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapCnfig;
//판매관련 DAO 
public class SaleDAO {

	SqlSessionFactory sqlSessionFactory = SqlMapCnfig.getSqlSession();
	SqlSession sqlSession;
	int result;
	List<SaleDTO> list;
	 //1.판매테이블 판매이력을 insert
	 //2.상품테이블 판매수량만큼 해당제품에 제고를 update
	public int insertSale(HashMap<String, Object> map) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			result = sqlSession.insert("sale.insert", map);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		
		return result;
		
	}
	//일일판매량 출력하는 함수
	public void dashBoard() {
		int cnt = 0;
		int price = 0;
		sqlSession = sqlSessionFactory.openSession();
		try {
			list = sqlSession.selectList("sale.dashBoard");
			int i = 0;
			System.out.println("♬♬♬♬♬♬♬♬♬♬♬♬♬♬♬♬♬♬♬♬");
			System.out.println("번호\t 제품명\t 판매수량\t 가격 ");
			for (SaleDTO line : list) {
				System.out.print("♬"+ (i+1) +"\t");
				System.out.print(line.getSname() + "\t");
				System.out.print(line.getCnt() + "\t");
				System.out.print(line.getTprice() + "\t");
				System.out.println();
				cnt += list.get(i).getCnt();
				price += list.get(i).getTprice();
				i += 1;
			}
			System.out.println("오늘 판매한 제품은 총" + list.size()+"개 입니다.");
			System.out.println("총"+cnt+"개" + price +"원");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
	}
	
	
}
