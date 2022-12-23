package lesson18.homework18;

import java.util.*;

class Box<T> {
    private final List<T> boxOfFruits = new LinkedList<>();

    public void addFruit(T fruit) {
        boxOfFruits.add(fruit);
    }

    public void addFruitsSet(Set<T> fruits) {
        boxOfFruits.addAll(fruits);
    }

    public float getWeight(Fruit fruit) {
        return (float) boxOfFruits.size() * fruit.getWeight();
    }

    public boolean compare(Box<? extends Fruit> otherBox, Fruit fruit) {
        float thisBoxWeight = this.boxOfFruits.size() * fruit.getWeight();
        float otherBoxWeight = otherBox.getWeight(otherBox.getBoxOfFruits().get(0));
        return thisBoxWeight == otherBoxWeight;
    }

    public void merge(Box<T> otherBox) {
        this.boxOfFruits.addAll(otherBox.boxOfFruits);
    }

    public List<T> getBoxOfFruits() {
        return boxOfFruits;
    }

    @Override
    public String toString() {
        return "Box{" +
                "boxOfFruits=" + boxOfFruits +
                '}';
    }
}
