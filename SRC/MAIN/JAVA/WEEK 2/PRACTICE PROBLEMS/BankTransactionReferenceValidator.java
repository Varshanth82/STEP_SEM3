import java.util.Scanner;

public class BankTransactionReferenceValidator {

    public static String normalizeReference(String raw) {

        String reference = raw.trim();

        if (reference.length() < 3) {
            return reference.toUpperCase();
        }

        String bankCode = reference.substring(0, 3).toUpperCase();
        String remainingPart = reference.substring(3);

        return bankCode + remainingPart;
    }

    public static String validateAndFormat(String reference) {

        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }

        String bankCode = reference.substring(0, 3);

        for (int index = 0; index < 3; index++) {

            if (!Character.isLetter(reference.charAt(index))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int index = 3; index < reference.length(); index++) {

            if (!Character.isDigit(reference.charAt(index))) {
                return "Invalid: body must contain only digits";
            }
        }

        String date = reference.substring(3, 9);
        String sequence = reference.substring(9, 14);

        String day = date.substring(0, 2);
        String month = date.substring(2, 4);
        String year = date.substring(4, 6);

        StringBuilder formattedResult = new StringBuilder();

        formattedResult.append("[");
        formattedResult.append(bankCode);
        formattedResult.append("] DATE: ");
        formattedResult.append(day);
        formattedResult.append("/");
        formattedResult.append(month);
        formattedResult.append("/");
        formattedResult.append(year);
        formattedResult.append(" | SEQ: ");
        formattedResult.append(sequence);

        return formattedResult.toString();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter transaction reference: ");
        String rawReference = scanner.nextLine();

        String normalizedReference =
                normalizeReference(rawReference);

        String result =
                validateAndFormat(normalizedReference);

        System.out.println(result);

        scanner.close();
    }
}