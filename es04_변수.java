package 변수;

import java.util.Scanner;

public class es04_변수 {

	public static void main(String[] args) {
		System.out.println("김수아");
//		자료형(데이터 타입) 변수명 = (대입) 값;
		System.out.println();
		
		int a = 3;
		System.out.println('a');
		
		Scanner sc = new Scanner(System.in);
		System.out.print("입력:  ");
//		sc.next();
//		sc.nextInt();
		String name = sc.next();
		System.out.println(name);

		System.out.println("나이: ");
		int age = sc.nextInt();
		System.out.print(age);
		
//		string은 기본데이터타입이아님!! JRE에서 string 으로 제공
		
//		기본데이터타입이 아님!!
//		데이터타입은 쪼개져잇는데,, 하드웨어가 발달하지않아서 용량이 부녹해서!!
		byte age1 = 127;
		int b = 123456789;
		long c = 123456789;
//		float num = float를 사용하려면 f를 붙여야함,,,!!!
		float num = 1.5f;
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
