package lesson8.homework11;

public class ValueCalculator {
    private static final int arrayLength = 1111000;
    private float[] array = new float[arrayLength];
    private int halfArrayLength = arrayLength / 2;

    public long doCalc() {
        long start = System.currentTimeMillis();
        float numForArray = 1;

        for (int i = 0; i < arrayLength; i++) {
            array[i] = numForArray;
        }
        float[] array1 = new float[halfArrayLength];
        float[] array2 = new float[halfArrayLength];
        try {
            System.arraycopy(array, 0, array1, 0, halfArrayLength);
            System.arraycopy(array, 0, array2, 0, halfArrayLength);
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            for (int i = 0; i < halfArrayLength; i++) {

                array1[i] = (float) (array1[i] * Math.sin(0.2f + i / 5) *
                        Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < halfArrayLength; i++) {

                array2[i] = (float) (array2[i] * Math.sin(0.2f + i / 5) *
                        Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        }).start();

        try {
            System.arraycopy(array1, 0, array, 0, halfArrayLength);
            System.arraycopy(array2, 0, array, halfArrayLength - 1, halfArrayLength);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return System.currentTimeMillis() - start;
    }
}