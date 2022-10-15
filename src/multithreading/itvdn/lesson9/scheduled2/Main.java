package multithreading.itvdn.lesson9.scheduled2;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Main {

    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

        Runnable task1 = () -> {
            count++;
            System.out.println("Task 1, count = " + count);
        };

        ScheduledFuture<?> future = service.scheduleAtFixedRate(task1, 10, 1, TimeUnit.SECONDS);

        while (true) {
            System.out.println("count = " + count);
            Thread.sleep(1000);
            if (count == 5) {
                future.cancel(true);
                service.shutdown();
                break;
            }
        }
    }

}
