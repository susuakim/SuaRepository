package °ÔÀÓ;

import java.util.Random;

public class MinusGame implements Game {

	int num1, num2;
	
	@Override
	public void makeRandom() {
		num1=new Random().nextInt(10)+1;	
		num2=new Random().nextInt(10)+1;
}
	@Override
	public String setQuiz() {
		makeRandom();
		String result = String.format("%d - %d= ", num1, num2);
		return result;
	}

	@Override
	public boolean isCorrect(int input) {
		if(input == num1-num2) {
		return true;
	}
	return false;
	}

}
