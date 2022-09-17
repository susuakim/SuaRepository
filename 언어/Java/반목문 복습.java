package for문;

public class ex01_복습 {

	public static void main(String[] args) {
////		while : 반복횟수를 모를 때
////		조건식이 true일 때 실행하겠다
//		while(조건식) {
//			//주차별로 감량된 몸무게 입력받기
//		}
//		
////		while(true){
//			if(true) {
//				break;
//			}
////		for : 반복횟수를 알고 있을 때
//			for(초기화구문; 검사조건; 반복후작업) {
//				실행문장
//			}
		
		
		for(int i =1; i<=100; i++) {
			if(i%3==0) {
				System.out.print(i + " ");
			}//i에 들어가 있는 숫자를 3으로 나누었을때 0인 숫자들만 출력
		}
	}

}
