package exception;

import java.util.Scanner;

public class ScannerClose {
	static Scanner sc;
	
	public static void main(String[] args) {
		
		while(true) {
			
			sc = new Scanner(System.in);
		
			System.out.print("´Þ·¯ ÀÔ·Â>> ");
			int input = sc.nextInt();
			
			if(input == -1) {
				break;
			}else {
				System.out.println(input*1200 + "¿øÀÔ´Ï´Ù.");
			}
		}
		
		System.out.println("ÇÁ·Î±×·¥ Á¾·á");
		
		if(sc != null) {			
			sc.close();
		}
		
		
		
//		String[] drink = {"µ¥ÀÚ¿Í", "¼ÖÀÇ´«", "ZICO", "¸ÆÄÝ", "¾ÆÄ§ÇÞ»ì"};
//		String[] snack = {"»Ñ¼Å»Ñ¼Åµþ±â¸À", "»ÇºüÀÌ", "¸Àµ¿»ê", "½Ò°úÀÚ", "°Ç»§"};
//		
//		System.out.println(drink[0]); //µ¥ÀÚ¿Í
//		System.out.println(snack[0]); //»Ñ»Ñµþ±â¸À
//		
//		snack = drink; //drink ÁÖ¼Ò°ªÀ» snack ÁÖ¼Ò°ªÀ» º¹»çÇØ¶ó
//		
//		System.out.println(drink[0]); //µ¥ÀÚ¿Í
//		System.out.println(snack[0]); //µ¥ÀÚ¿Í
//		
//		drink[0] = "±ôÂïÀÌ¼Ò´Ù";
//		System.out.println(drink[0]); //±ôÂïÀÌ¼Ò´Ù
//		System.out.println(snack[0]); //±ôÂïÀÌ¼Ò´Ù
		
	}

}
