package dev.igorekudashev;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(calc(scanner.nextLine()));
    }

    public static String calc(String input) {
        String[] values = input.split("\\s", 3);
        try {
            return String.valueOf(apply(
                    Integer.parseInt(values[0]),
                    Integer.parseInt(values[2]),
                    values[1]));
        } catch (NumberFormatException ignored) {
            return Converter.arabicToRoman(apply(
                    Converter.romanToArabic(values[0]),
                    Converter.romanToArabic(values[2]),
                    values[1]));
        }
    }

    private static int apply(int var1, int var2, String operation) {
        if (var1 < 1 || var1 > 10 || var2 < 1 || var2 > 10) {
            throw new IllegalArgumentException();
        }
        return switch (operation) {
            case "+" -> var1 + var2;
            case "-" -> var1 - var2;
            case "*" -> var1 * var2;
            case "/" -> var1 / var2;
            default -> throw new IllegalArgumentException();
        };
    }
}