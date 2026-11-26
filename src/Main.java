
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n ALGORITHM ANALYSIS SYSTEM ");
            System.out.println("1. Complexity Analysis");
            System.out.println("2. Iterative Algorithms");
            System.out.println("3. Recursive Algorithms");
            System.out.println("4. Sorting Algorithms");
            System.out.println("5. Performance Benchmark");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Enter a number.");
                scanner.next();
                System.out.print("Select an option: ");
            }

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    Complexity.main(new String[0]);
                    break;

                case 2:
                    runIteration();
                    break;

                case 3:
                    runRecursion();
                    break;

                case 4:
                    runSorting();
                    break;

                case 5:
                    Benchmark.runBenchmarks();
                    break;

                case 0:
                    System.out.println("Program terminated.");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }

        } while (option != 0);

        scanner.close();
    }

    private static void runIteration() {
        int[] values = {8, 3, 10, 2, 7};

        System.out.println("\n ITERATIVE ALGORITHMS ");
        System.out.println("Factorial: " + Iteration.factorial(5));
        System.out.println("Array Sum: " + Iteration.sumArray(values));
        System.out.println("Maximum: " + Iteration.findMaximum(values));
    }

    private static void runRecursion() {
        int[] values = {8, 3, 10, 2, 7};

        System.out.println("\n  RECURSIVE ALGORITHMS ");
        System.out.println("Factorial: " + Recursion.factorial(5));
        System.out.println("Array Sum: " + Recursion.sumArray(values));
        System.out.println("Maximum: " + Recursion.findMaximum(values));
    }

    private static void runSorting() {
        int[] values = {45, 12, 90, 12, 3, 70, 45, 18};

        System.out.println("\n  SORTING ALGORITHMS ");
        System.out.println("Original Array: " + Arrays.toString(values));
        System.out.println("Bubble Sort: " +
                Arrays.toString(Sorting.bubbleSort(values)));
        System.out.println("Selection Sort: " +
                Arrays.toString(Sorting.selectionSort(values)));
        System.out.println("Insertion Sort: " +
                Arrays.toString(Sorting.insertionSort(values)));
        System.out.println("Shell Sort: " +
                Arrays.toString(Sorting.shellSort(values)));
    }
}
