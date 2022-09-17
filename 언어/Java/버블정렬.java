package sort;

import java.util.Arrays;

public class ex02_버블정렬 {

	public static void main(String[] args) {
		// array[0]과 array[1]을 비교한 후,
		//array[0]의 값이 더 크면
		//두 값을 치환한다.
		
		int[] arr = {45, 7, 12, 82, 25};
		int temp;
		
		for(int i=1; i<arr.length; i++) {
			for(int k=0; k<arr.length-i; k++) {
				if(arr[k]>arr[k+1]) {
					temp=arr[k];
					arr[k]=arr[k+1];
					arr[k+1]=temp;
				}
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		System.out.println(Arrays.toString(arr));

	}

}
