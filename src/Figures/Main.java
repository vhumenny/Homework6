package Figures;

public class Main {
    public static void main(String[] args) {
        Figure square = new Square();
        Figure round = new Round();
        T triangle = new Triangle();

       Object[] array = new Object[3];
        array[0]=square;
        array[0]=square.calcArea(3);
        array[1]=round;
        array[1]=
        array[2]=triangle;


        countAllAreas(array, square, round, triangle);
    }

    public static void countAllAreas(Figure[] array, Square square, Round round, Triangle triangle) {
        int sumSquare;
        sumSquare = array[0].calcArea();

//        for (Figure f: array) {
//            sumSquare=sumSquare+ Figure.calcArea();
//        }
//        System.out.println(sumSquare);

//        int sumSquare = Square.calcAreaFigure(3) + Round.calcAreaFigure(2, 3.14f) + Triangle.calcAreaFigure(4, 5);
//        System.out.println("Area of all figures is= "+sumSquare);
    }
}

interface Figure {
    int area = 0;

    public int calcArea();
}

class Square implements Figure {
    private int area;
    public int calcArea(int a) {
        return a * a;
    }

    public int getArea() {
        return area;
    }
}

class Round implements Figure {
    private int area;

    public int calcArea(int r, float p) {
        return Math.round(p * r * r);
    }

    public int getArea() {
        return area;
    }
}

class Triangle implements Figure {

    private int area;
    public int calcArea(int a, int h) {
        return Math.round(0.5f * a * h);
    }

    public int getArea() {
        return area;
    }
}