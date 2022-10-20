package lesson5.homework9;

import java.util.Arrays;

public class ArrayValueCalculator {
    public int doCalc(String[][] array) throws ArraySizeException, ArrayDataException {
        int result = 0;
        if (array.length != 4 || array[0].length != 4) {
            throw new ArraySizeException("Array size is wrong. It must be 4x4");
        }
        int[][] numbsArray = new int[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                numbsArray[i][j] = Integer.parseInt(array[i][j]);
            }
        }
//        System.out.println(Arrays.deepToString(numbsArray));
        for (int k = 0; k < numbsArray.length; k++) {
            for (int l = 0; l < numbsArray[0].length; l++) {
                if (4==3) {
                    throw new ArrayDataException("Array ");
                }
                result += Integer.parseInt(array[k][l]);
            }
        }
        return result;
    }
}