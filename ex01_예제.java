package 배열;

public class ex01_예제 {

	public static void main(String[] args) {
		
		int[] ar = {1,2,9,4,5,10,7,8,3,6,20,0};
		
		//기준값을 설정
		int max = ar[0];// 배열안에 있는 기준값으로 설정해야한다.
		int min = ar[0];
		
		for(int i=0; i<ar.length; i++) {
			if(max<ar[i]) {
				max=ar[i];
			}
		}System.out.println("큰값: " + max);
		
		for(int j=0; j<ar.length; j++) {
			if(min>ar[j]) {
				min=ar[j];
			}
		}System.out.println("작은값: " + min);
		
		
		for(int k = 0; k<ar.length; k++) {
			
		}
		
	}

}
