/***
 * Suman Kumari
 * 09-09-2024
 * Java program that finds whether a given number can be expressed as the sum of two or
more consecutive natural numbers. 
 */

package Week_2_Assignment_1;

import java.util.Scanner;

public class ConsecutiveNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print(Constant.ENTER_NUMBER);
			int n = sc.nextInt();
			if(n <= 0) {
	        	System.out.println("Invalid Number");
	        }
			else {
				System.out.println(Constant.CONSECUTIVE_NUMBER + n + ":");
				ConsecutiveSum(n);
			}
		}
	}
	public static void ConsecutiveSum(int n) {
		for(int i = 2; i < n; i++) {
			int k = (n - (i * (i - 1)) / 2) / i;
			if (k > 0 && (n - (i * (i-1)) / 2) % i == 0){
				printConsecutiveNumbers(k,i);
			}
		}
	}
    public static void printConsecutiveNumbers(int k, int i) {
        System.out.print(Constant.START_FROM + k + ": ");
        for (int j = 0; j < i; j++) {
            System.out.print((k + j) + " ");
        }
	     System.out.println();
    }
}
