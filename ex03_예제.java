package �ݺ���while;

import java.util.Scanner;

public class ex03_���� {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int c = 0;
//		while(true) {
//			System.out.println("���ڸ� �Է��ϼ���: ");
//			int a = sc.nextInt();
//			if(a<100) {
//				sum += a;
//				++c;
//			}else break;
//			
//			
//		}
		
		int a = 0;
		
		int sum = 0;
		while(0<=a && a<=100) {
			System.out.println("����:   ");
			a=sc.nextInt();
			sum = sum + a;
			c++;
		}
		
		
		System.out.println("cc: " + c);
		System.out.println("�հ�: " + sum);
		System.out.println("���: " + (float)(sum/c) );

	}

}
