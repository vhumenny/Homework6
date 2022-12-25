package lesson18.homework18;

import java.util.*;

class Box<T extends Fruit> {
    private final List<T> boxOfFruits = new LinkedList<>();

    public void addFruit(T fruit) {
        boxOfFruits.add(fruit);
    }

    public void addFruitsList(List<T> fruits) {
        boxOfFruits.addAll(fruits);
    }

    public float getWeight() {
        return (float) boxOfFruits.size() * boxOfFruits.get(0).getWeight();
    }

    public boolean compare(Box<? extends Fruit> otherBox) {
        float thisBoxWeight = this.boxOfFruits.size() * this.boxOfFruits.get(0).getWeight();
        float otherBoxWeight = otherBox.getWeight();
        return thisBoxWeight == otherBoxWeight;
    }

    public void merge(Box<T> otherBox) {
        this.boxOfFruits.addAll(otherBox.boxOfFruits);
        otherBox.boxOfFruits.clear();
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
