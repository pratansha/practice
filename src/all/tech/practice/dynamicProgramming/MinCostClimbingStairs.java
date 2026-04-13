package all.tech.practice.dynamicProgramming;

import java.util.Arrays;

/*

 */
public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[][] costs = {
                {10, 15, 20},                         // expected: 15
                {1, 100, 1, 1, 1, 100, 1, 1, 100, 1},  // expected: 6
                {5, 10},                               // expected: 5
                {0, 0, 0, 0},                           // expected: 0
                {7}                                    // expected: 7 (edge case)
        };

        System.out.println("=================1st way=================");
        for (int[] cost : costs) {
            System.out.println(Arrays.toString(cost) + " -> " + minCostClimbingStairsUsingDynamicProgramming(cost));
        }
        System.out.println("=================2nd way=================");
        for (int[] cost : costs) {
            System.out.println(Arrays.toString(cost) + " -> " + minCostClimbingStairsUsingDynamicProgrammingOptimized(cost));
        }
    }

    // Dynamic Programming way to solve where Run complexity O(n) and space complexity O(n).
    // Solution
    private static int minCostClimbingStairsUsingDynamicProgramming(int[] cost) {
        int n = cost.length;
        if (n == 0) return 0;
        if (n == 1) return cost[0];

        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        return Math.min(dp[n - 1], dp[n - 2]);
    }

    // Dynamic Programming way to solve where Run complexity O(n) and space complexity O(1).
    // Solution
    private static int minCostClimbingStairsUsingDynamicProgrammingOptimized(int[] cost) {
        int n = cost.length;

        if (n == 0) return 0;
        if (n == 1) return cost[0];

        int pre1 = cost[0];
        int pre2 = cost[1];

        for (int i = 2; i < n; i++) {
            int current = cost[i] + Math.min(pre1, pre2);
            pre1 = pre2;
            pre2 = current;
        }
        return Math.min(pre1, pre2);
    }
}
