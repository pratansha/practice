package all.tech.practice.dynamicProgramming;

/*
You are a professional robber planning to rob houses along a street.
Each house has a certain amount of money stashed,
the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected,
and it will automatically contact the police if two adjacent houses were broken into on the same night.
Given an integer array numbs representing the amount of money of each house,
return the maximum amount of money you can rob tonight without alerting the police.

Example 1:
Input: numbs = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.

Example 2:
Input: numbs = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.

DP formula is:==>> dp[i]=max(dp[i−1],[i−2]+numbs[i])

SOLUTION ::
===========
✅ Core idea (Decision at every house)
   At each house i, you have 2 choices:
    1: Skip current house:
                Then your money stays what you had till previous house:
                profit = dp[i-1]
    2: Rob current house:
                Then you must skip previous house, so you add current money to best till i-2:
                profit = dp[i-2] + numbs[i]

So the DP formula is:==>> dp[i] = max(dp[i−1],[i−2]+numbs[i])
NOTE : AT EVERY POSITION WE WILL PUT GREATER OR EQUAL IN THE DP ARRAY.
*/
public class HouseRobberAsList {
    public static void main(String[] args) {

        System.out.println("=======================1st way====================================");
        System.out.println(robUsingRecursion(new int[]{1, 2, 3, 1}));      // expected 4 (1 + 3)
        System.out.println(robUsingRecursion(new int[]{2, 7, 9, 3, 1}));   // expected 12 (2 + 9 + 1)
        System.out.println(robUsingRecursion(new int[]{2, 1, 1, 2}));      // expected 4 (2 + 2)
        System.out.println(robUsingRecursion(new int[]{5}));              // expected 5
        System.out.println(robUsingRecursion(new int[]{}));               // expected 0
        System.out.println(robUsingRecursion(new int[]{3, 10, 4, 5, 7}));     // expected 17
        System.out.println(robUsingRecursion(new int[]{13, 10, 4, 5, 1}));     // expected 18
        System.out.println(robUsingRecursion(new int[]{13, 20}));     // expected 20


        System.out.println("=======================2nd way====================================");
        System.out.println(robUsingDynamicProgramingMemoryWay(new int[]{1, 2, 3, 1}));      // expected 4 (1 + 3)
        System.out.println(robUsingDynamicProgramingMemoryWay(new int[]{2, 7, 9, 3, 1}));   // expected 12 (2 + 9 + 1)
        System.out.println(robUsingDynamicProgramingMemoryWay(new int[]{2, 1, 1, 2}));      // expected 4 (2 + 2)
        System.out.println(robUsingDynamicProgramingMemoryWay(new int[]{5}));              // expected 5
        System.out.println(robUsingDynamicProgramingMemoryWay(new int[]{}));               // expected 0
        System.out.println(robUsingDynamicProgramingMemoryWay(new int[]{3, 10, 4, 5, 7}));     // expected 17
        System.out.println(robUsingDynamicProgramingMemoryWay(new int[]{13, 10, 4, 5, 1}));     // expected 18
        System.out.println(robUsingDynamicProgramingMemoryWay(new int[]{13, 20}));     // expected 20


        System.out.println("=======================3rd way====================================");
        System.out.println(robUsingDynamicProgramingMemoryOptimized(new int[]{1, 2, 3, 1}));      // expected 4 (1 + 3)
        System.out.println(robUsingDynamicProgramingMemoryOptimized(new int[]{2, 7, 9, 3, 1}));   // expected 12 (2 + 9 + 1)
        System.out.println(robUsingDynamicProgramingMemoryOptimized(new int[]{2, 1, 1, 2}));      // expected 4 (2 + 2)
        System.out.println(robUsingDynamicProgramingMemoryOptimized(new int[]{5}));              // expected 5
        System.out.println(robUsingDynamicProgramingMemoryOptimized(new int[]{}));               // expected 0
        System.out.println(robUsingDynamicProgramingMemoryOptimized(new int[]{3, 10, 4, 5, 7}));     // expected 17
        System.out.println(robUsingDynamicProgramingMemoryOptimized(new int[]{13, 10, 4, 5, 1}));     // expected 18
        System.out.println(robUsingDynamicProgramingMemoryOptimized(new int[]{13, 20}));     // expected 20
    }

    //1.Using recursion but Time Complexity is O(2^n) & Space Complexity is O(n) in Worst case.
    public static int robUsingRecursion(int[] houses) {
        if (houses.length == 0) return 0;
        return robFrom(houses.length - 1, houses);
    }

    // Explanation : Formula will be Math.max( houses[i] + robFrom(i + 2, houses) , robFrom(i + 1, houses))]
    private static int robFrom(int i, int[] houses) {
        if (i <= 0) return houses[0];
        if (i == 1) return Math.max(houses[0], houses[1]);
        return Math.max(houses[i] + robFrom(i - 2, houses), robFrom(i - 1, houses));
    }

    //2.Using recursion but Time Complexity is O(n) & Space Complexity is O(n) in Worst case.
    public static int robUsingDynamicProgramingMemoryWay(int[] houses) {
        int n = houses.length;
        if (n == 0) return 0;
        if (n == 1) return houses[0];
        if (n == 2) return Math.max(houses[0], houses[1]);

        int[] dp = new int[houses.length];
        dp[0] = houses[0];
        dp[1] = Math.max(houses[0], houses[1]);

        for (int i = 2; i < houses.length; i++) {
            dp[i] = Math.max(dp[i - 1], houses[i] + dp[i - 2]);
        }
        return dp[dp.length - 1];
    }

    //3.Using recursion but Time Complexity is O(n) & Space Complexity is O(1) in Worst case.
    public static int robUsingDynamicProgramingMemoryOptimized(int[] houses) {
        if (houses.length == 0) return 0;
        int pre1 = 0;
        int pre2 = 0;

        for (int house : houses) {
            int cur = Math.max(house + pre2, pre1);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }
}