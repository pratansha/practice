package all.tech.practice.logical.arrayProblems;

// A contiguous sub-array means a sequence of elements taken from the array without skipping any elements in between.
// Finds the maximum sum of any contiguous sub-array in an array.
// Kadane’s Algorithm — one of the most elegant ways to solve the Maximum Sub-array Problem.
public class KadaneAlgorithm {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(checkMaximumContiguous(1, -3, 2, 1, -1));
        System.out.println("==================================================");
        System.out.println(checkMaximumContiguous(-3, -2, -41, -1));
        System.out.println("==================================================");
        System.out.println(checkMaximumContiguous(-1, -3, 2, 1, -1));
        System.out.println("==================================================");
        System.out.println(checkMaximumContiguous(-11, -3, 2, -1, 9));
        System.out.println("==================================================");
        System.out.println(checkMaximumContiguous(1, 2, 3, 4, 5));
        System.out.println("==================================================");
        System.out.println("========================Test=========================");
        System.out.println(checkMaximumContiguousTest(1, -3, 2, 1, -1));
        System.out.println(checkMaximumContiguousTest(-3, -2, -41, -1));
        System.out.println(checkMaximumContiguousTest(-1, -3, 2, 1, -1));
        System.out.println(checkMaximumContiguousTest(-11, -3, 2, -1, 9));
        System.out.println(checkMaximumContiguousTest(1, 2, 3, 4, 5));

    }

    public static int checkMaximumContiguous(int... arr) {
        int maxSoFar = 0;
        int currentSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSoFar = Math.max(maxSoFar, currentSum);
        }
        return maxSoFar;
    }

    public static int checkMaximumContiguousTest(int... arr) {
        int overallSum = 0;
        int currentSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currentSum = Math.max(currentSum + arr[i], arr[i]);
            overallSum = Math.max(currentSum, overallSum);
        }
        return overallSum;
    }
}
