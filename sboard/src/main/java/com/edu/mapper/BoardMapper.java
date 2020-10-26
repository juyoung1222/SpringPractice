package com.edu.mapper;

import java.util.List;

import org.springframework.stereotype.*;

import com.edu.dto.*;

@Repository("com.edu.mapper.BoardMapper")
public interface BoardMapper {

	//게시글 등록
	public int boardInsert(BoardDTO boardDTO) throws Exception;

	//게시글 목록 보기
	public List<BoardDTO> boardList() throws Exception;
	
	//게시글 상세보기
	public BoardDTO detail(Integer b_no) throws Exception;
	
	//게시글 수정
	public void update(BoardDTO boardDTO) throws Exception;
	
	//게시글 삭제
	public void delete(Integer b_no) throws Exception;
}
