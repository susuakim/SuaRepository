package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class BookDTO {
	@NonNull
	private String id;
	@NonNull
	private String pw;
	private String nick;
	private String email;
	private String tel;

}
