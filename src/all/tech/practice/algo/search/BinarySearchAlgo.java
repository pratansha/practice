package all.tech.practice.algo.search;

import java.util.Arrays;

// Search an Element using Binary Search Algorithm.
public class BinarySearchAlgo {
    public static void main(String[] args) {
        int[] numbers = {14, 2, 7, 13, 15, 3, 9, 0, 6};
        int searchElement = 14;
        // To apply Binary search it should be sort.
        Arrays.sort(numbers);
        for (int p : numbers)
            System.out.print(p + ",");
        System.out.println();
        int pos = -1;

        int dynamicPos = numbers.length;
        int startPos = 0;
        for (int i = startPos; i < dynamicPos; i++) {
            int mid = (i + dynamicPos) / 2;
            if (numbers[mid] == searchElement) {
                pos = mid;
                break;
            }
            if (numbers[mid] < searchElement) startPos = mid + 1;
            else dynamicPos = mid - 1;
        }

        System.out.println(pos);
        searchUsingBinarySearchAlgo(searchElement, numbers);
        searchUsingBinarySearchAlgoTest(searchElement, numbers);
    }

    // Binary Search applicable only for sorting Array, It should be asc or desc.
    public static void searchUsingBinarySearchAlgo(int searchElement, int... arr) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length;
        int mid = 0;
        while (left < right && arr[mid] != searchElement) {
            mid = (left + right) / 2;
            if (arr[mid] < searchElement) left = mid + 1;
            else right = mid - 1;
        }
        if (arr[mid] == searchElement) System.out.println("element is at : " + mid);
        else System.out.println("element not found...");
    }

    // Binary Search applicable only for sorting Array, It should be asc or desc.
    public static void searchUsingBinarySearchAlgoTest(int searchElement, int... arr) {
        Arrays.sort(arr);
        int start = 0;
        int last = arr.length;
        int m = 0;
        while (start < last && arr[m] != searchElement) {
            m = (start + last) / 2;
            if (arr[m] > searchElement) last = m - 1;
            else start = m + 1;
        }
        if (arr[m] == searchElement)
            System.out.println("Element found at location : " + m);
        else System.out.println("element not found...");
    }
}