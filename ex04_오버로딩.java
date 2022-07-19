package 메소드;

public class ex04_오버로딩 {

	public static void main(String[] args) {
		// 오버로딩 = 중복정의, 오버라이딩 = 재정의
		//오버로딩 : 메소드는 하나, 매개변수는 다르게, 여러개의 메소드를 만드는 기법, 같은 이름의 메소드를 중복해서 정의
		//오버로딩 1. 메소드 이름이 같아. 2. 매개변수의 타입&개수가 다르다
		
		//가장 많이쓴는 오버로딩 -> print();
		//print 메소드의 매개변수 안에 들어오는 데이터 타입에 따라서 다르게 기능
		//print라는 메소드의 이름은 같음 => 사용자의 편의성을 높여준다!!
		System.out.println(add(1,2,3));
		System.out.println(add(1.2,2.5));

	}
	
	public static int add(int num1, int num2) { // 오버로딩 중복정의
		return num1+num2;
	}
    
	public static int add(int num1, int num2, int num3) { // 오버로딩 중복정의
		return num1+num2+num3;
	}
	
	public static double add(double a, double b) {
		return a+b;
	}

}
