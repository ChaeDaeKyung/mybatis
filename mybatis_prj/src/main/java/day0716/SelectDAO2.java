package day0716;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.co.sist.dao.MyBatisHandler;
import kr.co.sist.emp.EmpDomain;

public class SelectDAO2 {
	private static SelectDAO2 sDAO;
	
	private SelectDAO2() {
	}// SelectDAO
	
	public static SelectDAO2 getInstance() {
		if(sDAO == null){
			sDAO = new SelectDAO2();
		}//end if
		return sDAO;
	}// getInstance
	
	/**
	 * 부서번호를 입력받아서 해당 부서에 모든 사원번호를 검색
	 * @param deptno 부서번호
	 * @return 사원번호들
	 * @throws PersistenceException
	 */
	public List<Integer> scmr(int deptno) throws PersistenceException{
		List<Integer> list = null;
		
		//1. MyBatis Handler 얻기
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss= mbh.getMyBatisHandler(null);
		//2. id에 해당하는 쿼리문을 찾아서 parsing하여 값을 넣어서 쿼리문 실행하여 결과 얻기
		list = ss.selectList("day0716.scmr", deptno);
		//3. Handler 닫기
		mbh.closeHandler(ss);
		
		return list;
	}// scmr
	
}// class
