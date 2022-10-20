package lesson5.homework9;

public class ArrayValueCalculator {
    public int doCalc(String[][] array) throws ArraySizeException {
        int result = 0;
        if (array[0].length != 4 && array.length != 4) throw new ArraySizeException();

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (Character.isDigit(Integer.parseInt(array[i][j]))) {

                }
                result += Integer.parseInt(array[i][j]);
            }
        }
        return result;
    }
}