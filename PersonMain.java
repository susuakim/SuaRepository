package ��ü�������α׷���;

public class PersonMain {

	public static void main(String[] args) {
		// ����� ������ ���赵�� �ҷ��ͼ� ���� ��ü�� ������ ���� -> main �޼ҵ尡 ���̤�
		
		//1. ���赵 �ҷ�����
		//Ŭ���� ��ü�� = new Ŭ����();
		Person person = new Person();
		
//		System.out.println("����Ǳ��� : ");
//		System.out.println(person.name);
//		System.out.println(person.age);
//		System.out.println(person.gender);
//		
//		//�ν��Ͻ�ȭ = ���赵�� ������ͼ� ���� ��ü�� �����ϴ� ��
//		//��ü���� ��� �����
//		//�ʵ��� ���� ä���
//		
//		System.out.println();
		
//		person.name = "�����";
//		person.age = 26;
//		person.gender = "����";
//		
//		System.out.println("����ǰ� �� �� : ");
//		System.out.println(person.name);
//		System.out.println(person.age);
//		System.out.println(person.gender);
		
		//���赵�� �ִ� eat, sleep, play ����
//		person.eat();
//		person.play();
//		person.sleep();
//		
		
		Person person2 = new Person();
//		
//		System.out.println("����ǰ� �� �� : ");
//		person.name = "�輼��";
//		person.age = 24;
//		person.gender = "����";
//		
//		System.out.println(person.name);
//		System.out.println(person.age);
//		System.out.println(person.gender);
//		
		
		
		//������ �����
		Person person3 = new Person("�̸���", 20, "����");
		
		System.out.println(person3.name);
		System.out.println(person3.age);
		System.out.println(person3.gender);
		
		person3.eat();
		person3.play();
		person3.sleep();
		
		
		
	}

}
