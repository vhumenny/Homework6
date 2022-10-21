package lesson5.homework9.arrayMethods;

import java.util.Scanner;

public class TwoDimensionalArrayFiller {
    public String[][] fillArrayOfStrings(String[][] array, Scanner scanner) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.println("Please enter a digit between 0 and 100:");
                int number = scanner.nextInt();
                if (number > 100 || number < 0) {
                    throw new IllegalArgumentException("Number must be between 0 and 100.");
                }
                array[i][j] = String.valueOf(number);
            }
        }
        return array;
    }
}