package all.tech.practice.logical.arrayProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupListOfStringsToSetOfAnagrams {
    public static void main(String[] args) {
        convertFromListToGroupOfSetsOfAnagrams("eat", "tea", "tan", "ate", "nat", "bat");
        convertFromListToGroupOfSetsOfAnagrams("listen", "silent", "enlist", "rat", "tar", "art");
        convertFromListToGroupOfSetsOfAnagrams("apple", "banana", "cherry");
        convertFromListToGroupOfSetsOfAnagrams("a", "b", "a", "c", "b");
        convertFromListToGroupOfSetsOfAnagrams("abb", "bba", "bab", "abc", "cab");
    }

    private static void convertFromListToGroupOfSetsOfAnagrams(String... array) {
        Map<String, List<String>> map = new HashMap<>();
        for (String string : array) {
            String key = calculateCanonicalFromString(string);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(string);
        }
        System.out.println(map);
        /*List<List<String>> arrayList = new ArrayList<>(map.values());
        System.out.println(arrayList);*/
    }

    private static String calculateCanonicalFromString(String str) {
        int[] temp = new int[26];
        for (int i = 0; i < str.length(); i++) {
            temp[str.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] > 0)
                sb.append((char) (i + 'a')).append(temp[i]).append("#");
        }
        return sb.toString();
    }
}
