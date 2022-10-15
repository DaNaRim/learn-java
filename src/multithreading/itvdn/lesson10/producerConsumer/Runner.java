package multithreading.itvdn.lesson10.producerConsumer;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class Runner {

    private final LinkedBlockingQueue<String> queue;
    private final AtomicBoolean isWorking;

    public Runner() {
        this.queue = new LinkedBlockingQueue<>();
        this.isWorking = new AtomicBoolean(true);
    }

    public void start() {
        for (int i = 0; i < 3; i++) {
            Producer producer = new Producer(queue, isWorking, "Producer " + i);
            Consumer consumer = new Consumer(queue, isWorking, "Consumer " + i);
            producer.produce();
            consumer.consume();
        }

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.schedule(() -> isWorking.set(true), 10, TimeUnit.SECONDS);
        executorService.shutdown();
    }

    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.start();
    }
}
