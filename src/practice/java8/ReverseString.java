package practice.java8;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseString {
    public static void main(String[] args) {
        String str = "abcdefghi";

        System.out.println(str.chars().mapToObj(x -> String.valueOf((char) x)).collect(Collectors.joining()));

        String reverse = IntStream.range(0, str.length()).mapToObj(x -> str.charAt(str.length() - 1 - x))
                .map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println(reverse);
    }
}
