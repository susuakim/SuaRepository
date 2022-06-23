package °ÔÀÓ;

import java.util.Random;

public class PlusGame implements Game{
	
	int num1; int num2;
	
	
	public void makeRandom() {
		
		Random r = new Random();
		num1 = r.nextInt(9)+1;
		num2 = r.nextInt(9)+1;
		
		
	}
	
	
	public String setQuiz() {
		
		makeRandom();
		
		String result = String.format("%d + %d= ", num1, num2);
		
		return result;
		

	}
	
	public boolean isCorrect(int input) {
		
		if(input == num1+num2) {
			return true;
		}
		
		return false;
	}


	


}
