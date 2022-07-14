package for문;

public class ex05_이중for문 {

	public static void main(String[] args) {
		
		for(int i =2; i<=9; i++) {
			System.out.print(i + "단 : " + " ");
			for(int j =1; j<=9; j++) {
				System.out.print(i + "*" + j + "=" + i*j + "\t");
			}
			System.out.println();
		}

	}

}

