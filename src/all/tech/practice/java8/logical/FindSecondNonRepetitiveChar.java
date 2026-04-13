package all.tech.practice.java8.logical;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

// Find 2nd Non-Repetitive Char in a given String.
public class FindSecondNonRepetitiveChar {
    public static void main(String[] args) {
        String str = "swiss-orange";  // Output = i
        System.out.println(str.chars().mapToObj(i -> (char) i).collect(Collectors.groupingBy(x -> x, Collectors.counting())));

        Optional<Map.Entry<Character, Long>> optionalEntry = str.chars().mapToObj(input -> (char) input)
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .skip(1)
                .findFirst();

        optionalEntry.ifPresent(characterLongEntry -> System.out.println(characterLongEntry.getKey()));
    }
}