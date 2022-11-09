package lesson10.homework13.list;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        OccurrencesMethods occurrencesMethods = new OccurrencesMethods();
        ArrayListMethods arrayListMethods = new ArrayListMethods();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("timer");
        arrayList.add("breakfast");
        arrayList.add("new");
        arrayList.add("timer");
        arrayList.add("arrow");
        arrayList.add("palindrome");
        arrayList.add("car");
        arrayList.add("dog");
        arrayList.add("dog");
        arrayList.add("sun");
        arrayList.add("moon");
        arrayList.add("apple");
        arrayList.add("tree");
        arrayList.add("window");
        arrayList.add("moon");
        arrayList.add("battery");
        String newString = "dog";

        Integer[] array = new Integer[]{1, 3, 5, 6, 7, 8};
        ArrayList<Integer> numbsArrayList = new ArrayList<>();
        numbsArrayList.add(5);
        numbsArrayList.add(4);
        numbsArrayList.add(5);
        numbsArrayList.add(5);
        numbsArrayList.add(1);
        numbsArrayList.add(2);
        numbsArrayList.add(3);
        numbsArrayList.add(3);

        occurrencesMethods.countOccurrence(arrayList, newString);
        System.out.println(arrayListMethods.toList(array));
        System.out.println(arrayListMethods.findUnique(numbsArrayList));
        occurrencesMethods.calcOccurrence(arrayList);
        System.out.println(occurrencesMethods.findOccurrence(arrayList));
    }
}
