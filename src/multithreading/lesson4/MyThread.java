package multithreading.lesson4;

public class MyThread extends Thread {

    private Resource resource;

    public MyThread(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        resource.changeStaticI();
        new Resource().changeI();
    }
}
