package multithreading.lesson24;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Main {

    static long numOfOperations = 10_000_000_000L;
    static int numOfThreads = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
//        System.out.println(new Date());

//        long sum = 0;
//        for (long i = 0; i < numOfOperations; i++) {
//            sum += i;
//        }
//        System.out.println(sum);


        Calendar timeStart = Calendar.getInstance();

        ForkJoinPool pool = new ForkJoinPool(numOfThreads);
        System.out.println(pool.invoke(new MyFork(0, numOfOperations)));

        Calendar timeEnd = Calendar.getInstance();
        System.out.println(
                (timeEnd.get(Calendar.MINUTE) - timeStart.get(Calendar.MINUTE))
                        + " min "
                        + Math.abs(timeEnd.get(Calendar.SECOND) - timeStart.get(Calendar.SECOND))
                        + " sec");

    }

    static class MyFork extends RecursiveTask<BigInteger> {

        long from;
        long to;

        public MyFork(long from, long to) {
            this.from = from;
            this.to = to;
        }

        @Override
        protected BigInteger compute() {

            int percentDone = 1;

            if (to - from <= numOfOperations / numOfThreads) {
                BigInteger sum = new BigInteger("0");
                for (long i = from; i < to; i++) {
                    sum = sum.add(BigInteger.valueOf(i));
                    if (i == to / 100 * percentDone) {
                        System.out.println(percentDone + "% Done");
                        percentDone++;
                    }
                }
                return sum;
            } else {
                long middle = (to + from) / 2;
                MyFork firstHalf = new MyFork(from, middle);
                firstHalf.fork();
                MyFork secondHalf = new MyFork(middle + 1, to);
                BigInteger secondValue = secondHalf.compute();
                return firstHalf.join().add(secondValue);
            }
        }
    }

}
