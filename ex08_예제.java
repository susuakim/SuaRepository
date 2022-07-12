package 삼항연산자;

import java.util.Scanner;

public class ex08_예제 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번째 정수 입력: ");
		int num1 = sc.nextInt();
		
		System.out.print("두번째 정수 입력: ");
		int num2 = sc.nextInt();
		
		int result = num1>num2 ? num1-num2 : num2-num1;
		
		System.out.println(result);
		
//		if(num1>num2) {
//			System.out.println("두 수의 차: " + (num1-num2));
//		}
//		else System.out.println("두 수의 차: " + (num2-num1));
	}

}
