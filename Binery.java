package ����;

public class Binery {

	public static void main(String[] args) {
		
//		extends,,,
		
		int[] arr= {1, 7, 8, 11, 27, 77, 96, 100};
		
		int search = 77;
		
		int lowIndex = 0;
		int highIndex = arr.length-1;
		int midIndex = (lowIndex + highIndex) / 2;
		
		
		while(arr[midIndex] != search) {
			if(arr[midIndex] < search) {
				lowIndex = midIndex + 1;
			}else if(arr[midIndex] > search) {
				highIndex = midIndex - 1;
			}
			
			if(lowIndex >= highIndex) {
				midIndex = -1; //������ ���� -1�� ���ϵǵ���(�������� ��Ģ)
				break;
			}
			
			midIndex = (highIndex + lowIndex) / 2;
		}
		
		System.out.println("���� ã�� ���� Index: " + midIndex + "�� �ִ�.");
				
	}

}
