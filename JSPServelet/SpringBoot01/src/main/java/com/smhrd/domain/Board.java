package com.smhrd.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
	
	private int idx;
	private String title;
	private String writer;
	private String content;
	private String indate;
	private int count;
	
}
