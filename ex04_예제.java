package 배열;

import java.util.Random;

public class ex04_예제 {

	public static void main(String[] args) {
		
		Random r = new Random();
		
		int[] ran = new int[10];
		
		int sum = 0;

		for(int i=0; i<10; i++) {
			ran[i]=r.nextInt(20)+1;
			System.out.println(ran[i]);
			sum += ran[i];
		}
		System.out.println("합: " + sum);
		System.out.println("평균: " + (float)sum/ran.length);
		
		
	}

}
