package dev.igorekudashev;

import java.util.List;
import java.util.TreeMap;

public class Converter {

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

    public static int romanToArabic(String romanNumber) {
        int index = romanNumerals.indexOf(romanNumber);
        if (index == -1) throw new IllegalArgumentException();
        else return index + 1;
    }

    public static String arabicToRoman(int arabicNumber) {
        if (arabicNumber <= 1) throw new IllegalArgumentException();
        int floorValue = numeralsMap.floorKey(arabicNumber);
        return arabicNumber == floorValue
                ? numeralsMap.get(arabicNumber)
                : numeralsMap.get(floorValue) + arabicToRoman(arabicNumber - floorValue);
    }
}