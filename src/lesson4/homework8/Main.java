package lesson4.homework8;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

//        System.out.println("Let's check if string contains a char 's'. \nPlease enter the string: ");
//        String string = scanner.next();
//        char a = 's';
//        System.out.println("Char " + a + " found " + findSymbolOccurance(string, a) + " times in string " + string);
//
//        System.out.println("Let's check if string 'target' is a part of string 'source'. \nPlease enter two strings: ");
//        String source = scanner.next();
//        String target = scanner.next();
//        System.out.println("Result: " + findWordPosition(source, target));
//
//        System.out.println("Enter the string to be reversed: ");
//        String r = scanner.next();
//        System.out.println(stringReverse(r));
//
//        System.out.println("Please enter the string to check if it's palindrome: ");
//        String p = scanner.next();
//        System.out.println(isPalindrome(p));

        guessTheWord(scanner, random);

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
        StringBuilder reversed = new StringBuilder();

        for (int i = array.length - 1; i >= 0; i--) {
            reversed.append(array[i]);
        }
        return reversed.toString();
    }

    public static boolean isPalindrome(String p) {
        StringBuilder reversed = new StringBuilder();

        for (int i = 0; i < p.length(); i++) {
            reversed.append(p.charAt(i));
        }
        return p.intern() == reversed.toString().intern();
    }

    public static void guessTheWord(Scanner scanner, Random random) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int numberOfHiddenWord = random.nextInt(0, words.length - 1);
        String hiddenWord = words[numberOfHiddenWord];
        String usersWord=scanner.next();
        StringBuilder stringToShow = new StringBuilder();

        while (hiddenWord.intern() != usersWord.intern()) {
            for (int i = 0; i <= hiddenWord.length(); i++) {
                if (hiddenWord.charAt(i) == usersWord.charAt(i)) stringToShow.append(usersWord.charAt(i));
                else stringToShow.append("#");
            }
            if (stringToShow.length() < 16) stringToShow.append("#");
            System.out.println(stringToShow);

            System.out.println("Please try again and guess the hidden word. Enter your word :");
            usersWord = scanner.next();


        }
        if (hiddenWord.intern() == usersWord.intern())
            System.out.println("Congratulations, you have guessed the hidden word - " + hiddenWord);
    }
}
//    contains, startWith, valueOf

//    public boolean startsWith(String prefix)
//Проверяет, начинается ли строка символами prefix с начала строки
//
//
//String str1 = "котлета";
//
//if(str1.startsWith("кот"))
//    infoTextView.setText("Слово содержит кота");
//else
//    infoTextView.setText("Плохое слово. Нет смысла его использовать");


//    public boolean contains (CharSequence cs)
//Определяет, содержит ли строка последовательность символов в CharSequence
//
//
//String testString = "котёнок";
//
//if(testString.contains("кот")){
//    infoTextView.setText("В слове котёнок содержится слово кот!");
//}
