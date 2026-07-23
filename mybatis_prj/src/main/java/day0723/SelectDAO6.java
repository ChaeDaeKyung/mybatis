package day0723;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import day0714.CpDept;
import kr.co.sist.dao.MyBatisHandler;
import kr.co.sist.emp.EmpDomain;

public class SelectDAO6 {
	private static SelectDAO6 sDAO;
	
	private SelectDAO6() {
	}// SelectDAO
	
	public static SelectDAO6 getInstance() {
		if(sDAO == null){
			sDAO = new SelectDAO6();
		}//end if
		return sDAO;
	}// getInstance
	
	public WebMemberDomain selectWebMember(String id) throws PersistenceException{
		WebMemberDomain wmd = null;
		
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getMyBatisHandler(null);
		
		wmd = ss.selectOne("day0723.selectMember", id);
		
		mbh.closeHandler(ss);
		
		return wmd;
	}// selectWebMember
	
	public void updateMember(WebMemberDTO wmDTO) throws PersistenceException {
		
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getMyBatisHandler(null,true);
		ss.update("day0723.updateMember", wmDTO);
		
		mbh.closeHandler(ss);
	}//updateMember
	
	public List<Integer> selectAllEmpno() throws PersistenceException{
		List<Integer> list = null;
		
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getMyBatisHandler(null);
		
		list = ss.selectList("day0723.selectAllEmpno");
		
		mbh.closeHandler(ss);
		
		return list;
	}// selectWebMember
	
	public List<EmpDomain> selectEmpno(Map<String, Object> map) throws PersistenceException{
		List<EmpDomain> list = null;
		
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getMyBatisHandler(null);
		
		list = ss.selectList("day0723.selectEmp", map);
		
		mbh.closeHandler(ss);
		
		return list;
	}// selectWebMember
	
	public boolean insertTransaction(TransactionDTO tDTO ) throws PersistenceException {
		boolean flag = false;
		
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getMyBatisHandler(null);
		
		//transaction 대상 쿼리 실행하여 행수 받기
		//insert인 경우 성공 또는 예외 실행된 두개의 쿼리가 모두실행시에만 커밋이 된다.
		//update, delete : 성공 (0~n) 아니면 예외
		ss.insert("transaction",tDTO);
		ss.insert("transaction2",tDTO);
		
		ss.commit();
		
		mbh.closeHandler(ss);
		return flag;
	}//insertTransaction
	
	
}// class
