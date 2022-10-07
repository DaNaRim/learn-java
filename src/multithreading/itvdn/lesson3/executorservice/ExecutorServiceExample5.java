package multithreading.itvdn.lesson3.executorservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceExample5 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService firstExecutorService = Executors.newFixedThreadPool(5);
        List<Future<String>> results = new ArrayList<>();

//        for (int i = 0; i < 100; i++) {
//            firstExecutorService.execute(new Task(i));
//        }

        for (int i = 0; i < 100; i++) {
            results.add(firstExecutorService.submit(new Task(i)));
        }

        firstExecutorService.shutdown();

        for (Future<String> result : results) {
            System.out.println(result.get());
        }
    }
}

class Task implements Callable<String> {

    private int id;

    Task(int id) {
        this.id = id;
    }

    @Override
    public String call() {
        return "Результат задачи: " + id;
    }
}
