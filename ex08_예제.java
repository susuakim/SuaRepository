package ���׿�����;

import java.util.Scanner;

public class ex08_���� {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("ù��° ���� �Է�: ");
		int num1 = sc.nextInt();
		
		System.out.print("�ι�° ���� �Է�: ");
		int num2 = sc.nextInt();
		
		int result = num1>num2 ? num1-num2 : num2-num1;
		
		System.out.println(result);
		
//		if(num1>num2) {
//			System.out.println("�� ���� ��: " + (num1-num2));
//		}
//		else System.out.println("�� ���� ��: " + (num2-num1));
	}

}
