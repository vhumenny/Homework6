package lesson8.homework12.petrolStation;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class PetrolStation {
    private static AtomicInteger amount = new AtomicInteger((int) 100f);

    public void doRefuel(PetrolStationConsumer consumer) {
        Random random = new Random();
        Semaphore semaphore = consumer.getSemaphore();

        try {
            semaphore.acquire(1);
            if (consumer.getAmountToTake() > amount.intValue()) {
                throw new RuntimeException("Not enough fuel on Petrol station for Consumer " + consumer.getConsumerId()
                        + ". There's only " + amount.intValue() + " left.");
            } else {
                System.out.println("Consumer " + consumer.getConsumerId() + " started refueling");
                amount.getAndAdd((int) -consumer.getAmountToTake());
                Thread.sleep(random.nextInt(3000, 10000));
                System.out.println("Consumer " + consumer.getConsumerId() + " finished refueling");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release(1);
        }
    }
}

class PetrolStationConsumer implements Runnable {
    private float amountToTake;
    private PetrolStation petrolStation = new PetrolStation();
    private int consumerId;
    private Semaphore semaphore;

    public PetrolStationConsumer(float amountToTake, int consumerId, Semaphore semaphore) {
        this.amountToTake = amountToTake;
        this.consumerId = consumerId;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        petrolStation.doRefuel(this);
    }

    public float getAmountToTake() {
        return amountToTake;
    }

    public int getConsumerId() {
        return consumerId;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

}
