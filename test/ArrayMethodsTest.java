import lesson17.homework17.ArrayMethods;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArrayMethodsTest {
    ArrayMethods arrayMethods;

    @BeforeEach
    public void beforeEachTestMethod() {
        arrayMethods = new ArrayMethods();
    }

    @Test
    public void testReturnDigitsArrayFromFour_IfArrayDoesNotContainFour_ThrowsRuntimeException() {
        int[] array = new int[]{1, 2, 2, 2, 1};
        String expectedExceptionMethod = "Number 4 not found in array";
        RuntimeException actualException = assertThrows(RuntimeException.class, () ->
                        arrayMethods.returnDigitsArrayFromFour(array),
                "Array doesn't contain 4, then method should throw RuntimeException");
        assertEquals(expectedExceptionMethod, actualException.getMessage());
    }

    @Test
    public void testReturnDigitsArrayFromFour_IfArrayContainsFour() {
        int[] array = new int[]{1, 2, 2, 4, 1};
        int[] expectedResult = new int[]{1};
        int[] actualResult = arrayMethods.returnDigitsArrayFromFour(array);
        assertEquals(Arrays.toString(expectedResult), Arrays.toString(actualResult));
    }

    @Test
    public void testReturnDigitsArrayFromFour_IfFourPlacedFirstInArray() {
        int[] array = new int[]{4, 2, 2, 7, 1};
        int[] expectedResult = new int[]{2, 2, 7, 1};
        int[] actualResult = arrayMethods.returnDigitsArrayFromFour(array);
        assertEquals(Arrays.toString(expectedResult), Arrays.toString(actualResult));
    }

    @Test
    public void testCheckIfArrayContainsOneAndFour_IfArrayContainsOneAndFour() {
        Integer[] array = new Integer[]{4, 2, 2, 7, 1};
        boolean expectedResult = true;
        boolean actualResult = arrayMethods.checkIfArrayContainsOneAndFour(array);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCheckIfArrayContainsOneAndFour_IfArrayContainsOnlyOne() {
        Integer[] array = new Integer[]{5, 2, 2, 7, 1};
        boolean expectedResult = false;
        boolean actualResult = arrayMethods.checkIfArrayContainsOneAndFour(array);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCheckIfArrayContainsOneAndFour_IfArrayContainsOnlyFour() {
        Integer[] array = new Integer[]{5, 4, 2, 7, 9};
        boolean expectedResult = false;
        boolean actualResult = arrayMethods.checkIfArrayContainsOneAndFour(array);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCheckIfArrayContainsOneAndFour_IfArrayIsEmpty() {
        Integer[] array = new Integer[]{};
        boolean expectedResult = false;
        boolean actualResult = arrayMethods.checkIfArrayContainsOneAndFour(array);
        assertEquals(expectedResult, actualResult);
    }
}
