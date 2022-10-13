package multithreading.itvdn.lesson6.runAsync;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunAsyncExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Runnable runnable = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello from " + Thread.currentThread().getName());
        };

        CompletableFuture<Void> future = CompletableFuture.runAsync(runnable);
        System.out.println("Async task started");
        System.out.println("Hello from " + Thread.currentThread().getName());
        future.get();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(runnable, executorService);
        System.out.println("Async task2 started");
        System.out.println("Hello from " + Thread.currentThread().getName());
        future2.get();
        executorService.shutdown();
    }
}
