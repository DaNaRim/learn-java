package multithreading.itvdn.lesson4.hashmap;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class ConcurrentHashMapExample {

    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "Java");
        map.put(2, "C#");
        map.put(3, "C++");
        map.put(4, "Python");
        map.put(5, "Go");

        Runnable runnable1 = () -> {
            System.out.println(map);
            for (Integer integer : map.keySet()) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(integer + " : " + map.get(integer));
            }
        };

        Runnable runnable2 = () -> {
            System.err.println(map);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.putIfAbsent(6, "JavaScript");
            System.err.println(map);
        };

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}
