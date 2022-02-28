package multithreading.lesson20;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Main {

    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(3, new Run());

        new Sportsman(cb);
        new Sportsman(cb);
        new Sportsman(cb);
    }

    static class Run extends Thread {
        CyclicBarrier cb;

        @Override
        public void run() {
            System.out.println("Run is begin");
        }
    }

    static class Sportsman extends Thread {
        CyclicBarrier cb;

        public Sportsman(CyclicBarrier cd) {
            this.cb = cd;
            start();
        }

        @Override
        public void run() {
            try {
                cb.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
