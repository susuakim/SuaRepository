package 메소드;

public class ex03_예제 {

	public static void main(String[] args) {
		System.out.println("덧셈은:  " + add(3,5));
		System.out.println("뺄셈은:  " + sub(3,5));
		System.out.println("곱셈은:  " + mul(3,5));
		System.out.println("나눗셈은:  " + div(3,5));

	}
	
	public static int add(int a, int b) {
		int result = a + b;
		return result;
	}
	
	public static int sub(int a, int b) {
		int result = a - b;
		return result;
	}
	
	public static int mul(int a, int b) {
		int result = a * b;
		return result;
	}
	
	public static int div(int a, int b) {
		int result = a / b;
		return result;
	}
	

}
