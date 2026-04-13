package algorithms.sort;

import java.util.Arrays;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 4, 13, 18};
        int[] arr2 = {2, 11, 12, 15, 17, 20, 21, 39, 49};
        // Arrays.stream(mergeTwoArrays(arr1, arr2)).forEach(System.out::println);
        int[] num1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] num2 = {2, 5, 6};
        int n = 3;
        mergeSortArray(num1, m, num2, n);
    }

    private static int[] mergeTwoArrays(int[] arr1, int[] arr2) {
        int i = 0;// using for arr1
        int j = 0;// using for arr2
        int[] sortedArray = new int[arr1.length + arr2.length];
        int k = 0;
        while (i < arr1.length && j < arr2.length)
            if (arr1[i] < arr2[j])
                sortedArray[k++] = arr1[i++];
            else sortedArray[k++] = arr2[j++];

        while (i < arr1.length && k < sortedArray.length)
            sortedArray[k++] = arr1[i++];

        while (j < arr2.length && k < sortedArray.length)
            sortedArray[k++] = arr2[j++];

        return sortedArray;
    }

    private static void mergeSortArray(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n];
        int k = 0;
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                result[k++] = nums1[i++];
            } else {
                result[k++] = nums2[j++];
            }
        }

        while (i < m && i < nums1.length) {
            result[k++] = nums1[i++];
        }

        while (j < n && j < nums2.length) {
            result[k++] = nums2[j++];
        }

        Arrays.stream(result).forEach(System.out::println);
    }
}
