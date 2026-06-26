package all.tech.practice.algo.search;

import java.util.Arrays;


// Search an Element using Binary Search Algorithm Using Recursion.
public class BinarySearchAlgoUsingRecursion {
    public static void main(String[] args) {
        int[] numbers = {14, 2, 7, 13, 15, 3, 9, 0, 6};
        int searchElement = 14;

        Arrays.sort(numbers);
        // print numbers in an order after sorting.
        for (int p : numbers)
            System.out.print(p + ",");
        System.out.println();

        // To apply Binary search it should be sort.
        System.out.println(findStringPosUsingRecursion(numbers, 0, numbers.length - 1, searchElement));
        System.out.println(findStringPosUsingRecursionTest(numbers, 0, numbers.length - 1, searchElement));

    }

    public static int findStringPosUsingRecursion(int[] numbers, int start, int end, int target) {
        int mid = (start + end) / 2;
        if (numbers[mid] == target)
            return mid;
        else if (numbers[mid] < target)
            return findStringPosUsingRecursion(numbers, mid + 1, end, target);
        else return findStringPosUsingRecursion(numbers, start, mid - 1, target);
    }

    public static int findStringPosUsingRecursionTest(int[] numbers, int start, int end, int target) {
        int med = (start + end) / 2;
        if (numbers[med] == target)
            return med;
        else if (numbers[med] < target) return findStringPosUsingRecursionTest(numbers, med + 1, end, target);
        else return findStringPosUsingRecursionTest(numbers, start, med - 1, target);
    }
}