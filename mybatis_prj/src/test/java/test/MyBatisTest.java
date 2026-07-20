package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import day0714.CpDept;
import day0714.TestDAO;
import day0715.NewsDTO;
import day0715.SelectDAO;
import day0715.UseMapperDAO;
import day0716.SelectDAO2;
import day0720.SelectDAO3;
import kr.co.sist.dao.MyBatisHandler;

class MyBatisTest {
	
	@Disabled
	@DisplayName("MyBatis Handler 얻기 test")
	@Test
	void test() {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		assertNotNull(mbh.getMyBatisHandler(null,false));
	}// test
	
	@Disabled
	@DisplayName("TestDAO InsertCpDept Test")
	@Test
	void insertTest() {
		TestDAO tDAO = new TestDAO();
		CpDept cd = new CpDept();
		cd.setDeptno(97);
		cd.setDname("스프링2");
		cd.setLoc("서울2");
		assertEquals(tDAO.insertCpDept(cd),1);
	}// insertTest
	
	@Disabled
	@Test
	@DisplayName("파라메타 없이 사용")
	void insertNotParam() {
		int cnt = 0;
		UseMapperDAO umDAO = UseMapperDAO.getInstance();
//		assertEquals(cnt = umDAO.insertNotParameter(), 1);
//		assertEquals(cnt = umDAO.insertPrimitiveParameter(150), 1);
		NewsDTO nDTO = new NewsDTO();
		nDTO.setSubject("DTO제목");
		nDTO.setNewsContent("DTO content");
		nDTO.setWriter("작성자 이름");
		assertEquals(cnt = umDAO.insertDTOParameter(nDTO), 1);
		System.out.println(cnt+": 실패와 성공=============");
	}// insertNotParam
	
	@Disabled
	@Test
	void updateNews() {
		int cnt = 0;
		UseMapperDAO umDAO = UseMapperDAO.getInstance();
		NewsDTO nDTO = new NewsDTO();
		nDTO.setNum(45);
		//nDTO.setSubject("제목변경");
		nDTO.setNewsContent("content변경");
		nDTO.setWriter("이름변경");
		assertEquals(cnt = umDAO.updateNews(nDTO), 1);
		System.out.println(cnt+": 실패와 성공=============");
	}// updateNews
	
	@Disabled
	@Test
	void deleteNews() {
		int cnt = 0;
		UseMapperDAO umDAO = UseMapperDAO.getInstance();
		NewsDTO nDTO = new NewsDTO();
		nDTO.setNum(44);
		assertEquals(cnt = umDAO.deleteNews(nDTO), 1);
		System.out.println(cnt+": 실패와 성공=============");
	}// updateNews
	
	@Disabled
	@Test
	@DisplayName("select 쿼리 test")
	void selectTest() {
		SelectDAO sDAO = SelectDAO.getInstance();
		/*
		 * String dname = sDAO.scsr(10); assertNotNull(dname); System.out.println(dname
		 * + " 로 나왔다.");
		 */
		assertNotNull(sDAO.mcsr(7521));
	}// selectTest
	
	@Disabled
	@Test
	@DisplayName("selectList 쿼리 test")
	void selectListTest() {
		SelectDAO2 sDAO = SelectDAO2.getInstance();
		//List<Integer> list = sDAO.scmr(31);
		//assertEquals(list.size(),0);//오차범위로 테스트도 할 수 있다.
		
		//예외로 사용
		assertDoesNotThrow(()->{
			sDAO.scmr(11);
		});
		
	}// selectListTest
	
	@Test
	void selectListTest2() {
		SelectDAO3 sDAO = SelectDAO3.getInstance();
		assertDoesNotThrow(()->{
//			System.out.println(sDAO.mcmr());
//			System.out.println(sDAO.lessThan(3000));
			System.out.println(sDAO.greaterThan(1000));
		});
		
	}
	
}// testClass
