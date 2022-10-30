package lesson8.homework11;

import java.util.Arrays;

public class ValueCalculator {
    private static int arrayLength = 1000000;
    private static float[] array = new float[arrayLength];
    private static int halfArrayLength = arrayLength / 2;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ValueCalculator valueCalculator = new ValueCalculator();


        System.out.println(valueCalculator.doCalc());
    }

    public long doCalc() {
        long start = System.currentTimeMillis();

        System.out.println(start);
        float numForArray = 1;

        for (int i = 0; i < arrayLength; i++) {
            array[i] = numForArray;
        }
        float[] array1 = new float[halfArrayLength];
        float[] array2 = new float[halfArrayLength];
        System.arraycopy(array, 0, array1, 0, halfArrayLength);
        System.arraycopy(array, 0, array2, 0, halfArrayLength);

        Thread arrayPart1 = new Thread(new arrayPart1Filler());
        Thread arrayPart2 = new Thread(new arrayPart2Filler());

        arrayPart1.start();
        arrayPart2.start();

        System.arraycopy(array1, 0, array, 0, halfArrayLength);

        System.arraycopy(array2, 0, array, halfArrayLength, halfArrayLength);
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        long finish = System.currentTimeMillis();
        return finish - start;
    }

    public static float[] getArray() {
        return array;
    }

    public static void setArray(float[] array) {
        ValueCalculator.array = array;
    }

    public static int getHalfArrayLength() {
        return halfArrayLength;
    }

    public static void setHalfArrayLength(int halfArrayLength) {
        ValueCalculator.halfArrayLength = halfArrayLength;
    }
}

