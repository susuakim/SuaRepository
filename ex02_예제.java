package �迭;

import java.util.Scanner;

public class ex02_���� {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] ar = new int[5];
		
		for(int i =0; i<ar.length; i++) {
			System.out.print((i+1) + "��° �Է�>> ");
			int num = sc.nextInt();
		
			ar[i]=num;

		}
		System.out.print("�Էµ� ����: ");
		
		int sum = 0;
		
		for(int j = 0; j<ar.length; j++) {
		System.out.print(ar[j] + " ");
		sum += ar[j];
		} 
		System.out.println();
		
		//����, �ְ�����, ����, ��� ���ϱ�------------------------
		int max = ar[0]; 
		int min = ar[0];
		
		for(int k =0; k<ar.length; k++) {
			if(max < ar[k]) {
				max = ar[k];
			}
			if(min > ar[k]) {
				min = ar[k];
			}
		}
		
		System.out.println("�ְ�����: " + max + "   " + "��������: " + min);
		System.out.print("����: " + sum + "   ");
		System.out.println("���: " + (float)sum/ar.length);
		
	}
	
}
