package org.company.app.service;

public class YoutubeServiceImpl {


private int cnt =1;

	public void getYoutube(String nextToken) {
	
	  String apikey = "AIzaSyCZipqqY0LuwEqH30mU2zO3hA3GLKUAGMk";
	  String channelId = "UCwgtORdDtUKhpjE1VBv6XfA";
	  String UPplaylistid ="UUwgtORdDtUKhpjE1VBv6XfA";
	  String apiUrl = "https://www.googleapis.com/youtube/v3/playlistItems?key="+ apikey
	  + "&playlistId="+ UPplaylistid
	  + "&part=snippet&fields=nextPageToken,pageInfo,items(id,snippet(publishedAt,title,description,thumbnails(high(url)),resourceId(videoId)))&order=date&maxResults=50";
	
	  //2번째 부터 다음 토큰값 있으면 파리미터 추가한다.
	  if (nextToken != null) {
		 apiUrl+= "&pageToken=" + nextToken ;
	  }
	 
	
	
		
		//유튜브 동영상 정보  출력   여기값들 저장 필요;;;;
	//	System.out.println(cnt);
	//	System.out.println(title);
	//	System.out.println(publishedAt);
	//	System.out.println(description);
	//	System.out.println(thumbUrl);
	//	System.out.println(videoId);
		
		
	  }
	
}
