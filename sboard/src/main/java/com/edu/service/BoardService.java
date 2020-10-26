package com.edu.service;

import java.util.List;

import javax.annotation.*;

import org.springframework.stereotype.*;

import com.edu.dto.BoardDTO;
import com.edu.mapper.BoardMapper;

@Service("com.edu.service.BoardService")
public class BoardService {

	@Resource(name="com.edu.mapper.BoardMapper")
	BoardMapper boardMapper;
	
	public int insertBoard(BoardDTO boardDTO) 	throws Exception {
		System.out.println("Service insertBoard : " + boardDTO);
		return boardMapper.boardInsert(boardDTO);
	}
	
	//게시글 목록 보기
	public List<BoardDTO> boardList() throws Exception {
		System.out.println("Service boardList");
		return boardMapper.boardList();
	}
	
	public BoardDTO detail(Integer b_no) throws Exception{
		System.out.println("Service detail");
		return boardMapper.detail(b_no);
	}
	
	public void update(BoardDTO boardDTO) throws Exception{
		System.out.println("Service update : " + boardDTO);
		boardMapper.update(boardDTO);
		
	
	}
	public void delete(Integer b_no) throws Exception{
		System.out.println("Service delete ");
		boardMapper.delete(b_no);
	}


}