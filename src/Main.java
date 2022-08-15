import java.util.*;
import java.util.function.*;
public class Main{
    static List<Function<Integer,String>>a=new ArrayList<>(){{add((arab)->arab.equals(d.floorKey(arab))?d.get(arab):d.get(d.floorKey(arab))+get(0).apply(arab-d.floorKey(arab)));}};
    static List<String>b=List.of("I","II","III","IV","V","VI","VII","VIII","IX","X");
    static Map<String,IntBinaryOperator>c=Map.of("+",Integer::sum,"-",(a,b)->a-b,"*",(a,b)->a*b,"/",(a,b)->a/b);
    static TreeMap<Integer,String>d=new TreeMap<>(Map.of(100,"C",90,"XC",50,"L",40,"XL",10,"X",9,"IX",5,"V",4,"IV",1,"I"));
    public static void main(String[]args){
        System.out.println(calc(new Scanner(System.in).nextLine()));
    }
    static String calc(String i){
        String[]p=i.split("\\s",3);
        return p[0].matches("[1-9]|10")&&p[2].matches("[1-9]|10")?String.valueOf(c.get(p[1]).applyAsInt(Integer.parseInt(p[0]),Integer.parseInt(p[2]))):b.contains(p[0])&&b.contains(p[2])?a.get(0).apply(c.get(p[1]).applyAsInt(b.indexOf(p[0])+1,b.indexOf(p[2])+1)):b.get(b.indexOf("."));
    }
}