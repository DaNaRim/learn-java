package multithreading.itvdn.lesson4.arrayset;

import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;

public class CopyOnWriteArraySetExample {

    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArraySet<String> arrayList = new CopyOnWriteArraySet<>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");

        Runnable runnable1 = () -> {
            for (String s : arrayList) {
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(s);
            }
        };

        Runnable runnable2 = () -> {
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            arrayList.remove("5");
            arrayList.add("6");
            System.err.println(arrayList);
        };

        System.out.println(arrayList);
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(arrayList);
        thread1 = new Thread(runnable1);
        thread1.start();
        thread1.join();
    }
}
