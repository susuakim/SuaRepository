package 객체지향프로그래밍;

public class Student {
	
	private String name;
	private String birth;
	private int age;
	private int java;
	private int android;

	public Student(String name, String birth, int age, int java, int android) {
		this.name = name;
		this.birth = birth;
		this.age = age;
		this.java = java;
		this.android = android;
	}
	
	public Student() {
	
	}
	
	public void show() {
		System.out.println(name + "안녕하세요");
		System.out.println(birth + "년도");
		System.out.println(age + "살");
		System.out.println(java + "자바점수");
		System.out.println(android + "안드로이드 점수");
	}
	
	//private를 걸었기에 지금 필드에 선언된 변수들은 설계도 내부에만 접근 가능
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getJava() {
		return java;
	}

	public void setJava(int java) {
		this.java = java;
	}

	public int getAndroid() {
		return android;
	}

	public void setAndroid(int android) {
		this.android = android;
	}

}
