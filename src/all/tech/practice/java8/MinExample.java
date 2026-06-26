package all.tech.practice.java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

// All Min function used in java-8
public class MinExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(6, 5, 20, 2, 1);

        Comparator<Integer> comparator1 = Integer::compareTo; // Integer::compare means => (x,y)->Integer.compare(x,y);
        Comparator<Integer> comparator2 = Integer::compareTo;

        // Example:1 min takes Comparator in
        Optional<Integer> min1 = numbers.stream().min(comparator1);
        Optional<Integer> min2 = numbers.stream().min(comparator2);

        Optional<Integer> max = numbers.stream().max(Integer::compare);

        min1.ifPresent(v -> System.out.println("min1 = " + v));
        min2.ifPresent(v -> System.out.println("min2 = " + v));
        max.ifPresent(v -> System.out.println("max = " + v));

        String str = "i love my india";
        //str.chars();
        Map<String, Long> count = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(count);
    }
}