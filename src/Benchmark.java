
import java.util.Random;
import java.util.Locale;

public class Benchmark {

    private static final int[] SIZES = {10, 100, 1000, 10000};
    private static final int RUNS = 3;

    private static final String[] TYPES = {
            "Ascending", "Descending", "Random",
            "Repeated", "Nearly Sorted"
    };

    private static class Metrics {
        long comparisons = 0;
        long movements = 0;
    }

    public static void runBenchmarks() {
        System.out.println("ALGORITHM BENCHMARK");
        System.out.println("Algorithm,Size,Data Type,Comparisons,Movements,Average Time (ms)");

        Random random = new Random();

        for (int size : SIZES) {
            for (String type : TYPES) {

                int[] original = generateData(size, type, random);

                String[] algorithms = {
                        "Bubble Sort", "Selection Sort",
                        "Insertion Sort", "Shell Sort"
                };

                for (String algorithm : algorithms) {

                    long totalTime = 0;
                    long totalComparisons = 0;
                    long totalMovements = 0;

                    // JVM warm-up
                    for (int warmup = 0; warmup < 2; warmup++) {
                        int[] warmupData = original.clone();
                        sort(warmupData, algorithm, new Metrics());
                    }

                    // Benchmark executions
                    for (int run = 0; run < RUNS; run++) {

                        int[] data = original.clone();
                        Metrics metrics = new Metrics();

                        long start = System.nanoTime();

                        sort(data, algorithm, metrics);

                        long end = System.nanoTime();

                        totalTime += end - start;
                        totalComparisons += metrics.comparisons;
                        totalMovements += metrics.movements;
                    }

                    double averageTime =
                            totalTime / (double) RUNS / 1_000_000.0;

                    System.out.printf(
                            Locale.US,
                            "%s,%d,%s,%d,%d,%.6f%n",
                            algorithm,
                            size,
                            type,
                            totalComparisons / RUNS,
                            totalMovements / RUNS,
                            averageTime
                    );
                }
            }
        }
    }

    private static int[] generateData(
            int size, String type, Random random
    ) {
        int[] data = new int[size];

        for (int i = 0; i < size; i++) {
            data[i] = i + 1;
        }

        switch (type) {
            case "Descending":
                for (int i = 0; i < size; i++) {
                    data[i] = size - i;
                }
                break;

            case "Random":
                for (int i = 0; i < size; i++) {
                    data[i] = random.nextInt(10000);
                }
                break;

            case "Repeated":
                for (int i = 0; i < size; i++) {
                    data[i] = 5;
                }
                break;

            case "Nearly Sorted":
                for (int i = 0; i < size / 10; i++) {
                    int a = random.nextInt(size);
                    int b = random.nextInt(size);

                    int temp = data[a];
                    data[a] = data[b];
                    data[b] = temp;
                }
                break;
        }

        return data;
    }

    private static void sort(
            int[] data, String algorithm, Metrics m
    ) {
        switch (algorithm) {
            case "Bubble Sort":
                bubbleSort(data, m);
                break;
            case "Selection Sort":
                selectionSort(data, m);
                break;
            case "Insertion Sort":
                insertionSort(data, m);
                break;
            case "Shell Sort":
                shellSort(data, m);
                break;
        }
    }

    private static void bubbleSort(int[] data, Metrics m) {
        for (int i = 0; i < data.length - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < data.length - 1 - i; j++) {
                m.comparisons++;

                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;

                    m.movements += 3;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }
    }

    private static void selectionSort(int[] data, Metrics m) {
        for (int i = 0; i < data.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < data.length; j++) {
                m.comparisons++;

                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = data[i];
                data[i] = data[minIndex];
                data[minIndex] = temp;

                m.movements += 3;
            }
        }
    }

    private static void insertionSort(int[] data, Metrics m) {
        for (int i = 1; i < data.length; i++) {
            int key = data[i];
            int j = i - 1;

            while (j >= 0) {
                m.comparisons++;

                if (data[j] > key) {
                    data[j + 1] = data[j];
                    m.movements++;
                    j--;
                } else {
                    break;
                }
            }

            data[j + 1] = key;
            m.movements++;
        }
    }

    private static void shellSort(int[] data, Metrics m) {
        for (int gap = data.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < data.length; i++) {
                int temp = data[i];
                int j = i;

                while (j >= gap) {
                    m.comparisons++;

                    if (data[j - gap] > temp) {
                        data[j] = data[j - gap];
                        m.movements++;
                        j -= gap;
                    } else {
                        break;
                    }
                }

                data[j] = temp;
                m.movements++;
            }
        }
    }
}
