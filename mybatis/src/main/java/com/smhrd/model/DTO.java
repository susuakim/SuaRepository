package com.smhrd.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter // getter 생성자
@Setter // setter 생성자
@AllArgsConstructor // 전체 생성자
@RequiredArgsConstructor // 필요한 핀드만 있는 생성자
public class DTO {
	
		@NonNull private String id;
		@NonNull private String pw;
		private String name;
		
		public DTO(String id) {
			this.id=id;
		}
}
