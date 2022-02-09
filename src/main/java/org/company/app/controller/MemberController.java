package org.company.app.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.company.app.dto.Member;
import org.company.app.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("member")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/")
	public String list() {
		
		
		return "member/list";
		
		
	}
	
	@GetMapping("list")
	public String list(@RequestParam String findvalue,  Model model) {
		List<Member> mlist= memberService.selectList(findvalue);
		model.addAttribute("mlist",mlist);
		
		return "member/list";
	}
	
	@GetMapping("modify")
	public String modify(@RequestParam String email, Model model) {
		Member member=memberService.selectOne(email);
		model.addAttribute("member",member);
		
		return "member/modify";
		
		
	}
	
	
	@PostMapping("modify")
	public String modify(@ModelAttribute Member member, RedirectAttributes rattr) {
		Map<String, Object> result = memberService.update(member);
		int code= (int) result.get("code");
		String msg = (String) result.get("msg");
		rattr.addFlashAttribute("msg", msg);
		if (code == 0) { //홈으로 이동
			return "redirect:/";
		}else { //수정폼으로 이동
			return "redirect:modify";
		}
		
		
		
	}
	@GetMapping("join")
	public void join() {}
	
	//주소팝업창호출
	@RequestMapping("jusoPopup")
	public void jusoPopup() {
		
	
	}
	@PostMapping("join")
	public String join(@ModelAttribute Member member, HttpSession session, RedirectAttributes rattr) throws Exception {
		Map<String, Object> result= memberService.insert(member);
		
		session.setAttribute("email", member.getEmail());
		
		int code= (int)result.get("code");
		String msg=(String)result.get("msg");
		rattr.addFlashAttribute("msg", msg);
		if(code==0) {
			return "redirect:/member/";
		}else {
			return "redirect:/member/join";
		}
		
	}
	
		
}
