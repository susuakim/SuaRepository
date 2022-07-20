package 객체지향프로그래밍;

import java.util.ArrayList;
import java.util.Scanner;

import javazoom.jl.player.MP3Player;

public class MusicMain {

	public static void main(String[] args) {
		
		int index = 0;
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<MusicVO> musicList = new ArrayList<MusicVO>();
		

		musicList.add(new MusicVO("2002","Anne Marie", 18, "C:/Users/smhrd/Desktop/새 폴더/music//Anne Marie - 2002.mp3" ));
		musicList.add(new MusicVO("bad guy","Billie Eilish", 19, "C:/Users/smhrd/Desktop/새 폴더/music//Billie Eilish - bad guy.mp3" ));
		
		
		MP3Player mp3 = new MP3Player();
		mp3.play(musicList.get(0).getPath());
		
		while(true) {
			System.out.print("[1]노래조회 [2]노래추가 [3]이전곡 [4]다음곡 [5]종료>> ");
			
			int menu = sc.nextInt();
			
			if(menu == 1) {
				playList(musicList);
			}else if(menu == 2) {
				playList(musicList);
				System.out.print("어떤 노래를 재생할까요?>> ");
				int input = sc.nextInt();
				index = input - 1;
				
				if(mp3.isPlaying()) {
					mp3.stop();
				}
				
				mp3.play(musicList.get(input-1).getPath());
				
				
			}else if(menu == 3) {
				
				
				
			}else if(menu == 4) {
				if(mp3.isPlaying()) {
					mp3.stop();
				}
				index++;
				if(index == musicList.size()) {
					index = 0;
				}
				mp3.play(musicList.get(index).getPath());
				
			}else { if(menu == 5) {
				System.out.println("종료 되었습니다.");
				break;
				
			}else {
				System.out.println("잘못 입력하셨습니다.");
			}
			
			
		}
		
		
		
		
	}

	}

	private static void playList(ArrayList<MusicVO> musicList) {
		for(int i=0; i<musicList.size(); i++) {
			System.out.print((i+1) + ".");
			musicList.get(i).show();
		}
	}
}
