package lesson5.homework9;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        ArrayValueCalculator calculator = new ArrayValueCalculator();
        TwoDimensionalArrayFiller arrayFiller = new TwoDimensionalArrayFiller();
        TwoDimensionalArrayMaker arrayMaker = new TwoDimensionalArrayMaker(new String[3][4]);

        arrayFiller.fillArrayOfStrings(arrayMaker.getTwoDimensionalArray(), new Random());
        try {
            calculator.doCalc(arrayMaker.getTwoDimensionalArray());
        } catch (ArraySizeException | ArrayDataException e) {
            e.printStackTrace();
        }
    }
}
