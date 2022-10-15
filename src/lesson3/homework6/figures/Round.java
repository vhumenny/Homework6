package lesson3.homework6.figures;

public class Round implements Figure {
    private int r;

    public Round(int r) {
        this.r = r;
    }

    public int calcArea() {
        return Math.round(3.14f * r * r);
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }
}
