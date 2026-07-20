package day0720;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.co.sist.dao.MyBatisHandler;
import kr.co.sist.emp.EmpDomain;

public class SelectDAO3 {
	private static SelectDAO3 sDAO;
	
	private SelectDAO3() {
	}// SelectDAO
	
	public static SelectDAO3 getInstance() {
		if(sDAO == null){
			sDAO = new SelectDAO3();
		}//end if
		return sDAO;
	}// getInstance
	
	public List<EmpDomain> mcmr() throws PersistenceException{
		List<EmpDomain> listAllEmp = null;
		//1. myBatis framework 생성
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getMyBatisHandler(null);
		//2. myBatis Handler 얻기, 쿼리를 parsing하여 수행 후 결과를 받기
		listAllEmp = ss.selectList("mcmr");
		
		//3. handler 닫기
		mbh.closeHandler(ss);
		
		return listAllEmp;
	}//selectAllEmp
	
	public List<EmpDomain> lessThan(int sal) throws PersistenceException{
		List<EmpDomain> list = null;
		
		//1. myBatis framework 생성
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getMyBatisHandler(null);
		//2. myBatis Handler 얻기, 쿼리를 parsing하여 수행 후 결과를 받기
		list = ss.selectList("lessThan", sal);
		
		//3. handler 닫기
		mbh.closeHandler(ss);
		
		return list;
	}//lessThan

	public List<EmpDomain> greaterThan(int sal) throws PersistenceException{
		List<EmpDomain> list = null;
		
		//1. myBatis framework 생성
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getMyBatisHandler(null);
		//2. myBatis Handler 얻기, 쿼리를 parsing하여 수행 후 결과를 받기
		list = ss.selectList("greaterThan", sal);
		
		//3. handler 닫기
		mbh.closeHandler(ss);
		
		return list;
	}//lessThan
	
}// class
