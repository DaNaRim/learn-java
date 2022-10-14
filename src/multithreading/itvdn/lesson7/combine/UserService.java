package multithreading.itvdn.lesson7.combine;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class UserService {

    public static User getFromRemoteService() {
        return new User();
    }

    public static Integer getDiscount(User user) {
        boolean isRegisteredBeforeLastDay =
                user.getRegistrationDate()
                        .before(new Date(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1)));

        if (isRegisteredBeforeLastDay
                && user.getCountOfOrders() > 5
                && user.getSumOfOrders() > 1000
                && user.getReferralFriendsCount() > 3) {
            return 10;
        }
        if (isRegisteredBeforeLastDay
                && user.getCountOfOrders() > 5
                && user.getSumOfOrders() > 1000) {
            return 5;
        }
        if (isRegisteredBeforeLastDay
                && user.getCountOfOrders() > 5) {
            return 2;
        }
        if (isRegisteredBeforeLastDay) {
            return 1;
        }
        return 0;
    }
}
