package �迭;

public class ex01_���� {

	public static void main(String[] args) {
		
		int[] ar = {1,2,9,4,5,10,7,8,3,6,20,0};
		
		//���ذ��� ����
		int max = ar[0];// �迭�ȿ� �ִ� ���ذ����� �����ؾ��Ѵ�.
		int min = ar[0];
		
		for(int i=0; i<ar.length; i++) {
			if(max<ar[i]) {
				max=ar[i];
			}
		}System.out.println("ū��: " + max);
		
		for(int j=0; j<ar.length; j++) {
			if(min>ar[j]) {
				min=ar[j];
			}
		}System.out.println("������: " + min);
		
		
		for(int k = 0; k<ar.length; k++) {
			
		}
		
	}

}
