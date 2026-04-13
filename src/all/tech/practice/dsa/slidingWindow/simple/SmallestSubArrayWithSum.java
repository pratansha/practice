package all.tech.practice.dsa.slidingWindow.simple;

//Your task is to find the length of the smallest contiguous sub-array whose sum is greater than or equal to K.
//If no such sub-array exists, return 0.
public class SmallestSubArrayWithSum {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 2, 4, 3};
        int k = 7;
        // expected Output: 2
        System.out.println("Smallest sub-array length: " + smallestSubArrayLength(arr, k));

        int[] arr2 = {2, 3, 1, 2, 4, 3, 5};
        int k2 = 5;
        // expected Output: 1
        System.out.println("Smallest sub-array length: " + smallestSubArrayLength(arr2, k2));

        System.out.println("========================================");
        System.out.println(smallestSubArrayLengthTest(arr, k));
        System.out.println(smallestSubArrayLengthTest(arr2, k2));
    }

    public static int smallestSubArrayLength(int[] arr, int k) {
        int left = 0;
        int windowSum = 0;
        int minLength = arr.length;

        for (int i = 0; i < arr.length; i++) {
            windowSum = windowSum + arr[i];
            while (windowSum >= k) {
                minLength = Math.min(minLength, i - left + 1);
                windowSum = windowSum - arr[left++];
            }
        }
        return minLength;
    }

    public static int smallestSubArrayLengthTest(int[] arr, int k) {
        int sum = 0;
        int length = arr.length;
        int left = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            while (sum >= k) {
                length = Math.min(length, i - left + 1);
                sum = sum - arr[left++];
            }
        }
        return length;
    }

}
