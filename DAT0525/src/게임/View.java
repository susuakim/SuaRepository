package 게임;

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
				System.out.println("정답입니다!!");
				right++;
				break;
				
				}else {
				System.out.println("틀렸습니다ㅠㅠ");

					
				}
			}
			
		}
		
		System.out.println("종료되었습니다");
		System.out.println("정답 개수: " + right);
		System.out.println("오답 개수: " + (5-right));
		
	}
	
	
}
