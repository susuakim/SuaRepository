package ¹è¿­;

import java.util.Random;

public class ex04_¿¹Á¦ {

	public static void main(String[] args) {
		
		Random r = new Random();
		
		int[] ran = new int[10];
		
		int sum = 0;

		for(int i=0; i<10; i++) {
			ran[i]=r.nextInt(20)+1;
			System.out.println(ran[i]);
			sum += ran[i];
		}
		System.out.println("ÇÕ: " + sum);
		System.out.println("Æò±Õ: " + (float)sum/ran.length);
		
		
	}

}
