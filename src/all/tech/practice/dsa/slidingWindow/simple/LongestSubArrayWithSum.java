package all.tech.practice.dsa.slidingWindow.simple;

public class LongestSubArrayWithSum {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 7;
        // expected output =3
        System.out.println(longestSubArrayLength(arr, k));

        int[] arr2 = {2, 1, 4, 1, 1, 2, 1, 1, 0};
        int k2 = 7;
        // expected output =6
        System.out.println(longestSubArrayLength(arr2, k2));

        int[] arr3 = {2, 1, 3, 1, 1, 1, 0};
        int k3 = 7;
        // expected output =6
        System.out.println(longestSubArrayLength(arr3, k3));
        System.out.println("=============================================");

        System.out.println(longestSubArrayLengthTest(arr, 7));
        System.out.println(longestSubArrayLengthTest(arr2, 7));
        System.out.println(longestSubArrayLengthTest(arr3, 7));
    }

    public static int longestSubArrayLength(int[] arr, int k) {
        int maxLen = 0;
        int left = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            while (sum > k) {
                sum -= arr[left++];
            }
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
    }

    public static int longestSubArrayLengthTest(int[] arr, int k) {
        int sum = 0;
        int start = 0;
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sum <= k) {
                sum = sum + arr[i];
                maxLength++;
            }
            while (sum > k) {
                sum = sum - arr[start++];
                maxLength = maxLength - 1;
                maxLength = Math.max(maxLength, i - start + 1);
            }
        }
        return maxLength;
    }

}