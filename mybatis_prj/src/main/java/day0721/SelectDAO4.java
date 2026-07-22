package day0721;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.co.sist.dao.MyBatisHandler;
import kr.co.sist.emp.EmpDomain;

public class SelectDAO4 {
	private static SelectDAO4 sDAO;
	
	private SelectDAO4() {
	}// SelectDAO
	
	public static SelectDAO4 getInstance() {
		if(sDAO == null){
			sDAO = new SelectDAO4();
		}//end if
		return sDAO;
	}// getInstance
	
	public List<BoardDomain> like(String title) throws PersistenceException{
		List<BoardDomain> list = null;
		//1. MyBatis Handler 얻기
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getMyBatisHandler(null);
		//2. id에 해당하는 쿼리문을 찿아서 parsing한 후 쿼리문 실행해서 결과 얻기
		list = ss.selectList("day0721.like",title);
		//3. Handler 닫기
		mbh.closeHandler(ss);
		return list;
	}// like

	public List<String> selectMaker(String country) throws PersistenceException{
		List<String> list = null;
		//1. MyBatis Handler 얻기
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getMyBatisHandler(null);
		//2. id에 해당하는 쿼리문을 찿아서 parsing한 후 쿼리문 실행해서 결과 얻기
		list = ss.selectList("day0721.selectMaker", country);
		//3. Handler 닫기
		mbh.closeHandler(ss);
		return list;
	}// like
	
	public List<String> selectModel(String maker) throws PersistenceException{
		List<String> list = null;
		//1. MyBatis Handler 얻기
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getMyBatisHandler(null);
		//2. id에 해당하는 쿼리문을 찿아서 parsing한 후 쿼리문 실행해서 결과 얻기
		list = ss.selectList("day0721.selectModel", maker);
		//3. Handler 닫기
		mbh.closeHandler(ss);
		return list;
	}// selectModel
	
	public List<CarDomain> selectCar(String model) throws PersistenceException{
		List<CarDomain> list = null;
		//1. MyBatis Handler 얻기
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getMyBatisHandler(null);
		//2. id에 해당하는 쿼리문을 찿아서 parsing한 후 쿼리문 실행해서 결과 얻기
		list = ss.selectList("day0721.selectCar", model);
		//3. Handler 닫기
		mbh.closeHandler(ss);
		return list;
	}// selectCar
	
}// class
