import java.util.*;
import java.util.function.*;
public class A {
    Function<Integer, String> f;
    public static void main(String[] a) {
        System.out.print(new A().calc(new Scanner(System.in).nextLine()));
    }
    String calc(String i) {
        var l = List.of("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X");
        Map<String, IntBinaryOperator> c = Map.of("+", (a, b) -> a + b, "-", (a, b) -> a - b, "*", (a, b) -> a * b, "/", (a, b) -> a / b);
        var d = new TreeMap<>(Map.of(100, "C", 90, "XC", 50, "L", 40, "XL", 10, "X", 9, "IX", 5, "V", 4, "IV", 1, "I"));
        f = r -> r == d.floorKey(r) ? d.get(r) : d.get(d.floorKey(r)) + f.apply(r - d.floorKey(r));
        var p = i.split(" ", 3);
        return p[0].matches("[1-9]|10") & p[2].matches("[1-9]|10")
                ? "" + c.get(p[1]).applyAsInt(Integer.parseInt(p[0]), Integer.parseInt(p[2]))
                : l.contains(p[0]) & l.contains(p[2])
                    ? f.apply(c.get(p[1]).applyAsInt(l.indexOf(p[0]) + 1, l.indexOf(p[2]) + 1))
                    : l.get(10);
    }
}