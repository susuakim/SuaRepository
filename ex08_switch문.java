package if문;

import java.util.Scanner;

public class ex08_switch문 {

	public static void main(String[] args) {

		switch(str) {
		case "A" :
			System.out.println("A");
			break;
			
		case "B" :
			System.out.println("A");
			break;
		
		case "C" :
			System.out.println("A");
			break;
			
		default://case를 비교했을 때 모두 false이면 실행!!!@@!!!@@!!!@@!!!
			System.out.println("다른 문자를 입력하셨습니다.");
		}
		
		//break 조건문, 반복문에서 탈출하는 키워드,,,,..,,,..,,,..,,,..,,,..,,,
		//break 걸지 않으면, 조건문을 탈출하지 않아서 다음 break문을 만날때까지 실행문장들을 실행한다.
		
		
		
//		switch(입력값) {
//		case 비교할 값 : // 연산이나, 변수 들어가지 않음	 비교할 값에는 연산식 변수 사용 안함
//			break;
//			
		}
	}

}
