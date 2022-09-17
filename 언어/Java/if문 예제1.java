package 실습;

import java.io.*;
import java.util.Scanner;

public class ex08_예제 {
	public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("숫자 입력: ");
        int num = sc.nextInt();
        
        int num_c;
        
        if(num>=100){
            num_c = num - (num/10)*10;
            System.out.println("반올림숫자??" + num_c);
            if(num_c>5){
                num = num + (10-num_c); System.out.print("수: " + num);
            }else num -= num_c;
            
            System.out.print("반올림 수: " + num);
        }else System.out.println("100이상의 자리를 입력해주세요.");
        
        
        

	}
}
