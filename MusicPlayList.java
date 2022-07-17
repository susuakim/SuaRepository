package ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class MusicPlayList {

	public static void main(String[] args) {
		
		System.out.println("===Music Play===");
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<String> musiclist = new ArrayList<String>();
		
		while(true) {

			System.out.print("[1] 노래추가 [2]노래 조회 [3]노래 삭제 [4]종료>> ");
			int num = sc.nextInt();
			
			//1번 노래추가 =====================================================================
			if(num==1) {
				System.out.print("[1]원하는 위치에 추가 [2]마지막 위치에 추가>> ");
				int num_1_1 = sc.nextInt();
				
				
				String song_a;
				
				System.out.print("추가할 노래 입력>> ");
				song_a = sc.next();
					
				System.out.println();
				System.out.println("==============현재 재생 목록==============");
				for(int i =0; i<musiclist.size(); i++) {
					System.out.println(i+1 + ". " + musiclist.get(i));
				}
				System.out.println();
				
				if(num_1_1==1) {
					System.out.print("추가할 위치 입력>> ");
					int num_2 = sc.nextInt();
					musiclist.add(num_2, song_a);
					
				}else{musiclist.add(song_a);}
				
				for(int i =0; i<musiclist.size(); i++) {
					System.out.println(i+1 + ". " + musiclist.get(i) + " ");
				}
				System.out.println();
				System.out.print("추가가 완료되었습니다.");
				
				System.out.println();
					
				//2번 노래조회 =====================================================================
				if(num==2) {
					System.out.println("==============현재 재생 목록==============");
					for(int i =0; i<musiclist.size(); i++) {
						System.out.println(i+1 + ". " + musiclist.get(i));
					}
				}
			}
				System.out.println();
				
				//3번 노래삭제 =====================================================================
				if(num==3) {
					System.out.print("[1]선택삭제 [2]전체삭제");
					int num_3_1 = sc.nextInt();
					
					if(num_3_1==1) {
						System.out.print("삭제할 위치 입력>> ");
						int num_3 = sc.nextInt();
						musiclist.remove(num_3);
						
					}else {musiclist.clear(); System.out.println("재생목록이 없습니다.");}
					
				}
				
				System.out.println();
				
				//4번 종료 =====================================================================
				if(num==4) {
					System.out.println("뮤직 플레이리스트를 종료합니다.");
					break;
				}
				
	
				
			}
		}
		
	}


