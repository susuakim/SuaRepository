package if문;

import java.util.Scanner;

public class ex11_예제 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이름1>> ");
		String name1 = sc.next();
		
		System.out.println("이름2>> ");
		String name2 = sc.next();
		
		
		System.out.println("게임1>> ");
		String game1 = sc.next();
		
		System.out.println("게임2>> ");
		String game2 = sc.next();
		
		if(game1.equals(game2)) {
			System.out.println("무승부!!");
		}
		
		else if(game1.equals("가위")) {
			if(game2.equals("바위")) {
				System.out.println(game2 + " 승!!");
			}
			else{
				System.out.println(game1 + " 승!!");
			}
			
		}
	}

}
