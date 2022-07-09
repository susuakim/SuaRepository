package if¹®;

import java.util.Scanner;

public class ex10_¿¹Á¦ {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("user1: ");
		String name1 = sc.next();
		
		System.out.print("user2: ");
		String name2 = sc.next();
		
		System.out.print(name1 + ">>");
		String game1 = sc.next();
				
		System.out.print(name2 + ">>");
		String game2 = sc.next();
		
		switch(game1) {
		case "°¡À§":
			if(game2.equals("¹ÙÀ§")) {
				System.out.println(name2 + " ½Â");
			}else if(game2.equals("º¸")) {
				System.out.println(name1 + " ½Â");
			}else System.out.println("¹«½ÂºÎ");
			break;
		
		case "¹ÙÀ§":
			if(game2.equals("°¡À§")) {
				System.out.println(name1 + " ½Â");
			}else if(game2.equals("º¸")) {
				System.out.println(name2 + " ½Â");
			}else System.out.println("¹«½ÂºÎ");
			break;
		
		case "º¸":
			if(game2.equals("°¡À§")) {
				System.out.println(name2 + " ½Â");
			}else if(game2.equals("¹ÙÀ§")) {
				System.out.println(name1 + " ½Â");
			}else System.out.println("¹«½ÂºÎ");
			break;
	
		}
	}
}
		
