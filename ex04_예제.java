package 반복문while;

import java.util.Scanner;

public class ex04_예제 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.print("첫 번째 정수를 입력하세요>> ");
			int num1 = sc.nextInt();
			
			System.out.print("두 번째 정수를 입력하세요>> ");
			int num2 = sc.nextInt();
			
			System.out.print("[1]더하기 [2]빼기 >> ");
			int rlt = sc.nextInt();
			
			if(rlt == 1) {
				System.out.println("더하기 연산 결과는 " + (num1+num2) + "입니다.");
				
			}else System.out.println("빼기 연산 결과는 " + (num1-num2) + "입니다.");
			
			//------------------------------		
//			System.out.println("결과는 " + (rlt == 1 ? num1+num2 : num1-num2)); 삼항연산자 사용하면 간단
			
			
			System.out.print("다시 실행하시겠습니까? (Y/N)");
			String s = sc.next();//
			
			if(s.equals("N")) {
				System.out.println("종료되었습니다.");
				break;
			}
			
		}
		
		
	}

}
