import java.util.*;
public class Main {
    private static final TreeMap<Integer, String> numeralsMap = new TreeMap<>() {{
        for (int i = 0; i < 9; i++) put(new int[] {100, 90, 50, 40, 10, 9, 5, 4, 1}[i], new String[] {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"}[i]);
    }};
    public static void main(String[] args) {
        System.out.println(calc(new Scanner(System.in).nextLine()));
    }
    public static String calc(String input) {
        try {
            return String.valueOf(apply(Integer.parseInt(input.split("\\s", 3)[0]), Integer.parseInt(input.split("\\s", 3)[2]), input.split("\\s", 3)[1]));
        } catch (NumberFormatException ignored) {
            return arabicToRoman(apply(romanToArabic(input.split("\\s", 3)[0]), romanToArabic(input.split("\\s", 3)[2]), input.split("\\s", 3)[1]));
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
        if (arabicNumber <= 1) throw new IllegalArgumentException();
        int floorValue = numeralsMap.floorKey(arabicNumber);
        return arabicNumber == floorValue ? numeralsMap.get(arabicNumber) : numeralsMap.get(floorValue) + arabicToRoman(arabicNumber - floorValue);
    }
}