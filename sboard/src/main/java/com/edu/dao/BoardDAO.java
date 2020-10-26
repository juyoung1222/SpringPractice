package com.edu.dao;



import java.util.List;
import com.edu.dto.BoardDTO;

/**
 * 
 * @author ㄴㅇㄴㅇ
 *
 */


public interface BoardDAO {
	//게시글 등록
	/**
	 * 이 매서드는 ~~~ 다
	 * @param boardDTO
	 * @throws Exception
	 */
	public void boardInsert(BoardDTO boardDTO) throws Exception;
	
	//게시글 목록보기
	/**
	 * 
	 * @return ㄴㅇㄴ
	 * @throws Exception
	 */
	public List<BoardDTO> boardList() throws Exception;
	
	//게시글 상세보기
	public void detail(Integer b_no) throws Exception;
	
	//게시글 수정
	public void update(BoardDTO boardDTO) throws Exception;
	
	//게시글 삭제
	public void delete(Integer b_no) throws Exception;
	
		
	

}
