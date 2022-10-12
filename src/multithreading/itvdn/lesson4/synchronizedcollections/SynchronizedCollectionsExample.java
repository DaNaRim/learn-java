package multithreading.itvdn.lesson4.synchronizedcollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SynchronizedCollectionsExample {

    public static void main(String[] args) throws InterruptedException {
//        ArrayList<Integer> list = new ArrayList<>();
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Runnable runnable1 = () -> {
            synchronized (list) {
                for (Integer integer : list) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(integer);
                }
            }
        };

        Runnable runnable2 = () -> {
            for (int i = 6; i < 11; i++) {
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                list.add(i);
                System.err.println(list);
            }
        };

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(list);
    }
}
