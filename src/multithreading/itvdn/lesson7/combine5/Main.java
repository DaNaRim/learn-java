package multithreading.itvdn.lesson7.combine5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import static multithreading.itvdn.lesson7.combine.Main.getDiscount;
import static multithreading.itvdn.lesson7.combine.Main.getUserFromRemote;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            list.add(i);
        }

        List<CompletableFuture<StoreDiscount>> storeDiscountFuture = list.stream()
                .map(Main::getStoreDiscount)
                .toList();

        CompletableFuture<Void> allFuturesResult = CompletableFuture.allOf(
                storeDiscountFuture.toArray(new CompletableFuture[0])
        );

        CompletableFuture<List<StoreDiscount>> allStore = allFuturesResult
                .thenApply(v -> storeDiscountFuture.stream()
                        .map(CompletableFuture::join)
                        .collect(Collectors.toList())
                );

        CompletableFuture<Integer> userDiscount = getUserFromRemote()
                .thenCompose(user -> getDiscount(user));

        CompletableFuture<List<Integer>> result = userDiscount.thenCombine(
                allStore, Main::getStoresWithUserDiscount
        );

        System.out.println(allStore.get());
        System.out.println(userDiscount.get());
        System.out.println(result.get());
    }

    public static CompletableFuture<StoreDiscount> getStoreDiscount(Integer storeNumber) {
        return CompletableFuture.supplyAsync(() -> {
            StoreDiscount storeDiscount = new StoreDiscount();
            storeDiscount.setStoreNumber(storeNumber);
            storeDiscount.setDiscount(new Random().nextInt(10));
            return storeDiscount;
        });
    }

    public static List<Integer> getStoresWithUserDiscount(Integer userDiscount, List<StoreDiscount> storeDiscounts) {
        return storeDiscounts.stream()
                .filter(storeDiscount -> storeDiscount.getDiscount().equals(userDiscount))
                .map(StoreDiscount::getStoreNumber)
                .collect(Collectors.toList());
    }
}
