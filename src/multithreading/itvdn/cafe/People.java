package multithreading.itvdn.cafe;

public class People implements Runnable {

    @Override
    public void run() {
        try {
            System.err.printf("Гости с потока %s пришли в ресторан и ищут столик\n", Thread.currentThread().getName());
            Main.tables.acquire();

            System.out.printf("Гости с потока %s сели за столик и позвали официанта\n", Thread.currentThread().getName());
            Main.waiter.acquire();

            System.out.printf("Официант подошел к гостям с потока %s\n", Thread.currentThread().getName());
            Thread.sleep(2000);
            System.out.printf("Официант принял заказ у гостей с потока %s\n", Thread.currentThread().getName());
            Main.waiter.release();

            Thread.sleep(4000);
            Main.waiter.acquire();

            System.out.printf("Официант принёс заказ гостям с потока %s\n", Thread.currentThread().getName());
            Main.waiter.release();

            Thread.sleep(4000);
            System.err.printf("Гости с потока %s покушали и ушли\n", Thread.currentThread().getName());
            Main.tables.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
