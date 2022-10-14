package multithreading.itvdn.lesson7.combine;

import java.util.Date;
import java.util.Random;

public class User {

    private Date registrationDate;
    private int countOfOrders;
    private double sumOfOrders;
    private int referralFriendsCount;

    public User() {
        Random random = new Random();
        this.registrationDate = new Date(System.currentTimeMillis() - random.nextInt(1_000_000_000));
        this.countOfOrders = random.nextInt(50);
        this.sumOfOrders = random.nextDouble() * random.nextInt(1000);
        this.referralFriendsCount = random.nextInt(30);
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public int getCountOfOrders() {
        return countOfOrders;
    }

    public void setCountOfOrders(int countOfOrders) {
        this.countOfOrders = countOfOrders;
    }

    public double getSumOfOrders() {
        return sumOfOrders;
    }

    public void setSumOfOrders(double sumOfOrders) {
        this.sumOfOrders = sumOfOrders;
    }

    public int getReferralFriendsCount() {
        return referralFriendsCount;
    }

    public void setReferralFriendsCount(int referralFriendsCount) {
        this.referralFriendsCount = referralFriendsCount;
    }
}
