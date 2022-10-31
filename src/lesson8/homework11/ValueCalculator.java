package lesson8.homework11;

public class ValueCalculator {
    private static final int arrayLength = 1000000;
    private float[] array = new float[arrayLength];
    private int halfArrayLength = arrayLength / 2;

    public long doCalc() throws InterruptedException {
        long start = System.currentTimeMillis();
        float numForArray = 1;

        for (int i = 0; i < arrayLength; i++) {
            array[i] = numForArray;
        }
        float[] array1Part = new float[halfArrayLength];
        float[] array2Part = new float[halfArrayLength];

        System.arraycopy(array, 0, array1Part, 0, halfArrayLength);
        System.arraycopy(array, halfArrayLength, array2Part, 0, halfArrayLength);

        Thread thread1 = new Thread(new ArrayCalculationThread(array1Part));
        Thread thread2 = new Thread(new ArrayCalculationThread(array2Part));
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.arraycopy(array1Part, 0, array, 0, halfArrayLength);
        System.arraycopy(array2Part, 0, array, halfArrayLength, halfArrayLength);

        return System.currentTimeMillis() - start;
    }

    public class ArrayCalculationThread implements Runnable {
        float[] array;

        public ArrayCalculationThread(float[] array) {
            this.array = array;
        }

        @Override
        public void run() {
            for (int i = 0; i < array.length; i++) {
                array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) *
                        Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        }
    }
}
