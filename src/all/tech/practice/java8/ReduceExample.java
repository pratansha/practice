package all.tech.practice.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;
/*
At its core, reduce() is an implementation of fold-left logic, governed by three main components: Identity, Accumulator, and Combiner.
1. The Core Components
 Identity: Both the initial seed value and the default result if the stream is empty.
 Accumulator: A function that takes a partial result and the next element of the stream, returning a new partial result.
 Combiner: A function used to merge two partial results (crucial for parallel processing).
*/

public class ReduceExample {
    public static void main(String[] args) {
        // Get the Longest length word from String.
        List<String> country = Arrays.asList("DEmark", "na", "Gey", "England", "op");
        Optional<String> data = country.stream().reduce((c1, c2) -> c1.length() > c2.length() ? c1 : c2);
        data.ifPresent(System.out::println);

        // Reverse a String, Using Reduce.
        String str = "abcdefghi";
        System.out.println(str.chars().reduce(Integer::sum)); // This will give optional result.
        System.out.println(str.chars().mapToObj(i -> String.valueOf((char) i)).reduce("", (x, y) -> (y + x))); // This will give without optional result.
        System.out.println(str.chars().mapToObj(x -> String.valueOf((char) x)).reduce("-prefix-", (x, y) -> (y + x))); // This will append a word in the result

        // Reverse a String without reduce.
        System.out.println(IntStream.range(0, str.length()).collect(StringBuilder::new, (sb, i) -> sb.append(str.charAt(str.length() - 1 - i)), StringBuilder::append).toString());

        "hello".chars().mapToObj(x -> x + 1);   // still int

        System.out.println("============BiFunction & BinaryOperator differences==================");
        // Sometimes accumulator or sometime combiner(merger)
        BinaryOperator<Integer> op = (a, b) -> a + b;

        // always accumulator
        BiFunction<Integer, String, Integer> addBiFunction = (a, b) -> a + b.length();

        // here op is accumulator.
        int sum = Stream.of(10, 20, 30).reduce(0, op);
        BinaryOperator<Integer> op2 = Integer::sum;
        System.out.println(sum); // 60

        // here op is combiner
        List<String> names = Arrays.asList("aa", "bbbb", "c", "ddd", "eeee");
        Integer totalLen = names.stream().reduce(0, addBiFunction, op);
        System.out.println(totalLen);

        // Sum using Reduce
        System.out.println(Stream.of(100, 200, 300).reduce(0, (a, b) -> a + b));
        //System.out.println(Stream.of(100, 200, 300).);

        int a = 100, b = 21;
        int carry = a & b;   // carry
        a = a ^ b;           // sum without carry
        b = carry << 1;      // shifted carry
        System.out.println("sum is " + b);
    }
}