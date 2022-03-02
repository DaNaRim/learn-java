package multithreading.lessons.lesson01;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
//        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
