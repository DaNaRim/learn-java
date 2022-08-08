package multithreading.itvdn.cafe;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Main {

    static final Semaphore tables = new Semaphore(3);
    static final Semaphore waiter = new Semaphore(1);

    private static boolean isAvailableHours;

    public static synchronized boolean isOpen() {
        return isAvailableHours;
    }

    public static synchronized void closeCafe() {
        isAvailableHours = true;
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable cafe = () -> {
            int i = 0;
            while (!isOpen()) {
                try {
                    new Thread(new People(), String.valueOf(i)).start();
                    i++;
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread cafeThread = new Thread(cafe, "Cafe");
        cafeThread.start();
        TimeUnit.SECONDS.sleep(6);
        closeCafe();
    }
}
