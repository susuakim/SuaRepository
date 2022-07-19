package 객체지향프로그래밍;

import java.util.Scanner;

public class PiggyBank {
	
	Scanner sc = new Scanner(System.in);
	
	int money = 0;
	
	public void deposit(int num) {
		System.out.println("입금할 돈은 " + num + "원 이고, 총 잔액은" + (money+=num) + "입니다.");
	}
	
	public void withdraw(int num) {
		System.out.println("출금할 돈은 " + num + "원 이고, 총 잔액은" + (money-=num) + "입니다.");
	}

	public void showmoney() {
		System.out.println("총 잔액은" + money + "입니다.");
	}
}
