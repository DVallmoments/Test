package com.test.myapp.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.test.myapp.service.BoardService;
import com.test.myapp.vo.BoardDTO;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Resource(name = "boardService")
	private BoardService boardService;

	@RequestMapping("list.do")
	public String list(Model model) throws Exception {
		model.addAttribute("list", boardService.listAll());
		return "board/list";
	}

	//글쓰기
	@RequestMapping(value = "writer.do", method = RequestMethod.GET)
	public String writing() throws Exception {
		return "board/write";
	}

	@RequestMapping(value = "insert.do", method = RequestMethod.POST)
	public String insert(@ModelAttribute BoardDTO boardDTO) throws Exception {
		boardDTO.setRegDate(Timestamp.valueOf(LocalDateTime.now()));
		boardService.writing(boardDTO);
		return "redirect:list.do";
	}

	//상세보기
	@RequestMapping(value = "view.do", method = RequestMethod.GET)
	public ModelAndView view(@RequestParam int bno, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("board/view");
		mav.addObject("boardDTO", boardService.view(bno));

		return mav;
	}

	//수정
	@RequestMapping(value = "update.do", method = RequestMethod.POST)
	public String modify(@ModelAttribute BoardDTO boardDTO) throws Exception {
		boardService.modify(boardDTO);
		return "redirect:list.do";
	}

	//삭제
	@RequestMapping("delete.do")
	public String delete(@RequestParam int bno) throws Exception {
		boardService.delete(bno);
		return "redirect:list.do";
	}
}
