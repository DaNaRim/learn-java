package multithreading.itvdn.lesson5.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        System.out.println("CompletableFuture isDone: " + completableFuture.isDone());
//        System.out.println("CompletableFuture result: " + completableFuture.get());

        CompletableFuture<String> completableFuture2 = CompletableFuture.completedFuture("Result");
        System.out.println("CompletableFuture2 isDone: " + completableFuture2.isDone());
        System.out.println("CompletableFuture2 result: " + completableFuture2.get());

        CompletableFuture<String> completableFuture3 = CompletableFuture.failedFuture(new RuntimeException("Error"));
        System.out.println("CompletableFuture3 isDone: " + completableFuture3.isDone());
//        System.out.println("CompletableFuture3 result: " + completableFuture3.get());


        CompletionStage<String> completionStage = CompletableFuture.completedStage("Result from completedStage");
        System.out.println("CompletionStage isDone: " + completionStage.toCompletableFuture().isDone());
        System.out.println("CompletionStage result: " + completionStage.toCompletableFuture().get());
    }

}
