package practice.logical;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PermutationCalculation {
    public static void main(String[] args) {
        String str = "cat";
        List<String> result = new ArrayList<>();
        permute(str, "", result);
        extractPalindrome(result);
        System.out.println(result);
        System.out.println(extractPalindrome(result));
    }

    private static Set<String> extractPalindrome(List<String> result) {
        return result.stream().filter(str -> {
            int pre = (str.length() / 2) - 1;
            if (str.length() / 2 == 0)
                return str.substring(0, pre).equals(str.substring(pre + 1));
            else return str.substring(0, pre).equals(str.substring(pre + 2));
        }).collect(Collectors.toSet());
    }

    public static void permute(String str, String prefix, List<String> result) {
        if (str == null || str.isEmpty()) {
            System.out.println("Adding to list : " + prefix);
            result.add(prefix);
        } else {
            // System.out.println("permute starting for str :" + str);
            for (int i = 0; i < str.length(); i++) {
                System.out.print("str = " + str + " , pre-prefix = " + prefix);
                String remaining = str.substring(0, i) + str.substring(i + 1);
                System.out.println("  i=" + i + " , prefix : " + prefix + str.charAt(i) + " , remaining : " + remaining);
                permute(remaining, prefix + str.charAt(i), result);
            }
        }
    }
}
