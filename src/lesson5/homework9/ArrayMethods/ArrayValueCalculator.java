package lesson5.homework9.ArrayMethods;

import lesson5.homework9.Exceptions.ArrayDataException;
import lesson5.homework9.Exceptions.ArraySizeException;

public class ArrayValueCalculator {
    public int doCalc(String[][] array) throws ArraySizeException, ArrayDataException {
        int result = 0;
        if (array.length != 4 || array[0].length != 4) {
            throw new ArraySizeException("Array size is wrong. It must be 4x4");
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
//                System.out.println(Integer.valueOf(Integer.parseInt(array[i][j],123)Integer.parseInt(array[i][j])));
                if (!(Integer.parseInt(array[i][j]) >= 0 || Integer.parseInt(array[i][j]) < 0)) {
                    throw new ArrayDataException("Array transformation from String into int went wrong in " +
                            "array[" + i + "][" + j + "]");
                }
                result += Integer.parseInt(array[i][j]);
            }
        }
        return result;
    }
}