package ��ü�������α׷���;

import java.util.ArrayList;

public class PocketmonMain2 {

	public static void main(String[] args) {
		
		ArrayList<Pocketmon> bags = new ArrayList<Pocketmon>();
		
		bags.add(new Pocketmon("��ī��","����", 1, 50, 50, 100));
		bags.add(new Pocketmon("������","����", 1, 100, 100, 200));
		bags.add(new Pocketmon("���̸�","��", 1, 70, 70, 50));
		bags.add(new Pocketmon("���α�","��", 1, 60, 60, 80));
		bags.add(new Pocketmon("����Ǯ","Ǯ", 1, 80, 70, 120));
		bags.add(new Pocketmon("�ߵ���","��", 1, 40, 80, 100));
		
		for(int i=0; i<bags.size(); i++) {
			System.out.println(bags.get(i).getName());
		}
		
	}

}
