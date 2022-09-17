package 메소드;

public class ex01_실습 {

	public static void main(String[] args) {
		add(3,5);
		sub(3,5);
		mul(3,5);
		div(3,5);
		
		System.out.println("==============");
		System.out.println("덧셈은: " + add);
		System.out.println("뺄셈은: " + sub);
		System.out.println("곱셈은: " + mul);
		System.out.println("나눗셈은: " + div);
	}

	
	public static int add(int a, int b) {
		return a + b;
	}
	
	public static int sub(int a, int b) {
		return a - b;
	}
	
	public static int mul(int a, int b) {
		return a * b;
	}
	
	public static int div(int a, int b) {
		return a / b;
	}
	
	
	
}
