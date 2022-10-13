package multithreading.itvdn.lesson6.supplyAsync;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

public class SupplyAsyncExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        AtomicInteger actionCounter = new AtomicInteger();

        Supplier<List<Integer>> readFile = () -> {

            File file = new File("src/multithreading/itvdn/lesson6/supplyAsync/array1.txt");
            try (Scanner fileScanner = new Scanner(file)) {

                List<Integer> result = new ArrayList<>();
                while (fileScanner.hasNextInt()) {
                    result.add(fileScanner.nextInt());
                }
                return result;
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        };
        while (true) {
            CompletableFuture<List<Integer>> future = CompletableFuture.supplyAsync(readFile);

            System.out.println("Enter action: ");
            System.out.println("1 - get min and max");
            System.out.println("2 - get sum");
            System.out.println("3 - get average");

            int action = scanner.nextInt();

            if (!future.isDone()) {
                System.out.println("Waiting for result...");
            }

            switch (action) {
                case 1 -> future.thenAccept(integers -> {
                    actionCounter.getAndIncrement();

                    System.err.println(actionCounter.get() + " Min: " + integers.stream().min(Integer::compareTo).orElse(-1));
                    System.err.println(actionCounter.get() + " Max: " + integers.stream().max(Integer::compareTo).orElse(-1));
                });
                case 2 -> future.thenAccept(integers -> {
                    actionCounter.getAndIncrement();

                    System.err.println(actionCounter.get() + " Sum: " + integers.parallelStream()
                            .map(i -> new BigInteger(i.toString()))
                            .reduce(BigInteger.ZERO, BigInteger::add));
                });
                case 3 -> future.thenAccept(integers -> {
                    actionCounter.getAndIncrement();

                    System.err.printf(actionCounter.get() + " Average: %.2f%n", integers.stream()
                            .mapToInt(Integer::intValue)
                            .average()
                            .orElse(-1.0));
                });
                default -> System.err.println("Wrong action");
            }
        }
    }

}
