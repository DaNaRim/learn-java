package multithreading.itvdn.lesson10.producerConsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class Consumer {

    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    private final LinkedBlockingQueue<String> queue;

    private final AtomicBoolean isWorking;
    private final String producerName;

    public Consumer(LinkedBlockingQueue<String> queue, AtomicBoolean isWorking, String producerName) {
        this.queue = queue;
        this.isWorking = isWorking;
        this.producerName = producerName;
    }

    public void consume() {
        executorService.execute(() -> {
            while (isWorking.get()) {
                try {
                    System.out.println("Consumer " + producerName + " " + queue.poll(1000, TimeUnit.MILLISECONDS));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            executorService.shutdown();
        });
    }
}
