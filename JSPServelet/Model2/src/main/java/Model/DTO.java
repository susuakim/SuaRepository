package Model;

public class DTO {
	//DTO : Data Transfer Object
	
	private String id;
	private String pw;
	private String name;
	
	public DTO(String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		
	}
	
	public DTO(String id, String pw) {
		this.id = id;
		this.pw = pw;
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

}
