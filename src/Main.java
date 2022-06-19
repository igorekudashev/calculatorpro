import java.util.*;
import java.util.function.*;
public class Main {
    private static final List<Function<Integer, String>> arabicToRomanWrapper = new ArrayList<>() {{add((arab) -> arab.equals(map.floorKey(arab)) ? map.get(arab) : map.get(map.floorKey(arab)) + get(0).apply(arab - map.floorKey(arab)));}};
    private static final List<String> romans = List.of("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X");
    private static final Map<String, IntBinaryOperator> operations = Map.of("+", Integer::sum, "-", (a, b) -> a - b, "*", (a, b) -> a * b, "/", (a, b) -> a / b);
    private static final TreeMap<Integer, String> map = new TreeMap<>(Map.of(100, "C", 90, "XC", 50, "L", 40, "XL", 10, "X", 9, "IX", 5, "V", 4, "IV", 1, "I"));
    public static void main(String[] args) {
        System.out.println(calc(new Scanner(System.in).nextLine()));
    }
    public static String calc(String input) {
        String[] parts = input.split("\\s", 3);
        return parts[0].matches("[1-9]|10") && parts[2].matches("[1-9]|10") ? String.valueOf(operations.get(parts[1]).applyAsInt(Integer.parseInt(parts[0]), Integer.parseInt(parts[2]))) : romans.contains(parts[0]) && romans.contains(parts[2]) ? arabicToRomanWrapper.get(0).apply(operations.get(parts[1]).applyAsInt(romans.indexOf(parts[0]) + 1, romans.indexOf(parts[2]) + 1)) : romans.get(romans.indexOf("."));
    }
}
