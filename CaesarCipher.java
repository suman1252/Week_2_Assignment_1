/***
 * Suman Kumari
 * 09-09-2024
 * program that implements the Caesar Cipher encryption technique
but with a twist. If the pattern array length is shorter than the input string, 
repeat the pattern.
 * isValidPattern: Validates the input pattern.
 */

package Week_2_Assignment_1;
import java.util.Scanner;
public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(Constant.ENTER_STRING);
            String input = scanner.nextLine();

            if (!isValidInput(input)) {
                System.out.println(Constant.INVALID_STRING);
                continue; 
            }
            System.out.print(Constant.ENTER_PATTERN);
            String patternInput = scanner.nextLine();
            if (!isValidPattern(patternInput)) {
                System.out.println("Enter a valid pattern.");
                continue;
            }
            String[] patternArray = patternInput.split(",");
            int[] shiftPattern = new int[patternArray.length];

            for (int i = 0; i < patternArray.length; i++) {
                shiftPattern[i] = Integer.parseInt(patternArray[i].trim());
            }
            
            String encryptedString = encrypt(input, shiftPattern);
            System.out.println(Constant.ENCRYPTED_STRING + encryptedString);
        }
    }

    private static String encrypt(String input, int[] shiftPattern) {
        StringBuilder encrypted = new StringBuilder();
        int patternLength = shiftPattern.length;
        int patternIndex = 0; 
        
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (Character.isLetter(currentChar)) {
                int shift = shiftPattern[patternIndex % patternLength];
                patternIndex++; 
                
                if (Character.isUpperCase(currentChar)) {
                    char encryptedChar = (char) ((currentChar - 'A' + shift) % 26 + 'A');
                    encrypted.append(encryptedChar);
                } else {
                    char encryptedChar = (char) ((currentChar - 'a' + shift) % 26 + 'a');
                    encrypted.append(encryptedChar);
                }
            } else {
                encrypted.append(currentChar);
            }
        }
        return encrypted.toString();
    }

    private static boolean isValidInput(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                return false; 
            }
        }
        return true; 
    }

    private static boolean isValidPattern(String patternInput) {
        String[] patterns = patternInput.split(",");
        for (String pattern : patterns) {
            try {
                Integer.parseInt(pattern.trim()); 
            } catch (NumberFormatException e) {
                return false; 
            }
        }
        return true; 
    }
}
