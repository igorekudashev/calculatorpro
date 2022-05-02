import java.util.*;
public class Main {
    private static final TreeMap<Integer, String> numeralsMap = new TreeMap<>() {{
        int[] arabs = {100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < 9; i++) put(arabs[i], romans[i]);
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
        int index = List.of("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "XI", "X").indexOf(romanNumber);
        if (index == -1) throw new IllegalArgumentException();
        else return index + 1;
    }
    private static String arabicToRoman(int arabicNumber) {
        if (arabicNumber <= 0) throw new IllegalArgumentException();
        int floorValue = numeralsMap.floorKey(arabicNumber);
        return arabicNumber == floorValue ? numeralsMap.get(arabicNumber) : numeralsMap.get(floorValue) + arabicToRoman(arabicNumber - floorValue);
    }
}