package all.tech.practice.logical.stringProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Find FindLongest Substring non-repeatable characters.
public class FindLongestSubstring {
    public static void main(String[] args) {
        String input = getLongestStringUsingArray("abcabcbbabcde");
        System.out.println("1.Using Array Maximum longest non repetitive substring is :" + input + " where length is :" + input.length());
        input = getLongestStringUsingMap("abcabcbbabcde");
        System.out.println("1.Using Map Maximum longest non repetitive substring is :" + input + " where length is :" + input.length());

        input = getLongestStringUsingArray("aaaaa");
        System.out.println("2.Using Array Maximum longest non repetitive substring is :" + input + " where length is :" + input.length());
        input = getLongestStringUsingMap("aaaaa");
        System.out.println("2.Using Map Maximum longest non repetitive substring is :" + input + " where length is :" + input.length());

        input = getLongestStringUsingArray("aaaaaaaaaabb");
        System.out.println("3.Using Array Maximum longest non repetitive substring is :" + input + " where length is :" + input.length());
        input = getLongestStringUsingMap("aaaaaaaaaabb");
        System.out.println("3.Using Map Maximum longest non repetitive substring is :" + input + " where length is :" + input.length());
        input = getLongestStringUsingArray("abbbbb");
        System.out.println("3.Using Array Maximum longest non repetitive substring is :" + input + " where length is :" + input.length());

    }

    // Use a Pointer left=0 which will increase by 1 only when a repeatable character found in that particular location.
    // Location tracing for each character will be feeding char count at particular index.
    // We also need to create an array of 256 char length and filling it with -1 values.
    private static String getLongestStringUsingArray(String inputStr) {
        int left = 0;
        String longestSubString = "";
        int[] arr = new int[256]; // 256 ASCII chars.
        Arrays.fill(arr, -1);

        for (int i = 0; i < inputStr.length(); i++) {
            char c = inputStr.charAt(i);
            if (arr[c] >= left) { // 0
                left = arr[c] + 1;
            }
            arr[c] = i;
            String temp = inputStr.substring(left, i + 1);
            if (temp.length() > longestSubString.length()) {
                longestSubString = temp;
            }
        }
        return longestSubString;
    }

    private static String getLongestStringUsingMap(String inputStr) {
        Map<Character, Integer> map = new HashMap<>();
        String maxString = "";
        int left = 0;
        for (int i = 0; i < inputStr.length(); i++) {
            char c = inputStr.charAt(i);
            if (map.containsKey(c) && map.get(c) >= left) {
                left = map.get(c) + 1;
            }
            map.put(c, i);
            String tempStr = inputStr.substring(left, i + 1);
            if (tempStr.length() > maxString.length()) {
                maxString = tempStr;
            }
        }
        return maxString;
    }
}