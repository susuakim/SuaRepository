package ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class ex01_실습{

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<String> arrlist = new  ArrayList<String>();
		
		
		for(int i = 0; i < 5; i++) {
			System.out.print("이름을 입력하세요: ");
			String name = sc.next();
			arrlist.add(name);
		}
		
		for(int i = 0; i<arrlist.size(); i++) {
			System.out.print(arrlist.get(i) + " ");
		}
		
		System.out.println();
		
		System.out.print("삭제할 이름:  ");
		String name_d = sc.next();
		
		arrlist.remove(name_d);
		
		System.out.print("삭제 후 이름 출력: ");
		
		for(int i = 0; i<arrlist.size(); i++) {
			System.out.print(arrlist.get(i) + " ");
		}
		
	}

}
