package 배열;

import java.util.Scanner;

public class ex02_예제 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] ar = new int[5];
		
		for(int i =0; i<ar.length; i++) {
			System.out.print((i+1) + "번째 입력>> ");
			int num = sc.nextInt();
		
			ar[i]=num;

		}
		System.out.print("입력된 점수: ");
		
		int sum = 0;
		
		for(int j = 0; j<ar.length; j++) {
		System.out.print(ar[j] + " ");
		sum += ar[j];
		} 
		System.out.println();
		
		//최저, 최고점수, 총합, 평균 구하기------------------------
		int max = ar[0]; 
		int min = ar[0];
		
		for(int k =0; k<ar.length; k++) {
			if(max < ar[k]) {
				max = ar[k];
			}
			if(min > ar[k]) {
				min = ar[k];
			}
		}
		
		System.out.println("최고점수: " + max + "   " + "최저점수: " + min);
		System.out.print("총합: " + sum + "   ");
		System.out.println("평균: " + (float)sum/ar.length);
		
	}
	
}
