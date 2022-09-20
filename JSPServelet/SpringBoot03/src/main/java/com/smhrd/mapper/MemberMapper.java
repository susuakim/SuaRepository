package com.smhrd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smhrd.domain.Member;

@Mapper
public interface MemberMapper {
	
	public List<Member> memberList();

	
}
