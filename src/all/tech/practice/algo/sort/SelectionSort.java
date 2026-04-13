package algorithms.sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {50, 40, 30, 22, 23, 1, 10, 5, 2, 0};
        selectionSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void selectionSort(int[] arr) {

        int pos = 0;
        for (int i = 0; i < arr.length; i++) {
            int start = i;
            int min = arr[start];
            while (start < arr.length) {
                if (min > arr[start]) {
                    min = arr[start];
                    pos = start;
                }
                start++;
            }
            if (arr[i] != min) {
                int temp = arr[i];
                arr[i] = min;
                arr[pos] = temp;
            }
        }
    }
}
