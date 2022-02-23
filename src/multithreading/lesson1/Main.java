package multithreading.lesson1;

public class Main {

    public static void main(String[] args) {
//        MyThread myThread = new MyThread().start();
//        myThread.start();
//        myThread.start();
        new MyThread().start();

        MyRunnable myRunnable = new MyRunnable();
        Thread thread2 = new Thread(myRunnable);
        thread2.start();
//        new Thread(new MyRunnable()).start();
    }


}
