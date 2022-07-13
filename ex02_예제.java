package 반복문while;

import java.util.Scanner;

public class ex02_예제 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("현재몸무게a : ");
		int a = sc.nextInt();
		
		System.out.print("목표몸무게b : ");
		int b = sc.nextInt();
		
		int sum = 0;
		
		int c = 1;
//		while(true) {
//			System.out.print(c++ + "주차 감량 몸무게 : ");
//			int d = sc.nextInt();
//		
//			sum += d;
//			
//			if(sum > (a-b)) {
//				System.out.println(a - sum + "kg 달성!!");
//				break;
//			} 
			
			while(sum < (a-b)) {
				System.out.print(c++ + "주차 감량 몸무게 : ");
				int d = sc.nextInt();
			
				sum += d;
			
				} 
			System.out.println(a - sum + "kg 달성!!");
		}

	}


