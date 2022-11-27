package lesson12.practicum;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        int[] arr = new int[]{12, 11, 10, 9, 3, 1, 4, 6, 8, 9, 11, 12, 13, 14, 22};
        int[] arr1 = new int[1000];
        int[] arr2 = new int[1000000];
        Arrays.setAll(arr1, o -> arr1[o] = random.nextInt(0, 1000));
        Arrays.setAll(arr2, o -> arr2[o] = random.nextInt(0, 1000));

//        System.out.println(sort(arr));
//        System.out.println(sort(arr1));
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(arr1));
        long start = System.currentTimeMillis();
//        Arrays.sort(arr2);
        System.out.println(sort(arr2));
        long finish = System.currentTimeMillis();
        System.out.println(finish - start);
    }

    public static int sort(int[] array) {

        int counter = 1;
        for (int i = 1; i < array.length; i++) {
            counter++;
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    int number = array[j - 1];
                    array[j - 1] = array[j];
                    counter++;
                    array[j] = number;
                    counter++;
                }
            }
        }
        return counter;
    }
}


