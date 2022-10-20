package lesson5.homework9;

public class ArrayMaker {
    private String[][] twoDimensionalArray;
//    private int sumResult = 0;

    public ArrayMaker(String[][] twoDimensionalArray) {
        this.twoDimensionalArray = twoDimensionalArray;
    }

    public String[][] getTwoDimensionalArray() {
        return twoDimensionalArray;
    }

    public void setTwoDimensionalArray(String[][] twoDimensionalArray) {
        this.twoDimensionalArray = twoDimensionalArray;
    }

//    public int getSumResult() {
//        return sumResult;
//    }
//
//    public void setSumResult(int sumResult) {
//        this.sumResult = sumResult;
//    }
}