package ��ü�������α׷���;

public class PocketmonMain {
	
	public static void main(String[] args) {
		// ���ڻ��� ���赵�� ����ؼ� Ű��� ���� ���ϸ� �����
		
		// �⺻ ������ ����ؼ� ���ϸ� �����
		Pocketmon mon1 = new Pocketmon("��ī��", "����", 1,50,30,100);
		
		// ���赵�� ������ ���� ���ϸ� �����
		Pocketmon mon2 = new Pocketmon("���̸�", "��", 1, 70, 20, 90);
		
		//3��° ���ϸ� ������
		Pocketmon mon3 = new Pocketmon("���α�", "��", 1, 60, 40, 80);
		
		Pocketmon mon4 = new Pocketmon("�̻��ؾ�", "Ǯ", 1, 40, 60, 80);
		
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