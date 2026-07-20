package day0720;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import kr.co.sist.emp.EmpDomain;

public class SelectService3 {
	private static SelectService3 ss;
	
	private SelectService3() {
	}
	
	public static SelectService3 getInstance() {
		
		if(ss==null) {
			ss = new SelectService3();
		}//end if
		return ss;
	}// getInstance
	
	public List<EmpDomain> mcmr(){
		List<EmpDomain> list = null;
		SelectDAO3 sDAO = SelectDAO3.getInstance();
		try {
			list = sDAO.mcmr();
		} catch(PersistenceException pe) {
			pe.printStackTrace();
		}// end try catch
		return list;
	}// mcmr
	
	public List<EmpDomain> lessThan(int sal){
		List<EmpDomain> list = null;
		SelectDAO3 sDAO = SelectDAO3.getInstance();
		try {
			list = sDAO.lessThan(sal);
		} catch(PersistenceException pe) {
			pe.printStackTrace();
		}// end try catch
		return list;
	}// lessThan
	
	public List<EmpDomain> greaterThan(int sal){
		List<EmpDomain> list = null;
		SelectDAO3 sDAO = SelectDAO3.getInstance();
		try {
			list = sDAO.greaterThan(sal);
		} catch(PersistenceException pe) {
			pe.printStackTrace();
		}// end try catch
		return list;
	}// lessThan
	
}// class
