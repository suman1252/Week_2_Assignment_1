/***
 * Suman Kumari 
 * 09-09-2024
 * Java program that continuously takes a number as input 
 * and replaces it with the sum of its digits until 
 * the number is reduced to a single digit.
 */

package Week_2_Assignment_1;

import java.util.Scanner;

public class DigitSum {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
        	System.out.print(Constant.ENTER_NUMBER);
            int n = sc.nextInt();
            
            int result = calculateDigitSum(n);
            if(n < 0) {
	        	System.out.println("Invalid Number");
	        }
			else {
            System.out.println(Constant.SUM_OF_DIGIT+ result);
			}
        }
    }
    
    public static int calculateDigitSum(int n) {
        int sum = 0;
        
        while (n > 0 || sum > 9) {
            if (n == 0) {
                n = sum;
                sum = 0;
            }
            sum += n % 10; 
            n /= 10;
        }
        return sum; 
    }
}