package multithreading.itvdn.lesson3.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample3 {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService firstExecutorService = Executors.newFixedThreadPool(5);

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
        }
        firstExecutorService.shutdown();
        System.out.println(firstExecutorService.isShutdown());

        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println(firstExecutorService.isTerminated());
    }
}
