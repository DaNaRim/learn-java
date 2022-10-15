package multithreading.itvdn.lesson9.scheduled3;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

        executor.scheduleAtFixedRate(() -> { // between start and start
            System.out.println("Rate " + new Date());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, 0, 1, TimeUnit.SECONDS);

        executor.scheduleWithFixedDelay(() -> { // between end and start
            System.out.println("Delay " + new Date());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, 2, 1, TimeUnit.SECONDS);

        executor.awaitTermination(10, TimeUnit.SECONDS);

        executor.shutdown();
    }

}
