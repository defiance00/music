package org.company.app.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.company.app.dto.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AlbumDAOImpl implements AlbumDAO {
	@Autowired
	private SqlSession session;
	
	@Override
	public List<Album> selectList() {
		// TODO Auto-generated method stub
		return session.selectList("org.company.app.AlbumMapper.selectList");
	}

	@Override
	public Album selectOne(String albums) {
		return session.selectOne("org.company.app.AlbumMapper.selectOne", albums);
	}

	@Override
	public int insert(Album album) {
		return session.insert("org.company.app.AlbumMapper.insert", album);
	}

	@Override
	public int update(Album album) {
		return session.update("org.company.app.AlbumMapper.update", album);
	}

	@Override
	public int delete(int albumnumber) {
		return session.delete("org.company.app.AlbumMapper.delete", albumnumber);
	}

}
