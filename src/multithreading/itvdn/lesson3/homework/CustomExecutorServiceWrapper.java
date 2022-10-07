package multithreading.itvdn.lesson3.homework;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

import static java.util.stream.Collectors.toList;

public class CustomExecutorServiceWrapper implements ExecutorService {

    protected final ExecutorService target;

    public CustomExecutorServiceWrapper(ExecutorService target) {
        this.target = target;
    }

    public static void main(String[] args) throws InterruptedException {
        CustomExecutorServiceWrapper executor = new CustomExecutorServiceWrapper(Executors.newFixedThreadPool(3));

        executor.submit(() -> {
            System.out.println("Task 1");
            throw new RuntimeException("Exception in task 1");
        });

        BlockingQueue<Callable<Void>> queue = new ArrayBlockingQueue<>(10);
        queue.add(() -> {
            System.out.println("Task 2");
            return null;
        });
        queue.add(() -> {
            System.out.println("Task 3");
            throw new RuntimeException("Exception in task 3");
        });
        executor.invokeAll(queue);
    }

    @Override
    public void shutdown() {
        target.shutdown();
    }

    @Override
    public List<Runnable> shutdownNow() {
        return target.shutdownNow();
    }

    @Override
    public boolean isShutdown() {
        return target.isShutdown();
    }

    @Override
    public boolean isTerminated() {
        return target.isTerminated();
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return target.awaitTermination(timeout, unit);
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        return target.submit(wrap(task, clientTrace(), Thread.currentThread().getName()));
    }

    @Override
    public <T> Future<T> submit(Runnable task, T result) {
        return target.submit(wrap(task, clientTrace(), Thread.currentThread().getName()), result);
    }

    @Override
    public Future<?> submit(Runnable task) {
        return target.submit(task);
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        return tasks.stream().map(this::submit).collect(toList());
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks,
                                         long timeout,
                                         TimeUnit unit) throws InterruptedException {
        return target.invokeAll(tasks, timeout, unit);
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
        return target.invokeAny(tasks);
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks,
                           long timeout,
                           TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return target.invokeAny(tasks, timeout, unit);
    }

    @Override
    public void execute(Runnable command) {
        target.execute(command);
    }

    private <T> Callable<T> wrap(Callable<T> task, Exception clientStack, String clientThreadName) {
        return () -> {
            try {
                return task.call();
            } catch (Exception e) {
                System.out.printf("Exception in %s in %s: %s%n", clientThreadName, clientStack, e.getMessage());
                throw e;
            }
        };
    }

    private Runnable wrap(Runnable task, Exception clientStack, String clientThreadName) {
        return () -> {
            try {
                task.run();
            } catch (Exception e) {
                System.out.printf("Exception in %s in %s: %s%n", clientThreadName, clientStack, e.getMessage());
                throw e;
            }
        };
    }

    private Exception clientTrace() {
        return new Exception("Exception in client thread");
    }
}
