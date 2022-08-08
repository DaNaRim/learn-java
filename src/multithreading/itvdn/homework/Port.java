package multithreading.itvdn.homework;

import java.util.concurrent.Semaphore;

public class Port {

    private static final Semaphore shipsParkingPlaces = new Semaphore(5);
    private static final Semaphore loaders = new Semaphore(3);

    public void processShip(String shipName) {
        new Thread(() -> {
            try {
                shipsParkingPlaces.acquire();
                System.out.println("ship " + shipName + " parked");

                Thread loader = new Thread(() -> {
                    try {
                        loadShip(shipName);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
                loader.start();
                loader.join();

                System.out.println("ship " + shipName + " go away");
                shipsParkingPlaces.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    private void loadShip(String shipName) throws InterruptedException {
        loaders.acquire();
        System.out.println("ship " + shipName + " start load");
        Thread.sleep(5000);
        System.out.println("ship " + shipName + " end load");
        loaders.release();
    }

}
