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

//            System.out.println(Integer.parseInt(array[0][0]));
//            for (int j = 0; j < intArray.length; j++) {
////                if ( !Character.isDigit(str.charAt(i)))
//                for (int k = 0; k <intArray[0].length; k++) {
//                    result += intArray[j][k];
//                }
//            }

        return result;
    }
}


//Arrays.deepToString(myArray);