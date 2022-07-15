package ¹è¿­;

public class ex05_¿¹Á¦ {

	public static void main(String[] args) {

		int[] num = {4,86,45,22,48,68,7};
		int cnt=0;
		
		for(int i=0; i<7; i++) {
			if(num[i]%2==1) {
				System.out.println("È¦¼ö´Â " + num[i]);
				cnt++;
			}
		}System.out.println("ÃÑ "+cnt);

	}

}
