package com.smhrd.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.smhrd.domain.Member;

@Mapper
public interface MemberMapper {
	
	public int join(Member member);
	
	public Member login(Member member);
}
