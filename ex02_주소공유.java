package 배열;

public class ex02_주소공유 {

	public static void main(String[] args) {
		
//		int[] a = new int[5];
//		
//		//기본데이터타입 => 값 자체 저장
//		
//		int num = 3;
//		int temp = num;
//		
//		// 배열 레퍼런스 변수, 주소를 공유한다는 것은 같은 공간을 공유한다.
		int[] array1 = new int[5];
		int[] array2 = array1;
		
		array1[0] = 3;
		
		System.out.println(array2[0]);

	}

}
