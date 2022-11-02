package lesson8.homework12.petrolStation;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(3);
        Thread thread1 = new Thread(new PetrolStationConsumer(5, semaphore, 1));
        Thread thread2 = new Thread(new PetrolStationConsumer(10, semaphore, 2));
        Thread thread3 = new Thread(new PetrolStationConsumer(90, semaphore, 3));
        Thread thread4 = new Thread(new PetrolStationConsumer(30, semaphore, 4));
        Thread thread5 = new Thread(new PetrolStationConsumer(10, semaphore, 5));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
