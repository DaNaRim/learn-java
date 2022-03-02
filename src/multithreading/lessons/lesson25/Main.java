package multithreading.lessons.lesson25;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Math.random());
        System.out.println(ThreadLocalRandom.current().nextInt());

//        Thread.sleep(TimeUnit.DAYS.toMillis(14));
        System.out.println(TimeUnit.DAYS.toMillis(14));
    }
}
