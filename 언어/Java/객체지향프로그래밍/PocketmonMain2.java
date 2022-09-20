package 객체지향프로그래밍;

import java.util.ArrayList;

public class PocketmonMain2 {

	public static void main(String[] args) {
		
		ArrayList<Pocketmon> bags = new ArrayList<Pocketmon>();
		
		bags.add(new Pocketmon("피카츄","전기", 1, 50, 50, 100));
		bags.add(new Pocketmon("라이츄","전기", 1, 100, 100, 200));
		bags.add(new Pocketmon("파이리","불", 1, 70, 70, 50));
		bags.add(new Pocketmon("꼬부기","물", 1, 60, 60, 80));
		bags.add(new Pocketmon("버터풀","풀", 1, 80, 70, 120));
		bags.add(new Pocketmon("야도란","물", 1, 40, 80, 100));
		
		for(int i=0; i<bags.size(); i++) {
			System.out.println(bags.get(i).getName());
		}
		
	}

}
