package com.kh.portfolio.board.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.portfolio.board.svc.BoardSVC;
import com.kh.portfolio.board.vo.BoardCategoryVO;
import com.kh.portfolio.board.vo.BoardFileVO;
import com.kh.portfolio.board.vo.BoardVO;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	private static final Logger logger = 
			LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	BoardSVC boardSVC;
	
	@ModelAttribute("boardCategory") 
	//현재 Controller에서 만들어지는 view페이지 내에서 boardCategoryVO 이름으로 참조가 가능하다.
	public List<BoardCategoryVO> getCategory() {	
		return boardSVC.getCategory();
	}
	
//	public void getCategory(Model model) {
//		List<BoardCategoryVO> boardCategoryVO = boardSVC.getCategory();
//		model.addAttribute("boardCategory", boardCategoryVO);		
//	}
	
	//게시글 작성(화면)
	@GetMapping("/writeForm")
	public String writeForm(
			@ModelAttribute("boardVO") BoardVO boardVO, //case 1)
			Model model) {		
// case2)		
//		model.addAttribute("boardVO", new BoardVO());
		
		return "/board/writeForm";
	}
	
	
	//게시글 작성 처리
	@PostMapping("/write")
	public String write(
			@Valid @ModelAttribute("boardVO") BoardVO boardVO, //유효성 체크: @Valid
			BindingResult result) {		
		
		if(result.hasErrors()) {
			return "/board/writeForm";
		}
		
		boardSVC.write(boardVO);

		return "redirect:/board/list";
	}
	
	
	//게시글 목록
	@GetMapping("list")
	public String list(Model model) {
		
		model.addAttribute("list", boardSVC.list());
		
		return "/board/list";
	}

	//게시글 보기
	@GetMapping("/view/{bnum}")
	public String view(
			@PathVariable("bnum") String bnum,
			Model model) {
		
		Map<String, Object> map = boardSVC.view(bnum);
		
		BoardVO boardVO = (BoardVO)map.get("board");
		
		List<BoardFileVO> files =null;
		if(map.get("files") != null) {
			files = (List<BoardFileVO>)map.get("files");
		}
		
		model.addAttribute("boardVO", boardVO);
		model.addAttribute("files", files);	
		
		return "/board/readForm";
	}
	
	//게시글 삭제
	@GetMapping("/delete/{bnum}")
	public String delete(@PathVariable("bnum") String bnum) {
		
		boardSVC.delete(bnum);
		
		return "redirect:/board/list";
	}
	
}























