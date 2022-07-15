package 배열;

import java.io.*;
import java.util.Scanner;

public class ex03_예제 {
	public static void main(String args[]) {
    
        for(int i=1; i<=5; i++){
            for(int j=i-1; j<5; j++){
                System.out.print(" ");
            }
            for(int k=5; k<5-i; k++){
                System.out.print("*");
            }System.out.println();
        }

	}
}
