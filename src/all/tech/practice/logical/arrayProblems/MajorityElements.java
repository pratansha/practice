package all.tech.practice.logical.arrayProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
public class MajorityElements {
    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 1, 2, 1};
        System.out.println(MajorityElements.usingSortingWayToCheckMajority(arr));
        System.out.println(MajorityElements.usingHashMapToCheckMajority(arr));
        System.out.println(MajorityElements.boyerMooreMajority(arr));
    }

    public static int usingSortingWayToCheckMajority(int[] arr) {
        //Using Sorting way to check majority elements.
        int expectedCount = (arr.length / 2) + 1;
        System.out.println("Expected count is : " + expectedCount);
        Arrays.sort(arr);
        for (int j : arr) System.out.print("," + j);
        System.out.println();

        int number = arr[0];
        int count = 0;
        for (int j : arr) {
            if (number == j)
                count++;
            if (number != j) {
                count = 1;
                number = j;
            }
            if (count >= expectedCount) return number;
        }
        return -1;
    }

    public static int usingHashMapToCheckMajority(int[] arr) {
        Map<Integer, Integer> counterMap = new HashMap<>();
        int expectedCount = (arr.length / 2) + 1;

        for (int j : arr) {
            int valueCount = counterMap.getOrDefault(j, 0) + 1;
            counterMap.put(j, valueCount);
            if (valueCount >= expectedCount) return j;
        }
        return -1;
    }

    public static int boyerMooreMajority(int[] arr) {
        int candidate = -1, count = 0;

        // Phase 1: Find candidate
        for (int num : arr) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        // Phase 2: Verify candidate
        int freq = 0;
        for (int num : arr) {
            if (num == candidate) freq++;
        }

        return freq > arr.length / 2 ? candidate : -1;
    }

}
