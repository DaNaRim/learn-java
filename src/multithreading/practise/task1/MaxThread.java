package multithreading.practise.task1;

class MaxThread extends Thread {

    private static int[] array;
    private static int max;

    public MaxThread(int[] array) {
        MaxThread.array = array;
        MaxThread.max = array[0];
    }

    @Override
    public void run() {
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) max = array[i];
        }
    }

    public static int getMax() {
        return max;
    }
}
