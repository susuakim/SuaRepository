package �迭;

public class ex02_�ּҰ��� {

	public static void main(String[] args) {
		
//		int[] a = new int[5];
//		
//		//�⺻������Ÿ�� => �� ��ü ����
//		
//		int num = 3;
//		int temp = num;
//		
//		// �迭 ���۷��� ����, �ּҸ� �����Ѵٴ� ���� ���� ������ �����Ѵ�.
		int[] array1 = new int[5];
		int[] array2 = array1;
		
		array1[0] = 3;
		
		System.out.println(array2[0]);

	}

}
