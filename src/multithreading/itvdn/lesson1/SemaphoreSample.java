package multithreading.itvdn.lesson1;

import java.util.concurrent.Semaphore;

public class SemaphoreSample {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        Runnable runnable = () -> {
            try {
                System.out.printf("Поток: %s запрашивает доступ.\n", Thread.currentThread().getName());
                semaphore.acquire();
                synchronizedMethod();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            semaphore.release();
        };

        new Thread(runnable, "Thread 1").start();
        new Thread(runnable, "Thread 2").start();
        new Thread(runnable, "Thread 3").start();
    }

    private static void synchronizedMethod() {
        try {
            System.out.printf("С synchronizedMethod работает поток: %s\n", Thread.currentThread().getName());
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
