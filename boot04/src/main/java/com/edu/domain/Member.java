package com.edu.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="tbl_members")
@EqualsAndHashCode(of="uid")//복잡한 연관관계를 잡아주는 것,일반적으로 id를 붙여줌.
public class Member {
	
	@Id
	private String uid;
	private String upw;
	private String uname;
	

}
