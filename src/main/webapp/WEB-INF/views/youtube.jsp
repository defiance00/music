<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">

	$(function() {
		var tag = document.createElement('script');

		tag.src = "https://www.youtube.com/iframe_api";
		var firstScriptTag = document.getElementsByTagName('script')[0];
		firstScriptTag.parentNode.insertBefore(tag, firstScriptTag); 

		var player;
		window.onYouTubeIframeAPIReady = function() {
		    player = new YT.Player('youtube_video', {});
		};
        
        
        $("#play").click(function(){
        	if(!player || typeof player.playVideo === 'undefined') return;
            player.playVideo();
        });
        
        $("#pause").click(function(){
            player.pauseVideo();
       	}); 
        

        
	});

</script>
</head>
<body>
	<div>
		<a href="https://www.youtube.com/embed/YDzv0GC1SfI?mute=1&version=3&enablejsapi=1" target="youtube_video">YDzv0GC1SfI</a>
		<a href="https://www.youtube.com/embed/phqVc3aLYqQ?mute=1&version=3&enablejsapi=1" target="youtube_video">phqVc3aLYqQ</a>
	</div>
	<!-- <iframe name="youtube_video" id="youtube_video" src="https://www.youtube.com/embed/YDzv0GC1SfI?autoplay=1&mute=1&version=3&enablejsapi=1"></iframe> -->
	<iframe name="youtube_video" id="youtube_video" src="https://www.youtube.com/embed/YDzv0GC1SfI?mute=1&version=3&enablejsapi=1"></iframe>

	<div>
		<button id="play">재생</button>
		<button id="pause">일시정지</button>
	</div>
	<input type="text" id="youtube_id">

</body>
</html>