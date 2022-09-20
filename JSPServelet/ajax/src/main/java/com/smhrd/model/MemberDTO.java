package com.smhrd.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class MemberDTO {
	
	@NonNull
	private String email;
	@NonNull
	private String pw;
	private String tel;
	private String address;
}
