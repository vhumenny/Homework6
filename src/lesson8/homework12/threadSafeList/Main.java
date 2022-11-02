package lesson8.homework12.threadSafeList;

public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new ArrayListThread(0, 1));
        Thread thread2 = new Thread(new ArrayListThread(0, 1));
        Thread thread3 = new Thread(new ArrayListThread(0, 1));

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
