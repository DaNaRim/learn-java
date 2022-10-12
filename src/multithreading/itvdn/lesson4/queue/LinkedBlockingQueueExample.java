package multithreading.itvdn.lesson4.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class LinkedBlockingQueueExample {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();

        Runnable runnable1 = () -> {
            try {
//                System.out.println(queue.take());
                String textFromQueue = queue.poll(2, TimeUnit.SECONDS);
                if (textFromQueue != null) {
                    System.out.println(textFromQueue);
                } else {
                    System.out.println("Поток не дождался елемента в очереди");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable runnable2 = () -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            queue.add("String from runnable 2");
        };

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(queue);
    }
}
