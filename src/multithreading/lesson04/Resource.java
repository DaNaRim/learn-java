package multithreading.lesson04;

public class Resource {
    private static int i;

    public /*synchronized*/ void changeStaticI() {
        synchronized (Resource.class) {
            int i = Resource.i;
            if (Thread.currentThread().getName().equals("one")) {
                Thread.yield();
            }
            i++;
            Resource.i = i;
        }
    }

    public /*synchronized*/ void changeI() {
        synchronized (this) {
            int i = Resource.i;
            if (Thread.currentThread().getName().equals("one")) {
                Thread.yield();
            }
            i++;
            Resource.i = i;
        }
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
