package multithreading.itvdn.lesson3.homework;

import java.util.concurrent.*;

public class DemoWithRenaming {

    private static final BlockingQueue<Foo> processedQueue = new ArrayBlockingQueue<>(10);
    private static final ExecutorService executorService = Executors.newFixedThreadPool(3);

    private static volatile boolean isWork = true;

    public static void main(String[] args) {
        processedQueue.add(new Foo("1"));
        processedQueue.add(new Foo("2"));

        while (isWork) {
            try {
                final long startTime = System.nanoTime();
                Future<?> result = executorService.submit(() -> {
                    final long queueDuration = System.nanoTime() - startTime;
                    System.out.printf("Queue duration: %d\n", queueDuration);

                    if (processedQueue.isEmpty()) {
                        isWork = false;
                        return;
                    }

                    final Thread currentThread = Thread.currentThread();
                    final String oldName = currentThread.getName();

                    Foo foo = processedQueue.poll();

                    currentThread.setName("Processing-" + foo.getName());
                    try {
                        System.out.println(Thread.currentThread().getName() + " is processing " + foo.getName());
//                        throw new RuntimeException("Exception in " + foo.getName());
                    } finally {
                        currentThread.setName(oldName);
                    }
                });
                result.get();

                TimeUnit.SECONDS.sleep(1);
//                Thread.currentThread().interrupt();
            } catch (InterruptedException e) {
                System.out.println("Thread is interrupted");
                isWork = false;
            } catch (ExecutionException e) {
                System.out.println("Thread throws exception: " + e.getMessage());
            }
        }
        executorService.shutdown();
    }

    private static class Foo {

        private final String name;

        public Foo(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

}
