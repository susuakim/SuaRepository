package ��ü�������α׷���;

public class Person {

	//������ ĳ���� �����
	//class(���赵)-> ���踸 �ϴ� ���̶� �ڵ带 �����ϴ� main�޼ҵ� �ʿ� ����.
	
	String name;
	int age;
	String gender;
	
	//����� �� �� �ִ� ���
	
	//Person() ������ �޼ҵ� �����
	//������: ��ü�� �����Ǵ� ������ �ڵ����� ȣ��Ǵ� �޼ҵ�, ������ ���ÿ� �ʵ忡 ���� ���� ����, 
	
	public Person(String name, int age, String gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	//�⺻������, default ������
	public Person() {
		
	}
	
	public void eat() {
		System.out.println("������ �ȳ�");
	}
	
	public void sleep() {
		System.out.println("���� ����");
	}
	
	public void play() {
		System.out.println("���� ����");
	}

}
