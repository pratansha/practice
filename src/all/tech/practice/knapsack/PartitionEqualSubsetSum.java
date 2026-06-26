package all.tech.practice.knapsack;

import java.util.Arrays;

// Partition Equal Subset Sum. link : https://leetcode.com/problems/partition-equal-subset-sum/
/*Given an integer array numbs, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.
Example 1:
Input: numbs = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].

Example 2:
Input: numbs = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.

Example 3:
Input: numbs = [1, 2, 5] // [1,2,3,5,3] // [1 2 3]
Output: false
Explanation: sum = 8 (even), but still there is not partitioned possible which will make 2 Partitions.
*/
public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        int[][] allArrays = {
                new int[]{1, 2, 3, 4},            // expected: true  (sum=10 target=5 -> 1+4 or 2+3)
                new int[]{100, 1, 2, 3, 4, 90},   // expected: true  (sum=200 target=100 -> 100 alone)
                new int[]{},                      // expected: true  (two empty subsets sum to 0)
                new int[]{0},                     // expected: true  (0 vs 0)
                new int[]{1},                     // expected: false (sum=1 odd)
                new int[]{2},                     // expected: false (sum=2 even, target=1 not possible)
                new int[]{0, 0},                  // expected: true
                new int[]{0, 2},                  // expected: false (sum=2 target=1 not possible)
                new int[]{1, 1, 3, 5},            // expected: true (sum=10 target=5; subset=5 exists, but remaining=5? check: remaining is 1+1+3=5 yes -> actually true!)
                new int[]{1, 2, 7},               // expected: false (sum=10 target=5 not possible)
                new int[]{0, 0, 1, 1},            // expected: true  (1 vs 1, zeros anywhere)
                new int[]{0, 0, 2, 2},            // expected: true  (2 vs 2)
                new int[]{0, 0, 1, 2, 3},         // expected: true  (sum=6 target=3 -> 3 alone)
                new int[]{0, 0, 1, 2, 5},         // expected: false (sum=8 target=4 not possible)
                new int[]{10, 1, 2, 3},           // expected: false (sum=16 target=8, 10 > 8 => cannot)
                new int[]{9, 1, 1, 1},            // expected: false (sum=12 target=6, 9 > 6)

        };

        System.out.println("================= 1st way ===================================");
        for (int[] arr : allArrays) {
            System.out.println("Result for array :" + Arrays.toString(arr) + " is :" + checkPartitionIsPossibleUsingRecursion(arr));
        }

        System.out.println("================= 2nd way ===================================");
        for (int[] arr : allArrays) {
            System.out.println("Result for array :" + Arrays.toString(arr) + " is :" + checkPartitionIsPossibleUsingMemorization(arr));
        }

        System.out.println("================= 3rd way ===================================");
        for (int[] arr : allArrays) {
            System.out.println("Result for array :" + Arrays.toString(arr) + " is :" + checkPartitionIsPossibleUsingDynamicProgramming(arr));
        }
    }

    //1. Explanation:If there is a subset element's sum = to half of the total sum of the array then partition is possible.
    //   Time Complexity: O(2^n) , Space Complexity: O(n)
    public static boolean checkPartitionIsPossibleUsingRecursion(int[] arr) {
        int sum = 0;
        int i = arr.length - 1;
        while (i >= 0) sum += arr[i--];
        if ((sum & 1) != 0) return false;
        return checkPartitionIsPossibleUsingRecursionHelper(arr, sum / 2, 0);
    }

    private static boolean checkPartitionIsPossibleUsingRecursionHelper(int[] arr, int sum, int currentIndex) {
        if (sum == 0) return true;
        if (currentIndex >= arr.length) return false;
        //  1 2 3 4
        if (arr[currentIndex] <= sum && checkPartitionIsPossibleUsingRecursionHelper(arr, sum - arr[currentIndex], currentIndex + 1))
            return true;
        // Recursive call after excluding the number at the currentIndex
        return checkPartitionIsPossibleUsingRecursionHelper(arr, sum, currentIndex + 1);
    }


    //2. Time Complexity: O(n * s) - s is half of the total sum , Space Complexity: O(n * s).
    public static boolean checkPartitionIsPossibleUsingMemorization(int[] arr) {
        int sum = 0;
        int i = arr.length - 1;
        while (i >= 0) sum += arr[i--];
        if ((sum & 1) != 0) return false;

        Boolean[][] dp = new Boolean[arr.length][(sum / 2) + 1];
        return checkPartitionIsPossibleUsingMemorizationHelper(arr, 0, sum / 2, dp);
    }

    public static boolean checkPartitionIsPossibleUsingMemorizationHelper(int[] arr, int index, int sum, Boolean[][] dp) {
        if (sum == 0) return true;
        if (index >= arr.length) return false;

        if (dp[index][sum] != null)
            return dp[index][sum];

        if (sum >= arr[index] && checkPartitionIsPossibleUsingMemorizationHelper(arr, index + 1, sum - arr[index], dp)) {
            dp[index][sum] = true;
            return true;
        }
        return checkPartitionIsPossibleUsingMemorizationHelper(arr, index + 1, sum, dp);
    }

    //3 Time Complexity: O(n * s) - where n is number of elements in the array and s is half the total sum of all elements. Space Complexity: O(s) - t
    public static boolean checkPartitionIsPossibleUsingDynamicProgramming(int[] arr) {
        int totalSum = 0;
        for (int num : arr) totalSum += num;

        if (totalSum % 2 != 0) return false;

        int sum = totalSum / 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true; // Base case: zero-sum is always achievable

       // dp[0,1,2,3,4,5]  => dp[0,0,0,0,0,0] ;
       // num = 1 ==> sum = 5,4,3,2,1,0  ==>  dp[5] = d[5] || d[4] = false , dp[4] = d[4] || d[3] = false , dp[3] = d[3] || d[2] = false , dp[2] = d[2] || d[1] = false , dp[1] = d[1] || d[0] = true.
        // 1 2 3 4
        for (int num : arr) {
            for (int s = sum; s >= num; s--) {
                dp[s] = dp[s] || dp[s - num];
            }
        }
        return dp[sum];
    }
}