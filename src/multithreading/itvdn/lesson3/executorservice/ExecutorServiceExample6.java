package multithreading.itvdn.lesson3.executorservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceExample6 {

//    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        ExecutorService firstExecutorService = Executors.newFixedThreadPool(5);
//        List<Future<String>> results = new ArrayList<>();
//
////        for (int i = 0; i < 100; i++) {
////            firstExecutorService.execute(new Task(i));
////        }
//
//        for (int i = 0; i < 100; i++) {
//            results.add(firstExecutorService.submit(new RunnableTask(i), "Задача: " + i));
//        }
//
//        firstExecutorService.shutdown();
//
//        firstExecutorService.awaitTermination(1, TimeUnit.SECONDS);
//
//        for (Future<String> result : results) {
//            System.out.println(result.get());
//        }
//    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService firstExecutorService = Executors.newFixedThreadPool(5);
        List<Future<?>> results = new ArrayList<>();

//        for (int i = 0; i < 100; i++) {
//            firstExecutorService.execute(new Task(i));
//        }

        for (int i = 0; i < 100; i++) {
            results.add(firstExecutorService.submit(new RunnableTask(i)));
        }

        firstExecutorService.shutdown();

        firstExecutorService.awaitTermination(1, TimeUnit.SECONDS);

        for (Future<?> result : results) {
            if (result.get() == null) {
                System.out.println("Поток завершился успешно");
            } else {
                System.err.println("Ошибка");
            }
        }
    }
}

class RunnableTask implements Runnable {

    private int id;

    RunnableTask(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Задача: " + id + " исполняется");
    }
}
