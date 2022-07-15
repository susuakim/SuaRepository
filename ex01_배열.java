package 배열;

public class ex01_배열 {

	public static void main(String[] args) {
		
		//기본데이터타입 -> 크기가 조겅(int, char, short, long)
		
		//레퍼런스타입 -> 크기가 유동적, 주소를 저장하는 변수(배열, 열거, 클래스, 인터페이스)
		
		//배열 선언 및 생성
		//new : 생성할 때 쓰는 키워드
		
		int[] num = new int[10];
		
		int[] intArray = new int[5];
		
		System.out.println("배열의 주소: " + intArray);
		
		//배열 내의 값을 호출할때는 인덱스 번호로 호출
		//배열을 생성하면 0의 값으로 초기화가 되어있다.
		
		System.out.println("0번째의 값:  " + intArray[0]);
		System.out.println("1번째의 값:  " + intArray[1]);
		System.out.println("2번째의 값:  " + intArray[2]);
		System.out.println("3번째의 값:  " + intArray[3]);
		
		intArray[0] = 5;
		for(int i=0; i<5; i++) {
			System.out.println(i + "번째 값: " + intArray[i]);
		}
		
		for(int i =0; i<5; i++) {
			intArray[i]=i;
			System.out.println(intArray);
		}
		a.length
		length
		//배열의 크기는 생성할 때 결정, 수정 불가능;
		
		System.out.println(intArray.length);
	}

}


// int[] a = new int[5];
//배열은 생성하는 방법 2가지
//1. new 데이터타입[배열크기]
//int[] a= new int[5];
//
//
//2. 선언과 동시에 초기화-> 어떤 데이터가 들어갈지 명확할 때
//int[] a = {1, 2, 3, 4, 5};
//
//
//int[] a= {1, 2, 3};
//for
//

//배열의 크기











