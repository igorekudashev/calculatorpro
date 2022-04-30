package dev.igorekudashev;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Converter {

    private static final String[] romanNumbers = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "XI", "X"};

    private static final TreeMap<Integer, String> arabicToRomanMap = new TreeMap<>() {{
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
        List<String> test = new ArrayList<>();


        for (int i = 0; i < romanNumbers.length; i++) {
            if (romanNumbers[i].equals(romanNumber.toUpperCase())) {
                return i + 1;
            }
        }
        throw new IllegalArgumentException();
    }

    public static String arabicToRoman(int arabicNumber) {
        int floorValue = arabicToRomanMap.floorKey(arabicNumber);
        return arabicNumber == floorValue
                ? arabicToRomanMap.get(arabicNumber)
                : arabicToRomanMap.get(floorValue) + arabicToRoman(arabicNumber - floorValue);
    }
}