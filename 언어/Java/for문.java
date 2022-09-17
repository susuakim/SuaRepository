package 반복문for;

import java.util.Scanner;

public class ex06_for문 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("입력>> ");
		int num = sc.nextInt();
		
		for(int i=1; i<=num; i++) {
			System.out.print(i + " ");
		}
	}

}





//초기화(처음 값을 넣어주는 것) int a = 0;
//변수선언 int a;
//할당(초기화 이후의 값을 넣어주는 것) a = 0;
//---------------------------------------
//지역변수&전역변수  
//지역변수: 한정된 영역에서만 사용가능!!
//전역변수: 더 넓은 영역에서 사용가능!!
//변수는 초기화가 되어야 사용 가능!!
//
//---------------------------------------
//for 반복횟수가 정해졌을 때 사용
//for(초기화 구문; 검사조건; 반복 후 작업){
//	실행문장;}
//
//
//



