package org.company.app.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.company.app.dto.Album;
import org.company.app.service.MusicService;
import org.company.app.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
@RequestMapping("music") 
public class MusicController {
	@Autowired
	private MusicService musicService;
	@Autowired
	private LoginService loginService; 
	
	@RequestMapping("/")
	public String list(Model model, String findkey, String findvalue) throws Exception {
		
		System.out.println(findkey);
		System.out.println(findvalue);
		List<Map<String, String>> mlist = musicService.json_insert(findkey,findvalue);
		model.addAttribute("mlist",mlist);
		model.addAttribute("findkey", findkey);
		model.addAttribute("findvalue", findvalue);
		
		return "list";
		
	}
	@RequestMapping("test")
	public String test() throws Exception {
		return "test";
	}
	@RequestMapping("home")
	public String home() throws Exception {
		return "home";
	}
	@RequestMapping("albums")
	public String albums(Model model) throws Exception {
		//앨범을 db에서 조회후 이동
		List<Album> album= musicService.selectList();
		model.addAttribute("album", album);
		
		return "albums";
	}
	@RequestMapping("contact")
	public String contact() throws Exception {
		return "contact";
	}
	@RequestMapping("header")
	public String header() throws Exception {
		return "header";
	}
	@RequestMapping("login")
	public String login() throws Exception {
		return "login";
	}
	@PostMapping("login")
	public String login(@RequestParam String email, @RequestParam String passwd, 
			HttpSession session, RedirectAttributes rattr) {
		Map<String, Object> result = loginService.login(email, passwd);
		//code, msg
		//0 : 성공
		//1 : 이메일미존재
		//2 : 비밀번호 불일치
		//3 : 이메일 미인증
		//4: naver simplejoin
		int code = (int) result.get("code");
		String msg = (String)result.get("msg");
		rattr.addFlashAttribute("msg", msg);
		//성공일때는 home.jsp로 이동
		if (code == 0) {
			session.setAttribute("email", email);
			session.setMaxInactiveInterval(60*60*3);//세션의 유지 시간
			return "redirect:/board/list";
		}else {	//실패일경우 login.jsp로 이동
			return "login";
		}
	
	}
	
}
