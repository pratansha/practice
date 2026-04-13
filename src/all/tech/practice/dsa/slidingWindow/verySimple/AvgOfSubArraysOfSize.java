package all.tech.practice.dsa.slidingWindow.verySimple;

import java.util.Arrays;

// Given an array arr[] and an integer K, provide the average of all kth contiguous.
public class AvgOfSubArraysOfSize {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println(Arrays.toString(findAverageOfAllSubArrayOfSize(k, arr)));
    }

    public static double[] findAverageOfAllSubArrayOfSize(int k, int... arr) {
        double[] resultAvg = new double[arr.length - k + 1];
        double windowSum = 0;
        int left = 0;
        for (int i = 0; i < arr.length; i++) {
            windowSum += arr[i];
            if (i - left + 1 == k) {
                resultAvg[left] = windowSum / k;
                windowSum -= arr[left++];
            }
        }
        return resultAvg;
    }
}
