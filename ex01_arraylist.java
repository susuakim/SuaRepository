package ArratList;

import java.util.ArrayList;

public class ex01_arraylist {

	public static void main(String[] args) {
		
		int[] arr = new int[5];
		//Arraylist�� import �ؾ���
		//ArrayList<������Ÿ��> ������ = new ArrayList
		//������Ÿ���� ��üŸ������ �����ؾ���, int���� ��üŸ���� Integer
		ArrayList<Integer> arrlist = new ArrayList<Integer>();
		
		System.out.println(arr.length);
		System.out.println(arrlist.size());
		
		arr[0] = 0;
		arr[1] = 1;
		
		
		arrlist.add(0);
		arrlist.add(1);
		arrlist.add(2);
		arrlist.add(3);
		System.out.println();
		
		System.out.println(arrlist.size());
		System.out.println(arrlist.get(0));
		
		for(int i =0; i<arrlist.size(); i++) {
			System.out.println(arrlist.get(i));
		}
		
		
		
	}
	

}
