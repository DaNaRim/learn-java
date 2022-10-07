package multithreading.itvdn.lesson3.executorservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceExample7 {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService firstExecutorService = Executors.newFixedThreadPool(5);
        List<Task> tasks = new ArrayList<>();
        List<Future<String>> results;

        for (int i = 0; i < 100; i++) {
            tasks.add(new Task(i));
        }

//        results = firstExecutorService.invokeAll(tasks);
//        results = firstExecutorService.invokeAll(tasks, 1, TimeUnit.NANOSECONDS);
//        System.out.println(firstExecutorService.invokeAny(tasks));
        System.out.println(firstExecutorService.invokeAny(tasks, 1, TimeUnit.SECONDS));

        firstExecutorService.shutdown();
    }
}
