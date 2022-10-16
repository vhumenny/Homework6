package lesson4.homework7;

import java.util.Scanner;

public class HomeWorkApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printThreeWords();

        checkSumSign(scanner);

        printColor(scanner);

        compareNumbers(scanner);

        System.out.println("Let's check if the sum of two numbers is between 10 and 20. \nEnter number c: ");
        int c = scanner.nextInt();
        System.out.println("Enter number d: ");
        int d = scanner.nextInt();
        checkNumbers(c, d);


        System.out.println("Enter number e, to check if it's positive or negative: ");
        int e = scanner.nextInt();
        checkIfPositive(e);

        System.out.println("Enter number f, to check if it's negative: ");
        int f = scanner.nextInt();
        checkIfNegative(f);

        System.out.println("Enter how many times you want print the string: ");
        int g = scanner.nextInt();
        System.out.println("Enter the string to print: ");
        String string = scanner.next();
        printString(string, g);

        checkIfYearIsLeap(scanner);
    }

    public static void printThreeWords() {
        System.out.println("Orange \nBanana \nApple");
    }

    public static void checkSumSign(Scanner scanner) {
        System.out.println("Let's check if the sum of two numbers is positive or negative. \nPlease enter number a:");
        int a = scanner.nextInt();
        System.out.println("please enter number b:");
        int b = scanner.nextInt();

        if (a + b >= 0) System.out.println("Sum is positive.");
        else System.out.println("Sum is negative.");
    }

    public static void printColor(Scanner scanner) {
        System.out.println("please enter the number to print specified color: ");
        int value = scanner.nextInt();

        if (value <= 0) System.out.println("Red");
        if (value > 0 && value <= 100) System.out.println("Yellow");
        if (value > 100) System.out.println("Green");
    }

    public static void compareNumbers(Scanner scanner) {
        System.out.println("Let's compare two numbers. \nPlease enter number a:");
        int a = scanner.nextInt();
        System.out.println("please enter number b:");
        int b = scanner.nextInt();

        if (a >= b) System.out.println("a>=b");
        else System.out.println("a<b");
    }

    public static boolean checkNumbers(int c, int d) {
        int a = c + d;
        return a >= 10 && a <= 20;
    }

    public static void checkIfPositive(int e) {
        if (e >= 0) System.out.println("The number " + e + " is positive.");
        else System.out.println("The number " + e + " is negative.");
    }

    public static boolean checkIfNegative(int f) {
        return f < 0;
    }

    public static void printString(String string, int g) {
        for (int i = 0; i < g; i++) {
            System.out.println(string);
        }
    }

    public static boolean checkIfYearIsLeap(Scanner scanner) {
        System.out.println("Let's check if the year is leap. \nPlease enter the year: ");
        int year = scanner.nextInt();
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }
}
