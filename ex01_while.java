package 반복문while;

public class ex01_while {

	public static void main(String[] args) {
		//반복문: 조건이 true일 때 실행문장을 반복,,!! 참일때 반복
		//while 반복횟수가 정해지지 않았을 때 사용
//		while(조건식) {
//			System.out.println("실행문장");
//		}
		
		// while문 실행순서 1. 조건식이 참이라면 실행문자 실행되지만, 거짓이라면 반복문 종료
		int a=1;
		while(a<=10) {
			System.out.print(a++ + " ");
				}

		// 무한루프
		//break로 탈출 -> if문과 같이 사용
		int b=2;
		while(true) {
			System.out.println("무한루프");
			b++;
			if(b==10) {
				break;
			}
		}
	}

}
