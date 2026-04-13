package all.tech.practice.logical.arrayProblems;

import java.util.*;

// Return all the combinations which sums  equal to the target.
public class TwoNumbersSumToTarget {
    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15, 3, 9, 0, 6};
        int target = 9;
        System.out.println("\nFirst Solution..");
        for (int[] p : getSumOfCombinationUsingHashMap(numbers, target)) {
            System.out.println(Arrays.toString(p));
        }

        System.out.println("\nSecond Solution..");
        for (int[] p : getSumOfCombinationUsingTwoPointers(target, numbers)) {
            System.out.println(Arrays.toString(p));
        }
    }


    public static List<int[]> getSumOfCombinationUsingHashMap(int[] arr, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        List<int[]> newArrayCombinations = new ArrayList<>();
        for (int j : arr) {
            if (hashMap.containsKey((target - j)))
                newArrayCombinations.add(new int[]{target - j, j});
            hashMap.put(j, -1);
        }
        return newArrayCombinations;
    }

    public static List<int[]> getSumOfCombinationUsingTwoPointers(int target, int... arr) {
        Arrays.sort(arr);
        List<int[]> newArrayCombinations = new ArrayList<>();

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                newArrayCombinations.add(new int[]{arr[left], arr[right]});
                left++;
            } else if (sum < target) left++;
            else right--;
        }
        return newArrayCombinations;
    }
}
