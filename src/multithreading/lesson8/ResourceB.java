package multithreading.lesson8;

class ResourceB {
    ResourceA resourceA;

    public synchronized int getI() {
        return resourceA.returnI();
    }

    public synchronized int returnI() {
        return 2;
    }
}
