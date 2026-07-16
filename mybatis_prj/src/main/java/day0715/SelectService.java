package day0715;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.apache.ibatis.exceptions.PersistenceException;

import kr.co.sist.emp.EmpDomain;

public class SelectService {
	private static SelectService ss;
	
	private SelectService() {
	}
	
	public static SelectService getInstance() {
		
		if(ss==null) {
			ss = new SelectService();
		}//end if
		return ss;
	}// getInstance
	
	/**
	 * 부서번호를 입력받아서 부서명을 검색
	 * @param deptno 부서번호
	 * @return 부서명
	 */
	public String scsr(int deptno) {
		String dname = null;
		SelectDAO sDAO = SelectDAO.getInstance();
		try {
			dname = sDAO.scsr(deptno);
		} catch(PersistenceException pe) {
			pe.printStackTrace();
		}//end try catch
		return dname;
	}//scsr
	
	/**
	 * 사원번호를 입력받아서 사원의 정보를 검색
	 * @param empno 사원번호
	 * @return 사원의 정보
	 */
	public EmpDomain mcsr(int empno) {
		EmpDomain ed = null;
		SelectDAO sDAO = SelectDAO.getInstance();
		try {
			ed = sDAO.mcsr(empno);
		} catch(PersistenceException pe) {
			pe.printStackTrace();
		}//end try catch
		return ed;
	}//mcsr
	
}// class
