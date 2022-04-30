package dev.igorekudashev;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println(calc(new Scanner(System.in).nextLine()));
    }

    public static String calc(String input) {
        String[] parts = input.split("\\s", 3);
        try {
            return String.valueOf(apply(Integer.parseInt(parts[0]), Integer.parseInt(parts[2]), parts[1]));
        } catch (NumberFormatException ignored) {
            return Converter.arabicToRoman(apply(Converter.romanToArabic(parts[0]), Converter.romanToArabic(parts[2]), parts[1]));
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
}