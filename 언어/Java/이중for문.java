package for¹®;

public class ex05_ÀÌÁßfor¹® {

	public static void main(String[] args) {
		
		for(int i =2; i<=9; i++) {
			System.out.print(i + "´Ü : " + " ");
			for(int j =1; j<=9; j++) {
				System.out.print(i + "*" + j + "=" + i*j + "\t");
			}
			System.out.println();
		}

	}

}

