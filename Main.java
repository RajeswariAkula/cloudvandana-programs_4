import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Accept array values from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        Integer[] numbers = new Integer[n];
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        // Shuffle the array
        Collections.shuffle(Arrays.asList(numbers));
        System.out.println("Shuffled Array: " + Arrays.toString(numbers));

        // Accept a Roman number as input
        System.out.print("Enter a Roman numeral: ");
        scanner.nextLine(); // Consume the newline character left by nextInt
        String romanNumeral = scanner.nextLine();
        int intValue = romanToInteger(romanNumeral);
        System.out.println("Integer value: " + intValue);

        // Check if the input is a pangram
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();
        boolean isPangram = isPangram(sentence.toLowerCase());
        if (isPangram) {
            System.out.println("The sentence is a pangram.");
        } else {
            System.out.println("The sentence is not a pangram.");
        }

        scanner.close();
    }

    public static int romanToInteger(String s) {
        // Define the values of Roman numerals
        int[] values = {1, 5, 10, 50, 100, 500, 1000};
        String[] symbols = {"I", "V", "X", "L", "C", "D", "M"};

        int result = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int index = Arrays.asList(symbols).indexOf(String.valueOf(c));
            int value = values[index];

            if (value < prevValue) {
                result -= value;
            } else {
                result += value;
            }

            prevValue = value;
        }

        return result;
    }

    public static boolean isPangram(String sentence) {
        // Define an array to check for each alphabet
        boolean[] isAlphabetPresent = new boolean[26];

        // Mark each alphabet as not present
        for (int i = 0; i < 26; i++) {
            isAlphabetPresent[i] = false;
        }

        int index;

        // Traverse the sentence and mark the alphabets that are present
        for (int i = 0; i < sentence.length(); i++) {
            char character = sentence.charAt(i);
            if (character >= 'a' && character <= 'z') {
                index = character - 'a';
                isAlphabetPresent[index] = true;
            }
        }

        // Check if any alphabet is not marked as present
        for (int i = 0; i < 26; i++) {
            if (!isAlphabetPresent[i]) {
                return false;
            }
        }

        return true;
    }
}
