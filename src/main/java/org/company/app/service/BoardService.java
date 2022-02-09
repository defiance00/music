package org.company.app.service;

import java.util.List;
import java.util.Map;

import org.company.app.dto.Board;
import org.company.app.dto.Page;

public interface BoardService {

	

	List<Board> selectList(Page page);

	Map<String, Object> selectOne(int bnum);

	Map<String, Object> insert(Board board) throws Exception;

	int updateReadCnt(int bnum);
	
	int updateRemoveYn(int bnum);

	Map<String, Object> update(Board board, List<Integer> removeyn) throws Exception;

	

}
