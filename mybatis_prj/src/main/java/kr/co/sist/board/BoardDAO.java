package kr.co.sist.board;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.co.sist.dao.MyBatisHandler;

public class BoardDAO {
	private static BoardDAO bDAO;

	private BoardDAO() {
	}

	public static BoardDAO getInstance() {
		if (bDAO == null) {
			bDAO = new BoardDAO();
		}

		return bDAO;
	}

	public int selectTotalCount(RangeDTO rDTO) throws PersistenceException {
		int totalCount = 0;
		
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss= mbh.getMyBatisHandler(null);
		totalCount = ss.selectOne("kr.co.sist.board.totalCount",rDTO);
		mbh.closeHandler(ss);
		
		return totalCount;
	}// selectTotalCount
	
	public List<BoardDomain> selectBoard(RangeDTO rDTO) throws PersistenceException {
		
		List<BoardDomain> boardList = new ArrayList<BoardDomain>(); 
		
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss= mbh.getMyBatisHandler(null);
		boardList = ss.selectList("kr.co.sist.board.selectBoard",rDTO);
		mbh.closeHandler(ss);
		
		return boardList;
	}
	
	public void insertBoard(BoardDomain bDTO) throws PersistenceException {
		
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss= mbh.getMyBatisHandler(null, true);
		ss.insert("kr.co.sist.board.insertBoard", bDTO);
		mbh.closeHandler(ss);
		
	}//insertBoard
	
	public BoardDomain selectBoardDetail(int num) throws PersistenceException {
		BoardDomain bDTO = null; 
		
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss= mbh.getMyBatisHandler(null);
		bDTO = ss.selectOne("kr.co.sist.board.selectBoardDetail", num);
		mbh.closeHandler(ss);
		
		return bDTO;
	}
	

	public void updateCnt(int num) throws PersistenceException {
		
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss= mbh.getMyBatisHandler(null, true);
		ss.update("kr.co.sist.board.updateCnt", num);
		mbh.closeHandler(ss);
		
	}//insertBoard
		
	public int updateBoard(BoardDomain bDTO) throws PersistenceException {
		int cnt = 0;
		
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss= mbh.getMyBatisHandler(null, true);
		cnt = ss.update("kr.co.sist.board.updateBoard", bDTO);
		mbh.closeHandler(ss);
		
		return cnt;
	}//updateBoard
	
	public int deleteBoard(BoardDomain bDTO) throws PersistenceException {
		int cnt = 0;
		
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss= mbh.getMyBatisHandler(null, true);
		cnt = ss.delete("kr.co.sist.board.deleteBoard", bDTO);
		mbh.closeHandler(ss);

		return cnt;
	}//updateBoard
	
}
