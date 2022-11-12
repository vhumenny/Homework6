package lesson12.practicum;

import java.util.Arrays;
import java.util.Random;

public class Searching {
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[]{12, 11, 10, 9, 3, 1, 4, 6, 8, 9, 11, 12, 13, 14, 22};
        int[] arr1 = new int[100000];
        int[] arr3 = new int[1000000];
        int[] arr2 = new int[100000000];
        Arrays.setAll(arr1, o -> arr1[o] = random.nextInt(0, 100000));
        Arrays.setAll(arr2, o -> arr2[o] = random.nextInt(0, 1000000));
        Arrays.setAll(arr3, o -> arr3[o] = random.nextInt(0, 100000));
//        System.out.println(sort(arr, 4));

//        Arrays.sort(arr2);
        arr1[99999] = 1000001;
        arr2[99999999] = 1000001;
        arr3[999999] = 1000001;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        Arrays.sort(arr3);

//        long startLine = System.currentTimeMillis();
//        System.out.println(Arrays.toString(arr));
//        long finishLine = System.currentTimeMillis();
        long start1 = System.currentTimeMillis();
        System.out.println(binarySearch(arr1, 1000001));
        long finish1 = System.currentTimeMillis();
        long start2 = System.currentTimeMillis();
        System.out.println(binarySearch(arr2, 1000001));
        long finish2 = System.currentTimeMillis();
        long start3 = System.currentTimeMillis();
        System.out.println(binarySearch(arr3, 1000001));
        long finish3 = System.currentTimeMillis();
        System.out.println("time 1" + (finish1 - start1));
        System.out.println("time 2" + (finish2 - start2));
        System.out.println("time 3" + (finish3 - start3));
//        System.out.println(finishLine - startLine);
    }

    public static int sort(int[] arr, int number) {
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            counter++;
            if (arr[i] == number) {
                System.out.println("Amount of operations:" + counter);
                return i;
            }
        }
        System.out.println(counter);
        return -1;
    }

    public static int binarySearch(int[] arr, int number) {
        int counter = 1;
        int current = arr.length / 2;
        int startPoint = 0;
        int endPoint = arr.length - 1;
        while (startPoint <= endPoint) {
            counter++;
            current = (startPoint + endPoint) / 2;
            if (number == arr[current]) {
                System.out.println("Amount of operations = " + counter);
                return current;
            }
            if (current <= 0 || current >= arr.length - 1) {
                System.out.println("Amount of operations = " + counter);
                return -1;
            }
            if (number > arr[current]) {
                startPoint = current + 1;
            }
            if (number < arr[current]) {
                endPoint = current - 1;
            }
        }
        System.out.println("Amount of operations = " + counter);
        return -1;
    }
}
