package day0716;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import kr.co.sist.emp.EmpDomain;

public class SelectService2 {
	private static SelectService2 ss;
	
	private SelectService2() {
	}
	
	public static SelectService2 getInstance() {
		
		if(ss==null) {
			ss = new SelectService2();
		}//end if
		return ss;
	}// getInstance
	
	public List<Integer> scmr(int deptno){
		List<Integer> listEmpno = null;
		SelectDAO2 sDAO = SelectDAO2.getInstance();
		try {
			listEmpno = sDAO.scmr(deptno);
		} catch(PersistenceException pe) {
			pe.printStackTrace();
		}// end try catch
		return listEmpno;
	}// scmr
	
}// class
