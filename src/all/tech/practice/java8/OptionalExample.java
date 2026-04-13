package all.tech.practice.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");
        list.add("date");
        list.add("fig");
        list.add("grape");

        Map<Integer, List<String>> map = list.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(map);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(23);
        numbers.add(22);
        numbers.add(1);
        numbers.add(20);
        numbers.add(3);
        Optional<Integer> result = numbers.stream().filter(x -> x % 2 == 0).findFirst();
        result.ifPresent(System.out::println);

    }
}
