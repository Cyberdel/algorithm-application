
public class Complexity {

    public static void main(String[] args) {

        int[] sizes = {10, 100, 1000, 10000};

        System.out.println("\n===== COMPLEXITY ANALYSIS =====");

        for (int size : sizes) {

            System.out.println("\n================================");
            System.out.println("INPUT SIZE: " + size);
            System.out.println("================================");

            int[] data = new int[size];

            for (int i = 0; i < size; i++) {
                data[i] = i + 1;
            }

            // Algorithm A: Linear Complexity O(n)
            System.out.println("\n--- ALGORITHM A: O(n) ---");

            long sum = 0;
            long operations = 0;

            for (int value : data) {
                sum += value;
                operations++;

                if (size <= 10) {
                    System.out.println(
                            "Adding " + value + " | Current Sum: " + sum
                    );
                }
            }

            System.out.println("Final Sum: " + sum);
            System.out.println("Total Operations: " + operations);
            System.out.println("Theoretical Complexity: O(n)");

            // Algorithm B: Quadratic Complexity O(n^2)
            System.out.println("\n--- ALGORITHM B: O(n^2) ---");

            long comparisons = 0;

            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    comparisons++;

                    if (size <= 10) {
                        System.out.println(
                                "Comparing " + data[i] + " and " + data[j]
                        );
                    }
                }
            }

            System.out.println("Total Comparisons: " + comparisons);
            System.out.println("Theoretical Complexity: O(n^2)");

            // Algorithm C: Logarithmic Complexity O(log n)
            System.out.println("\n--- ALGORITHM C: O(log n) ---");

            int number = size;
            long divisions = 0;

            while (number > 1) {
                System.out.println(
                        "Current Number: " + number +
                                " | Dividing by 2"
                );

                number /= 2;
                divisions++;
            }

            System.out.println("Final Number: " + number);
            System.out.println("Total Divisions: " + divisions);
            System.out.println("Theoretical Complexity: O(log n)");
        }
    }
}
