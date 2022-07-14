package for문;

public class ex04_예제 {

	public static void main(String[] args) {

		for(int i = 1; i <=50; i++) {
			int num = i%10;
			if(num==3 || num==6 || num==9) {
				System.out.print("박수" + " ");
		}else if(num==5) {
			System.out.print("으악");
		}else System.out.println(i);

		}

	}
}
