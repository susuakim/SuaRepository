package 이차원배열;

public class ex02_예제 {

	public static void main(String[] args) {
		
		//1~25까지 5행 5열 array에 초기화하기
		
		int[][] num = new int[5][5];
		int cnt = 1;//대입할 값을 대입ㅂ
		
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


	


