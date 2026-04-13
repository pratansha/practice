package all.tech.practice.java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AnagramGroupFromArray {
    public static void main(String[] args) {
        findAnagramPairs("eat", "tea", "tan", "ate", "nat", "bat");
    }

    //1st way to solve it...
    private static void findAnagramPairs(String... arr) {
        Map<String, List<String>> map = Arrays.stream(arr).collect(Collectors.groupingBy(AnagramGroupFromArray::findStringFromChars));
        System.out.println(map);
        map.values().stream().flatMap(Collection::stream).forEach(System.out::println);
    }

    private static String findStringFromChars(String str) {
        int[] temp = new int[26];
        for (int i = 0; i < str.length(); i++) {
            temp[str.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append((char) (i + 'a')).append(i).append("#");
        }
        return sb.toString();
    }

    // 2nd way to solve it .
    private static void findAnagramPairs2(String... arr) {
        Map<Integer, List<String>> map = Arrays.stream(arr).collect(Collectors.groupingBy(AnagramGroupFromArray::findSumOfChars));
        System.out.println(map);
        map.values().stream().flatMap(Collection::stream).forEach(System.out::println);
    }

    private static int findSumOfChars(String str) {
        return IntStream.range(0, str.length()).map(i -> (int) str.charAt(i)).sum();
    }

}
