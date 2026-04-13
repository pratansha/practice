package all.tech.practice.java8.logical;

import java.util.stream.IntStream;

// Sum of Top 10 natural numbers.
public class SumOfTopNumbers {
    public static void main(String[] args) {

        int sum = IntStream.range(0, 11).sum();
        System.out.println(sum);

        var result = sum(10, 20);
        System.out.println("result is : " + result);
    }

    public static Integer sum(int a, int b) {
        return a + b;
    }
}