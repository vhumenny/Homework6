import lesson17.homework17.SimpleMathLibrary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SimpleMathLibraryTest {
    SimpleMathLibrary simpleMathLibrary;

    @BeforeEach
    public void beforeEachTestMethod() {
        simpleMathLibrary = new SimpleMathLibrary();
    }

    @Test
    public void testAddPositiveNumbers() {
        double a = 1.1;
        double b = 1.2;
        double expectedResult = 2.30;
        double actualResult = simpleMathLibrary.add(a, b);
        if (expectedResult == actualResult) System.out.println("OK");
        else System.out.println("Not OK");
    }

    @Test
    public void testAddNegativeNumbers() {
        double a = -3.5;
        double b = -2.2;
        double expectedResult = -5.70;
        double actualResult = simpleMathLibrary.add(a, b);
        if (expectedResult == actualResult) System.out.println("OK");
        else System.out.println("Not OK");
    }

    @Test
    public void testAddBigNumbers() {
        double a = 1000.1;
        double b = 3400.2;
        double expectedResult = 4400.30;
        double actualResult = simpleMathLibrary.add(a, b);
        if (expectedResult == actualResult) System.out.println("OK");
        else System.out.println("Not OK");
    }

    @Test
    public void testAddZero() {
        double a = 1000.1;
        double b = 0;
        double expectedResult = 1000.10;
        double actualResult = simpleMathLibrary.add(a, b);
        if (expectedResult == actualResult) System.out.println("OK");
        else System.out.println("Not OK");
    }

    @Test
    public void testMinus() {
        double minuend = 1.1;
        double subtrahend = 2.2;
        double expectedResult = -1.1;
        double actualResult = simpleMathLibrary.minus(minuend, subtrahend);
        if (expectedResult == actualResult) System.out.println("OK");
        else System.out.println("Not OK");
    }

    @Test
    public void testMinusNegativeNumbers() {
        double minuend = -5.1;
        double subtrahend = -10.1;
        double expectedResult = 5.0;
        double actualResult = simpleMathLibrary.minus(minuend, subtrahend);
        if (expectedResult == actualResult) System.out.println("OK");
        else System.out.println("Not OK");
    }

    @Test
    public void testMinusBigNumbers() {
        double minuend = 540000.9;
        double subtrahend = 210000.4;
        double expectedResult = 330000.5;
        double actualResult = simpleMathLibrary.minus(minuend, subtrahend);
        if (expectedResult == actualResult) System.out.println("OK");
        else System.out.println("Not OK");
    }

    @Test
    public void testMinusZero() {
        double minuend = 40.9;
        double subtrahend = 0;
        double expectedResult = 40.9;
        double actualResult = simpleMathLibrary.minus(minuend, subtrahend);
        if (expectedResult == actualResult) System.out.println("OK");
        else System.out.println("Not OK");
    }

    @Test
    public void testMinusZeroAndTen() {
        double minuend = 0;
        double subtrahend = 10.9;
        double expectedResult = -10.9;
        double actualResult = simpleMathLibrary.minus(minuend, subtrahend);
        if (expectedResult == actualResult) System.out.println("OK");
        else System.out.println("Not OK");
    }
}
