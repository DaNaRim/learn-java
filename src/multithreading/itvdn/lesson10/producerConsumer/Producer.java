package multithreading.itvdn.lesson10.producerConsumer;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class Producer {

    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    private final LinkedBlockingQueue<String> queue;
    private final AtomicBoolean isWorking;
    private final String producerName;

    public Producer(LinkedBlockingQueue<String> queue, AtomicBoolean isWorking, String producerName) {
        this.queue = queue;
        this.isWorking = isWorking;
        this.producerName = producerName;
    }

    public void produce() {
        executorService.execute(() -> {
            while (isWorking.get()) {
                try {
                    queue.add("Producer " + producerName + " at " + new Date());
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            executorService.shutdown();
        });
    }
}
