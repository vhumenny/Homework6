package lesson5.homework9;


import java.util.Arrays;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        ArrayValueCalculator calculator = new ArrayValueCalculator();
        TwoDimensionalArrayFiller arrayFiller = new TwoDimensionalArrayFiller();
        ArrayMaker arrayMaker = new ArrayMaker(new String[4][4]);

        arrayFiller.fillArrayOfStrings(arrayMaker.getTwoDimensionalArray(), new Random());
        calculator.doCalc(arrayMaker.getTwoDimensionalArray(), arrayMaker.getSumResult());

        System.out.println(Arrays.deepToString(arrayMaker.getTwoDimensionalArray()));
        System.out.println(arrayMaker.getSumResult());
    }
}
