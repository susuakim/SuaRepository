package �ݺ���while;

public class ex01_while {

	public static void main(String[] args) {
		//�ݺ���: ������ true�� �� ���๮���� �ݺ�,,!! ���϶� �ݺ�
		//while �ݺ�Ƚ���� �������� �ʾ��� �� ���
//		while(���ǽ�) {
//			System.out.println("���๮��");
//		}
		
		// while�� ������� 1. ���ǽ��� ���̶�� ���๮�� ���������, �����̶�� �ݺ��� ����
		int a=1;
		while(a<=10) {
			System.out.print(a++ + " ");
				}

		// ���ѷ���
		//break�� Ż�� -> if���� ���� ���
		int b=2;
		while(true) {
			System.out.println("���ѷ���");
			b++;
			if(b==10) {
				break;
			}
		}
	}

}
