package org.company.app.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.company.app.dto.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class MusicDAOImpl implements MusicDAO {
	@Autowired
	private SqlSession session;
	
	@Override
	public List<Music> selectList(Music music) {
		return session.selectList("org.company.app.MusicMapper.selectList", music);
		
	}

	@Override
	public Music selectOne(String artistname) {
		return session.selectOne("org.company.app.MusicMapper.selectOne", artistname);
	}

	@Override
	public int insert(Music music) {
		return session.insert("org.company.app.MusicMapper.insert", music);
	}

	@Override
	public int update(Music music) {
		return session.update("org.company.app.MusicMapper.update", music);
	}

	@Override
	public int delete(int artistnumber) {
		return session.delete("org.company.app.MusicMapper.delete", artistnumber);
	}

}
