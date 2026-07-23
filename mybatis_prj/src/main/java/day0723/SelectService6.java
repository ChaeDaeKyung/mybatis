package day0723;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;

import day0714.CpDept;
import kr.co.sist.chipher.DataDecryption;
import kr.co.sist.chipher.DataEncryption;
import kr.co.sist.emp.EmpDomain;

public class SelectService6 {
	private static SelectService6 ss;
	
	private SelectService6() {
	}
	
	public static SelectService6 getInstance() {
		
		if(ss==null) {
			ss = new SelectService6();
		}//end if
		return ss;
	}// getInstance
	
	public WebMemberDomain searchWebMember(String id) {
		WebMemberDomain wmd = null;
		SelectDAO6 sDAO = SelectDAO6.getInstance();
		try {
			wmd=sDAO.selectWebMember(id);
			String key="a012345678912345";
			DataDecryption dd = new DataDecryption(key);
			
			//null || "" 는 복호화하면 error 가 발생
			wmd.setName(dd.decrypt(wmd.getName()));
			wmd.setEmail(dd.decrypt(wmd.getEmail()));
			wmd.setPhone(dd.decrypt(wmd.getPhone()));
			
			wmd.setId(id);
			
		} catch(PersistenceException pe) {
			pe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return wmd;
	}// searchWebMember
	
	public boolean modifyMember(WebMemberDTO wmDTO) {
		boolean flag = false;
		try {
			if(wmDTO.getId() != null) {
				String key="a012345678912345";
				DataEncryption de = new DataEncryption(key);
				
				//암호화 : 이름, 이메일, 전화번호 => null 체크 후 암호화 진행
				if(wmDTO.getPassword() != null && !wmDTO.getPassword().isEmpty()) {
					wmDTO.setPassword(de.messageDigest("SHA-1", wmDTO.getPassword()));
				}
				wmDTO.setName(de.encrypt(wmDTO.getName()));
				wmDTO.setEmail(de.encrypt(wmDTO.getEmail()));
				wmDTO.setPhone(de.encrypt(wmDTO.getPhone()));
				
				SelectDAO6 sDAO = SelectDAO6.getInstance();
				sDAO.updateMember(wmDTO);
				flag = true;
			}// end if
		} catch(PersistenceException pe) {
			pe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}// modifyMember
	
	public List<Integer> selectAllEmpno(){
		List<Integer> list = null;
		
		SelectDAO6 sDAO = SelectDAO6.getInstance();
		try {
			list = sDAO.selectAllEmpno();
		} catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		return list;
	}
	
	public List<EmpDomain> selectEmp(String[] empno){
		List<EmpDomain> list = null;
		Map<String, Object> map = new HashMap();
		map.put("empnoArr", empno);
		
		SelectDAO6 sDAO = SelectDAO6.getInstance();
		try {
			list = sDAO.selectEmpno(map);
		} catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		return list;
	}
	
}// class
