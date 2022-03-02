package multithreading.lessons.lesson15;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new MyRunnable());
        System.out.println(executorService.submit(new MyCallable()).get());
        executorService.shutdown();
    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println(1);
        }
    }


    static class MyCallable implements Callable<String> {

        @Override
        public String call() {
            return "2";
        }
    }
}

