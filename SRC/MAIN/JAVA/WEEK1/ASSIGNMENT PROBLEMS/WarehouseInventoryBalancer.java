import java.util.Scanner;

public class WarehouseInventoryBalancer {

    public static void analyzeInventory(
            int[] sectionA, int[] sectionB) {

        int totalA = 0;
        int totalB = 0;

        for (int quantity : sectionA) {
            totalA += quantity;
        }

        for (int quantity : sectionB) {
            totalB += quantity;
        }

        boolean balanced = totalA == totalB;

        int highestQuantity = sectionA[0];
        String highestSection = "Section A";
        int highestIndex = 0;

        for (int index = 0; index < sectionA.length; index++) {

            if (sectionA[index] > highestQuantity) {
                highestQuantity = sectionA[index];
                highestSection = "Section A";
                highestIndex = index;
            }

            if (sectionB[index] > highestQuantity) {
                highestQuantity = sectionB[index];
                highestSection = "Section B";
                highestIndex = index;
            }
        }

        System.out.println("Section A Total: " + totalA);
        System.out.println("Section B Total: " + totalB);

        if (balanced) {
            System.out.println("Status: Balanced");
        } else {
            System.out.println("Status: Not Balanced");
        }

        System.out.println(
                "Highest Quantity: " + highestQuantity
                + " (" + highestSection
                + ", Item " + (highestIndex + 1) + ")"
        );
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int numberOfItems = scanner.nextInt();

        int[] sectionA = new int[numberOfItems];
        int[] sectionB = new int[numberOfItems];

        System.out.println("Enter quantities for Section A:");

        for (int index = 0; index < numberOfItems; index++) {
            System.out.print("Item " + (index + 1) + ": ");
            sectionA[index] = scanner.nextInt();
        }

        System.out.println("Enter quantities for Section B:");

        for (int index = 0; index < numberOfItems; index++) {
            System.out.print("Item " + (index + 1) + ": ");
            sectionB[index] = scanner.nextInt();
        }

        analyzeInventory(sectionA, sectionB);

        scanner.close();
    }
}