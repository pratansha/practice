package all.tech.practice.logical.stringProblems;

/*  To check whether a string is a palindrome,
You typically use one of these approaches:
    ✅ Two pointers (fastest & simplest for “is this substring palindrome?”)
         "racecar"   → true
         "abba"      → true
         "abc"       → false
*/
public class PalindromeStringCheck {
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
            System.out.println(" For String: \"" + s + " is palindrome - " + isPalindrome(s) + "\"");
            System.out.println("--------------------------------------------------");
        }
    }

    // This method applicable only for String not substring.We can use here 2 Pointer approach we will search from start and end.
    public static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}