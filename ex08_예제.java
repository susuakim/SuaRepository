package �ǽ�;

import java.io.*;
import java.util.Scanner;

public class ex08_���� {
	public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("���� �Է�: ");
        int num = sc.nextInt();
        
        int num_c;
        
        if(num>=100){
            num_c = num - (num/10)*10;
            System.out.println("�ݿø�����??" + num_c);
            if(num_c>5){
                num = num + (10-num_c); System.out.print("��: " + num);
            }else num -= num_c;
            
            System.out.print("�ݿø� ��: " + num);
        }else System.out.println("100�̻��� �ڸ��� �Է����ּ���.");
        
        
        

	}
}
