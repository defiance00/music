package org.company.app.service;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.company.app.dao.AlbumDAO;
import org.company.app.dto.Album;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriBuilder;

import java.io.BufferedReader;
import java.io.IOException;

@Service
public class MusicServiceImpl implements MusicService{
	@Autowired
	AlbumDAO albumDAO;
	@Override
	public List<Map<String, String>> json_insert(String findkey, String findvalue) throws Exception {
		//파싱라이브러리 : json-simple-1.1.1.jar
		if(findkey==null) return null;
		
		
		StringBuilder urlBuilder = null;
	
		if(findkey.equals("name")) {
	        urlBuilder = new StringBuilder("https://ws.audioscrobbler.com/2.0/?method=track.search&format=json");
	        
	        urlBuilder.append("&api_key=3dcf979f227cbc127d860d43364ecca8");
	        urlBuilder.append("&track=" + findvalue);
	       
	        urlBuilder.append("&page=1");
		}
       //아티스트 선택
		else if(findkey.equals("artist")) {
			urlBuilder = new StringBuilder("http://ws.audioscrobbler.com/2.0/?method=artist.search&format=json");
			urlBuilder.append("&api_key=3dcf979f227cbc127d860d43364ecca8");
			urlBuilder.append("&artist=" + findvalue);
			urlBuilder.append("&page=1");
        
		}
		
        
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json;charset=UTF-8");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
        
        //json파싱
        JSONParser parser = new JSONParser();
        //가져오는 값이 json형태일때 , {}
        JSONObject object =  (JSONObject)parser.parse(sb.toString()); 
        object = (JSONObject)object.get("results");
        JSONArray array=null;
        if(findkey.equals("name")) {
        	object = (JSONObject)object.get("trackmatches");
        	array = (JSONArray)object.get("track");
        }else if(findkey.equals("artist")){
        	object = (JSONObject)object.get("artistmatches");
        	array = (JSONArray)object.get("artist");
        }
        //가져오는 값이 array형태일때 , []
         //키에해당되는 값을 반환
        System.out.println("data의 건수:" + array.size());
        System.out.println(array);
        
        //반환값:map리스트
        List<Map<String, String>> mlist= new ArrayList<>();
//        //반복문으로 data 키의 데이터를 파싱
        for (int i=0; i< array.size(); i++) {
        	object = (JSONObject)array.get(i); //인덱스를 이용해서 데이터 추출
        	System.out.println(object);
//        	//Map생성(dto대신)
        	Map<String, String> map = new HashMap<>();
//        	
//        	//모든 키 Set저장
//        	//set:중복되는 데이터 불가
        	Set<String> kset =  object.keySet();
        	for(String key : kset) {
//	        		System.out.println("------------------");
//	        		System.out.println(key);
//	        		System.out.println(object.get(key));
	        		if(!key.equals("image"))
	        			map.put(key, (String)object.get(key)); //key와 key에 해당되는 값을 map에 넣기
      	}
        	// System.out.println(map); 
        	mlist.add(map);
        	
        	
        }
	     System.out.println(mlist); 
	     return mlist;
	     
   }

	@Override
	public List<Album> selectList() {
		List<Album> album= albumDAO.selectList();
		return album;
	}


}

