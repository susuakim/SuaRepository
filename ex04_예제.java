package if��;

import java.util.Scanner;

public class ex04_���� {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("������ �Է��ϼ���:  ");
		
		int num = sc.nextInt();
		
		if(num%2 == 0) {
			System.out.println(num + " ¦���Դϴ�.");
		} else System.out.println(num + " Ȧ���Դϴ�.");

	}
	
	//���࿡ num�� 2�� ��������� �������� 0�� ���ٸ� ���ǽ� ©==����
	//���� �ʴٸ� else Ȧ�� ���๮��___sc.nextInt();
	
	else {
		System.out.println();
		System.out.println();System.out.println("ex04_����.enclosing_method()");
	}

}
