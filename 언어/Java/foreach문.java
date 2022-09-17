package 배열;

public class ex03_foreach문 {

	public static void main(String[] args) {
		
		//for each문: 반복을 할 수 있는 배열, ArrayList 등에서 사용이 가능
		//
		
//		for(사용할 변수 선언: 배열) {
//			실행문장;
//		}
//		
		int[] ar = {1,2,3};
		
		for(int i =0; i<ar.length; i++) {
			System.out.println(ar[i]);
		}
		
		System.out.println("for each 사용하여 출력 -------------------------");
		
		for(int i : ar) {
			System.out.println(i + " ");
		}
		
		
		
		
		
		
	}

}
