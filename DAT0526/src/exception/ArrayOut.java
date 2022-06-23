package exception;

public class ArrayOut {

	public static void main(String[] args) {
		
		int[] array = {1, 2, 3};
		
		
		try {
			System.out.println(array[3]);
			System.out.println(10/0);
			String str = "1234";
			int num = Integer.parseInt(str);
			System.out.println(num);
			
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("인덱스를 잘못 입력하셨습니다.");
		}catch(ArithmeticException e) {
			System.out.println("0으로 나누셨습니다.");
		}catch(Exception e) { // 어떤 에러인지 모를때 사용
			e.printStackTrace(); // 어떤 에러가 발생했는지 콘솔창에 출력
		}
		
		System.out.println("프로그램 종료");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
