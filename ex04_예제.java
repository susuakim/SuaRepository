package �ݺ���while;

import java.util.Scanner;

public class ex04_���� {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.print("ù ��° ������ �Է��ϼ���>> ");
			int num1 = sc.nextInt();
			
			System.out.print("�� ��° ������ �Է��ϼ���>> ");
			int num2 = sc.nextInt();
			
			System.out.print("[1]���ϱ� [2]���� >> ");
			int rlt = sc.nextInt();
			
			if(rlt == 1) {
				System.out.println("���ϱ� ���� ����� " + (num1+num2) + "�Դϴ�.");
				
			}else System.out.println("���� ���� ����� " + (num1-num2) + "�Դϴ�.");
			
			//------------------------------		
//			System.out.println("����� " + (rlt == 1 ? num1+num2 : num1-num2)); ���׿����� ����ϸ� ����
			
			
			System.out.print("�ٽ� �����Ͻðڽ��ϱ�? (Y/N)");
			String s = sc.next();//
			
			if(s.equals("N")) {
				System.out.println("����Ǿ����ϴ�.");
				break;
			}
			
		}
		
		
	}

}
