package exception;

public class Devide0 { // 0으로 나누자

	public static void main(String[] args) {
		
		int num1 = 10;
		int num2 = 0;
		
		
		try {
			System.out.printf("%d / %d = %d%n", num1, num2, num1/num2); //이 문장을 시도할 건데,, 만약 에러가 발생한다면
		}catch(ArithmeticException e) {
			System.out.println("0으로 나누면 안됩니다");
		}

		System.out.println("프로그램 종료");
		
	}

}
