package exception;

public class ArrayOut {

	public static void main(String[] args) {
		
		int[] array = {1, 2, 3};
		
		
		try {
			System.out.println(array[3]);
			System.out.println(10/0);
			String str = "1234";
			int num = Integer.parseInt(str);
			System.out.println(num);
			
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("�ε����� �߸� �Է��ϼ̽��ϴ�.");
		}catch(ArithmeticException e) {
			System.out.println("0���� �����̽��ϴ�.");
		}catch(Exception e) { // � �������� �𸦶� ���
			e.printStackTrace(); // � ������ �߻��ߴ��� �ܼ�â�� ���
		}
		
		System.out.println("���α׷� ����");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
