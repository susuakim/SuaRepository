package for��;

public class ex02_���� {

	public static void main(String[] args) {
		
		int sum = 0;
		for(int i =1; i<=100; i++) {
			if(i*3>100) {
				break;
			}
			System.out.println(i*3 +" ");
			if(i%3==0) {
				sum += i;
		}
		System.out.println(sum);

	}
	}
}

