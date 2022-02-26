package multithreading.lesson8;

class MyThread2 extends Thread {
    ResourceB resourceB;

    @Override
    public void run() {
        System.out.println(resourceB.getI());
    }
}
