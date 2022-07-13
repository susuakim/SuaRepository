package 반복문while;

import java.util.Random;

public class ex05_예제 {

	public static void main(String[] args) {
		Random r = new Random();
		
		int num = r.nextInt(20)+1;// 0~19까지의 랜덤수를 뽑아낸다,,
//		r.nextInt(20)+1;//0~20까지의 랜덤수를 뽑아낸다,,
		System.out.println(num);
		
	}

}
