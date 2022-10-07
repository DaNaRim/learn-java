package multithreading.itvdn.lesson3.treadpool;

import java.util.concurrent.BlockingQueue;

public class PoolThreadRunnable implements Runnable {

    private final BlockingQueue<Runnable> taskQueue;
    private Thread thread = null;
    private boolean isStopped = false;

    public PoolThreadRunnable(BlockingQueue<Runnable> queue) {
        taskQueue = queue;
    }

    public void run() {
        this.thread = Thread.currentThread();
        while (!isStopped()) {
            Runnable runnable;
            try {
                runnable = taskQueue.take();
                runnable.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void doStop() {
        isStopped = true;
        this.thread.interrupt();
    }

    public synchronized boolean isStopped() {
        return isStopped;
    }
}
