package 메소드;

public class ex01_메소드기본구조 {

		//main메소드: 코드를 실행시켜주는 메소드
	public static void main(String[] args) {
		
		int result = addNumber(1,2);
		System.out.println(result);
		System.out.println(addNumber(2,5));

	}

	
	//메소드를 생성할 때 생성위치가 main 메소드와 같은 클래스에 있다면 static 키워드를 붙여주어야한다.
	public static int addNumber(int num1, int num2) {
		int result = num1+num2;
		return result;

	}

	
	
}