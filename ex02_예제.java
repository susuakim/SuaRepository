package ���������;

import java.util.Scanner;

public class ex02_���� {

	public static void main(String[] args) {
		
		System.out.print("�����Է�: ");

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		if(num>=100) {
			System.out.println(num/100*100);
		}
		else System.out.println("���� �ڸ��� �Է��ϼ���!!");
	
	}

}
