import java.util.*;
import java.util.function.*;
public class A {
    static Function<Integer, String> f;
    public static void main(String[] a) {
        System.out.print(calc(new Scanner(System.in).nextLine()));
    }
    static String calc(String i) {
        var l = List.of(" ", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X");
        var c = Map.of("+", (BinaryOperator<Integer>)(a, b) -> a + b, "-", (a, b) -> a - b, "*", (a, b) -> a * b, "/", (a, b) -> a / b);
        var d = new TreeMap<>(Map.of(100, "C", 90, "XC", 50, "L", 40, "XL", 10, "X", 9, "IX", 5, "V", 4, "IV", 1, "I"));
        f = r -> r == d.floorKey(r) ? d.get(r) : d.get(d.floorKey(r)) + f.apply(r - d.floorKey(r));
        var p = i.split(" ", 3);
        var e = "[1-9]|10";
        return p[0].matches(e) & p[2].matches(e)
                ? "" + c.get(p[1]).apply(Integer.valueOf(p[0]), Integer.valueOf(p[2]))
                : f.apply(c.get(p[1]).apply(l.indexOf(p[0]), l.indexOf(p[2])));
    }
}