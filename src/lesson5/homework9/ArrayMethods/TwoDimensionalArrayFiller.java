package lesson5.homework9.ArrayMethods;

import java.util.Random;

public class TwoDimensionalArrayFiller {

    public String[][] fillArrayOfStrings(String[][] array, Random random) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = Integer.toString(random.nextInt(0, 100));
                if (array[i][j] == null) {
                    throw new IllegalArgumentException("Element of the array can't be null!");
                }
            }
        }
        return array;
    }
}