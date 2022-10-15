package lesson3.homework5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cat barsik = new Cat("Barsik");
        Dog rex = new Dog("Rex");
        Dog sharik = new Dog("Sharik");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the distances for the cat to run:");
        barsik.run(scanner.nextInt(), barsik.getCatName());
        System.out.println("Please enter the distances for the cat to swim:");
        barsik.swim(scanner.nextInt(), barsik.getCatName());

        System.out.println("Please enter the distances for the dogs to run:");
        rex.run(scanner.nextInt(), rex.getDogName());
        sharik.run(scanner.nextInt(), sharik.getDogName());
        System.out.println("Please enter the distances for the dogs to swim:");
        rex.swim(scanner.nextInt(), rex.getDogName());
        sharik.swim(scanner.nextInt(), sharik.getDogName());

        System.out.println("Amount of animals made: " + Animal.getInstanceCount());
        System.out.println("Amount of cats made: " + Cat.getInstanceCount());
        System.out.println("Amount of dogs made: " + Dog.getInstanceCount());
    }
}

class Animal {
    private static int instanceCount = 0;

    public Animal() {
        instanceCount++;
    }

    public void run(int length) {
        System.out.println("run");
    }

    public void swim(int length) {
        System.out.println("swim");
    }

    public static int getInstanceCount() {
        return instanceCount;
    }

}

class Cat extends Animal {
    private String catName;
    private static int instanceCount = 0;

    public Cat(String catName) {
        this.catName = catName;
        instanceCount++;
    }

    public void run(int lengthRan, String catName) {
        int maxRunLength = 200;
        if (lengthRan <= maxRunLength) {
            System.out.println("Cat " + catName + " ran " + lengthRan + " m");
        } else {
            System.err.println(catName + " can't run more than 200 m!");
        }
    }

    public void swim(int length, String catName) {
        System.err.println(catName + " can't swim!");
    }

    public String getCatName() {
        return catName;
    }

    public static int getInstanceCount() {
        return instanceCount;
    }

}

class Dog extends Animal {
    private String dogName;
    private static int instanceCount = 0;

    public Dog(String dogName) {
        this.dogName = dogName;
        instanceCount++;
    }

    public void run(int lengthRan, String dogName) {
        int maxRunLength = 500;
        if (lengthRan <= maxRunLength) {
            System.out.println("Dog " + dogName + " ran " + lengthRan + " m");
        } else {
            System.err.println(dogName + " can't run more than " + maxRunLength + " m!");
        }
    }

    public void swim(int lengthSwam, String dogName) {
        int maxSwimLength = 10;
        if (lengthSwam <= maxSwimLength) {
            System.out.println("Dog " + dogName + " swam " + lengthSwam + "m");
        } else {
            System.err.println(dogName + " can't swim more than " + maxSwimLength + " m!");
        }
    }

    public String getDogName() {
        return dogName;
    }

    public static int getInstanceCount() {
        return instanceCount;
    }

}
