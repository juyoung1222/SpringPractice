package com.edu.dto;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity//클래스 선언부에 반드시 @Entity가 설정되어야함.
@Table(name="tbl_board")//@Table을 설정하는 경우에는 기본적으로 데이터베이스의 클래스명과 동일한 이름으로 생성한다.
						//만일 클래스명과 다른 이름으로 테이블명을 지정하고 싶을 때에는 @Table의 name속성을 사용한다.
public class BoardDTO {
	
	@Id//가장 중요한 어노테이션, 해당 컬럼이 식별키(primary key)라는 것을 의미
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long bno;
	private String title;
	private String writer;
	private String content;
	
	@CreationTimestamp//시간관련아노테이션,엔티티가 생성되거나 업데이트 되는 시점의 날짜 데이터를 기록하는 설정이다.
	private Timestamp regdate;//게시글 등록일자
	@UpdateTimestamp//시간관련아노테이션,엔티티가 생성되거나 업데이트 되는 시점의 날짜 데이터를 기록하는 설정이다.
	private Timestamp updatedate;//게시글 수정일자

}
