package lesson8.homework11;

public class Main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ValueCalculator valueCalculator = new ValueCalculator();

        System.out.println("Total time spent by method doCalc() = " + valueCalculator.doCalc() + " milliseconds");
        long finish = System.currentTimeMillis();
        System.out.println("Total time spent by the program = " + (finish - start) + " milliseconds");
    }
}
