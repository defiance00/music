package org.company.app.service;

import java.util.List;
import java.util.Map;

import org.company.app.dto.Album;

public interface MusicService {
	public List<Map<String, String>> json_insert(String findkey, String findvalue) throws Exception;
	List<Album> selectList();
	
	
	
}
