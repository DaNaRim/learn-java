package multithreading.itvdn.lesson2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Sample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Main начал работу");
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Callable<String> callable = () -> {
            System.out.printf("%s начал работу\n", Thread.currentThread().getName());
            Thread.sleep(1000);
            return Thread.currentThread().getName();
        };

        List<Future<String>> futures = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            futures.add(executorService.submit(callable));
        }

        System.out.println("Main продолжает работу");

        for (Future<String> future : futures) {
            System.err.printf("Результат из потока %s\n", future.get());
        }
        executorService.shutdown();
    }
}
