package com.edu.member.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.edu.member.controller.MemberController;
import com.edu.member.domain.MemberDTO;
import com.edu.member.mapper.MemberMapper;

@Repository("com.edu.member.service.MemberService")
public class MemberService {
	
	//로깅을 위한 변수
	private static final Logger logger 
	 = LoggerFactory.getLogger(MemberController.class);
	
	@Resource(name="com.edu.member.mapper.MemberMapper")
	MemberMapper memberMapper;
	
	//아이디체크
	public int idCheck(MemberDTO memberDTO) throws Exception{
		logger.info("service idcheck.......");
		int result = memberMapper.idCheck(memberDTO);
		return result;
	}
	//회원가입
	public void register(MemberDTO memberDTO) throws Exception{
		logger.info("service register.....");
		memberMapper.register(memberDTO);
	}
	//로그인
	public MemberDTO login(MemberDTO memberDTO) throws Exception{
		logger.info("service login......");
		return memberMapper.login(memberDTO);
	}
	//회원정보수정
	public void update(MemberDTO memberDTO) throws Exception{
		logger.info("service update........");
		memberMapper.update(memberDTO);
	}
	//회원탈퇴
	public void delete(MemberDTO memberDTO) throws Exception{
		logger.info("service delete......");
		memberMapper.delete(memberDTO);
	}
}
