package for��;

import java.util.Scanner;

public class ex05_���� {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�� �Է� >> ");
		int num1 = sc.nextInt();
		
		System.out.print("���� �Է� >> ");
		int num2 = sc.nextInt();
		
		
		for(int i=1; i<=num2; i++) {
			System.out.println(num1 + " * " + i + " = " + i*num1);
		}

		
	}

}
