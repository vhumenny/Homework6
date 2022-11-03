package lesson8.homework12.petrolStation;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class PetrolStation {
    private static AtomicInteger amount = new AtomicInteger((int) 100f);

    public void doRefuel(float amountToTake, int consumerId) {
        Random random = new Random();
        if (amountToTake > amount.intValue()) {
            throw new RuntimeException("Not enough fuel on Petrol station. There's only " + amount.intValue() + " left.");
        } else {
            try {
                System.out.println("Consumer " + consumerId + " started refueling");
                Thread.sleep(random.nextInt(3000, 10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        amount.getAndAdd((int) -amountToTake);
        System.out.println("Consumer " + consumerId + " finished refueling");
    }
}

class PetrolStationConsumer implements Runnable {
    private float amountToTake;
    private Semaphore semaphore;
    private PetrolStation petrolStation = new PetrolStation();
    private int consumerId;

    public PetrolStationConsumer(float amountToTake, Semaphore semaphore, int consumerId) {
        this.amountToTake = amountToTake;
        this.semaphore = semaphore;
        this.consumerId = consumerId;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire(1);
            petrolStation.doRefuel(amountToTake, consumerId);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release(1);
        }
    }
}
