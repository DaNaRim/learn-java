package multithreading.lessons.lesson02;

public class Main {

    public static void main(String[] args) throws InterruptedException {


        Thread myThread = new MyThread();
        myThread.start();
//        myThread.setPriority(Thread.MAX_PRIORITY);
        Thread.yield();

        myThread.join();

//        Thread.sleep(1000);

        System.out.println("Tread main");
    }


}
