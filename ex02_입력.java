package 입출력;

import java.util.Scanner;

public class ex02_입력 {

	public static void main(String[] args) {
		
		//입력 Scanner : 입력할때 사용하는 라이브러리
		//jre에서 불러옴 import!
		//import = 이 라이브러리를 가지고 와서 사용하겠다 -> 자동완성으로 자동 import
		//system.in 키보드를 직접 제어해서 키를 입력받느 입력스트림객체
		//기계가 읽을 수 있도록 byte 데이터로 변환
		//Scanner = 읽어온 byte데이터를 문자, 정수, 실수 등 다양한 타입으로 변환해서 리턴하는 라이브러리
		
		Scanner sc=new Scanner(System.in);
		System.out.print("당신의 이름을 작성하세요: ");
		sc.next();
		
		System.out.print("당신의 나이를 입력하세요");
		sc.nextInt();
		
	
		final int b=3;
		
		

	}

}
