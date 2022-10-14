package com.company.figures;

public class Square implements Figure {
    private int a;

    public Square(int a) {
        this.a = a;
    }

    public int calcArea() {
        return a * a;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}