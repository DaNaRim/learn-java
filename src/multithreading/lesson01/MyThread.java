package multithreading.lesson01;

public class MyThread extends Thread {
    @Override
    public void run() {
//        System.out.println("new thread");
//        System.out.println(Thread.currentThread().getName());

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
        someMethod();
    }

    private void someMethod() {
//        throw new RuntimeException();
    }
}
