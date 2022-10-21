package lesson5.homework9;

import lesson5.homework9.arrayMethods.ArrayValueCalculator;
import lesson5.homework9.arrayMethods.TwoDimensionalArrayFiller;
import lesson5.homework9.arrayMethods.TwoDimensionalArrayMaker;
import lesson5.homework9.exceptions.ArrayDataException;
import lesson5.homework9.exceptions.ArraySizeException;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayValueCalculator calculator = new ArrayValueCalculator();
        TwoDimensionalArrayFiller arrayFiller = new TwoDimensionalArrayFiller();
        TwoDimensionalArrayMaker arrayMaker = new TwoDimensionalArrayMaker(new String[4][4]);

        try {
            arrayFiller.fillArrayOfStrings(arrayMaker.getTwoDimensionalArray(), new Random());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        try {
            calculator.doCalc(arrayMaker.getTwoDimensionalArray());
        } catch (ArraySizeException | ArrayDataException e) {
            e.printStackTrace();
        }
    }
}