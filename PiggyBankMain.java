package ��ü�������α׷���;

import java.util.Scanner;

public class PiggyBankMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
//		�� �Ա�--------------------------------------------
		System.out.print("�� �Ա�??>> ");
		int num_in = sc.nextInt();
		
		PiggyBank pig = new PiggyBank();
		
		pig.deposit(num_in);
		
		System.out.println();

//		�� ���--------------------------------------------
		System.out.print("�� ���??>> ");
		int num_out = sc.nextInt();
		
		pig.withdraw(num_out);
		
		System.out.println();
		
//		�ܾ�--------------------------------------------
		pig.showmoney();

	}

}
