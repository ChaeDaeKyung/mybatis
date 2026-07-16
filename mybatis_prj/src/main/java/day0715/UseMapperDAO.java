package day0715;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.co.sist.dao.MyBatisHandler;

public class UseMapperDAO {

	private static UseMapperDAO umDAO;
	
	private UseMapperDAO() {
		
	}
	
	public static UseMapperDAO getInstance() {
		
		if(umDAO == null) {
			umDAO = new UseMapperDAO();
		}// end if
		
		return umDAO;
	}// getInstance
	
	public int insertNotParameter() throws PersistenceException {
		int cnt = 0;
		
		//1. MyBatis Handler 얻기
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getMyBatisHandler(null,true);
		
		//2. id를 넣어서 Mapper.xml에서 쿼리문을 찾고 parsing하여 실행
		cnt = ss.insert("day0715.insertNotParameter");//namespace의 이름도 함께 입력해줘야 충돌을 줄일 수 있다.
		
		//3. Handler 닫기
		mbh.closeHandler(ss);
		
		return cnt;
	}//insertNotParameter
	
	public int insertPrimitiveParameter(int num) throws PersistenceException {
		int cnt = 0;
		
		//1. MyBatis Handler 얻기
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getMyBatisHandler(null,true);
		
		//2. id를 넣어서 Mapper.xml에서 쿼리문을 찾고 parsing하여 실행
		cnt = ss.insert("day0715.insertPrimitiveParameter", num);//namespace의 이름도 함께 입력해줘야 충돌을 줄일 수 있다.
		
		//3. Handler 닫기
		mbh.closeHandler(ss);
		
		return cnt;
	}//insertNotParameter

	public int insertDTOParameter(NewsDTO nDTO) throws PersistenceException {
		int cnt = 0;
		
		//1. MyBatis Handler 얻기
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getMyBatisHandler(null,true);
		
		//2. id를 넣어서 Mapper.xml에서 쿼리문을 찾고 parsing하여 실행
		cnt = ss.insert("day0715.insertDTOParameter", nDTO);//namespace의 이름도 함께 입력해줘야 충돌을 줄일 수 있다.
		
		//3. Handler 닫기
		mbh.closeHandler(ss);
		
		return cnt;
	}//insertNotParameter
	
	public int updateNews(NewsDTO nDTO) throws PersistenceException {
		int cnt = 0;
		
		//1. MyBatis Handler 얻기
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getMyBatisHandler(null,true);
		
		//2. id를 넣어서 Mapper.xml에서 쿼리문을 찾고 parsing하여 실행
		cnt = ss.update("day0715.updateNews", nDTO);//namespace의 이름도 함께 입력해줘야 충돌을 줄일 수 있다.
		
		//3. Handler 닫기
		mbh.closeHandler(ss);
		
		return cnt;
	}// updateNews
	
	public int deleteNews(NewsDTO nDTO) throws PersistenceException {
		int cnt = 0;
		
		//1. MyBatis Handler 얻기
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getMyBatisHandler(null,true);
		
		//2. id를 넣어서 Mapper.xml에서 쿼리문을 찾고 parsing하여 실행
		cnt = ss.delete("day0715.deleteNews", nDTO);//namespace의 이름도 함께 입력해줘야 충돌을 줄일 수 있다.
		
		//3. Handler 닫기
		mbh.closeHandler(ss);
		
		return cnt;
	}// updateNews
	
	public void selectNews() {
		
	}
	
}// class
