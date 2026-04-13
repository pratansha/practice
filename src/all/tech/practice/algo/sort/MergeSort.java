package algorithms.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {50, 40, 30, 22, 23, 1, 10, 5, 2, 0};
        mergeSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void mergeSort(int[] arr) {


    }

    static void sort(int[] arr) {
        int divider = arr.length / 2 == 0 ? (arr.length / 2) - 1 : arr.length / 2;
        int[] left = new int[divider];
        //int[] right = new int[]
    }


}
