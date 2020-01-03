package mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapCnfig {
	private static SqlSessionFactory sqlSessionFactory;

	static {//정적블럭클래스 로딩시 1회만 실행되는 코드
		String resource = "mybatis/Configuration.xml";

		try { 
 
			Reader reader = Resources.getResourceAsReader(resource);
			if (sqlSessionFactory == null) {
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
				//build인 빌드전분가에겐 객체생성을 맡기는 것 : 빌드패턴 : 빌드생성해달라고
				//객체 생성만 딱 하기에는 공장이 너무 복잡해서 맡기는 것
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// 스태틱끝

	public static SqlSessionFactory getSqlSession() {
		return sqlSessionFactory;
	}
}
