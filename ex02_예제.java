package if문;

import java.util.Scanner;

public class ex02_예제 {

	public static void main(String[] args) {
		
		System.out.print("숫자 입력:  ");
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		if(num%3==0 && num%5==0) {
			System.out.println("3과 5의 배수입니다.");
		}
		
	}

}
