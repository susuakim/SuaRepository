package sort;

import java.util.Arrays;

public class ex02_�������� {

	public static void main(String[] args) {
		// array[0]�� array[1]�� ���� ��,
		//array[0]�� ���� �� ũ��
		//�� ���� ġȯ�Ѵ�.
		
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
