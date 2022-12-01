import java.util.*;
import java.util.function.*;
public final class Main {
    public static final Function<Integer, String> arabToRomanFunc = (b) -> b.equals(Main.arabToRomanMap.floorKey(b)) ? Main.arabToRomanMap.get(b) : Main.arabToRomanMap.get(Main.arabToRomanMap.floorKey(b)) + Main.arabToRomanFunc.apply(b - Main.arabToRomanMap.floorKey(b));;
    public static final List<String> romans = List.of("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X");
    public static final Map<String, IntBinaryOperator> operations = Map.of("+", Integer::sum, "-", (a, b) -> a - b, "*", (a, b) -> a * b, "/", (a, b) -> a / b);
    public static final TreeMap<Integer, String> arabToRomanMap = new TreeMap<>(Map.of(100, "C", 90, "XC", 50, "L", 40, "XL", 10, "X", 9, "IX", 5, "V", 4, "IV", 1, "I"));
    public static void main(String[] args) {
        System.out.println(calc(new Scanner(System.in).nextLine()));
    }
    public static String calc(String input) {
        var parts = input.split(" ",3);
        return parts[0].matches("[1-9]|10") && parts[2].matches("[1-9]|10") ? "" + operations.get(parts[1]).applyAsInt(Integer.parseInt(parts[0]), Integer.parseInt(parts[2])) : romans.contains(parts[0]) && romans.contains(parts[2]) ? arabToRomanFunc.apply(operations.get(parts[1]).applyAsInt(romans.indexOf(parts[0]) + 1, romans.indexOf(parts[2]) + 1)) : romans.get(10);
    }
}