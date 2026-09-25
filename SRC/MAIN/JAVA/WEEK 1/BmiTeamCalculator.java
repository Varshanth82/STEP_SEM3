public class BmiTeamCalculator {

    public static String getBmiStatus(double bmi) {

        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void printWellnessReport(
            double[] heights, double[] weights) {

        System.out.printf("%-10s %-12s %-12s %-10s %-15s%n",
                "Person", "Height(m)", "Weight(kg)", "BMI", "Status");

        System.out.println(
                "------------------------------------------------------------");

        for (int index = 0; index < heights.length; index++) {

            double height = heights[index];
            double weight = weights[index];

            double bmi = weight / (height * height);

            String status = getBmiStatus(bmi);

            System.out.printf("%-10d %-12.2f %-12.2f %-10.2f %-15s%n",
                    index + 1,
                    height,
                    weight,
                    bmi,
                    status);
        }
    }

    public static void main(String[] args) {

        double[] heights = {
            1.75, 1.60, 1.80, 1.68, 1.72,
            1.65, 1.78, 1.70, 1.82, 1.58
        };

        double[] weights = {
            70, 90, 75, 80, 65,
            85, 95, 60, 88, 72
        };

        printWellnessReport(heights, weights);
    }
}