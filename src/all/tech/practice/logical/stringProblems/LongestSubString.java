package all.tech.practice.logical.stringProblems;

// Longest substring without 'a':
public class LongestSubString {
    public static void main(String[] args) {
        String s = "abcabcdababs"; // expected = bcd

        String longest = "";
        String[] substrings = s.split("a");
        for (String substring : substrings) {
            if (substring.length() > longest.length()) {
                longest = substring;
            }
        }
        System.out.println("Longest substring without 'a': " + longest);
    }
}
