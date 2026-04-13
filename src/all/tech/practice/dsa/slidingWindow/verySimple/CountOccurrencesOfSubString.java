package all.tech.practice.dsa.slidingWindow.verySimple;

public class CountOccurrencesOfSubString {
    public static void main(String[] args) {
        String str = "fforrforfxdoforfor"; // this is main string where we need to check anagram exists or not.
        String requiredStr = "for"; // search anagram for this substring.
        System.out.println("Result is - " + countOccurrencesOfGivenStr(str, requiredStr));
        System.out.println(countOccurrencesOfGivenStrTest(str, requiredStr));
    }

    private static int countOccurrencesOfGivenStr(String str, String requiredStr) {
        int counter = 0;
        int len = requiredStr.length();
        for (int i = 0; i < str.length() - len + 1; i++) {
            String ret = str.substring(i, len + i);
            if (requiredStr.equalsIgnoreCase(ret)) {
                counter++;
            }
        }
        return counter;
    }

    private static int countOccurrencesOfGivenStrTest(String str, String requiredStr) {
        int leftOfRequiredStrMax = requiredStr.length();
        int count = 0;
        for (int i = 0; i < str.length() - leftOfRequiredStrMax + 1; i++) {
            if (str.substring(i, leftOfRequiredStrMax + i).equals(requiredStr)) {
                count++;
            }
        }
        return count;
    }
}