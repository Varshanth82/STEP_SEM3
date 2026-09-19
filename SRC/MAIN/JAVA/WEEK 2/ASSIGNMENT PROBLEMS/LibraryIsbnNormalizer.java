import java.util.Scanner;

public class LibraryIsbnNormalizer {

    public static String normalizeCode(String raw) {

        String code = raw.trim();

        if (code.length() < 3) {
            return code.toUpperCase();
        }

        String publisherCode = code.substring(0, 3).toUpperCase();
        String remainingCode = code.substring(3);

        return publisherCode + remainingCode;
    }

    public static String validateAndFormat(String code) {

        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        for (int index = 0; index < 3; index++) {

            if (!Character.isLetter(code.charAt(index))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int index = 3; index < code.length(); index++) {

            if (!Character.isDigit(code.charAt(index))) {
                return "Invalid: body must contain only digits";
            }
        }

        String publisherCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        StringBuilder result = new StringBuilder();

        result.append("[");
        result.append(publisherCode);
        result.append("] YEAR: ");
        result.append(year);
        result.append(" | CATALOG: ");
        result.append(catalog);

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter ISBN-style code: ");
        String rawCode = scanner.nextLine();

        String normalizedCode = normalizeCode(rawCode);

        String result = validateAndFormat(normalizedCode);

        System.out.println(result);

        scanner.close();
    }
}