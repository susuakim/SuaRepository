package ����;

import java.util.Random;
import java.util.Scanner;

public class View {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int cnt = 0;
		int right = 0;
		
		while(cnt<5) {
			
			PlusGame game1 = new PlusGame();
			MinusGame game2 = new MinusGame();
			
			Game[] games = {game1, game2};
			
			int random = new Random().nextInt(2);
			
			String quiz = games[random].setQuiz();
			cnt++;
			
			for(int i=0; i<3; i++) {
				System.out.println(quiz);
				int input = sc.nextInt();
			
				if((games[random].isCorrect(input))) {
				System.out.println("�����Դϴ�!!");
				right++;
				break;
				
				}else {
				System.out.println("Ʋ�Ƚ��ϴ٤Ф�");

					
				}
			}
			
		}
		
		System.out.println("����Ǿ����ϴ�");
		System.out.println("���� ����: " + right);
		System.out.println("���� ����: " + (5-right));
		
	}
	
	
}
