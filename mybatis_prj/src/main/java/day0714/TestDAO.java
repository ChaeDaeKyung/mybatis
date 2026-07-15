package day0714;

import org.apache.ibatis.session.SqlSession;

import kr.co.sist.dao.MyBatisHandler;

public class TestDAO {

	public int insertCpDept(CpDept cd) {
		int cnt = 0;
		//1. MyBatis Framework를 생성
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		//2. Handler를 얻기
		SqlSession ss = mbh.getMyBatisHandler(null, true);
		//namespace명과 id명을 같이 사용하여 충돌을 방지한다.
		cnt = ss.insert("day0715.insertDept",cd);

		/*
		 * if(cnt == 1) { ss.commit(); }// end if
		 */		
		//handler 사용 완료 후 연결 끊기
		mbh.closeHandler(ss);
		return cnt;
	}// insertCpDept
	
}// class
