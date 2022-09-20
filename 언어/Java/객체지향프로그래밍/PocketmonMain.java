package 객체지향프로그래밍;

public class PocketmonMain {
	
	public static void main(String[] args) {
		// 오박사의 설계도를 사용해서 키우고 싶은 포켓몬 만들기
		
		// 기본 생성자 사용해서 포켓몬 만들기
		Pocketmon mon1 = new Pocketmon("피카추", "전기", 1,50,30,100);
		
		// 설계도에 생성자 만들어서 포켓몬 만들기
		Pocketmon mon2 = new Pocketmon("파이리", "불", 1, 70, 20, 90);
		
		//3번째 포켓몬 만들자
		Pocketmon mon3 = new Pocketmon("꼬부기", "물", 1, 60, 40, 80);
		
		Pocketmon mon4 = new Pocketmon("이상해씨", "풀", 1, 40, 60, 80);
		
		mon1.show();
		mon2.show();
		mon3.show();
		mon4.show();
		
		System.out.println(mon1.getName());
		System.out.println(mon2.getName());
		System.out.println(mon3.getName());
		System.out.println(mon4.getName());
		
		
		Pocketmon[] monsters = new Pocketmon[4];
		monsters[1]=mon1;
		monsters[2]=mon2;
		monsters[3]=mon3;
		monsters[4]=mon4;
		
		for(int i=0; i<monsters.length; i++) {
			System.out.println(monsters[i].getType());
		}
		
		for(int i=0; i<monsters.length; i++) {
			monsters[i].show();
		}
		
		
		System.out.println(monsters[0].getType());
		
		
		
		
		
		
		
		
		
	
	}
}