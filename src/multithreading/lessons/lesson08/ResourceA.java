package multithreading.lessons.lesson08;

class ResourceA {
    ResourceB resourceB;

    public synchronized int getI() {
        return resourceB.returnI();
    }

    public synchronized int returnI() {
        return 1;
    }
}
