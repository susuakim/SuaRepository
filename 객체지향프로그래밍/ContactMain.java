package ��ü�������α׷���;

import java.util.ArrayList;

public class ContactMain {

	public static void main(String[] args) {
		
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		
		contacts.add(new Contact("�����", 25, "010101"));
	
		for(int i = 0; i<contacts.size(); i++) {
			String name = contacts.get(i).getName();
			int age = contacts.get(i).getAge();
			String tel = contacts.get(i).getTel();
			
			System.out.printf("%d, %s(%d��), %s%n", (i+1), name, age, tel );
		}
		
	}

}
