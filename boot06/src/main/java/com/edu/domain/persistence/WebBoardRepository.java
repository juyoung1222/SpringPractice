package com.edu.domain.persistence;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.edu.domain.QWebBoard;
import com.edu.domain.WebBoard;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;


//Querydsl을 사용하기 위해서 Querydsl을 상속받는다.인터페이스는 다중상속이 가능, 클래스는 단일상속.
public interface WebBoardRepository extends CrudRepository<WebBoard,Long>, QuerydslPredicateExecutor<WebBoard>{
	
	public default Predicate makePredicate(String type,String keyword) {
		BooleanBuilder builder = new BooleanBuilder();
		QWebBoard board = QWebBoard.webBoard;
		
		builder.and(board.bno.gt(0));//gt는 greater than,board.bno>0
		
		if(type==null) {
		return builder;
	
		}
		switch(type){
		case "t" :
			builder.and(board.title.like("%"+keyword+"%"));
			break;
		case "c" :
			builder.and(board.content.like("%"+keyword+"%"));
			break;
		case "w" :
			builder.and(board.writer.like("%"+keyword+"%"));
			break;
		}
		return builder;
	}
		
	

}
