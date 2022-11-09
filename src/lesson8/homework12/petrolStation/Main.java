package lesson8.homework12.petrolStation;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger amount = new AtomicInteger((int) 50f);
        Semaphore semaphore = new Semaphore(3);
        Thread thread1 = new Thread(new PetrolStation(30f, 1, semaphore, amount));
        Thread thread2 = new Thread(new PetrolStation(30f, 2, semaphore, amount));
        Thread thread3 = new Thread(new PetrolStation(45f, 3, semaphore, amount));
        Thread thread4 = new Thread(new PetrolStation(25f, 4, semaphore, amount));
        Thread thread5 = new Thread(new PetrolStation(60f, 5, semaphore, amount));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
