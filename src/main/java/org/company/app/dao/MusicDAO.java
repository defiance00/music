package org.company.app.dao;

import java.util.List;

import org.company.app.dto.Music;

public interface MusicDAO {
	
	
	List<Music> selectList(Music music);
	Music selectOne(String artistname);
	int insert(Music music);
	int update(Music music);
	int delete(int artistnumber);
	
}