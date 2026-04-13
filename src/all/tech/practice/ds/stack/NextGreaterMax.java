package all.tech.practice.ds.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterMax {
    public static void main(String[] args) {
        int[] arr = {9, 10, 11, 1, 2, 4, 3};
        int[] output = nextGreaterMax(arr);
        System.out.println(Arrays.toString(output));
        System.out.println("Using Stack :" + Arrays.toString(nextGreaterMaxUsingStack(arr)));
    }

    public static int[] nextGreaterMax(int[] arr) {
        int n = arr.length;
        int[] suffixMax = new int[n];

        // Build suffix maximums
        suffixMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(arr[i], suffixMax[i + 1]);
        }

        for (int i = 0; i < n; i++) {
            if (suffixMax[i] == arr[i]) {
                suffixMax[i] = -1; // no greater to the right
            }
        }
        return suffixMax;
    }

    public static int[] nextGreaterMaxUsingStack(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Pop smaller or equal elements
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            // If stack not empty, top is the maximum greater to the right
            if (!stack.isEmpty()) {
                result[i] = stack.peek();
            }
            // Push current element
            stack.push(arr[i]);
        }
        return result;
    }
}