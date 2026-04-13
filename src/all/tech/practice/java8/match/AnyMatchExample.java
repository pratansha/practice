package all.tech.practice.java8.match;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class AnyMatchExample {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        int[] arr2 = {3, 4, 5, 6};
        // Print = 3,4,5,6 .....

        // Example:1 AnyMatch Java8 : Print common number using anyMatch.
        Arrays.stream(arr1).filter(x -> Arrays.stream(arr2).anyMatch(y -> y == x)).forEach(x -> System.out.print(x + " "));

        // Example:2 Using Boxed Java8 : Print common number using anyMatch.
        System.out.println();
        Set<Integer> set = Arrays.stream(arr1).boxed().collect(Collectors.toSet());
        Arrays.stream(arr2).filter(set::contains).boxed().forEach(x -> System.out.print(x + " "));
    }
}
