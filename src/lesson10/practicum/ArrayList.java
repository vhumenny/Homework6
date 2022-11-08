package lesson10.practicum;

import java.util.Arrays;

public class ArrayList implements MyList {

    private final int stepSize = 10;
    private int currentPosition = 0;

    private Object[] internalArray = new Object[stepSize];

    @Override
    public boolean add(Object e) {
        if (currentPosition < internalArray.length - 1) {
            internalArray[currentPosition++] = e;
        } else {
            Object[] newArray = new Object[internalArray.length + stepSize];
            System.arraycopy(internalArray, 0, newArray, 0, internalArray.length);
            newArray[currentPosition++] = e;
            internalArray = newArray;
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < currentPosition; i++) {
            if (internalArray[i].equals(o)) {
                System.arraycopy(internalArray, i + 1, internalArray, i, internalArray.length - i - 1);
                internalArray[internalArray.length - 1] = null;
                break;
            }
        }
        return true;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(internalArray, currentPosition);
    }

    @Override
    public boolean isEmpty() {
        return currentPosition == 0;
    }

    @Override
    public int size() {
        return currentPosition;
    }

    @Override
    public void clear() {
        for (int i = 0; i < stepSize; i++) {
            internalArray[i] = null;
        }

    }

    @Override
    public Object get(int index) {
        if (index <= currentPosition) {
            return internalArray[index];
        } else {
            throw new IndexOutOfBoundsException("Index " + index + "is bigger than " + currentPosition);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringForPrint = new StringBuilder("ArrayList: {");
        for (Object o : internalArray) {
            stringForPrint.append(o).append(",");
        }
        stringForPrint.append("}");
        return stringForPrint.toString();
    }
}
