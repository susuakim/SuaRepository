package if��;

import java.util.Scanner;

public class ex02_���� {

	public static void main(String[] args) {
		
		System.out.print("���� �Է�:  ");
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		if(num%3==0 && num%5==0) {
			System.out.println("3�� 5�� ����Դϴ�.");
		}
		
	}

}
