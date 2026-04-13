package all.tech.practice.dynamicProgramming;

import java.util.Arrays;

/*
You are a professional robber planning to rob houses along a street.
Each house has a certain amount of money stashed.
All houses at this place are arranged in a circle.That means the first house is the neighbor of the last one. Meanwhile,
adjacent houses have a security system connected,and it will automatically contact the police
if two adjacent houses were broken into on the same night.

Given an integer array numbs representing the amount of money of each house,
return the maximum amount of money you can rob tonight without alerting the police.

Example 1:
Input: numbs = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.

Example 2:
Input: numbs = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).Total amount you can rob = 1 + 3 = 4.

Example 3:
Input: numbs = [1,2,3]
Output: 3 , It is circular so it can start from last that will treat as first.
*/
public class HouseRobberAsCircularList {
    public static void main(String[] args) {
        int[][] inputs = {
                {},                         // expected: 0
                {5},                        // expected: 5
                {2, 10},                    // expected: 10

                {2, 3, 2},                  // expected: 3
                {1, 2, 3, 1},               // expected: 4
                {1, 2, 3},                  // expected: 3

                {5, 5, 5, 5},               // expected: 10
                {4, 4, 4, 4, 4},            // expected: 8

                {10, 1, 1, 10},             // expected: 11
                {100, 1, 1, 100},           // expected: 101
                {2, 1, 1, 2},               // expected: 3

                {1, 3, 1, 3, 100},          // expected: 103
                {6, 7, 1, 30, 8, 2, 4},     // expected: 41
                {4, 1, 2, 7, 5, 3, 1},      // expected: 14

                {0, 0, 0},                  // expected: 0
                {0, 5, 0, 5, 0},            // expected: 10

                {1, 2, 3, 4, 5, 6},         // expected: 12
                {6, 5, 4, 3, 2, 1},         // expected: 12

                {8, 9, 8, 9, 8},            // expected: 18  (choose 9+9)
                {3, 2, 5, 10, 7},           // expected: 13  (case: [2..] gives 13)
                {2, 7, 9, 3, 1},            // expected: 11
        };

        System.out.println("=======================1st way====================================");
        for (int[] t : inputs) {
            int ans = robUsingRecursion(t);
            System.out.println(Arrays.toString(t) + " -> " + ans);
        }

        System.out.println("=======================2nd way====================================");
        for (int[] t : inputs) {
            int ans = robUsingDynamicProgramingMemoryWay(t);
            System.out.println(Arrays.toString(t) + " -> " + ans);
        }

        System.out.println("=======================3rd way====================================");
        for (int[] t : inputs) {
            int ans = robUsingDynamicProgramingMemoryOptimized(t);
            System.out.println(Arrays.toString(t) + " -> " + ans);
        }

    }

    //1.Using recursion but Time Complexity is O(2^n) & Space Complexity is O(n) in Worst case.
    public static int robUsingRecursion(int[] houses) {
        int n = houses.length;
        if (n == 0) return 0;
        if (n == 1) return houses[0];

        return Math.max(robFrom(houses, 0, n - 2), robFrom(houses, 1, n - 1));
    }

    // Explanation : Formula will be Math.max( houses[i] + robFrom(i + 2, houses) , robFrom(i + 1, houses))]
    private static int robFrom(int[] houses, int start, int end) {
        if (start > end) return 0;
        int cur = houses[start] + robFrom(houses, start + 2, end);
        int skip = robFrom(houses, start + 1, end);
        return Math.max(cur, skip);
    }

    //2.Using recursion but Time Complexity is O(n) & Space Complexity is O(n) in Worst case.
    public static int robUsingDynamicProgramingMemoryWay(int[] houses) {
        int n = houses.length;
        if (n == 0) return 0;
        if (n == 1) return houses[0];
        if (n == 2) return Math.max(houses[0], houses[1]);
        return Math.max(robUsingDynamicProgramingMemoryWayLogic(houses, 0, n - 2), robUsingDynamicProgramingMemoryWayLogic(houses, 1, n - 1));
    }

    private static int robUsingDynamicProgramingMemoryWayLogic(int[] houses, int start, int end) {
        int length = end - start + 1;
        int[] dp = new int[length + 1];
        dp[start] = houses[start];
        dp[start + 1] = Math.max(houses[start], houses[start + 1]);

        for (int i = start + 2; i <= length; i++) {
            dp[i] = Math.max(houses[i] + dp[i - 2], dp[i - 1]);
        }
        return start == 0 ? dp[dp.length - 2] : dp[dp.length - 1];
    }

    //3.Using recursion but Time Complexity is O(n) & Space Complexity is O(1) in Worst case.
    public static int robUsingDynamicProgramingMemoryOptimized(int[] houses) {
        int n = houses.length;
        if (n == 0) return 0;
        if (n == 1) return houses[0];

        int case1 = robUsingDynamicProgramingMemoryOptimizedLogic(houses, 0, n - 2);
        int case2 = robUsingDynamicProgramingMemoryOptimizedLogic(houses, 1, n - 1);
        return Math.max(case1, case2);

    }

    private static int robUsingDynamicProgramingMemoryOptimizedLogic(int[] houses, int start, int end) {
        int pre1 = 0;
        int pre2 = 0;
        for (int i = start; i <= end; i++) {
            int cur = Math.max(houses[i] + pre2, pre1);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }
}