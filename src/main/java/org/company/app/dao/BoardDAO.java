package org.company.app.dao;

import java.util.List;
import java.util.Map;

import org.company.app.dto.Board;
import org.company.app.dto.Page;

public interface BoardDAO {
	List<Board> selectList(Page page);
	org.company.app.dto.Board selectOne(int bnum);
	int insert(Board board);
	int update(Board board);
	int delete(int bnum);
	int selectTotCnt(Page page);
	int updateReadCnt(int bnum);
	int updateRemoveYn(int bnum);
	
	
}
