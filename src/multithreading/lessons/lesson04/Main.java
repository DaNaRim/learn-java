package multithreading.lessons.lesson04;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Resource resource = new Resource();
        resource.setI(5);

        MyThread myThread = new MyThread(resource);
        myThread.setName("one");
        MyThread myThread2 = new MyThread(resource);

        myThread.start();
        myThread2.start();

        myThread.join();
        myThread2.join();

        System.out.println(resource.getI());

        //no mix static and not-static changes for same changes
    }
}
