package all.tech.practice.dynamicProgramming;

import java.util.Arrays;

// Print Fibonacci of any given number n.
public class FibonacciUsingDP {
    public static void main(String[] args) {
        int n = 10;
        // Solution , We need to memorize previous values so that instead of using we can reuse it.
        int[] arr = new int[n];

        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        System.out.println(Arrays.toString(arr));
        int res = fibonacciUsingRecursion(n);
    }

    // Incomplete------->
    private static int fibonacciUsingRecursion(int n) {
        if (n == 1) return n;
        // n =
        return n;
    }


}
