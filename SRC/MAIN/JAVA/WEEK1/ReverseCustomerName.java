import java.util.Scanner;

public class ReverseCustomerName {

    public static String reverseCustomerName(String customerName) {

        char[] characters = customerName.toCharArray();

        String reversedName = "";

        for (int index = characters.length - 1;
             index >= 0;
             index--) {

            reversedName += characters[index];
        }

        return reversedName;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();

        String reversedName = reverseCustomerName(customerName);

        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reversedName);

        scanner.close();
    }
}