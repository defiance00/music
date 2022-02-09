package org.company.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.company.app.dao.BoardDAO;

import org.company.app.dto.Board;

import org.company.app.dto.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDAO boardDAO; 

	
	@Override
	public List<Board> selectList(Page page) {
		//page 처리 값
		int curPage = page.getCurPage();//현재페이지
		int perPage = page.getPerPage();//한페이지당 게시물수
		int perBlock = page.getPerBlock(); //화면 페이지 수
		
		//1)전체게시물수
		int totCnt = boardDAO.selectTotCnt(page);
		//2)전체페이지수
		int totPage = totCnt / perPage;
		if (totCnt%perPage != 0) totPage ++; //나머지가 있으면 +1
		page.setTotPage(totPage);
		
		//3)시작번호
//		int startNum = (curPage-1)*perPage+1; 오라클
		int startNum = (curPage-1)*perPage;
		page.setStartNum(startNum);
		//4)끝번호
		int endNum = startNum + perPage -1;
		page.setEndNum(endNum);
		
		//5)시작페이지
		int startPage = curPage - ((curPage-1)%perBlock);
		page.setStartPage(startPage);
		
		//6)끝페이지
		int endPage = startPage + perBlock -1;
		if (endPage>totPage) endPage = totPage;//끝페이지는 전체페이지보다 클수없다
		page.setEndPage(endPage);
		
		return boardDAO.selectList(page);
	}

	@Override
	public Map<String, Object> selectOne(int bnum) {
		// 게시물 + 게시물 파일들 조회
		//1)게시물 조회
		Board board = boardDAO.selectOne(bnum);
	
		
		Map<String, Object> result = new HashMap<>();
		result.put("board", board);
		
		
		return result;
	}

	@Override
	public int updateReadCnt(int bnum) {
		return boardDAO.updateReadCnt(bnum);
	}
	

	@Override
	public int updateRemoveYn(int bnum) {
		return boardDAO.updateRemoveYn(bnum);
	}
	@Transactional
	@Override
	public Map<String, Object> update(Board board, List<Integer> removeyn) throws Exception {
		//1)게시물 수정
		boardDAO.update(board);
		
	
		
		//결과맵
		Map<String, Object> result = new HashMap<>();
		result.put("code", 0);
		result.put("msg", "수정완료");
		return result;
	}

	@Transactional
	@Override
	public Map<String, Object> insert(Board board) throws Exception {
		//1)게시물 저장(mapper에서 bnum세팅된다)
		boardDAO.insert(board);
		Map<String, Object> result = new HashMap<>();
		result.put("code", 0);
		result.put("msg", "등록완료");
		return result;
	}

	
	
}
