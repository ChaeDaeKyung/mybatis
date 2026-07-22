package day0721;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import kr.co.sist.emp.EmpDomain;

public class SelectService4 {
	private static SelectService4 ss;
	
	private SelectService4() {
	}
	
	public static SelectService4 getInstance() {
		
		if(ss==null) {
			ss = new SelectService4();
		}//end if
		return ss;
	}// getInstance
	
	public List<BoardDomain> like(String title) {
		List<BoardDomain> list = null;
		
		SelectDAO4 sDAO = SelectDAO4.getInstance();
		try {
			list = sDAO.like(title);
		} catch(PersistenceException pe) {
			pe.printStackTrace();
		}// end try catch
		return list;
	}// like
	
}// class
