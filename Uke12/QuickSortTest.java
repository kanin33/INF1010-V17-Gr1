import java.util.Random;
import java.util.Arrays;

public class QuickSortTest {
    private static final int TEST_SIZE = 10000000;
    private static final int TEST_MAX_VALUE = 99999;
    private static final Random random = new Random(1);

    public static void main(String[] args) {
        System.out.printf("Generating test set of size %d ...", TEST_SIZE);
        Integer[] numbers = new Integer[TEST_SIZE];
        for (int i = 0; i < TEST_SIZE; i++)
            numbers[i] = random.nextInt(TEST_MAX_VALUE);
        System.out.println(" done!");

        // Test sorting without threads.
        Integer[] sorted = Arrays.copyOfRange(numbers, 0, numbers.length);
        long t0 = System.nanoTime();
        new QuickSorter<Integer>().sort(sorted);
        long time = System.nanoTime() - t0;
        System.out.printf("Sorting with %d threads: %d ms.\n", 1,
                                time / 1000000);

        // Test sorting with threads.
        int bestNumberOfThreads = Runtime.getRuntime().availableProcessors();
        sorted = Arrays.copyOfRange(numbers, 0, numbers.length);
        t0 = System.nanoTime();
        new ParallelQuickSort<Integer>(sorted, bestNumberOfThreads).sort();
        time = System.nanoTime() - t0;
        System.out.printf("Sorting with %d threads: %d ms\n", bestNumberOfThreads,
                                time / 1000000);

        // Assert that the result is actually sorted (must be run with -ea to assert).
        for (int i = 1; i < TEST_SIZE; i++)
            assert sorted[i-1].compareTo(sorted[i]) <= 0;
    }
}
