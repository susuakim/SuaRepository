package �޼ҵ�;

public class ex01_�ǽ� {

	public static void main(String[] args) {
		add(3,5);
		sub(3,5);
		mul(3,5);
		div(3,5);
		
		System.out.println("==============");
		System.out.println("������: " + add);
		System.out.println("������: " + sub);
		System.out.println("������: " + mul);
		System.out.println("��������: " + div);
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
