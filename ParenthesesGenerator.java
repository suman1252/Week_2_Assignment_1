/***
 * Suman Kumari
 * 09-09-2024
 * Java program that generates all valid combinations of the string pairs of
parentheses. 
 * isValidKnput: Validates the input string to ensure it contains only letters and is not empty.
 */

package Week_2_Assignment_1;
import java.util.Scanner;
public class ParenthesesGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(Constant.ENTER_STRING);
            String input = scanner.nextLine().trim(); 
            if (input.isEmpty() || input.matches("\\s+")) {
                System.out.println(Constant.EMPTY_STRING);
                continue; 
            }
            int maxCombinations = (1 << input.length()) - 1;
            String[] combinations = new String[maxCombinations];
            int index = 0;
            for (int i = 1; i <= maxCombinations; i++) {
                StringBuilder combination = new StringBuilder();
                for (int j = 0; j < input.length(); j++) {
                    if ((i & (1 << j)) > 0) {
                        combination.append(input.charAt(j)); 
                    }
                }
                combinations[index++] = combination.toString(); 
            } 
            System.out.print(Constant.OUTPUT + "[");
            for (int i = 0; i < combinations.length; i++) {
                if (combinations[i] != null) {
                    System.out.print("\"" + combinations[i] + "\"");
                    if (i < combinations.length - 1 && combinations[i + 1] != null) {
                        System.out.print(", ");
                    }
                }
            }
            System.out.println("]");
        }
    }
    private static boolean isValidInput(String input) {
        if (input.isEmpty() || input.matches("\\s+")) {
            return false; 
        }
        for (char character : input.toCharArray()) {
            if (!Character.isLetter(character)) {
                return false; 
            }
        }
        return true;
    }
}