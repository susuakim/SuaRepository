package �ݺ���;

import java.util.Random;
import java.util.Scanner;

public class ex01_�߱����� {

	public static void main(String[] args) {
		
		Random r =new Random();
		
		int num1;
		int num2;
		int num3;
		
		while(true) {
			
		
			num1 = r.nextInt(10)+1;
			num2 = r.nextInt(10)+1;
			num3 = r.nextInt(10)+1;
			
			
			if(num1 != num2 && num1 != num3 || num2 != num3) {
				System.out.println(num1 + " " + num2 + " " + num3);
				break;
			
			}
		}
		
		Scanner sc = new Scanner(System.in);
		
		int cnt_s = 0;
		int cnt_b = 0;
		int cnt_o = 0;
		
		while(true) {
			
			
//			1��° ����--------------------------------------------------------------
			System.out.print("1��° ���� �Է�: ");
			
			int num_in1 = sc.nextInt();
			
			if(num_in1 == num1) {
				System.out.println("Strike");
				cnt_s++;
			}else if(num_in1 == num2 || num_in1 == num3) {
				System.out.println("Ball");
				cnt_b++;
			}else {System.out.println("out"); cnt_o++;}
			
//			2��° ����--------------------------------------------------------------
			System.out.print("2��° ���� �Է�: ");
			
			int num_in2 = sc.nextInt();
			
			if(num_in2 == num2) {
				System.out.println("Strike");
				cnt_s++;
			}else if(num_in2 == num1 || num_in2 == num3) {
				System.out.println("Ball");
				cnt_b++;
			}else {System.out.println("out"); cnt_o++;}
			
//			3��° ����--------------------------------------------------------------
			System.out.print("3��° ���� �Է�: ");
			
			int num_in3 = sc.nextInt();
			
			if(num_in3 == num3) {
				System.out.println("Strike");
				cnt_s++;
			}else if(num_in3 == num1 || num_in3 == num2) {
				System.out.println("Ball");
				cnt_b++;
			}else {System.out.println("out"); cnt_o++;}
			
			
			System.out.print(cnt_s + "��Ʈ����ũ "+ cnt_b + "�� " + cnt_o + "�ƿ�");
			
			if(cnt_s == 3) {
				System.out.println("Ȩ��");
				break;
		}else {
			
			cnt_s = 0;
			cnt_b = 0;
			cnt_o = 0;
			}
			
			}
		
		
	}
}

