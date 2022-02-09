package org.company.app.dao;

import java.util.List;

import org.company.app.dto.Album;



public interface AlbumDAO {
	List<Album> selectList();
	Album selectOne(String albums);
	int insert(Album album);
	int update(Album album);
	int delete(int albumnumber);
}
