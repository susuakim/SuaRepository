package ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class ex01_�ǽ�{

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<String> arrlist = new  ArrayList<String>();
		
		
		for(int i = 0; i < 5; i++) {
			System.out.print("�̸��� �Է��ϼ���: ");
			String name = sc.next();
			arrlist.add(name);
		}
		
		for(int i = 0; i<arrlist.size(); i++) {
			System.out.print(arrlist.get(i) + " ");
		}
		
		System.out.println();
		
		System.out.print("������ �̸�:  ");
		String name_d = sc.next();
		
		arrlist.remove(name_d);
		
		System.out.print("���� �� �̸� ���: ");
		
		for(int i = 0; i<arrlist.size(); i++) {
			System.out.print(arrlist.get(i) + " ");
		}
		
	}

}
