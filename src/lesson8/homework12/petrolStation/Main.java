package lesson8.homework12.petrolStation;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(3);
        Thread thread1 = new Thread(new PetrolStationConsumer(5, 1, semaphore));
        Thread thread2 = new Thread(new PetrolStationConsumer(10, 2, semaphore));
        Thread thread3 = new Thread(new PetrolStationConsumer(90, 3, semaphore));
        Thread thread4 = new Thread(new PetrolStationConsumer(30, 4, semaphore));
        Thread thread5 = new Thread(new PetrolStationConsumer(10, 5, semaphore));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
