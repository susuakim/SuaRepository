package �迭;

public class ex03_foreach�� {

	public static void main(String[] args) {
		
		//for each��: �ݺ��� �� �� �ִ� �迭, ArrayList ��� ����� ����
		//
		
//		for(����� ���� ����: �迭) {
//			���๮��;
//		}
//		
		int[] ar = {1,2,3};
		
		for(int i =0; i<ar.length; i++) {
			System.out.println(ar[i]);
		}
		
		System.out.println("for each ����Ͽ� ��� -------------------------");
		
		for(int i : ar) {
			System.out.println(i + " ");
		}
		
		
		
		
		
		
	}

}
