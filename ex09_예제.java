package if��;

import java.util.Scanner;

public class ex09_���� {

	public static void main(String[] args) {
		
		System.out.print("�� �Է�:  ");
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		
		switch(a) {
		case 12:
		case 1:
		case 2:
			System.out.println(a + "���� �ܿ��Դϴ�!");
			break; 
			
		case 3:
		case 4:
		case 5:
			System.out.println(a + "���� ���Դϴ�!");
		 	break;
		 	
		case 6:
		case 7:
		case 8:
			System.out.println(a + "���� �����Դϴ�!");
			break;		
			
		case 9:
		case 10:
		case 11:
			System.out.println(a + "���� �����Դϴ�!");
	 		break;
			}
		}
	}


