package multithreading.practise.task1;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        int[] arr = new int[1_000_100_000]; //if error change this

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) Math.round(Math.random() * 10_000);
        }

        System.out.println(new Date());

        MinThread minThread = new MinThread(arr);
        MaxThread maxThread = new MaxThread(arr);

        minThread.start();
        maxThread.start();
        try {
            minThread.join();
            maxThread.join();
            System.out.println("min " + MinThread.getMin());
            System.out.println("max " + MaxThread.getMax());
        } catch (InterruptedException e) {
            System.err.println("Error");
        }
        System.out.println(new Date());

//        int min = arr[0];
//        int max = arr[0];
//        for (int i = 1; i < arr.length; i++) {
//            if (arr[i] > max) max = arr[i];
//            if (arr[i] < min) min = arr[i];
//        }
//        System.out.println("min " + min);
//        System.out.println("max " + max);
//
//        System.out.println(new Date());
    }
}

