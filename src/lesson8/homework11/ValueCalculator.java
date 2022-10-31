package lesson8.homework11;

public class ValueCalculator {
    private static final int arrayLength = 1111000;
    private float[] array = new float[arrayLength];
    private int halfArrayLength = arrayLength / 2;
    private float[] array1Part = new float[halfArrayLength];
    private float[] array2Part = new float[halfArrayLength];

    public long doCalc() throws InterruptedException {
        long start = System.currentTimeMillis();
        float numForArray = 1;

        for (int i = 0; i < arrayLength; i++) {
            array[i] = numForArray;
        }
        array1Part = new float[halfArrayLength];
        array2Part = new float[halfArrayLength];

        System.arraycopy(array, 0, array1Part, 0, halfArrayLength);
        System.arraycopy(array, halfArrayLength, array2Part, 0, halfArrayLength);

        Thread thread1 = new Thread(new Thread1());
        Thread thread2 = new Thread(new Thread2());
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.arraycopy(array1Part, 0, array, 0, halfArrayLength);
        System.arraycopy(array2Part, 0, array, halfArrayLength, halfArrayLength);

        return System.currentTimeMillis() - start;
    }

    public class Thread1 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < array1Part.length; i++) {
                array1Part[i] = (float) (array1Part[i] * Math.sin(0.2f + i / 5) *
                        Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        }
    }

    public class Thread2 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < array2Part.length; i++) {
                array2Part[i] = (float) (array2Part[i] * Math.sin(0.2f + i / 5) *
                        Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        }
    }
}