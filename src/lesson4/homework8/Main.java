package lesson4.homework8;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Let's check if string contains a char 's'. \nPlease enter the string: ");
        String string = scanner.next();
        char a = 's';
        System.out.println("Char " + a + " found " + findSymbolOccurance(string, a) + " times in string " + string);

        System.out.println("Let's check if string 'target' is a part of string 'source'. \nPlease enter two strings: ");
        String source = scanner.next();
        String target = scanner.next();
        System.out.println("Result: " + findWordPosition(source, target));

        System.out.println("Enter the string to be reversed: ");
        String r = scanner.next();
        System.out.println(stringReverse(r));

        System.out.println("Please enter the string to check if it's palindrome: ");
        String p = scanner.next();


    }

    public static int findSymbolOccurance(String string, char a) {
        int symbolCounter = 0;

        for (int i = 0; i < string.length(); i++) {
            string.charAt(i);
            if (string.charAt(i) == a) {
                symbolCounter++;
            }
        }
        return symbolCounter;
    }

    public static int findWordPosition(String source, String target) {
        return source.indexOf(target);
    }

    public static String stringReverse(String r) {
        char[] array = r.toCharArray();
        String reversed = "";

        for (int i = array.length - 1; i >= 0; i--) {
            reversed = reversed + array[i];
        }
        return reversed;
    }

    public static boolean isPalindrome(String p){

    }
}
