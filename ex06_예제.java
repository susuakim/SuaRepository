package if문;

import java.util.Scanner;

public class ex06_예제 {

	public static void main(String[] args) {
		System.out.print("점수 입력:  ");
		
		Scanner sc = new Scanner(System.in);
		int totalScore = sc.nextInt();
		
		
		if(totalScore >= 90) {
			System.out.println("A학점입니다.");
		}else if(totalScore >= 80 && totalScore <= 89) {
			System.out.println("B학점입니다.");
		}else if(totalScore >= 70 && totalScore <= 79) {
			System.out.println("C학점입니다.");
		}else System.out.println("D학점입니다.");

	}
}
