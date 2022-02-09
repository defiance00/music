package org.company.app.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.company.app.dto.Board;
import org.company.app.dto.Page;
import org.company.app.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jdk.jshell.spi.ExecutionControl.ExecutionControlException;
@Controller
@RequestMapping("board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/")
	public String list() {
		return "board/list";
		
	}
	
	@RequestMapping("list")
	public String list(@ModelAttribute Page page, Model model ) {
		List<Board> blist =boardService.selectList(page);
		model.addAttribute("blist", blist);
		
		return "board/list";
	}
	//상세조회폼으로 이동
	@RequestMapping("detail")
	public String detail(@RequestParam int bnum, Model model) {
		
		boardService.updateReadCnt(bnum);
		
		
		Map<String , Object> result =boardService.selectOne(bnum);
		model.addAttribute("result", result);
		
		return "board/detail";
		
	}
	
	@GetMapping("add")
	public void add() {
		
	
	}
	
	@PostMapping("add")
	public String add(@ModelAttribute Board board, HttpServletRequest request, 
			RedirectAttributes rattr) throws Exception {
		
		board.setIp(request.getRemoteAddr());
		Map<String, Object> result=boardService.insert(board);
		String msg=(String) result.get("msg");
		rattr.addFlashAttribute("msg",msg);
		
		return "redirect:list";
		
	}
	@RequestMapping("remove")
	public String remove(@RequestParam int bnum) {
		boardService.updateRemoveYn(bnum);
		
		return "redirect:list";
		
	}
	@GetMapping("modify")
	public String modify(@RequestParam int bnum, Model model) {
		Map<String, Object> result=boardService.selectOne(bnum);
		model.addAttribute("result", result);
		return "board/modify";
		
	}
	@PostMapping("modify")
	public String modify(@ModelAttribute Board board, 
			@RequestParam(required=false) List<Integer> removeyn, HttpServletRequest request, RedirectAttributes rattr) throws Exception {
		board.setIp(request.getRemoteAddr());
		
		Map<String, Object> result= boardService.update(board, removeyn);
		rattr.addAttribute("bnum", board.getBnum());
		
		return "redirect:detail";
	}

		
	
	
}
