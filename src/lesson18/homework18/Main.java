package lesson18.homework18;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{1, 2, 3};
        System.out.println(toList(array));

        Box<Orange> orangeBox = new Box<>();
        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox2 = new Box<>();

        List<Apple> apples = new LinkedList<>();
        apples.add(new Apple());
        apples.add(new Apple());
        apples.add(new Apple());

        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());
        orangeBox2.addFruit(new Orange());
        appleBox.addFruitsList(apples);

        System.out.println(orangeBox);
        System.out.println(orangeBox.getWeight());
        System.out.println(appleBox);
        System.out.println(orangeBox.compare(appleBox));
        orangeBox.merge(orangeBox2);
        System.out.println(orangeBox);
        System.out.println(orangeBox2.getBoxOfFruits().isEmpty());
    }

    public static List<?> toList(Object[] array) {
        return Arrays.stream(array).toList();
    }
}

