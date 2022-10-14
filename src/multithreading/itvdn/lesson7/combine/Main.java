package multithreading.itvdn.lesson7.combine;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> result = getUserFromRemote()
                .thenCompose(user -> getDiscount(user));

        System.out.println("Discount: " + result.get() + "%");
    }

    public static CompletableFuture<User> getUserFromRemote() {
        return CompletableFuture.supplyAsync(UserService::getFromRemoteService);
    }

    public static CompletableFuture<Integer> getDiscount(User user) {
        return CompletableFuture.supplyAsync(() -> UserService.getDiscount(user));
    }

}
