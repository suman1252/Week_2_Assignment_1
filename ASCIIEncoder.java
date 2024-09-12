package Week_2_Assignment_1;

import java.util.Scanner;

public class ASCIIEncoder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(Constant.DIGITS_OF_ARRAY);
            String inputArray = scanner.nextLine();
            
            // Validate the input array
            if (!isValidInput(inputArray)) {
                System.out.println("Invalid input! Please enter a valid sequence of integers.");
                continue;
            }

            int[] digitsArray = new int[inputArray.length()];
            for (int i = 0; i < inputArray.length(); i++) {
                digitsArray[i] = inputArray.charAt(i) - '0';
            }

            System.out.print(Constant.SERIES_OF_INTEGERS);
            String inputSeries = scanner.nextLine();

            // Validate the series input
            if (!isValidInput(inputSeries)) {
                System.out.println("Invalid input! Please enter a valid sequence of integers.");
                continue;
            }

            int[] series = new int[inputSeries.length()];
            for (int i = 0; i < inputSeries.length(); i++) {
                series[i] = inputSeries.charAt(i) - '0';
            }

            sortArrayDescending(digitsArray);

            StringBuilder encodedString = new StringBuilder();
            for (int i = 0; i < series.length; i++) {
                int index = series[i] - 1; // Subtract 1 to match 0-based index
                if (index < digitsArray.length && index >= 0) {
                    int highestDigit = digitsArray[index];
                    int asciiValue = highestDigit + '0';
                    encodedString.append(asciiValue);
                } else {
                    System.out.println("Invalid series input: " + series[i]);
                }
            }

            System.out.println(Constant.ENCODED + encodedString.toString());
        }
    }

    // Method to validate that the input string contains only digits
    private static boolean isValidInput(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
        return true;
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
