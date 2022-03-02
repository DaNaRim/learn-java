package multithreading.lessons.lesson16;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();

        ses.schedule(new MyThread(), 1, TimeUnit.SECONDS);
        ses.shutdown();
    }

    static class MyThread extends Thread {

        @Override
        public void run() {
            System.out.println(1);
        }
    }
}
