package ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class MusicPlayList {

	public static void main(String[] args) {
		
		System.out.println("===Music Play===");
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<String> musiclist = new ArrayList<String>();
		
		while(true) {

			System.out.print("[1] �뷡�߰� [2]�뷡 ��ȸ [3]�뷡 ���� [4]����>> ");
			int num = sc.nextInt();
			
			//1�� �뷡�߰� =====================================================================
			if(num==1) {
				System.out.print("[1]���ϴ� ��ġ�� �߰� [2]������ ��ġ�� �߰�>> ");
				int num_1_1 = sc.nextInt();
				
				
				String song_a;
				
				System.out.print("�߰��� �뷡 �Է�>> ");
				song_a = sc.next();
					
				System.out.println();
				System.out.println("==============���� ��� ���==============");
				for(int i =0; i<musiclist.size(); i++) {
					System.out.println(i+1 + ". " + musiclist.get(i));
				}
				System.out.println();
				
				if(num_1_1==1) {
					System.out.print("�߰��� ��ġ �Է�>> ");
					int num_2 = sc.nextInt();
					musiclist.add(num_2, song_a);
					
				}else{musiclist.add(song_a);}
				
				for(int i =0; i<musiclist.size(); i++) {
					System.out.println(i+1 + ". " + musiclist.get(i) + " ");
				}
				System.out.println();
				System.out.print("�߰��� �Ϸ�Ǿ����ϴ�.");
				
				System.out.println();
					
				//2�� �뷡��ȸ =====================================================================
				if(num==2) {
					System.out.println("==============���� ��� ���==============");
					for(int i =0; i<musiclist.size(); i++) {
						System.out.println(i+1 + ". " + musiclist.get(i));
					}
				}
			}
				System.out.println();
				
				//3�� �뷡���� =====================================================================
				if(num==3) {
					System.out.print("[1]���û��� [2]��ü����");
					int num_3_1 = sc.nextInt();
					
					if(num_3_1==1) {
						System.out.print("������ ��ġ �Է�>> ");
						int num_3 = sc.nextInt();
						musiclist.remove(num_3);
						
					}else {musiclist.clear(); System.out.println("�������� �����ϴ�.");}
					
				}
				
				System.out.println();
				
				//4�� ���� =====================================================================
				if(num==4) {
					System.out.println("���� �÷��̸���Ʈ�� �����մϴ�.");
					break;
				}
				
	
				
			}
		}
		
	}


