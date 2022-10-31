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
            System.arraycopy(array, halfArrayLength, array2, 0, halfArrayLength);
        } catch (Exception e) {
            e.printStackTrace();
        }
        arrayFiller(array1);
        arrayFiller(array2);
        try {
            System.arraycopy(array1, 0, array, 0, halfArrayLength);
            System.arraycopy(array2, 0, array, halfArrayLength, halfArrayLength);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return System.currentTimeMillis() - start;
    }

    public void arrayFiller(float[] newArray) {
        new Thread(() -> {
            for (int i = 0; i < halfArrayLength; i++) {
                newArray[i] = (float) (newArray[i] * Math.sin(0.2f + i / 5) *
                        Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        }).start();
    }
}