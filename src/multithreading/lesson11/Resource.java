package multithreading.lesson11;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Resource {
    private int i;
    private int j;
    Lock lock = new ReentrantLock();

    public Resource(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public void changeI() {
        lock.lock();
        if (Thread.currentThread().getName().equals("one")) {
            Thread.yield();
        }
        i++;
        changeJ();
    }

    public void changeJ() {
        if (Thread.currentThread().getName().equals("one")) {
            Thread.yield();
        }
        j++;
        lock.unlock();
    }

    public int getI() {
        return i;
    }


    public int getJ() {
        return j;
    }

}
