package �������迭;

public class ex02_���� {

	public static void main(String[] args) {
		
		//1~25���� 5�� 5�� array�� �ʱ�ȭ�ϱ�
		
		int[][] num = new int[5][5];
		int cnt = 1;//������ ���� ���Ԥ�
		
		for(int i = 0; i<num.length; i++) {
			for(int k = 0; k<num[i].length; k++) {
				num[k][i] = cnt++;
			}System.out.println();
		
		
		int result = 0;
		
//		for(int i = 0; i < num.length; i++) {
//			for(int k = 0; k < num[i].length; k++) {
//				result = result + 1;
//				num[k][i] = result;
////				System.out.print(num[i][k] + " ");
//			}System.out.println();
//		}
		
		for(int j = 0; j < num.length; j++) {
			for(int a = 0; a < num[j].length; a++) {
				System.out.print(num[j][a] + " ");
			}System.out.println();
		}
		
		
		}
		
	}
	
}


	


