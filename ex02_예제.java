package �ݺ���while;

import java.util.Scanner;

public class ex02_���� {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���������a : ");
		int a = sc.nextInt();
		
		System.out.print("��ǥ������b : ");
		int b = sc.nextInt();
		
		int sum = 0;
		
		int c = 1;
//		while(true) {
//			System.out.print(c++ + "���� ���� ������ : ");
//			int d = sc.nextInt();
//		
//			sum += d;
//			
//			if(sum > (a-b)) {
//				System.out.println(a - sum + "kg �޼�!!");
//				break;
//			} 
			
			while(sum < (a-b)) {
				System.out.print(c++ + "���� ���� ������ : ");
				int d = sc.nextInt();
			
				sum += d;
			
				} 
			System.out.println(a - sum + "kg �޼�!!");
		}

	}


