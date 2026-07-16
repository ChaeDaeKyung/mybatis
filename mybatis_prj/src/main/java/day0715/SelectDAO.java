package day0715;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.co.sist.dao.MyBatisHandler;
import kr.co.sist.emp.EmpDomain;

public class SelectDAO {
	private static SelectDAO sDAO;
	
	private SelectDAO() {
	}// SelectDAO
	
	public static SelectDAO getInstance() {
		if(sDAO == null){
			sDAO = new SelectDAO();
		}//end if
		return sDAO;
	}// getInstance
	
	/**
	 * 컬럼 하나에 한 행 조회
	 * @param deptno 부서번호
	 * @return 부서명
	 */
	public String scsr(int deptno) throws PersistenceException {
		String dname="";
		//1. MyBatis Handler 얻기
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getMyBatisHandler(null);
		//2. Mapper에서 id에 해당하는 node를 찾고, parsing 하여 값을 넣고, 쿼리문 실행
		dname = ss.selectOne("day0715.scsr", deptno);
		//3. Handler 닫기
		mbh.closeHandler(ss);
		return dname;
	}//scsr

	/**
	 * 사원 번호를 입력받아서 입력받은 사원번호의 사원의 정보를 얻는다.
	 * @param empno 사원번호
	 * @return 사원정보
	 * @throws PersistenceException
	 */
	public EmpDomain mcsr(int empno) throws PersistenceException {
		EmpDomain ed = null;
		//1. MyBatis Handler 얻기
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getMyBatisHandler(null);
		//2. Mapper에서 id에 해당하는 node를 찾고, parsing 하여 값을 넣고, 쿼리문 실행
		ed = ss.selectOne("day0715.mcsr", empno);
		//3. Handler 닫기
		mbh.closeHandler(ss);
		return ed;
	}//mcsr
	
	
	
}// class
