package for문;

import java.util.Scanner;

public class ex05_예제 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("단 입력 >> ");
		int num1 = sc.nextInt();
		
		System.out.print("범위 입력 >> ");
		int num2 = sc.nextInt();
		
		
		for(int i=1; i<=num2; i++) {
			System.out.println(num1 + " * " + i + " = " + i*num1);
		}

		
	}

}
