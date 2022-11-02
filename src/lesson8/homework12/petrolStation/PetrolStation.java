package lesson8.homework12.petrolStation;

import java.util.concurrent.Semaphore;

public class PetrolStation {
    private static volatile float amount = 100;

    public void doRefuel(float amountToTake, int consumerId) {

        if (amountToTake > amount) {
            throw new RuntimeException("Not enough fuel on Petrol station. There's only " + amount + " left.");
        } else {
            try {
                System.out.println("Consumer " + consumerId + " started refueling");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        amount -= amountToTake;
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
            semaphore.release(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
