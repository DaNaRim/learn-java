package multithreading.lessons.lesson17;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Semaphore table = new Semaphore(2);

        Person person1 = new Person();
        person1.table = table;
        Person person2 = new Person();
        person2.table = table;
        Person person3 = new Person();
        person3.table = table;
        Person person4 = new Person();
        person4.table = table;
        Person person5 = new Person();
        person5.table = table;
        Person person6 = new Person();
        person6.table = table;

        person1.start();
        person2.start();
        person3.start();
        person4.start();
        person5.start();
        person6.start();
    }
}

class Person extends Thread {
    Semaphore table;

    @Override
    public void run() {
        System.out.println(this.getName() + " waiting for table");
        try {
            table.acquire();
            System.out.println(this.getName() + " eat at the table");
            sleep(1000);
            System.out.println(this.getName() + " release table");
            table.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
