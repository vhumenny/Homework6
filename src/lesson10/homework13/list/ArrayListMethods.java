package lesson10.homework13.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListMethods {
    public List<Integer> toList(Integer[] array) {
        return Arrays.asList(array);
    }

    public ArrayList<Integer> findUnique(ArrayList<Integer> arrayList) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.indexOf(arrayList.get(i)) == arrayList.lastIndexOf(arrayList.get(i))) {
                result.add(arrayList.get(i));
            }
        }
        return result;
    }
}
