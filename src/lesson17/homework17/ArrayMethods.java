package lesson17.homework17;

import java.util.Arrays;
import java.util.List;

public class ArrayMethods {

    public int[] returnDigitsArrayFromFour(int[] array) {
        int size = 0;
        int sourcePosition = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == 4) {
                size = array.length - i - 1;
                sourcePosition = i+1;
                break;
            }
            if (i == 0 && array[i] != 4) throw new RuntimeException("Number 4 not found in array");
        }
        int[] resultsArrayList = new int[size];
        System.arraycopy(array, sourcePosition, resultsArrayList, 0, size);
        return resultsArrayList;
    }

    public boolean checkIfArrayContainsOneAndFour(Integer[] array) {
        boolean result = false;
        List<Integer> list = Arrays.asList(array);
        if (list.contains(1) && list.contains(4)) result = true;
        return result;
    }
}
