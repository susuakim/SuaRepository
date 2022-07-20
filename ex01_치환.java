package sort;

public class ex01_ġȯ {

	public static void main(String[] args) {
		
		int[] arr = {45, 7, 12, 82, 25};
		int temp;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] > arr[i+1]) {
				temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
	}

}
