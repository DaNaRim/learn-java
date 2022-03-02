package multithreading.lessons.lesson02;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Tread 0");
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }
}
