package �޼ҵ�;

public class ex01_�޼ҵ�⺻���� {

		//main�޼ҵ�: �ڵ带 ��������ִ� �޼ҵ�
	public static void main(String[] args) {
		
		int result = addNumber(1,2);
		System.out.println(result);
		System.out.println(addNumber(2,5));

	}

	
	//�޼ҵ带 ������ �� ������ġ�� main �޼ҵ�� ���� Ŭ������ �ִٸ� static Ű���带 �ٿ��־���Ѵ�.
	public static int addNumber(int num1, int num2) {
		int result = num1+num2;
		return result;

	}

	
	
}