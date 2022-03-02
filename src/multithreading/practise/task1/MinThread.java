package multithreading.practise.task1;

class MinThread extends Thread {

    private static int[] array;
    private static int min;

    public MinThread(int[] array) {
        MinThread.array = array;
        MinThread.min = array[0];
    }

    @Override
    public void run() {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) min = array[i];
        }
    }

    public static int getMin() {
        return min;
    }
}
