package multithreading.itvdn.lesson6.exception;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AsyncExceptionExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture<Boolean> future = CompletableFuture.supplyAsync(() -> {
//           int[] arr = new int[] {1, 2, 3};
//
//            for (int i = 0; i < 4; i++) {
//                System.out.println(arr[i]);
//            }
//            return true;
//        }).exceptionally(throwable -> {
//            System.out.println("Exception: " + throwable.getMessage());
//            return false;
//        });
//
//        future.get();

        CompletableFuture<Boolean> future = CompletableFuture.supplyAsync(() -> {
            int[] arr = new int[]{1, 2, 3};

            for (int i = 0; i < 4; i++) {
                System.out.println(arr[i]);
            }
            return true;
        }).handle((result, throwable) -> {
            if (throwable != null) {
                System.out.println("Exception: " + throwable.getMessage());
                return false;
            }
            System.out.println("Result: " + result);
            return true;
        });
        future.get();
    }
}
