package com.edu;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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
	
	@Test
	public void testByWriterContaining() {
		Collection<BoardDTO> results = repo.findByWriterContaining("07");
	}
	@Test
	public void findByTitleAndBno() {
		Collection<BoardDTO> results = repo.findByTitleContainingAndBnoGreaterThan("5",50L);
	}
	@Test
	public void testBnoOrderBy() {
		Collection<BoardDTO> results = repo.findByBnoGreaterThanOrderByBnoDesc(120L);
		results.forEach(board ->System.out.println(board));
	}
	
	//페이징 처리
	@Test
	public void testBnoOrderByPaging() {
		//spring boot 2.0.0이전에는 Pageable paging = new PageRequest.of(0,10);
		//spring boot 2.0.0
		Pageable paging = PageRequest.of(3,10);
		Collection<BoardDTO> results = repo.findByBnoGreaterThanOrderByBnoDesc(0L,paging);
		results.forEach(board ->System.out.println(board));
	}
	/*
	@Test
	public void testBnoPagingSort() {
		Pageable paging = PageRequest.of(0,10,Sort.Direction.ASC,"bno");
		Collection<BoardDTO> results = repo.findByBnoGreaterThan(0L,paging);
		results.forEach(board ->System.out.println(board));
	}
	*/
	@Test
	public void testBnoPagingSort() {
		Pageable paging = PageRequest.of(0,10,Sort.Direction.ASC,"bno");
		Page<BoardDTO> results = repo.findByBnoGreaterThan(0L,paging);
		System.out.println("PAGE SIZE : " +results.getSize());
		System.out.println("TOTAL PAGES: " +results.getTotalPages());
		System.out.println("TOTAL COUNT : " +results.getTotalElements());
		System.out.println("NEXT : " +results.nextPageable());
		
		List<BoardDTO> list = results.getContent();
		list.forEach(board ->System.out.println(board));
	}
	@Test
	
	public void testByTitle2() {
		repo.findByTitle("17").forEach(board ->System.out.println(board));
		
	}
	@Test
	public void testByTitle21() {
		repo.findByTitle2("160").forEach(arr -> System.out.println(Arrays.toString(arr)));
	}
	

}//end - class Boot03ApplicationTests
