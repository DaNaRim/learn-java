package multithreading.lessons.lesson05;

public class Main {
    volatile static int i; //no cash

    public static void main(String[] args) {
        new MyThreadRead().start();
        new MyThreadWrite().start();
    }

    static class MyThreadWrite extends Thread {

        @Override
        public void run() {
            while (i < 5) {
                System.out.println("increment i to " + ++i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class MyThreadRead extends Thread {

        @Override
        public void run() {
            int localVar = i;
            while (localVar < 5) {
                if (localVar != i) {
                    System.out.println("new value of i is " + i);
                    localVar = i;
                }
            }
        }
    }
}


