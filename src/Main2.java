import javafx.scene.control.TableColumnBase;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main2 {
    public static void main(String[] args) {
        String st = "aabbcc";
        // abc cba , bcaacb
    }

    private static List<String> search(String str) {
        //   Map<Character, Integer> map = Stream.of(str.chars()).flatMap(x -> Character.valueOf(x))
        //   .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        // Character[] strignArray= Arrays.stream(str.chars().toArray()).map();

        char[] stringArray = str.toCharArray();
        Map<Character, Integer> map = new TreeMap<>();
        for (char string : stringArray) {
            if (map.containsKey(string)) {
                map.put(string, map.get(string) + 1);
            } else {
                map.put(string, 0);
            }
        }

       /* int iter = map.size() / 2 == 0 ? (map.size() / 2) - 1 : map.size() / 2;

        StringBuilder stringBuilder = new StringBuilder();

        for(Map.Entry entry : map.entrySet()){
            stringBuilder.append(entry.get)
        }*/


        return null;
    }
}
