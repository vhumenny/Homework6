package lesson8.homework12.petrolStation;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class PetrolStation implements Runnable {
    private static AtomicInteger amount = new AtomicInteger((int) 100f);
    private float amountToTake;
    private int consumerNumber;
    private Semaphore semaphore;
    private static final Object lock = new Object();

    public void doRefuel(float amountToTake) {
        Random random = new Random();
        try {
            semaphore.acquire(1);
            System.out.println("Consumer " + consumerNumber + " came to the petrol station");
            synchronized (lock) {
                if (amountToTake > amount.floatValue()) {
                    throw new RuntimeException("Not enough fuel on Petrol station for Consumer " + consumerNumber
                            + ". There's only " + amount.intValue() + " left.");
                } else {
                    System.out.println("Consumer " + consumerNumber + " started refueling");
                    Thread.sleep(random.nextInt(3000, 10000));
                    amount.getAndAdd((int) -amountToTake);
                    System.out.println("Consumer " + consumerNumber + " finished refueling");
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release(1);
        }
    }

    @Override
    public void run() {
        doRefuel(this.amountToTake);
    }

    public PetrolStation(float amountToTake, int requestNumber, Semaphore semaphore) {
        this.amountToTake = amountToTake;
        this.consumerNumber = requestNumber;
        this.semaphore = semaphore;
    }
}

