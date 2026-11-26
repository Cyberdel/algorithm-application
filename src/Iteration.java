
public class Iteration {

    public static long factorial(int number) {
        if (number < 0 || number > 20) {
            throw new IllegalArgumentException("Number must be between 0 and 20.");
        }

        long result = 1;

        System.out.println("\nFACTORIAL ITERATION:");

        for (int i = 1; i <= number; i++) {
            result *= i;
            System.out.println("Step " + i + ": " + result);
        }

        System.out.println("Final Result: " + result);
        return result;
    }

    public static long sumArray(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }

        long sum = 0;

        System.out.println("\nARRAY SUM ITERATION:");

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            System.out.println(
                    "Index " + i + ": Added " + array[i] +
                            " | Current Sum: " + sum
            );
        }

        System.out.println("Final Sum: " + sum);
        return sum;
    }

    public static int findMaximum(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }

        int maximum = array[0];

        System.out.println("\nMAXIMUM VALUE ITERATION:");
        System.out.println("Initial Maximum: " + maximum);

        for (int i = 1; i < array.length; i++) {
            System.out.println(
                    "Comparing " + array[i] + " with " + maximum
            );

            if (array[i] > maximum) {
                maximum = array[i];
                System.out.println("New Maximum: " + maximum);
            }
        }

        System.out.println("Final Maximum: " + maximum);
        return maximum;
    }
}
