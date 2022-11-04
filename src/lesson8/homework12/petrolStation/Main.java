package lesson8.homework12.petrolStation;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(3);
        Thread thread1 = new Thread(new PetrolStation(10f, 1, semaphore));
        Thread thread2 = new Thread(new PetrolStation(20f, 2, semaphore));
        Thread thread3 = new Thread(new PetrolStation(15f, 3, semaphore));
        Thread thread4 = new Thread(new PetrolStation(15f, 4, semaphore));
        Thread thread5 = new Thread(new PetrolStation(10f, 5, semaphore));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
