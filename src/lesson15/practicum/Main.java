package lesson15.practicum;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {
    private static Map<Character, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        romanToInt("XXX");
    }

    public static int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int currentChar = map.get(s.charAt(i));

            if (i + 1 < s.length()) {
                int nextChar = map.get(s.charAt(i + 1));
                if (currentChar >= nextChar) {
                    result += currentChar;
                } else {
                    result = result + nextChar - currentChar;
                    i++;
                }
            } else result += currentChar;
        }
        return result;
    }


}

class MainTest {

    @Test
    public void testRomanToIntXII() {
        assertEquals(12, Main.romanToInt("XII"));
    }

    @Test
    public void testRomanToIntIX() {
        assertEquals(9, Main.romanToInt("IX"));
    }

    @Test
    public void testRomanToIntXIV() {
        assertEquals(14, Main.romanToInt("XIV"));
    }

    @Test
    public void testRomanToIntMMXIV() {
        assertEquals(2014, Main.romanToInt("MMXIV"));
    }

    @Test
    public void testRomanToIntMMM() {
        assertEquals(3000, Main.romanToInt("MMM"));
    }

    @Test
    public void testRomanToIntXL() {
        assertEquals(40, Main.romanToInt("XL"));
    }

    @Test
    public void testRomanToIntL() {
        assertEquals(50, Main.romanToInt("L"));
    }

    @Test
    public void testRomanToIntCD() {
        assertEquals(400, Main.romanToInt("CD"));
    }

    @Test
    public void testRomanToIntXC() {
        assertEquals(90, Main.romanToInt("XC"));
    }
}