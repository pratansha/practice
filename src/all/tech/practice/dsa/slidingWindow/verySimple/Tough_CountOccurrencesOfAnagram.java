package all.tech.practice.dsa.slidingWindow.verySimple;

import java.util.Arrays;

// CountAnagramsSlidingWindow
public class Tough_CountOccurrencesOfAnagram {
    public static void main(String[] args) {
        String str = "xorfxorfxdofr"; // this is main string where we need to check anagram exists or not.
        String pat = "for"; // search anagram for this substring.
        System.out.println("Result is : " + countOccurrencesOfGivenStringAnagram(str, pat));
    }

    public static int countOccurrencesOfGivenStringAnagram(String str, String pat) {
        if (str == null || pat == null || pat.length() > str.length()) return 0;

        int[] temp = new int[256];
        int counter = 0;
        int patLength = pat.length();

        // 1) Add pattern frequency
        for (int i = 0; i < patLength; i++) {
            temp[pat.charAt(i)]++;
        }

        // 2) Subtract first window frequency
        for (int i = 0; i < patLength; i++) {
            temp[str.charAt(i)]--;
        }

        // ✅ FIX: Count nonZero across full array (0..255)
        int nonZero = 0;
        for (int i = 0; i < 256; i++) {
            if (temp[i] != 0) nonZero++;
        }

        // Check first window
        if (nonZero == 0) counter++;

        // 3) Slide windows
        for (int i = patLength; i < str.length(); i++) {
            char in = str.charAt(i);
            char out = str.charAt(i - patLength);

            Arrays.stream(temp).filter(x -> x != 0).mapToObj(x -> "|" + x + "-" + (char) x + "|,").forEach(x -> System.out.print(" " + x));

            // Incoming enters window => diff[in]--
            nonZero = updateNonZero(temp, nonZero, in, -1);
            // Outgoing leaves window => diff[out]++
            nonZero = updateNonZero(temp, nonZero, out, +1);

            if (nonZero == 0) counter++;
        }
        return counter;
    }

    private static int updateNonZero(int[] diff, int nonZero, char ch, int delta) {
        int idx = ch;               // same as (int) ch
        int before = diff[ch];
        int after = before + delta;
        diff[idx] = after;

        if (before != 0 && after == 0) nonZero--;
        else if (before == 0 && after != 0) nonZero++;

        return nonZero;
    }
}

