package if문;

import java.util.Scanner;

public class ex10_예제 {

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
		case "가위":
			if(game2.equals("바위")) {
				System.out.println(name2 + " 승");
			}else if(game2.equals("보")) {
				System.out.println(name1 + " 승");
			}else System.out.println("무승부");
			break;
		
		case "바위":
			if(game2.equals("가위")) {
				System.out.println(name1 + " 승");
			}else if(game2.equals("보")) {
				System.out.println(name2 + " 승");
			}else System.out.println("무승부");
			break;
		
		case "보":
			if(game2.equals("가위")) {
				System.out.println(name2 + " 승");
			}else if(game2.equals("바위")) {
				System.out.println(name1 + " 승");
			}else System.out.println("무승부");
			break;
	
		}
	}
}
		
