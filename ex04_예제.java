package for��;

public class ex04_���� {

	public static void main(String[] args) {

		for(int i = 1; i <=50; i++) {
			int num = i%10;
			if(num==3 || num==6 || num==9) {
				System.out.print("�ڼ�" + " ");
		}else if(num==5) {
			System.out.print("����");
		}else System.out.println(i);

		}

	}
}
