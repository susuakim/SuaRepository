package ��ü�������α׷���;
public class Pocketmon {
	
	// ���� ���ڻ�
	// ���ϸ��� �����ϱ� ���� ���ϸ� ����
	// ���ϸ��� �Ӽ� : �̸�, ���� Ÿ��, ����, ���ݷ�, ����, ü��
	private String name;
	private String type;
	private int level;
	private int attack_power;
	private int defense_power;
	private int hp;
	
	// ������
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
	
	
	// ���ϸ��� ��� : �����ϱ�, ����ϱ�, ���ϸ� ���� ���
	public void attack() {
		System.out.println(name+"�� ����~!");
	}
	
	public void defense() {
		System.out.println("����~!" +name+"�� ����!");
	}
	
	public void show() {
		System.out.print("�̸� : "+name+" ");
		System.out.print("�Ӽ� : "+type+" ");
		System.out.print("���� : "+level+" ");
		System.out.print("���ݷ� : "+attack_power+" ");
		System.out.print("���� : "+defense_power+" ");
		System.out.print("ü�� : "+hp+" ");
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