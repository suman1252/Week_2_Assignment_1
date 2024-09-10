/***
 * Suman Kumari
 * 09-09-2024
 * Java program that finds whether a given number can be expressed as the sum of two or
more consecutive natural numbers. 
 *  Finds and prints all sets of two or more consecutive natural numbers that sum up to the given number.
 *  printConsecutiveNumbers: Prints a sequence of consecutive natural numbers starting from k.   
 */

package Week_2_Assignment_1;
import java.util.Scanner;
public class ConsecutiveNumber {	
    static Scanner sc = new Scanner(System.in);
    static int n;  //variable to hold user input number
    public static void main(String[] args) {      
        while (true) {
            System.out.print(Constant.ENTER_NUMBER);
            if (!sc.hasNextInt()) {
                System.out.println(Constant.INVALID_INTEGERS);
                sc.nextLine();
                continue;
            }
            n = sc.nextInt();
            if (n <= 0) {
                System.out.println(Constant.INVALID_INTEGERS);
            } else {
                System.out.println(Constant.CONSECUTIVE_NUMBER + n + ":");                
                ConsecutiveSum(n);
            }
        }
    }    
    public static void ConsecutiveSum(int n) {
        for (int i = 2; i < n; i++) {
            int k = (n - (i * (i - 1)) / 2) / i;
            if (k > 0 && (n - (i * (i - 1)) / 2) % i == 0) {
                printConsecutiveNumbers(k, i); 
            }
        }
    }  
    public static void printConsecutiveNumbers(int k, int i) {
        System.out.print(Constant.START_FROM);
        for (int j = 0; j < i; j++) {
            System.out.print((k + j) + " + ");
        }
        System.out.println(); 
    }
}