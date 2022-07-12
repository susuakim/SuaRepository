package 산술연산자;

public class ex01_산술연산자 {

	public static void main(String[] args) {
		
//	산술연산자
		int a=10;
		int b=7;
		float c=7.0f;
		
		System.out.println(a+b+" == 더하기 결과");
		System.out.println(a-b+" == 빼기 결과");
		System.out.println(a*b+" == 곱하기 결과");
		System.out.println(a/b+" == 몫 결과");
		System.out.println(a%b+" == 나머지 결과");
		
		System.out.println("정수와 실수를 나누면??  ");
		System.out.println(a/c);
//		더 많은 정보를 담을 수 있는 float형태로 자동 형변환 된다.!!!
		
//		강제 형변환
		System.out.println((float)(a/b));
		
//		문자열 연결 + 연산자
		String d="10";
		String e="7";
		
		System.out.println(d+"  "+e);
		
		
	}

}
