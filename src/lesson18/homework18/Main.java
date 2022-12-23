package lesson18.homework18;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{1, 2, 3};
        System.out.println(toList(array));

        Box<Orange> orangeBox = new Box<>();
        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox2 = new Box<>();
        Set<Apple> apples = new HashSet<>();
        apples.add(new Apple());
        apples.add(new Apple());
        apples.add(new Apple());

        orangeBox.addFruit(new Orange());
        orangeBox2.addFruit(new Orange());
        appleBox.addFruitsSet(apples);

        System.out.println(orangeBox);
        System.out.println(orangeBox.getWeight(orangeBox.getBoxOfFruits().get(0)));
        System.out.println(appleBox);
        System.out.println(orangeBox.compare(appleBox, orangeBox.getBoxOfFruits().get(0)));
        orangeBox.merge(orangeBox2);
        System.out.println(orangeBox);
    }

    public static List<?> toList(Object[] array) {
        return Arrays.stream(array).toList();
    }
}

interface Fruit {
    float weight = 0;

    default float getWeight() {
        return weight;
    }
}

class Orange implements Fruit {

    public float getWeight() {
        return 1.0f;
    }
}

class Apple implements Fruit {

    public float getWeight() {
        return 1.5f;
    }
}

