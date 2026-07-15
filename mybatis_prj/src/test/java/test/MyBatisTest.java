package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import day0714.CpDept;
import day0714.TestDAO;
import kr.co.sist.dao.MyBatisHandler;

class MyBatisTest {
	
	@Disabled
	@DisplayName("MyBatis Handler 얻기 test")
	@Test
	void test() {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		assertNotNull(mbh.getMyBatisHandler(null,false));
	}// test
	
	@DisplayName("TestDAO InsertCpDept Test")
	@Test
	void insertTest() {
		TestDAO tDAO = new TestDAO();
		CpDept cd = new CpDept();
		cd.setDeptno(98);
		cd.setDname("스프링2");
		cd.setLoc("서울2");
		assertEquals(tDAO.insertCpDept(cd),1);
	}// insertTest
	
}
