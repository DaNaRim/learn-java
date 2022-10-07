package multithreading.itvdn.lesson3.forkjoin;

import java.util.concurrent.RecursiveTask;

public class MaxFindingForkJoinTask extends RecursiveTask<Integer> {

    private int[] numbers;
    private int lowIndex;
    private int highIndex;

    public MaxFindingForkJoinTask(int[] numbers, int lowIndex, int highIndex) {
        this.numbers = numbers;
        this.lowIndex = lowIndex;
        this.highIndex = highIndex;
    }

    @Override
    protected Integer compute() {
        if (highIndex - lowIndex < ForkJoinExample.THRESHOLD) {
            return findMaxNumber();
        } else {
            int middleIndex = (lowIndex + highIndex) / 2;

            MaxFindingForkJoinTask maxFindingForkJoinTask1 = new MaxFindingForkJoinTask(numbers, lowIndex, middleIndex);
            MaxFindingForkJoinTask maxFindingForkJoinTask2 = new MaxFindingForkJoinTask(numbers, middleIndex + 1, highIndex);

            invokeAll(maxFindingForkJoinTask1, maxFindingForkJoinTask2);

            return Math.max(maxFindingForkJoinTask1.join(), maxFindingForkJoinTask2.join());
        }
    }

    public int findMaxNumber() {
        int max = numbers[lowIndex];

        for (int i = lowIndex + 1; i < highIndex; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }
}
