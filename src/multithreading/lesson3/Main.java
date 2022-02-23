package multithreading.lesson3;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Resource resource = new Resource(5);

        MyThread myThread = new MyThread(resource);
        myThread.setName("one");
        MyThread myThread2 = new MyThread(resource);

        myThread.start();
        myThread2.start();

        myThread.join();
        myThread2.join();

        System.out.println(resource.getI());
    }


}
