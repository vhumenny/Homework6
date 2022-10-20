package lesson5.homework9;

public class ArrayValueCalculator {
    public int doCalc(String[][] array, int result) {
//        if (array.length != 4) {
//            throw ArraySizeException();
//        }
        int [][] intArray= new int[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
//                if (array[i][j].getClass()equals(String.)){
//
//                }
                Integer.parseInt(array[i][j]);
            }
            for (int j = 0; j < ; j++) {
                for (int k = 0; k < ; k++) {
                    result+=array[i][j];
                }
            }
        }
        return result;
    }


}


//Arrays.deepToString(myArray);