package lesson10.homework13.list;

import java.util.*;

public class ArrayListMethods {
    public List<Integer> toList(Integer[] array) {
        return Arrays.asList(array);
    }

    public ArrayList<Integer> findUnique(ArrayList<Integer> arrayList) {
        Set<Integer> set = new LinkedHashSet<>(arrayList);
        return new ArrayList<>(set);
    }
}
