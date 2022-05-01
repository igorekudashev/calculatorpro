package dev.igorekudashev;

import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    private static final List<String> romanNumerals = List.of("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "XI", "X");
    private static final TreeMap<Integer, String> numeralsMap = new TreeMap<>() {{
        put(100, "C");
        put(90, "XC");
        put(50, "L");
        put(40, "XL");
        put(10, "X");
        put(9, "IX");
        put(5, "V");
        put(4, "IV");
        put(1, "I");
    }};

    public static void main(String[] args) {
        System.out.println(calc(new Scanner(System.in).nextLine()));
    }

    public static String calc(String input) {
        String[] parts = input.split("\\s", 3);
        try {
            return String.valueOf(apply(Integer.parseInt(parts[0]), Integer.parseInt(parts[2]), parts[1]));
        } catch (NumberFormatException ignored) {
            return arabicToRoman(apply(romanToArabic(parts[0]), romanToArabic(parts[2]), parts[1]));
        }
    }

    private static int apply(int var1, int var2, String operation) {
        if (var1 < 1 || var1 > 10 || var2 < 1 || var2 > 10) throw new IllegalArgumentException();
        return switch (operation) {
            case "+" -> var1 + var2;
            case "-" -> var1 - var2;
            case "*" -> var1 * var2;
            case "/" -> var1 / var2;
            default -> throw new IllegalArgumentException();
        };
    }

    private static int romanToArabic(String romanNumber) {
        int index = romanNumerals.indexOf(romanNumber);
        if (index == -1) throw new IllegalArgumentException();
        else return index + 1;
    }

    private static String arabicToRoman(int arabicNumber) {
        if (arabicNumber <= 1) throw new IllegalArgumentException();
        int floorValue = numeralsMap.floorKey(arabicNumber);
        return arabicNumber == floorValue
                ? numeralsMap.get(arabicNumber)
                : numeralsMap.get(floorValue) + arabicToRoman(arabicNumber - floorValue);
    }
}