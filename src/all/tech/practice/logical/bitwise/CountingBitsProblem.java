package all.tech.practice.logical.bitwise;

import java.util.Arrays;

/*✅ 338. Counting Bits Problem
Given an integer n, return an array answer of size n + 1 where:
answer[i] = number of set bits (1s) in binary representation of i, for all i from 0 to n.

Example
    n = 5
    Output: [0, 1, 1, 2, 1, 2]
    Because:
    0 → 0 → 0
    1 → 1 → 1
    2 → 10 → 1
    3 → 11 → 2
    4 → 100 → 1
    5 → 101 → 2
*/
public class CountingBitsProblem {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(2))); // [0, 1, 1]
        System.out.println(Arrays.toString(countBits(5))); // [0, 1, 1, 2, 1, 2]
        System.out.println(Arrays.toString(countBits(10))); // [0,1,1,2,1,2,2,3,1,2,2]
    }

    /*
     * Explanation:
     * Using Brian Kernighan’s approach (n & (n - 1)), we derive a value that is always
     * smaller than the current number by removing its lowest set bit.
     *
     * For example, if n = 11:
     * n & (n - 1) => 11 & 10
     * Binary: 1011 & 1010 = 1010 (which is 10)
     *
     * Since the resulting value (10) is less than the current value (11),
     * it would have already been computed earlier.
     *
     * This forms a dynamic programming relationship where the result for the
     * current number can be derived from a previously solved sub-problem.
     * By being memoize these results, we avoid re-computation and efficiently reuse
     * earlier computed values.
     */
    public static int[] countBits(int n) {
        int[] res = new int[n + 1];

        for (int i = 1; i <= n; i++)
            res[i] = res[i & (i - 1)] + 1;
        return res;
    }
}
