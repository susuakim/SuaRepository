package 객체지향프로그래밍;

public class PersonMain {

	public static void main(String[] args) {
		// 사람을 설계한 설계도를 불러와서 실제 객체로 생성할 공간 -> main 메소드가 필이ㅛ
		
		//1. 설계도 불러오기
		//클래스 객체명 = new 클래스();
		Person person = new Person();
		
//		System.out.println("사람되기전 : ");
//		System.out.println(person.name);
//		System.out.println(person.age);
//		System.out.println(person.gender);
//		
//		//인스턴스화 = 설계도를 가지고와서 실제 객체로 생성하는 것
//		//구체적인 사람 만들기
//		//필드의 값을 채우기
//		
//		System.out.println();
		
//		person.name = "김수아";
//		person.age = 26;
//		person.gender = "여자";
//		
//		System.out.println("사람되고 난 후 : ");
//		System.out.println(person.name);
//		System.out.println(person.age);
//		System.out.println(person.gender);
		
		//설계도에 있는 eat, sleep, play 실행
//		person.eat();
//		person.play();
//		person.sleep();
//		
		
		Person person2 = new Person();
//		
//		System.out.println("사람되고 난 후 : ");
//		person.name = "김세령";
//		person.age = 24;
//		person.gender = "여자";
//		
//		System.out.println(person.name);
//		System.out.println(person.age);
//		System.out.println(person.gender);
//		
		
		
		//생성자 만들기
		Person person3 = new Person("이명훈", 20, "남자");
		
		System.out.println(person3.name);
		System.out.println(person3.age);
		System.out.println(person3.gender);
		
		person3.eat();
		person3.play();
		person3.sleep();
		
		
		
	}

}
