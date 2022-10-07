package multithreading.itvdn.lesson3.forkjoin;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinExample {

    public static int THRESHOLD;

    public static void main(String[] args) {
        int[] numbers = initNumbers(6_000_000);
        THRESHOLD = numbers.length / Runtime.getRuntime().availableProcessors();

        long start = System.currentTimeMillis();
        System.out.println("Max number: " + findMaxNumber(numbers, numbers.length));
        System.out.println("Time: " + (System.currentTimeMillis() - start) + " ms\n");

        ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        MaxFindingForkJoinTask task = new MaxFindingForkJoinTask(numbers, 0, numbers.length);

        start = System.currentTimeMillis();
        System.out.println("Max number: " + pool.invoke(task));
        System.out.println("Time: " + (System.currentTimeMillis() - start) + " ms");
    }

    public static int findMaxNumber(int[] numbers, int highIndex) {
        int max = numbers[0];

        for (int i = 1; i < highIndex; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        return max;
    }

    private static int[] initNumbers(int arraySize) {
        Random random = new Random();

        int[] numbers = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            numbers[i] = random.nextInt(100_000);
        }
        return numbers;
    }
}
