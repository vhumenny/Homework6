package lesson8.homework12.threadSafeList;

import java.util.ArrayList;

public class ThreadSafeList {
    private static final Object lock = new Object();
    private ArrayList<Integer> arrayList = new ArrayList<>();

    public void add(int index, Integer number) {
        synchronized (lock) {
            arrayList.add(index, number);
        }
    }

    public void get(int index) {
        synchronized (lock) {
            System.out.println(arrayList.get(index));
        }
    }

    public void remove(int index) {
        synchronized (lock) {
            arrayList.remove(index);
        }
    }
}

class ArrayListThread implements Runnable {
    ThreadSafeList threadSafeList = new ThreadSafeList();
    private int index;
    private int number;

    @Override
    public void run() {
        threadSafeList.add(index, number);
        threadSafeList.get(index);
        threadSafeList.remove(index);

    }

    public ArrayListThread(int index, int number) {
        this.index = index;
        this.number = number;
    }

}
