package model;

public class MemberDTO { //테이블별로 구성이 된다
	
	private String id;
	private String pw;
	private String name;
	
	
	public MemberDTO(String id, String pw) { //로그인을 할때 이름은 입력하지 않으니 id pw만 있는 생성자도 추가로 만들기
		super();
		this.id = id;
		this.pw = pw;
	}


	public MemberDTO(String id, String pw, String name) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
	}

	
	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public String getName() {
		return name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
	

}
