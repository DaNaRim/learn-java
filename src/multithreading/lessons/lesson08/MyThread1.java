package multithreading.lessons.lesson08;

class MyThread1 extends Thread {
    ResourceA resourceA;

    @Override
    public void run() {
        System.out.println(resourceA.getI());
    }
}
