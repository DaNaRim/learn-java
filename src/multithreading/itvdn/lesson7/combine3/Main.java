package multithreading.itvdn.lesson7.combine3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            list.add(i);
        }

        List<CompletableFuture<Integer>> listSquared = list.stream()
                .map(Main::getSquared)
                .toList();

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(
                listSquared.toArray(new CompletableFuture[0])
        );

        CompletableFuture<List<Integer>> allFuturesResult = allFutures
                .thenApply(v -> listSquared.stream()
                        .map(CompletableFuture::join)
                        .collect(Collectors.toList())
                );

        System.out.println(allFuturesResult.get());
    }

    public static CompletableFuture<Integer> getSquared(int number) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return number * number;
        });
    }
}
