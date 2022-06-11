import java.util.*;
import java.util.function.IntBinaryOperator;
public class Main {
    private static final List<String> romans = List.of("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X");
    private static final Map<String, IntBinaryOperator> operations = Map.of("+", Integer::sum, "-", (a, b) -> a - b, "*", (a, b) -> a * b, "/", (a, b) -> a / b);
    private static final TreeMap<Integer, String> map = new TreeMap<>(Map.of(100, "C", 90, "XC", 50, "L", 40, "XL", 10, "X", 9, "IX", 5, "V", 4, "IV", 1, "I"));
    public static void main(String[] args) {
        System.out.println(calc(new Scanner(System.in).nextLine()));
    }
    public static String calc(String input) {
        String[] parts = input.split("\\s", 3);
        try {
            return String.valueOf(apply(Integer.parseInt(parts[0]), Integer.parseInt(parts[2]), parts[1]));
        } catch (NumberFormatException ignored) {
            return arabicToRoman(apply(romans.indexOf(parts[0]) + 1, romans.indexOf(parts[2]) + 1, parts[1]));
        }
    }
    private static int apply(int a, int b, String operation) {
        if (a < 1 || a > 10 || b < 1 || b > 10) throw new IllegalArgumentException();
        return operations.get(operation).applyAsInt(a, b);
    }
    private static String arabicToRoman(int arab) {
        return arab == map.floorKey(arab) ? map.get(arab) : map.get(map.floorKey(arab)) + arabicToRoman(arab - map.floorKey(arab));
    }
}