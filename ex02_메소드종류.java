package �޼ҵ�;

public class ex02_�޼ҵ����� {

	public static void main(String[] args) {
		cc(22,3);
		System.out.println(vv(1,2));
		mulNumber(2,3);
	}
	
	//�Ű����� o, ��ȯ�� o
	public static void cc(int a, int b){
		int c = a+b;
		System.out.println(c);
	}

	public static int vv(int a, int b){
		int c = a+b;
		return c;
	}
	
	public static void addNumber(int num1, int num2) {
		
		int result = num1 + num2;
		
		
	}
	
	public static void mulNumber(int num1, int num2) {
		System.out.println(num1*num2);
	}
	
	
	public static int minus() {
		int result = 5-3;
		return result;
	}
	
	
	
	
	
	
	
	
}
