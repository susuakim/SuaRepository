package �޼ҵ�;

public class ex04_�����ε� {

	public static void main(String[] args) {
		// �����ε� = �ߺ�����, �������̵� = ������
		//�����ε� : �޼ҵ�� �ϳ�, �Ű������� �ٸ���, �������� �޼ҵ带 ����� ���, ���� �̸��� �޼ҵ带 �ߺ��ؼ� ����
		//�����ε� 1. �޼ҵ� �̸��� ����. 2. �Ű������� Ÿ��&������ �ٸ���
		
		//���� ���̾��� �����ε� -> print();
		//print �޼ҵ��� �Ű����� �ȿ� ������ ������ Ÿ�Կ� ���� �ٸ��� ���
		//print��� �޼ҵ��� �̸��� ���� => ������� ���Ǽ��� �����ش�!!
		System.out.println(add(1,2,3));
		System.out.println(add(1.2,2.5));

	}
	
	public static int add(int num1, int num2) { // �����ε� �ߺ�����
		return num1+num2;
	}
    
	public static int add(int num1, int num2, int num3) { // �����ε� �ߺ�����
		return num1+num2+num3;
	}
	
	public static double add(double a, double b) {
		return a+b;
	}

}
