package ¸Þ¼Òµå;

public class ex02_¿¹Á¦ {

	public static void main(String[] args) {
		
		int num1 = 50;
		int num2 = 15;
		char op = '*';
		
		System.out.println(cal(num1, num2, op));

	}
	
	public static int cal(int num1, int num2, char op) {
		
		switch(op) {
		case'+': return num1+num2;
		case'-': return num1-num2;
		case'*': return num1*num2;
		case'/': return num1/num2;
		}
		
		return 0;
	}

}
