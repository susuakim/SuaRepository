package if문;

import java.util.Scanner;

public class ex04_예제 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요:  ");
		
		int num = sc.nextInt();
		
		if(num%2 == 0) {
			System.out.println(num + " 짝수입니다.");
		} else System.out.println(num + " 홀수입니다.");

	}
	
	//만약에 num을 2로 나우었을때 나버지가 0과 같다면 조건식 짤==ㄱ수
	//같지 않다면 else 홀수 실행문장___sc.nextInt();
	
	else {
		System.out.println();
		System.out.println();System.out.println("ex04_예제.enclosing_method()");
	}

}
