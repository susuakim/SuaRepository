package ��ü�������α׷���;

public class Student {
	
	private String name;
	private String birth;
	private int age;
	private int java;
	private int android;

	public Student(String name, String birth, int age, int java, int android) {
		this.name = name;
		this.birth = birth;
		this.age = age;
		this.java = java;
		this.android = android;
	}
	
	public Student() {
	
	}
	
	public void show() {
		System.out.println(name + "�ȳ��ϼ���");
		System.out.println(birth + "�⵵");
		System.out.println(age + "��");
		System.out.println(java + "�ڹ�����");
		System.out.println(android + "�ȵ���̵� ����");
	}
	
	//private�� �ɾ��⿡ ���� �ʵ忡 ����� �������� ���赵 ���ο��� ���� ����
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getJava() {
		return java;
	}

	public void setJava(int java) {
		this.java = java;
	}

	public int getAndroid() {
		return android;
	}

	public void setAndroid(int android) {
		this.android = android;
	}

}
