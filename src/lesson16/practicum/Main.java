package lesson16.practicum;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Main {
}

class MathOperation {
    ItemSource mockItemSource;

    public MathOperation(ItemSource mockItemSource) {
        this.mockItemSource = mockItemSource;
    }

    public void checkIfListIsEmpty() {
        if (mockItemSource.getItems().isEmpty()) {
            throw new IllegalStateException();
        }
    }

    Integer sum() {
        checkIfListIsEmpty();
        Integer sum = 0;
        for (Integer i : mockItemSource.getItems()) {
            sum += i;
        }
        return sum;
    }

    Integer avg() {
        checkIfListIsEmpty();
        return sum() / mockItemSource.getItems().size();
    }

    Integer max() {
        checkIfListIsEmpty();
        Integer maximum = Integer.MIN_VALUE;
        for (Integer i : mockItemSource.getItems()) {
            if (i > maximum) maximum = i;
        }
        return maximum;
    }
}

interface ItemSource {
    List<Integer> getItems();
}

class TestMathOperation {

    @Test
    public void testSum() {
        ItemSource mockItemSource = mock(ItemSource.class);
        when(mockItemSource.getItems()).thenReturn(Arrays.asList(3, 7, 11));
        MathOperation mathOperation = new MathOperation(mockItemSource);
        assertEquals(21, mathOperation.sum());
    }

    @Test
    public void testSumEmpty() throws IllegalStateException {
        ItemSource mockItemSource = mock(ItemSource.class);
        when(mockItemSource.getItems()).thenReturn(List.of());
        MathOperation mathOperation = new MathOperation(mockItemSource);
        assertThrows(IllegalStateException.class, () -> assertEquals(new IllegalStateException(), mathOperation.sum()));
    }

    @Test
    public void testSumOne() {
        ItemSource mockItemSource = mock(ItemSource.class);
        when(mockItemSource.getItems()).thenReturn(List.of(1));
        MathOperation mathOperation = new MathOperation(mockItemSource);
        assertEquals(1, mathOperation.sum());
    }

    @Test
    public void testSumNull() {
        ItemSource mockItemSource = mock(ItemSource.class);
        when(mockItemSource.getItems()).thenReturn(Arrays.asList(0, 0, 0));
        MathOperation mathOperation = new MathOperation(mockItemSource);
        assertEquals(0, mathOperation.sum());
    }

    @Test
    public void testSumMinus() {
        ItemSource mockItemSource = mock(ItemSource.class);
        when(mockItemSource.getItems()).thenReturn(Arrays.asList(-1, -2, -3));
        MathOperation mathOperation = new MathOperation(mockItemSource);
        assertEquals(-6, mathOperation.sum());
    }

    @Test
    public void testAvg() {
        ItemSource mockItemSource = mock(ItemSource.class);
        when(mockItemSource.getItems()).thenReturn(Arrays.asList(3, 7, 11));
        MathOperation mathOperation = new MathOperation(mockItemSource);
        assertEquals(7, mathOperation.avg());
    }

    @Test
    public void testAvgEmpty() throws IllegalStateException {
        ItemSource mockItemSource = mock(ItemSource.class);
        when(mockItemSource.getItems()).thenReturn(List.of());
        MathOperation mathOperation = new MathOperation(mockItemSource);
        assertThrows(IllegalStateException.class, () -> assertEquals(new IllegalStateException(), mathOperation.avg()));
    }

    @Test
    public void testAvgOne() {
        ItemSource mockItemSource = mock(ItemSource.class);
        when(mockItemSource.getItems()).thenReturn(List.of(3));
        MathOperation mathOperation = new MathOperation(mockItemSource);
        assertEquals(3, mathOperation.avg());
    }

    @Test
    public void testAvgSameNumber() {
        ItemSource mockItemSource = mock(ItemSource.class);
        when(mockItemSource.getItems()).thenReturn(Arrays.asList(1, 1, 1));
        MathOperation mathOperation = new MathOperation(mockItemSource);
        assertEquals(1, mathOperation.avg());
    }

    @Test
    public void testAvgMinus() {
        ItemSource mockItemSource = mock(ItemSource.class);
        when(mockItemSource.getItems()).thenReturn(Arrays.asList(-1, -2, -3));
        MathOperation mathOperation = new MathOperation(mockItemSource);
        assertEquals(-2, mathOperation.avg());
    }

    @Test
    public void testMax() {
        ItemSource mockItemSource = mock(ItemSource.class);
        when(mockItemSource.getItems()).thenReturn(Arrays.asList(3, 7, 11));
        MathOperation mathOperation = new MathOperation(mockItemSource);
        assertEquals(11, mathOperation.max());
    }

    @Test
    public void testMaxEmpty() throws IllegalStateException {
        ItemSource mockItemSource = mock(ItemSource.class);
        when(mockItemSource.getItems()).thenReturn(List.of());
        MathOperation mathOperation = new MathOperation(mockItemSource);
        assertThrows(IllegalStateException.class, () -> assertEquals(new IllegalStateException(), mathOperation.max()));
    }

    @Test
    public void testMaxSameNumber() {
        ItemSource mockItemSource = mock(ItemSource.class);
        when(mockItemSource.getItems()).thenReturn(Arrays.asList(1, 1, 1));
        MathOperation mathOperation = new MathOperation(mockItemSource);
        assertEquals(1, mathOperation.max());
    }

    @Test
    public void testMaxMinus() {
        ItemSource mockItemSource = mock(ItemSource.class);
        when(mockItemSource.getItems()).thenReturn(Arrays.asList(-1, -2, -3));
        MathOperation mathOperation = new MathOperation(mockItemSource);
        assertEquals(-1, mathOperation.max());
    }

    @Test
    public void testMaxOne() {
        ItemSource mockItemSource = mock(ItemSource.class);
        when(mockItemSource.getItems()).thenReturn(List.of(3));
        MathOperation mathOperation = new MathOperation(mockItemSource);
        assertEquals(3, mathOperation.max());
    }
}

