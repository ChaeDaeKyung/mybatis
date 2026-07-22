package day0722;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import day0714.CpDept;
import kr.co.sist.dao.MyBatisHandler;
import kr.co.sist.emp.EmpDomain;

public class SelectDAO5 {
	private static SelectDAO5 sDAO;
	
	private SelectDAO5() {
	}// SelectDAO
	
	public static SelectDAO5 getInstance() {
		if(sDAO == null){
			sDAO = new SelectDAO5();
		}//end if
		return sDAO;
	}// getInstance
	
	public List<CpDept> selectAllDept (String tableName) throws PersistenceException{
		List<CpDept> list = null;
		
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getMyBatisHandler(null);
		
		list = ss.selectList("dollarSign", tableName);
		
		mbh.closeHandler(ss);
		
		return list;
	}// selectAllDept
	
	public void insert(CpDept cd) {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getMyBatisHandler(null,true);
		
		ss.insert("day0722.dollarSign2", cd);
		
		mbh.closeHandler(ss);
	}
	
	public List<EmpDomain> dynamicIf(CpDept cd) throws PersistenceException {
		List<EmpDomain> list = null;
		
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getMyBatisHandler(null);
		
		list = ss.selectList("day0722.dynamicIf", cd);
		
		mbh.closeHandler(ss);
		
		return list;
	}// dynamicIf
	
	public List<EmpDomain> dynamicChoose(int deptno) throws PersistenceException {
		List<EmpDomain> list = null;
		
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getMyBatisHandler(null);

		list = ss.selectList("day0722.dynamicChoose", deptno);
		
		mbh.closeHandler(ss);
		
		return list;
	}// dynamicIf
}// class
