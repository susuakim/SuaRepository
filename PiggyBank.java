package ��ü�������α׷���;

import java.util.Scanner;

public class PiggyBank {
	
	Scanner sc = new Scanner(System.in);
	
	int money = 0;
	
	public void deposit(int num) {
		System.out.println("�Ա��� ���� " + num + "�� �̰�, �� �ܾ���" + (money+=num) + "�Դϴ�.");
	}
	
	public void withdraw(int num) {
		System.out.println("����� ���� " + num + "�� �̰�, �� �ܾ���" + (money-=num) + "�Դϴ�.");
	}

	public void showmoney() {
		System.out.println("�� �ܾ���" + money + "�Դϴ�.");
	}
}
