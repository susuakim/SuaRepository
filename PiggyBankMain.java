package 객체지향프로그래밍;

import java.util.Scanner;

public class PiggyBankMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
//		돈 입금--------------------------------------------
		System.out.print("얼마 입금??>> ");
		int num_in = sc.nextInt();
		
		PiggyBank pig = new PiggyBank();
		
		pig.deposit(num_in);
		
		System.out.println();

//		돈 출금--------------------------------------------
		System.out.print("얼마 출금??>> ");
		int num_out = sc.nextInt();
		
		pig.withdraw(num_out);
		
		System.out.println();
		
//		잔액--------------------------------------------
		pig.showmoney();

	}

}
