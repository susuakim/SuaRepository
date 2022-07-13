package 반복문while;

import java.util.Scanner;

public class ex03_예제 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int c = 0;
//		while(true) {
//			System.out.println("숫자를 입력하세요: ");
//			int a = sc.nextInt();
//			if(a<100) {
//				sum += a;
//				++c;
//			}else break;
//			
//			
//		}
		
		int a = 0;
		
		int sum = 0;
		while(0<=a && a<=100) {
			System.out.println("점수:   ");
			a=sc.nextInt();
			sum = sum + a;
			c++;
		}
		
		
		System.out.println("cc: " + c);
		System.out.println("합계: " + sum);
		System.out.println("평균: " + (float)(sum/c) );

	}

}
