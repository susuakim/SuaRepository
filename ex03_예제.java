package ¸Ş¼Òµå;

public class ex03_¿¹Á¦ {

	public static void main(String[] args) {
		System.out.println("µ¡¼ÀÀº:  " + add(3,5));
		System.out.println("»¬¼ÀÀº:  " + sub(3,5));
		System.out.println("°ö¼ÀÀº:  " + mul(3,5));
		System.out.println("³ª´°¼ÀÀº:  " + div(3,5));

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
