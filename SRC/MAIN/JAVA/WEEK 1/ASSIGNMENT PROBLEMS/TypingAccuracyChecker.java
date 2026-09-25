import java.util.Scanner;

public class TypingAccuracyChecker {

    public static void checkTypingAccuracy(
            String original, String typed) {

        int matchedCharacters = 0;
        int firstMismatchPosition = -1;

        for (int index = 0; index < original.length(); index++) {

            if (original.charAt(index) == typed.charAt(index)) {
                matchedCharacters++;
            } else if (firstMismatchPosition == -1) {
                firstMismatchPosition = index;
            }
        }

        double accuracy =
                (matchedCharacters * 100.0) / original.length();

        System.out.printf(
                "Matched: %d/%d | Accuracy: %.2f%%",
                matchedCharacters,
                original.length(),
                accuracy
        );

        if (firstMismatchPosition == -1) {

            System.out.println(" | No Mismatches");

        } else {

            char originalCharacter =
                    original.charAt(firstMismatchPosition);

            char typedCharacter =
                    typed.charAt(firstMismatchPosition);

            System.out.println(
                    " | First Mismatch at position "
                    + (firstMismatchPosition + 1)
                    + " ('" + originalCharacter
                    + "' vs '" + typedCharacter + "')"
            );
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter original passage: ");
        String original = scanner.nextLine();

        System.out.print("Enter typed passage: ");
        String typed = scanner.nextLine();

        if (original.length() != typed.length()) {

            System.out.println(
                    "Error: Both strings must have equal length."
            );

        } else {

            checkTypingAccuracy(original, typed);
        }

        scanner.close();
    }
}
