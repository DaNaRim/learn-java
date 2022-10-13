package multithreading.itvdn.lesson6.homework;

import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.supplyAsync(() -> "Hello")
                .thenApply(s -> s + " World")
                .thenApply(s -> s + "!")
                .thenAccept(System.out::println);

        CompletableFuture.supplyAsync(() -> "Hello")
                .thenApply(s -> {
                    throw new RuntimeException("Exception");
                })
                .thenApply(s -> s + "!")
                .handle((result, throwable) -> {
                    if (throwable != null) {
                        System.out.println("Exception: " + throwable.getMessage());
                        return "Error";
                    }
                    System.out.println("Result: " + result);
                    return result;
                });

        CompletableFuture.supplyAsync(() -> "Hello")
                .thenApply(s -> {
                    throw new RuntimeException("Exception");
                })
                .thenApply(s -> s + "!")
                .exceptionally(throwable -> {
                    System.out.println("Exception2: " + throwable.getMessage());
                    return "Error";
                });
    }

}
