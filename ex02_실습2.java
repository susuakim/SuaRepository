package 메소드;

public class ex02_실습2 {

	public static void main(String[] args) {
		
		int num1 = 2;
		int num2 = 2;
		int result = largerNumbers(num1, num2);
		System.out.print("큰수확인:  " + result);
	
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

