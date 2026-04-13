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
    }
}
