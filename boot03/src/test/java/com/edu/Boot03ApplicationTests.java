package com.edu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.edu.dto.BoardDTO;
import com.edu.persistence.BoardRepository;

@SpringBootTest
class Boot03ApplicationTests {
	
	@Autowired
	private BoardRepository repo;
	
	@Test
	public void testInsert200() {//데이터 200건 만들기
		for(int i=1;i<=200;i++) {
			BoardDTO boardDTO = new BoardDTO();
			boardDTO.setTitle("제목 : " + i);
			boardDTO.setContent("내용 : " + i);
			boardDTO.setWriter("user0" + (i%10));
			repo.save(boardDTO);
		}
		
	}
	@Test
	public void testByTitle() {
		//repo.find뒤에 엔티티 타입을 지정
		//By뒤에는 컬럼명을 이용해서 만든다.
		repo.findBoardDTOByTitle("제목 : 147").forEach(board -> System.out.println(board));
		repo.findBoardDTOByWriter("user04").forEach(board -> System.out.println(board));
	}

}
