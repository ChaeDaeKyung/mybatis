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
import day0721.SelectDAO4;
import day0722.SelectDAO5;
import kr.co.sist.board.BoardDAO;
import kr.co.sist.board.BoardDomain;
import kr.co.sist.board.RangeDTO;
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
	
	@Disabled
	@Test
	void selectListTest2() {
		SelectDAO3 sDAO = SelectDAO3.getInstance();
		assertDoesNotThrow(()->{
//			System.out.println(sDAO.mcmr());
//			System.out.println(sDAO.lessThan(3000));
			System.out.println(sDAO.greaterThan(1000));
		});
		
	}//selectListTest2
	
	@Disabled
	@DisplayName("like 쿼리문 테스트")
	@Test
	void selectLikeTest() {
		SelectDAO4 sDAO = SelectDAO4.getInstance();
		
		assertDoesNotThrow(()->{
			//sDAO.like("오늘은");
//			sDAO.selectMaker("수입");
			sDAO.selectCar("아반테");
		});
		
	}//selectLikeTest
	
	
	@Test
	void selectTableNameTest() {
		SelectDAO5 sDAO = SelectDAO5.getInstance();
		assertDoesNotThrow(()->{
			//sDAO.selectAllDept("cp_dept");
			CpDept cd = new CpDept();
			cd.setDeptno(10);
			cd.setDname("개발");
			cd.setLoc("서울");
			//sDAO.insert(cd);
//			sDAO.dynamicIf(cd);
			sDAO.dynamicChoose(1);
		});
	}
	
	@Disabled
	@DisplayName("게시판 테스트")
	@Test
	void boardTest() {
		BoardDAO bDAO = BoardDAO.getInstance();
		assertDoesNotThrow(()->{
//			RangeDTO rDTO = new RangeDTO();
//			rDTO.setFieldNum("1");
//			rDTO.setKeyword("오늘은");
//			bDAO.selectTotalCount(rDTO);
//			bDAO.selectBoard(rDTO);
//			bDAO.selectBoardDetail(1);
//			bDAO.updateCnt(2);
//			BoardDomain bd = new BoardDomain();
//			bd.setNum(2);
//			bd.setId("test");
//			bd.setTitle("아 비가 오네 젠장");
//			bd.setContent("안온다고 했는데 개많이 옴");
//			bd.setIp("192.168.10.79");
//			bd.setUpfile("test.png");
//			bDAO.insertBoard(bd);
//			bDAO.updateBoard(bd);
//			bDAO.deleteBoard(bd);
		});
	}
	
	
}// testClass
