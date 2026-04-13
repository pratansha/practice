package all.tech.practice.logical.arrayProblems;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicateFromAnArray {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 7, 9, 7, 20, 3};
        // Using boxed java8.
        Set<Integer> result = Arrays.stream(arr).boxed().collect(Collectors.toSet());
        System.out.println(result);

        // Example of map to long -----parsing from int to long and then collect result.
        System.out.println(Arrays.stream(arr).mapToLong(i -> i).filter(x -> x % 2 == 0).boxed().collect(Collectors.toList()));

        System.out.println("\n===========1st way=================\n");
        // Sort this Array.
        Arrays.sort(arr);
        removeDuplicateFromSortedArray(new int[]{1, 1, 1, 2, 2, 3, 4, 5, 5, 5, 6, 6, 7, 8});
        System.out.println("\n============2nd way===============\n");
        System.out.println(Arrays.toString(removeDuplicateUsingLinkedHashSet(new int[]{1, 1, 1, 2, 2, 3, 4, 5, 5, 5, 6, 6, 7, 8})));

    }

    // Remove Duplicates if Array is Sorted Array.
    public static void removeDuplicateFromSortedArray(int[] arr1) {
        int fillingPos = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[fillingPos] != arr1[i]) {
                arr1[++fillingPos] = arr1[i];
            }
        }
        fillingPos++;
        while (fillingPos < arr1.length) {
            arr1[fillingPos++] = -1;
        }
        for (int i : arr1) {
            System.out.print(" " + i);
        }
    }

    public static int[] removeDuplicateUsingLinkedHashSet(int[] arr) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int j : arr)
            set.add(j);
        return set.stream().mapToInt(Integer::valueOf).toArray();
    }
}