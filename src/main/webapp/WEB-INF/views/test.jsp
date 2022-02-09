<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

</head>
  <body>
    <!-- 1. The <iframe> (and video player) will replace this <div> tag. -->
    <button id="ytplay">youtube play</button>
    <input type="text" id="videoId" value="2-dbg_5wWt4">
    
    <div id="player"></div>
    
    <script type="text/javascript">
	//$(function() {
    	// 2. This code loads the IFrame Player API code asynchronously.
      	var tag = document.createElement('script');

      	tag.src = 'https://www.youtube.com/iframe_api';
      	var firstScriptTag = document.getElementsByTagName('script')[0];
      	firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);
		
    	var player;
	      	
    	$('#ytplay').on('click', function() {
    		alert();
    		videoId = document.getElementById("videoId").value;  
	    	alert(videoId);
	        player = new YT.Player('player', {
	          		height: '360',
	          		width: '640',
	          		videoId: videoId,
	          		events: {
	            		'onReady': onPlayerReady,
	            		'onStateChange': onPlayerStateChange
	          		}
	        });

    		
    	});

	    // 3. This function creates an <iframe> (and YouTube player)
	    //    after the API code downloads.
	    //2-dbg_5wWt4 , nAvjYapdSxk
	    function onYouTubeIframeAPIReady() {
     	}

      	// 4. The API will call this function when the video player is ready.
      	function onPlayerReady(event) {
        	event.target.playVideo();
      	}

      	// 5. The API calls this function when the player's state changes.
      	//    The function indicates that when playing a video (state=1),
      	//    the player should play for six seconds and then stop.
      	var done = false;
      	function onPlayerStateChange(event) {
      //		alert("change");
        	if (event.data == YT.PlayerState.PLAYING && !done) {
          		setTimeout(stopVideo, 6000);
          		done = true;
        	}
      	}
      	
      	function stopVideo() {
        	player.stopVideo();
      	}		

	//});

</script>
  </body>
</html>