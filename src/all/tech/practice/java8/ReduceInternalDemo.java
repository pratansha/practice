package all.tech.practice.java8;

/*
The Parallel Reduction Logic :
When you run a reduction in parallel, the internal ForkJoin framework partitions the data.
    Split: The data is divided into chunks.
    Accumulate: Each chunk is reduced independently on a separate thread.
    Combine: The partial results are merged using your combiner function.
*/

import java.util.Arrays;
import java.util.List;

public class ReduceInternalDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        System.out.println("--- Starting Sequential Reduce ---");
        int sequentialSum = numbers.stream().reduce(0, (sum, element) -> {
            System.out.println("Accumulator (Seq): " + sum + " + " + element);
            return sum + element;
        }, (sum1, sum2) -> {
            System.out.println("Combiner (Seq) - I am never called!");
            return sum1 + sum2;
        });

        System.out.println(sequentialSum);

        System.out.println("\n--- Starting Parallel Reduce ---");
        int parallelSum = numbers.parallelStream().reduce(0, (sum, element) -> {
            System.out.println("Accumulator (Parallel) thread [" + Thread.currentThread().getName() + "]: " + sum + " + " + element);
            return sum + element;
        }, (sum1, sum2) -> {
            System.out.println("Combiner (Parallel) thread [" + Thread.currentThread().getName() + "]: merging " + sum1 + " & " + sum2);
            return sum1 + sum2;
        });

        System.out.println(parallelSum);
    }
}
