package all.tech.practice.dsa.slidingWindow.verySimple;

// Given an array arr[] and an integer K, find the max average among all contiguous sub-arrays of size K.
public class MaximumAvgSubArraysOfSizeK {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println(findMaxAverageOfSubArrayOfSize(k, arr));
    }

    public static double findMaxAverageOfSubArrayOfSize(int k, int... arr) {
        double maxAvg = 0;
        double windowSum = 0;
        int left = 0;
        for (int i = 0; i < arr.length; i++) {
            windowSum += arr[i];
            if (i - left + 1 == k) {
                maxAvg = Math.max(maxAvg, windowSum / k);
                windowSum -= arr[left++];
            }
        }
        return maxAvg;
    }
}
