
import java.util.Arrays;

public class Sorting {

    public static int[] bubbleSort(int[] array) {
        int[] data = array.clone();

        System.out.println("\n===== BUBBLE SORT =====");
        System.out.println("Initial Array: " + Arrays.toString(data));

        for (int i = 0; i < data.length - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < data.length - 1 - i; j++) {
                System.out.println(
                        "Comparing " + data[j] + " and " + data[j + 1]
                );

                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    swapped = true;

                    System.out.println("Swapped: " + Arrays.toString(data));
                }
            }

            System.out.println("Pass " + (i + 1) + ": " + Arrays.toString(data));

            if (!swapped) break;
        }

        System.out.println("Final Array: " + Arrays.toString(data));
        return data;
    }

    public static int[] selectionSort(int[] array) {
        int[] data = array.clone();

        System.out.println("\n===== SELECTION SORT =====");
        System.out.println("Initial Array: " + Arrays.toString(data));

        for (int i = 0; i < data.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < data.length; j++) {
                System.out.println(
                        "Comparing " + data[j] + " with " + data[minIndex]
                );

                if (data[j] < data[minIndex]) {
                    minIndex = j;
                    System.out.println("New Minimum: " + data[minIndex]);
                }
            }

            if (minIndex != i) {
                int temp = data[i];
                data[i] = data[minIndex];
                data[minIndex] = temp;

                System.out.println("Swapped: " + Arrays.toString(data));
            }

            System.out.println("Pass " + (i + 1) + ": " + Arrays.toString(data));
        }

        System.out.println("Final Array: " + Arrays.toString(data));
        return data;
    }

    public static int[] insertionSort(int[] array) {
        int[] data = array.clone();

        System.out.println("\n===== INSERTION SORT =====");
        System.out.println("Initial Array: " + Arrays.toString(data));

        for (int i = 1; i < data.length; i++) {
            int key = data[i];
            int j = i - 1;

            System.out.println("Inserting: " + key);

            while (j >= 0) {
                System.out.println(
                        "Comparing " + data[j] + " with " + key
                );

                if (data[j] > key) {
                    data[j + 1] = data[j];
                    j--;

                    System.out.println(
                            "Moving Element: " + Arrays.toString(data)
                    );
                } else {
                    break;
                }
            }

            data[j + 1] = key;

            System.out.println(
                    "After Insertion: " + Arrays.toString(data)
            );
        }

        System.out.println("Final Array: " + Arrays.toString(data));
        return data;
    }

    public static int[] shellSort(int[] array) {
        int[] data = array.clone();

        System.out.println("\n===== SHELL SORT =====");
        System.out.println("Initial Array: " + Arrays.toString(data));

        for (int gap = data.length / 2; gap > 0; gap /= 2) {
            System.out.println("Current Gap: " + gap);

            for (int i = gap; i < data.length; i++) {
                int temp = data[i];
                int j = i;

                while (j >= gap) {
                    System.out.println(
                            "Comparing " + data[j - gap] + " with " + temp
                    );

                    if (data[j - gap] > temp) {
                        data[j] = data[j - gap];
                        j -= gap;

                        System.out.println(
                                "Moving Element: " + Arrays.toString(data)
                        );
                    } else {
                        break;
                    }
                }

                data[j] = temp;
                System.out.println(
                        "Current Array: " + Arrays.toString(data)
                );
            }
        }

        System.out.println("Final Array: " + Arrays.toString(data));
        return data;
    }
}
