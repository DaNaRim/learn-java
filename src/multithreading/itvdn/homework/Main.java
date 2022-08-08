package multithreading.itvdn.homework;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Port port = new Port();

        port.processShip("A");
        port.processShip("B");
        port.processShip("C");

        port.processShip("D");
        port.processShip("E");
        port.processShip("F");

        port.processShip("G");
        port.processShip("H");
        port.processShip("I");

        port.processShip("J");
    }


}
