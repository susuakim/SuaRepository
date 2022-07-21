package 정렬;

import java.util.Arrays;

public class 선택정렬 {

	public static void main(String[] args) {

		int[] arr = {98, 77, 49, 11, 31};
		System.out.println(Arrays.toString(arr));
		
		
		for(int j=0; j<arr.length-1; j++) {
			int maxIndex=0;
			
			for(int i=0; i<arr.length-j; i++) {
				if(arr[i]>arr[maxIndex]) {
					maxIndex=i;
				}
			}
			
			int temp=arr[maxIndex];
			arr[maxIndex]=arr[arr.length-(j+1)];
			arr[arr.length-(j+1)]=temp;
			
			System.out.println(Arrays.toString(arr));
			
		}
		
	}

}
