package lesson5.homework9.arrayMethods;

import lesson5.homework9.exceptions.ArrayDataException;
import lesson5.homework9.exceptions.ArraySizeException;

public class ArrayValueCalculator {
    public int doCalc(String[][] array) throws ArraySizeException, ArrayDataException {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            if (array.length != 4 || array[i].length != 4) {
                throw new ArraySizeException("Array size is wrong. It must be 4x4");
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    result += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new ArrayDataException("Array transformation from String into int went wrong in " +
                            "array[" + i + "][" + j + "] String " + array[i][j] + " is not a digit");
                }
            }
        }
        return result;
    }
}