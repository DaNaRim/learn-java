package multithreading.itvdn.lesson3.treadpool;

public class ThreadPoolMainClass {

    public static void main(String[] args) throws Exception {
        ThreadPool threadPool = new ThreadPool(3, 10);

        for (int i = 0; i < 10; i++) {
            int taskNumber = i;
            threadPool.execute(() -> {
                System.out.printf("%s: Task %d%n", Thread.currentThread().getName(), taskNumber);
            });
        }
        threadPool.waitUntilAllTasksFinished();
        threadPool.stop();
    }
}
