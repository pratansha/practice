package all.tech.practice.dynamicProgramming;

// Link : https://leetcode.com/problems/climbing-stairs/
/*
You are at step 0 and want to reach step n.
    Each move you can climb:
    1 step, or
    2 steps
Find the number of distinct ways to reach step n.
input n=2 then output will be 2 => [0-1-2 or 0-2]
input n=3 then output will be 3 => [0-1-2-3 or 0-1-3 or 0-2-3 ]

 Mathematical Formula will be used to solve it : n! = n×(n−1)×(n−2)×...×1
 So If item is !2 = 1 * 2 = 2
 So If item is !3 = 1 * 2 * 3 = 6

*/
public class ClimbingStairsDP {
    public static void main(String[] args) {
        System.out.println("=============1st way================");
        System.out.println("Number of step would be :" + climbStairsUsingRecursion(2));
        System.out.println("Number of step would be :" + climbStairsUsingRecursion(3));
        System.out.println("Number of step would be :" + climbStairsUsingRecursion(4));
        System.out.println("Number of step would be :" + climbStairsUsingRecursion(10));

        System.out.println("=============2nd way================");
        System.out.println("Number of step would be :" + climbStairsUsingMemory(2));
        System.out.println("Number of step would be :" + climbStairsUsingMemory(3));
        System.out.println("Number of step would be :" + climbStairsUsingMemory(4));
        System.out.println("Number of step would be :" + climbStairsUsingMemory(10));

        System.out.println("==============3rd way===============");
        System.out.println("Number of step would be :" + climbStairsUsingDynamicProgramming(2));
        System.out.println("Number of step would be :" + climbStairsUsingDynamicProgramming(3));
        System.out.println("Number of step would be :" + climbStairsUsingDynamicProgramming(4));
        System.out.println("Number of step would be :" + climbStairsUsingDynamicProgramming(10));

        System.out.println("==============4th way===============");
        System.out.println("Number of step would be :" + climbStairsUsingDynamicProgrammingOptimized(2));
        System.out.println("Number of step would be :" + climbStairsUsingDynamicProgrammingOptimized(3));
        System.out.println("Number of step would be :" + climbStairsUsingDynamicProgrammingOptimized(4));
        System.out.println("Number of step would be :" + climbStairsUsingDynamicProgrammingOptimized(10));
    }

    //1.Worst case O(2^n). For each position it tries for 2 ways. (Not Recommended)
    // It is not useful because same logic calculation for every value.
    private static int climbStairsUsingRecursion(int n) {
        if (n <= 1) return 1;
        return climbStairsUsingRecursion(n - 1) + climbStairsUsingRecursion(n - 2);
    }

    //2. Memorizing way. worst case O(n) , space complexity O(n).
    private static int climbStairsUsingMemory(int n) {
        int[] arr = new int[n + 1];
        return climbStairsRecursion(n, arr);
    }

    private static int climbStairsRecursion(int n, int[] arr) {
        if (n <= 1) return 1;
        if (arr[n] != 0) return arr[n];
        arr[n] = climbStairsRecursion(n - 1, arr) + climbStairsRecursion(n - 2, arr);
        return arr[n];
    }


    //3. DP Memorizing way. worst case O(n) , space complexity O(n).
    private static int climbStairsUsingDynamicProgramming(int n) {
        if (n <= 1) return 1;

        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }


    //4. Dynamic Programming Preferred (More Optimized) DP Memorizing way. worst case O(n) , space complexity O(1).
    private static int climbStairsUsingDynamicProgrammingOptimized(int n) {
        if (n <= 1) return 1;

        int pre2 = 1;
        int pre1 = 1;

        for (int i = 2; i <= n; i++) {
            int num = pre1 + pre2;
            pre2 = pre1;
            pre1 = num;
        }
        return pre1;
    }
}
