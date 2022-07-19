package ¸Ş¼Òµå;

public class ex01_½Ç½À {

	public static void main(String[] args) {
		add(3,5);
		sub(3,5);
		mul(3,5);
		div(3,5);
		
		System.out.println("==============");
		System.out.println("µ¡¼ÀÀº: " + add);
		System.out.println("»¬¼ÀÀº: " + sub);
		System.out.println("°ö¼ÀÀº: " + mul);
		System.out.println("³ª´°¼ÀÀº: " + div);
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
