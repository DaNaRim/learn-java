package multithreading.lessons.lesson19;

import java.util.concurrent.Exchanger;

public class Main {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        new Mike(exchanger);
        new Anket(exchanger);
    }

    static class Mike extends Thread {
        Exchanger<String> exchanger;

        public Mike(Exchanger<String> exchanger) {
            this.exchanger = exchanger;
            start();
        }

        @Override
        public void run() {
            try {
                exchanger.exchange("Hi, i`m Mike");
                sleep(1000);
                exchanger.exchange("I`m 20 y.o.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Anket extends Thread {
        Exchanger<String> exchanger;

        public Anket(Exchanger<String> exchanger) {
            this.exchanger = exchanger;
            start();
        }

        @Override
        public void run() {
            try {
                System.out.println(exchanger.exchange(null));
                System.out.println(exchanger.exchange(null));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
