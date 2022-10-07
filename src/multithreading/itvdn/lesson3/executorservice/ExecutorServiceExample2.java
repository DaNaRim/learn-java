package multithreading.itvdn.lesson3.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample2 {

    public static void main(String[] args) {
        ExecutorService firstExecutorService = Executors.newFixedThreadPool(5);
        ExecutorService secondExecutorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 100; i++) {
            int taskNumber = i;
            firstExecutorService.execute(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted error");
                }
                System.out.println(Thread.currentThread().getName() + ": Task " + taskNumber);
            });
            secondExecutorService.execute(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted error");
                }
                System.err.println(Thread.currentThread().getName() + ": Task " + taskNumber);
            });
        }
        firstExecutorService.shutdown();
        System.out.println(secondExecutorService.shutdownNow().size());
    }
}
