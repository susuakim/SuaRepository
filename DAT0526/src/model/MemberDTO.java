package model;

public class MemberDTO { //member 테이블
	
	String id, pw, name;
	
	//1. 생성자
	//2. Getter & Setter

	public MemberDTO(String id, String pw, String name) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	
	public String getId() {return id;}
	public String getPw() {return pw;}
	public String getName() {return name;}
	
	public void setId(String id) {this.id = id;}
	public void setPw(String pw) {this.pw = pw;}
	public void setName(String name) {this.name = name;}

	

	
	
	

}
