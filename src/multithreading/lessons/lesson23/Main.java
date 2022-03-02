package multithreading.lessons.lesson23;

import java.util.concurrent.ThreadFactory;

public class Main {

    public static void main(String[] args) {
        ThreadFactory tf = r -> {
            Thread thread = new Thread(r);
            thread.setPriority(Thread.MAX_PRIORITY);
            return thread;
        };

        tf.newThread(new MyRun()).start();
    }


    static class MyRun implements Runnable {
        @Override
        public void run() {
            System.out.println(1);
        }
    }
}
