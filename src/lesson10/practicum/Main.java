package lesson10.practicum;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList test = new ArrayList();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);

        System.out.println(test.size());
        System.out.println(test.isEmpty());
        System.out.println(test);
        System.out.println(test.get(0));
        test.remove(3);
        System.out.println(test);
        test.clear();
        System.out.println(test);
        System.out.println(Arrays.toString(test.toArray()));
    }
}
