package 산술연산자;

import java.util.Scanner;

public class ex02_예제 {

	public static void main(String[] args) {
		
		System.out.print("숫자입력: ");

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		if(num>=100) {
			System.out.println(num/100*100);
		}
		else System.out.println("백의 자리를 입력하세요!!");
	
	}

}
