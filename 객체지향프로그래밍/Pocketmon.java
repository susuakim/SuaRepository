package 객체지향프로그래밍;
public class Pocketmon {
	
	// 나는 오박사
	// 포켓몬을 설계하기 위한 포켓몬 도감
	// 포켓몬의 속성 : 이름, 공격 타입, 레벨, 공격력, 방어력, 체력
	private String name;
	private String type;
	private int level;
	private int attack_power;
	private int defense_power;
	private int hp;
	
	// 생성자
	public Pocketmon(String name, String type, int level, int attack_power,
			int defense_power, int hp) {
		this.name = name;
		this.type = type;
		this.level = level;
		this.attack_power = attack_power;
		this.defense_power = defense_power;
		this.hp = hp;
	}
	
	public Pocketmon() {
		
	}
	
	
	// 포켓몬의 기능 : 공격하기, 방어하기, 포켓몬 정보 출력
	public void attack() {
		System.out.println(name+"의 공격~!");
	}
	
	public void defense() {
		System.out.println("쉴드~!" +name+"의 방어성공!");
	}
	
	public void show() {
		System.out.print("이름 : "+name+" ");
		System.out.print("속성 : "+type+" ");
		System.out.print("레벨 : "+level+" ");
		System.out.print("공격력 : "+attack_power+" ");
		System.out.print("방어력 : "+defense_power+" ");
		System.out.print("체력 : "+hp+" ");
		System.out.println();
	}
	
	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public int getLevel() {
		return level;
	}

	public int getAttack_power() {
		return attack_power;
	}

	public int getDefense_power() {
		return defense_power;
	}

	public int getHp() {
		return hp;
	}
	
	
	
	
}