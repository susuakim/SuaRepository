package exception;

import java.util.Scanner;

public class ScannerClose {
	static Scanner sc;
	
	public static void main(String[] args) {
		
		while(true) {
			
			sc = new Scanner(System.in);
		
			System.out.print("�޷� �Է�>> ");
			int input = sc.nextInt();
			
			if(input == -1) {
				break;
			}else {
				System.out.println(input*1200 + "���Դϴ�.");
			}
		}
		
		System.out.println("���α׷� ����");
		
		if(sc != null) {			
			sc.close();
		}
		
		
		
//		String[] drink = {"���ڿ�", "���Ǵ�", "ZICO", "����", "��ħ�޻�"};
//		String[] snack = {"�ѼŻѼŵ����", "�Ǻ���", "������", "�Ұ���", "�ǻ�"};
//		
//		System.out.println(drink[0]); //���ڿ�
//		System.out.println(snack[0]); //�ѻѵ����
//		
//		snack = drink; //drink �ּҰ��� snack �ּҰ��� �����ض�
//		
//		System.out.println(drink[0]); //���ڿ�
//		System.out.println(snack[0]); //���ڿ�
//		
//		drink[0] = "�����̼Ҵ�";
//		System.out.println(drink[0]); //�����̼Ҵ�
//		System.out.println(snack[0]); //�����̼Ҵ�
		
	}

}
