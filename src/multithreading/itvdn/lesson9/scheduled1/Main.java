package multithreading.itvdn.lesson9.scheduled1;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

        Runnable task = () -> System.out.println("Task 2");

        task1();
        service.schedule(task, 5, TimeUnit.SECONDS);
        task3();

        service.shutdown();
    }

    public static void task1() {
        System.out.println("Task 1");
    }

    public static void task3() {
        System.out.println("Task 3");
    }

}
