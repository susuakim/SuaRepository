package exception;

public class Devide0 { // 0���� ������

	public static void main(String[] args) {
		
		int num1 = 10;
		int num2 = 0;
		
		
		try {
			System.out.printf("%d / %d = %d%n", num1, num2, num1/num2); //�� ������ �õ��� �ǵ�,, ���� ������ �߻��Ѵٸ�
		}catch(ArithmeticException e) {
			System.out.println("0���� ������ �ȵ˴ϴ�");
		}

		System.out.println("���α׷� ����");
		
	}

}
