package if��;

import java.util.Scanner;

public class ex10_���� {

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
		case "����":
			if(game2.equals("����")) {
				System.out.println(name2 + " ��");
			}else if(game2.equals("��")) {
				System.out.println(name1 + " ��");
			}else System.out.println("���º�");
			break;
		
		case "����":
			if(game2.equals("����")) {
				System.out.println(name1 + " ��");
			}else if(game2.equals("��")) {
				System.out.println(name2 + " ��");
			}else System.out.println("���º�");
			break;
		
		case "��":
			if(game2.equals("����")) {
				System.out.println(name2 + " ��");
			}else if(game2.equals("����")) {
				System.out.println(name1 + " ��");
			}else System.out.println("���º�");
			break;
	
		}
	}
}
		
