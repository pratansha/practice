package all.tech.practice.dsa.slidingWindow.verySimple;

// Given an array arr[] and an integer K, find the maximum sum among all contiguous sub-arrays of size K.
public class MaximumSumSubArrayOfSizeK {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println(findMaximumSumSubArrayOfSize(k, arr));
    }

    public static int findMaximumSumSubArrayOfSize(int k, int... arr) {
        int maxSum = 0;
        int windowSum = 0;
        int left = 0;
        for (int i = 0; i < arr.length; i++) {
            windowSum += arr[i];
            if (i - left + 1 == k) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[left++];
            }
        }
        return maxSum;
    }


}
