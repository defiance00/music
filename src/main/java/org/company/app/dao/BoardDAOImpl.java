package org.company.app.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.company.app.dto.Board;
import org.company.app.dto.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO {
	@Autowired
	private SqlSession session;
	
	@Override
	public List<Board> selectList(Page page) {
		// TODO Auto-generated method stub
		return session.selectList("org.company.app.BoardMapper.selectList", page);
	}

	@Override
	public Board selectOne(int bnum) {
		// TODO Auto-generated method stub
		return session.selectOne("org.company.app.BoardMapper.selectOne", bnum);
	}

	@Override
	public int insert(Board board) {
		// TODO Auto-generated method stub
		return session.insert("org.company.app.BoardMapper.insert", board);
	}

	@Override
	public int update(Board board) {
		// TODO Auto-generated method stub
		return session.update("org.company.app.BoardMapper.update", board);
	}

	@Override
	public int delete(int bnum) {
		// TODO Auto-generated method stub
		return session.delete("org.company.app.BoardMapper.delete", bnum);
	}

	@Override
	public int selectTotCnt(Page page) {
		// TODO Auto-generated method stub
		return session.selectOne("org.company.app.BoardMapper.selectTotCnt", page);
	}

	@Override
	public int updateReadCnt(int bnum) {
		// TODO Auto-generated method stub
		return session.update("org.company.app.BoardMapper.updateReadCnt", bnum);
	}

	@Override
	public int updateRemoveYn(int bnum) {
		// TODO Auto-generated method stub
		return session.update("org.company.app.BoardMapper.updateRemoveYn", bnum);
	}

	
}
