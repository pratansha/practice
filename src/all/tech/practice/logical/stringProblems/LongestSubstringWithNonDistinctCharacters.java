package all.tech.practice.logical.stringProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given a string s and an integer k, find the length (or substring) of the longest contiguous substring that contains at most k distinct characters.
//Distinct characters means unique characters in that substring.
//So if k=2 meaning 2 distinct char is allow but not more than 2 allow.
public class LongestSubstringWithNonDistinctCharacters {
    public static void main(String[] args) {
        String s = "ecebaaa";
        int k = 2;
        System.out.println(getLongestSubstringWithNonDistinctCharactersUsingArray(s, k));
    }

    // Incomplete ....Need to continue work on it....
    private static String getLongestSubstringWithNonDistinctCharactersUsingArray(String str, int k) {
        int[] arr = new int[256];
        Arrays.fill(arr, -1);
        String longestStr = "";
        int currentUniqueCount = 0;
        int left = 0;

        List<String> allTopLongestString = new ArrayList<>();

        //int right = 0;
        for (int right = 0; right < str.length(); right++) {
            char ch = str.charAt(right);

           // while
            if (arr[ch] >= 0) {
                arr[ch]++;
            } else {
                arr[ch] = arr[ch] + 1;
                currentUniqueCount++;

                String temp = str.substring(left, right + 1);
                if (temp.length() >= longestStr.length()) {
                    longestStr = temp;
                    allTopLongestString.add(longestStr);
                }

                while (currentUniqueCount > k) {
                    left++;
                }

            }
        }
        System.out.println(allTopLongestString);
        return longestStr;
    }

    private static int checkCount(String string) {
        return (int) string.chars().mapToObj(ob -> (char) ob).distinct().count();
    }

}