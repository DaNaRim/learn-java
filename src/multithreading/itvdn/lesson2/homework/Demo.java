package multithreading.itvdn.lesson2.homework;

import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class Demo {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Callable<String> generateRandomString = () -> {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                stringBuilder.append((char) (Math.random() * 26 + 'a'));
            }
            TimeUnit.SECONDS.sleep(new Random().nextInt(10));
            return stringBuilder.toString();
        };

        List<HashMap<Future<String>, Boolean>> results = Stream.of(
                        executorService.submit(generateRandomString),
                        executorService.submit(generateRandomString),
                        executorService.submit(generateRandomString)
                )
                .map(future -> {
                    HashMap<Future<String>, Boolean> map = new HashMap<>();
                    map.put(future, false);
                    return map;
                })
                .toList();

        boolean isAllDone = false;
        while (!isAllDone) {
            isAllDone = true;
            System.out.println("Program is waiting for results...");

            for (HashMap<Future<String>, Boolean> result : results) {
                if (!result.keySet().iterator().next().isDone()) {
                    isAllDone = false;
                    continue;
                }
                if (!result.get(result.keySet().iterator().next())) {
                    try {
                        System.out.println(result.keySet().iterator().next().get());
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                    result.put(result.keySet().iterator().next(), true);
                }
            }
            if (!isAllDone) TimeUnit.SECONDS.sleep(1);
        }
        executorService.shutdown();
        System.out.println("Program is finished");
    }

}
