package lesson8.homework11;

public class arrayPart2Filler implements Runnable {

    @Override
    public void run() {

        for (int i = 0; i < ValueCalculator.getHalfArrayLength(); i++) {

            ValueCalculator.getArray()[i] = (float) (ValueCalculator.getArray()[i] * Math.sin(0.2f + i / 5) *
                    Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}
