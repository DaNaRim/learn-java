package multithreading.itvdn.lesson4.homework;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        MailSender mailSender = new MailSender();

        mailSender.send("mail1", "mail2", "mail3", "mail4", "mail5");

        mailSender.start();

        mailSender.send("mail6", "mail7", "mail8", "mail9", "mail10");
        mailSender.send("mail11");
        TimeUnit.SECONDS.sleep(2);
        mailSender.stop();
        mailSender.send("mail12");
    }

}
