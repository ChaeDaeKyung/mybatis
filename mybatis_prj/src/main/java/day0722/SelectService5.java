package day0722;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import day0714.CpDept;
import kr.co.sist.emp.EmpDomain;

public class SelectService5 {
	private static SelectService5 ss;
	
	private SelectService5() {
	}
	
	public static SelectService5 getInstance() {
		
		if(ss==null) {
			ss = new SelectService5();
		}//end if
		return ss;
	}// getInstance
	
	public List<CpDept> dollarSign(String tableName){
		List<CpDept> list = null;
		
		SelectDAO5 sDAO = SelectDAO5.getInstance();

		try {
			list = sDAO.selectAllDept(tableName);
		} catch(PersistenceException pe) {
			pe.printStackTrace();
		}// end try catch
		
		return list;
	}// dollarSign
	
	public List<EmpDomain> dynamicIf(CpDept cd) throws PersistenceException {
		List<EmpDomain> list = null;
		
		SelectDAO5 sDAO = SelectDAO5.getInstance();
		
		try {
			list = sDAO.dynamicIf(cd);
		} catch(PersistenceException pe) {
			pe.printStackTrace();
		}// end try catch
		
		return list;
	}// dynamicIf
	
	public List<EmpDomain> dynamicChoose(int deptno) throws PersistenceException {
		List<EmpDomain> list = null;
		
		SelectDAO5 sDAO = SelectDAO5.getInstance();
		
		try {
			list = sDAO.dynamicChoose(deptno);
		} catch(PersistenceException pe) {
			pe.printStackTrace();
		}// end try catch
		
		return list;
	}// dynamicIf
}// class
