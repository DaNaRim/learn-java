package multithreading.lesson03;

public class Resource {
    private int i;

    public Resource(int i) {
        this.i = i;
    }

    public /*synchronized*/ void changeI() {
        System.out.println(i);
        synchronized(this) {
            if (Thread.currentThread().getName().equals("one")) {
                Thread.yield();
            }
            i++;
        }
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
