package 이차원배열;

public class ex03_예제 {

	public static void main(String[] args) {
		
		int[][] arr = new int[5][5];
		int cnt = 20;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				arr[j][i] = ++cnt;
			}
		}
		
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[j][i] + " ");
			}System.out.println();
		}

	}

}
