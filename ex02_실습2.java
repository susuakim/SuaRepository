package �޼ҵ�;

public class ex02_�ǽ�2 {

	public static void main(String[] args) {
		
		int num1 = 2;
		int num2 = 2;
		int result = largerNumbers(num1, num2);
		System.out.print("ū��Ȯ��:  " + result);
	
	}
	
	public static int largerNumbers(int num1, int num2) {
		
		if(num1 > num2) {
			return num1;
		}else if(num1 < num2){
			return num2;
		}else return 0;
		
	}

}


int result = 0;
if(num1 == num2) {
	result = 0;
}else {
	result = num1 > num2 ? num1 : num2;
}

return result;

