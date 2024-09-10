/***
 * Suman Kumari
 * 09-09-2024
 * Java program that takes an unsorted array of digits and a series of integers. It encodes
the highest digits, based on the provided series, into their corresponding ASCII characters.
 * (isValidInput): Validates the input string to ensure it only contains digits.
 *parameter (inputArray): The string containing the digits entered by the user.
 */

package Week_2_Assignment_1;
import java.util.Scanner;
public class ASCIIEncoder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(Constant.DIGITS_OF_ARRAY);
            String inputArray = scanner.nextLine();
            if (!isValidInput(inputArray)) {
                System.out.println(Constant.INVALID_STRING);
                continue;
            }           
            int[] digitsArray = new int[inputArray.length()];
            
            for (int i = 0; i < inputArray.length(); i++) {
                digitsArray[i] = inputArray.charAt(i) - '0';
            }
            System.out.print(Constant.SERIES_OF_INTEGERS);
            String inputSeries = scanner.nextLine();
            int[] series = new int[inputSeries.length()];
            
            for (int i = 0; i < inputSeries.length(); i++) {
                series[i] = inputSeries.charAt(i) - '0';
            }
            sortArrayDescending(digitsArray);
            StringBuilder encodedString = new StringBuilder();
            
            for (int i = 0; i < series.length; i++) {
                int index = series[i] - 1; 
                if (index < digitsArray.length && index >= 0) {
                    int highestDigit = digitsArray[index];
                    int asciiValue = highestDigit + '0';
                    encodedString.append(asciiValue);
                } 
            }
            System.out.println(Constant.ENCODED + encodedString.toString());
        }
    }
    public static boolean isValidInput(String inputArray) {
		return false;
	}
	private static void sortArrayDescending(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
