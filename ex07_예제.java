package �ݺ���while;

import java.util.Scanner;

public class ex07_���� {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�Է�>>");
		int num1 = sc.nextInt();
		
		System.out.print("�Է�>>");
		int num2 = sc.nextInt();
		
		int max = num1>num2? num1 : num2;
		int min = num1<num2? num1 : num2;
		
		int sum = 0;
		
		for(int i=min; i<=max; i++) {
			sum+=i;
			System.out.print(i);
				
			}
		System.out.println(sum);

	}
}
