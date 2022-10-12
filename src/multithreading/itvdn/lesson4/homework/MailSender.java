package multithreading.itvdn.lesson4.homework;

import java.util.Collections;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

public class MailSender {

    private final ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

    private boolean isWorking;

    public boolean isWorking() {
        return isWorking;
    }

    public void send(String mail) {
        queue.add(mail);
    }

    public void send(String... mails) {
        Collections.addAll(queue, mails);
    }

    public void start() {
        isWorking = true;

        new Thread(() -> {
            while (isWorking) {
                if (!queue.isEmpty()) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        System.err.println("Thread was interrupted");
                        isWorking = false;
                    }
                    System.out.println("Sending mail: " + queue.poll());
                }
            }
        }).start();
    }

    public void stop() {
        isWorking = false;
    }

}
