package all.tech.practice.algo.sort;

import java.util.Arrays;

public class InsertionSort {
    /*
        def link-1 : https://www.tutorialspoint.com/data_structures_algorithms/insertion_sort_algorithm.htm
        def link-2 : https://www.geeksforgeeks.org/insertion-sort-algorithm/
        Worst-case: 𝑂( 𝑛 2 ) (when the array is reverse sorted)
        Best-case: 𝑂( 𝑛 ) (when the array is already sorted)
        Average-case: 𝑂( 𝑛 2 )
 */
    public static void main(String[] args) {

        int[] arr = {50, 40, 30, 22, 23, 1, 10, 5, 2, 0};
        insertionSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
    private static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int j = i + 1;
            int post = arr[j];
            int pre = arr[j - 1];
            int b = arr[j];
            int k = j;
            while (post < pre && 0 < k && arr[k] < arr[k - 1]) {
                arr[k] = arr[k - 1];
                arr[k - 1] = b;
                k--;
            }
        }
    }
}
