package com.edu.controller;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.edu.dto.BoardDTO;
import com.edu.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	//@Resource(name="com.edu.service.BoardService")
	/*
	 * This is instance variable to use~~~ 
	 */
	@Inject
	BoardService boardService;
	
	//웹 브라우저에서 http://localhost:8099/board/insert로 호출한다.
	//게시글 등록화면으로 이동한다.
	@RequestMapping("/insert")
	private String insertForm() {
		return "/board/insert";
	}
	
	/*
	@RequestMapping(value="/insertProc")
	public int insertPOST(HttpServletRequest request) throws Exception {
		BoardDTO boardDTO = (BoardDTO)request.getParameterMap();
		return boardService.insertBoard(boardDTO);
		//return "/board/list";
	}
	*/
	//게시글 등록
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insertPOST(BoardDTO boardDTO, Model model) throws Exception {
		System.out.println("Controller insertPOST : " + boardDTO);
		boardService.insertBoard(boardDTO);
		return "redirect:/board/list";
		//return "/board/list";
	}

	//게시글 목록 보여주기
	@RequestMapping("/list")
	private String boardList(Model model) throws Exception {
		System.out.println("Controller boardList Before");
		//게시글 목록 보여주기 화면으로 가기 전에 보여줄 데이터를 가져와서 model에 담든다.
		model.addAttribute("list", boardService.boardList());
		System.out.println("Controller boardList After");
		return "/board/list";
	}
	@RequestMapping("/view")
	private String detail(@RequestParam("b_no") int b_no, Model model) throws Exception{
		System.out.println("Controller detail Before");
		BoardDTO boardDTO = null;
		boardDTO = boardService.detail(b_no);
		model.addAttribute("boardDTO",boardDTO );
		return "/board/view";
		
	}
	
	
	//게시물 수정
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String updateGET(BoardDTO boardDTO, Model model) throws Exception{
		System.out.println("updateGET가 시작되었습니다.");
		return "/board/update";
		
}
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updatePOST(@RequestParam("b_no") int b_no,BoardDTO boardDTO) throws Exception{
		
		System.out.println("updatePost가 시작되었습니다.");
		boardService.update(boardDTO);
		
		return "redirect:/board/list";
		
	}
	
	//게시물 삭제
	//삭제할 게시번호를 받아서 서비스한테 게시번호를 주고 삭제 작업을 의뢰한다.
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String deleteGET(@RequestParam("b_no") int b_no) throws Exception{
		System.out.println("deleteGET가 시작되었습니다.");
		boardService.delete(b_no);
		return "redirect:/board/list";
	}
	
	


} // End - public class BoardController













