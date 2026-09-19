import java.util.Scanner;

public class PalindromeChecker {

    public static boolean isPalindromeIterative(String text) {

        int left = 0;
        int right = text.length() - 1;

        while (left < right) {

            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static boolean isPalindromeRecursive(String text) {

        if (text.length() <= 1) {
            return true;
        }

        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }

        return isPalindromeRecursive(
                text.substring(1, text.length() - 1)
        );
    }

    public static boolean isPalindromeArrayReversal(String text) {

        char[] characters = text.toCharArray();

        int left = 0;
        int right = characters.length - 1;

        while (left < right) {

            char temporary = characters[left];
            characters[left] = characters[right];
            characters[right] = temporary;

            left++;
            right--;
        }

        String reversedText = new String(characters);

        return text.equals(reversedText);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String text = scanner.nextLine();

        boolean iterativeResult = isPalindromeIterative(text);
        boolean recursiveResult = isPalindromeRecursive(text);
        boolean arrayResult = isPalindromeArrayReversal(text);

        System.out.println();

        System.out.println("Iterative: "
                + (iterativeResult ? "Palindrome" : "Not Palindrome"));

        System.out.println("Recursive: "
                + (recursiveResult ? "Palindrome" : "Not Palindrome"));

        System.out.println("Array Reversal: "
                + (arrayResult ? "Palindrome" : "Not Palindrome"));

        scanner.close();
    }
}