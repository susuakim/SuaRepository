package �迭;

public class ex01_�迭 {

	public static void main(String[] args) {
		
		//�⺻������Ÿ�� -> ũ�Ⱑ ����(int, char, short, long)
		
		//���۷���Ÿ�� -> ũ�Ⱑ ������, �ּҸ� �����ϴ� ����(�迭, ����, Ŭ����, �������̽�)
		
		//�迭 ���� �� ����
		//new : ������ �� ���� Ű����
		
		int[] num = new int[10];
		
		int[] intArray = new int[5];
		
		System.out.println("�迭�� �ּ�: " + intArray);
		
		//�迭 ���� ���� ȣ���Ҷ��� �ε��� ��ȣ�� ȣ��
		//�迭�� �����ϸ� 0�� ������ �ʱ�ȭ�� �Ǿ��ִ�.
		
		System.out.println("0��°�� ��:  " + intArray[0]);
		System.out.println("1��°�� ��:  " + intArray[1]);
		System.out.println("2��°�� ��:  " + intArray[2]);
		System.out.println("3��°�� ��:  " + intArray[3]);
		
		intArray[0] = 5;
		for(int i=0; i<5; i++) {
			System.out.println(i + "��° ��: " + intArray[i]);
		}
		
		for(int i =0; i<5; i++) {
			intArray[i]=i;
			System.out.println(intArray);
		}
		a.length
		length
		//�迭�� ũ��� ������ �� ����, ���� �Ұ���;
		
		System.out.println(intArray.length);
	}

}


// int[] a = new int[5];
//�迭�� �����ϴ� ��� 2����
//1. new ������Ÿ��[�迭ũ��]
//int[] a= new int[5];
//
//
//2. ����� ���ÿ� �ʱ�ȭ-> � �����Ͱ� ���� ��Ȯ�� ��
//int[] a = {1, 2, 3, 4, 5};
//
//
//int[] a= {1, 2, 3};
//for
//

//�迭�� ũ��











