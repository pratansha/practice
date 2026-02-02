package all.tech.practice.problems;

public class GetFirstLongestSubString {
    public static void main(String[] args) {

        String s = "abcabcdababs";
        String longest = "";
        String[] substrings = s.split("a");
        for (String substring : substrings) {
            if (substring.length() > longest.length()) {
                longest = substring;
            }
        }
       // System.out.println("Longest substring without 'a': " + longest);
    }
}
