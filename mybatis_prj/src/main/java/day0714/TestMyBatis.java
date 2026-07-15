package day0714;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class TestMyBatis {
	
	public static void main(String[] args) {
		org.apache.ibatis.logging.LogFactory.useLog4J2Logging();
		//mybaits 사용법
		//1. 설정파일과 연결.
		String configPath = "kr/co/sist/dao/mybatis-config.xml";
		Reader reader = null;
		SqlSession ss = null;
		SqlSessionFactory ssf = null;
		try {
			reader = Resources.getResourceAsReader(configPath);
			
			//2. MyBatis Framework 생성
			ssf = new SqlSessionFactoryBuilder().build(reader);
			
			if(reader != null) {
				reader.close();
			}// end if
			
			//3. MyBatis Handler얻기
			ss = ssf.openSession();
			
			List<String> list = ss.selectList("day0714.selectDept");

			System.out.println(list);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(ss != null) {
				ss.close();
			}// end if
		}// end try catch finally
		
		
	}// main

}// class
