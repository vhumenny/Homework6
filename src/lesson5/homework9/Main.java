package lesson5.homework9;

import lesson5.homework9.arrayMethods.ArrayValueCalculator;
import lesson5.homework9.arrayMethods.TwoDimensionalArrayFiller;
import lesson5.homework9.exceptions.ArrayDataException;
import lesson5.homework9.exceptions.ArraySizeException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[][] array = new String[4][4];
        Scanner scanner = new Scanner(System.in);

        ArrayValueCalculator calculator = new ArrayValueCalculator();
        TwoDimensionalArrayFiller arrayFiller = new TwoDimensionalArrayFiller();

        try {
            arrayFiller.fillArrayOfStrings(array, scanner);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        try {
            calculator.doCalc(array);
        } catch (ArraySizeException | ArrayDataException e) {
            e.printStackTrace();
        }
    }
}