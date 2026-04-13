package all.tech.practice.logical.arrayProblems;

public class AnagramOfEachOther {
    public static void main(String[] args) {
        System.out.println(isAnagramLowercase("eat", "tea"));   // true
        System.out.println(isAnagramLowercase("tan", "nat"));   // true
        System.out.println(isAnagramLowercase("bat", "tab"));   // true
        System.out.println(isAnagramLowercase("hello", "bello"));// false
        System.out.println(isAnagramLowercase("ab", "ac"));// false
        System.out.println(isAnagramLowercase("ab", "ba"));// true
    }

    public static boolean isAnagramLowercase(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        if (s1.length() != s2.length()) return false;

        int[] temp = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 < 'a' || c1 > 'z' || c2 < 'a' || c2 > 'z') return false; // extra verification for chars.

            temp[s1.charAt(i) - 'a']++;
            temp[s2.charAt(i) - 'a']--;
        }
        // safe condition
        for (int v : temp) {
            if (v != 0) return false;
        }

        // unsafe condition.
        for (int i = 0; i < s1.length(); i++)
            if (temp[s1.charAt(i) - 'a'] != 0)
                return false;
        return true;
    }
}
