package lesson5.homework9;

import java.util.Random;

public class TwoDimensionalArrayFiller {

    public String[][] fillArrayOfStrings(String[][] array, Random random) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = "" + random.nextInt(0, 100);
            }
        }
        return array;
    }
}
