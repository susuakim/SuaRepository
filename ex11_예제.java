package if��;

import java.util.Scanner;

public class ex11_���� {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�̸�1>> ");
		String name1 = sc.next();
		
		System.out.println("�̸�2>> ");
		String name2 = sc.next();
		
		
		System.out.println("����1>> ");
		String game1 = sc.next();
		
		System.out.println("����2>> ");
		String game2 = sc.next();
		
		if(game1.equals(game2)) {
			System.out.println("���º�!!");
		}
		
		else if(game1.equals("����")) {
			if(game2.equals("����")) {
				System.out.println(game2 + " ��!!");
			}
			else{
				System.out.println(game1 + " ��!!");
			}
			
		}
	}

}
