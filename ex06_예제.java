package if��;

import java.util.Scanner;

public class ex06_���� {

	public static void main(String[] args) {
		System.out.print("���� �Է�:  ");
		
		Scanner sc = new Scanner(System.in);
		int totalScore = sc.nextInt();
		
		
		if(totalScore >= 90) {
			System.out.println("A�����Դϴ�.");
		}else if(totalScore >= 80 && totalScore <= 89) {
			System.out.println("B�����Դϴ�.");
		}else if(totalScore >= 70 && totalScore <= 79) {
			System.out.println("C�����Դϴ�.");
		}else System.out.println("D�����Դϴ�.");

	}
}
