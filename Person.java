package 객체지향프로그래밍;

public class Person {

	//나만의 캐릭터 만들기
	//class(설계도)-> 설계만 하는 것이라서 코드를 실행하는 main메소드 필요 없다.
	
	String name;
	int age;
	String gender;
	
	//사람이 할 수 있는 기능
	
	//Person() 생성자 메소드 만들기
	//생성자: 객체가 생성되는 순간에 자동으로 호출되는 메소드, 생성과 동시에 필드에 값을 적용 가능, 
	
	public Person(String name, int age, String gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	//기본생성자, default 생성자
	public Person() {
		
	}
	
	public void eat() {
		System.out.println("돈가스 냠냠");
	}
	
	public void sleep() {
		System.out.println("꿀잠 쿨쿨");
	}
	
	public void play() {
		System.out.println("놀자 놀자");
	}

}
