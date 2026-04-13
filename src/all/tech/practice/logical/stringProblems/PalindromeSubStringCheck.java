package all.tech.practice.logical.stringProblems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static all.tech.practice.logical.stringProblems.PalindromeCheckFromChatGPT.longestPalindrome;

/*  To check whether a string (or a substring) is a palindrome,
you typically use one of these approaches:
    ✅ Expand around center (best for finding palindromic substrings)
    ✅ DP / Manacher (for advanced “longest palindromic substring” problems)
*/
public class PalindromeSubStringCheck {
    public static void main(String[] args) {

        // Add/Remove test strings here. Expected outputs are written in comments.
        String[] tests = {
                "racecar",                         // strict=true,  normalized=true,  longest="racecar", count=10
                "abba",                            // strict=true,  normalized=true,  longest="abba",    count=6
                "abc",                             // strict=false, normalized=false, longest="a",       count=3
                "babad",                           // strict=false, normalized=false, longest="bab" OR "aba", count=7
                "cbbd",                            // strict=false, normalized=false, longest="bb",      count=5
                "a",                               // strict=true,  normalized=true,  longest="a",       count=1
                "",                                // strict=true,  normalized=true,  longest="",        count=0
                "A man, a plan, a canal: Panama",  // strict=false, normalized=true,  longest=" a "?? (strict longest depends on punctuation),
                // better to test longest on normalized string separately if needed
                "race a car",                      // strict=false, normalized=false, longest="a" (or any single char), count depends on spaces
                "aaa",                             // strict=true,  normalized=true,  longest="aaa",     count=6
        };

        for (String s : tests) {
            System.out.print("Input: \"" + s + "\"");
            // System.out.println("  Strict Palindrome?     " + isPalindromeStrict(s));
            // System.out.println("  Normalized Palindrome? " + isPalindromeNormalized(s));

            // Longest palindrome for strings with punctuation/spaces may vary because we treat them as normal characters.
            // If you want longest palindrome ignoring punctuation/spaces, we should normalize first then call longestPalindrome().
            System.out.print("  Longest Pal Substring: \"" + allPalindromicSubstringsBruteForce(s) + "\"");
            //  System.out.println("  Pal Substring Count:   " + countAllPalindromicSubstrings(s));
            System.out.print("--------------------------------------------------\n");
        }

        // Optional: Longest palindrome on normalized string example
        String tricky = "A man, a plan, a canal: Panama";
        String normalized = tricky.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        System.out.println("Normalized longest palindrome for: \"" + tricky + "\"");
        System.out.println("Normalized string: \"" + normalized + "\"");
        System.out.println("Longest palindrome (normalized): \"" + longestPalindrome(normalized) + "\""); // expected: "amanaplanacanalpanama"

        System.out.println("==================2nd method..=====================");
        for (String s : tests) {
            System.out.print("Input: \"" + s + "\"");
            // System.out.println("  Strict Palindrome?     " + isPalindromeStrict(s));
            // System.out.println("  Normalized Palindrome? " + isPalindromeNormalized(s));

            // Longest palindrome for strings with punctuation/spaces may vary because we treat them as normal characters.
            // If you want longest palindrome ignoring punctuation/spaces, we should normalize first then call longestPalindrome().
            System.out.print(" Substring is : \"" + longestSubstring(s) + "\"");
            //  System.out.println("  Pal Substring Count:   " + countAllPalindromicSubstrings(s));
            System.out.print("--------------------------------------------------\n");
        }


    }

    // Brute Force way to check all substrings which are Palindrome.
    // If String length is odd then we will use left=i, right=i and if length is even then we will use left=i & right=i+1/
    // And for each iteration do left reduce and right increase to check until match l >= 0 && r < s.length() && arr[left--]=arr[right++]
    // Complexity will be O(n^n) worst-case.
    public static List<String> allPalindromicSubstringsBruteForce(String s) {
        List<String> res = new ArrayList<>();
        int k = (s.length() & 1) == 0 ? 1 : 0; //for odd k=0 , even k=1
        for (int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i + k;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                res.add(s.substring(left, right + 1));
                left--;
                right++;
            }
        }
        return res;
    }



    public static String longestSubstring(String s) {
        if (s == null || s.length() == 0) return "";

        Set<Character> set = new HashSet<>();
        int left = 0, maxLen = 0, startIndex = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            // If duplicate found, shrink window
            while (set.contains(ch)) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(ch);

            if (right - left + 1 > maxLen) {
                maxLen = right - left + 1;
                startIndex = left;
            }
        }

        return s.substring(startIndex, startIndex + maxLen);
    }



}