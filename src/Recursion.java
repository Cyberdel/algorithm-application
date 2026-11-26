
public class Recursion {

    public static long factorial(int number) {
        if (number < 0 || number > 20) {
            throw new IllegalArgumentException("Number must be between 0 and 20.");
        }

        System.out.println("\nFACTORIAL RECURSION:");
        return factorialRecursive(number);
    }

    private static long factorialRecursive(int number) {
        System.out.println("Calling factorial(" + number + ")");

        if (number <= 1) {
            System.out.println("Base Case: factorial(" + number + ") = 1");
            return 1;
        }

        long result = number * factorialRecursive(number - 1);

        System.out.println(
                "Returning factorial(" + number + ") = " + result
        );

        return result;
    }

    public static long sumArray(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }

        System.out.println("\nARRAY SUM RECURSION:");
        return sumArrayRecursive(array, 0);
    }

    private static long sumArrayRecursive(int[] array, int index) {
        System.out.println("Processing index: " + index);

        if (index == array.length) {
            System.out.println("Base Case: returning 0");
            return 0;
        }

        long result = array[index] +
                sumArrayRecursive(array, index + 1);

        System.out.println(
                "Returning sum at index " + index + ": " + result
        );

        return result;
    }

    public static int findMaximum(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }

        System.out.println("\nMAXIMUM VALUE RECURSION:");
        return findMaximumRecursive(array, 0);
    }

    private static int findMaximumRecursive(int[] array, int index) {
        System.out.println("Processing index: " + index);

        if (index == array.length - 1) {
            System.out.println(
                    "Base Case: returning " + array[index]
            );
            return array[index];
        }

        int maximum = findMaximumRecursive(array, index + 1);

        int result = Math.max(array[index], maximum);

        System.out.println(
                "Comparing " + array[index] + " with " + maximum +
                        " | Returning: " + result
        );

        return result;
    }
}
