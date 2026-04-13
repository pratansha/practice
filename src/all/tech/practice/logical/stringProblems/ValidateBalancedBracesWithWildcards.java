package all.tech.practice.logical.stringProblems;

import java.util.*;

/*✅ Problem: Validate Balanced Braces With Wildcards (*)
Question
You are given a string s containing only the characters:
    { : opening brace
    } : closing brace
    * : wildcard that can represent {, }, or empty string ("")

Write a function to determine whether the string can be interpreted as a balanced brace expression.
A brace expression is balanced if:

NOTE:
Every closing brace "}" has a matching opening brace "{" before it.
After processing the full string, all opening braces are matched (no unmatched "{" left).
✅ Sample Examples
Valid
    "{}"    ✅
    "{*}"   ✅ (treat * as empty → "{}")
    "*{}"   ✅ (treat * as empty)
    "{**}"  ✅ (treat one * as { and one * as } → "{{}}")
    "*"     ✅ (treat * as empty)

Invalid
    "}{"    ❌ (closing before opening)
    "{}}"   ❌ (extra closing brace)
    "{{"    ❌ (unclosed opening braces)
*/
public class ValidateBalancedBracesWithWildcards {
    public static void main(String[] args) {
        String[] tests = {
                /*"{}", "{*}", "*{}", "{**}", "*",
                "}{", "{}}", "{{", "{*}}",
                "{{*}}",*/
                "*}", "*{}}", "{*", "{{}*", "{{*}", "{*{"
        };

        for (String t : tests) {
            System.out.print(t + " -> " + isBalancedUsingStack(t) + " , ");
        }

        System.out.println("\n================================");
        for (String t : tests) {
            System.out.print(t + " -> " + isBalanced(t) + " , ");
        }

        System.out.println("\n================================");
        for (String t : tests) {
            System.out.print(t + " -> " + isBalancedWithStar(t) + " , ");
        }
    }

    private static boolean isBalancedUsingStack(String t) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '{')
                stack.add(t.charAt(i));
            else if (t.charAt(i) == '}' && !stack.isEmpty())
                stack.pop();
            else if (t.charAt(i) == '}')
                return false;
        }
        return stack.isEmpty();
    }

    private static boolean isBalanced(String t) {
        int pointer = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '{')
                pointer++;
            else if (t.charAt(i) == '}' && pointer > 0)
                pointer--;
            else if (t.charAt(i) == '}')
                return false;
        }

        return pointer == 0;
    }

    // This method considers asterisk(8) sign.
    /* Explanation : We have used 2 pointer because if there is just 2 brackets then single pointer was enough
     * but it is given asterisk(*) which may be open { or close } that's why we have considered 2 pointer.
     * One Pointer will consider increase another will consider decrease of the pointer.
     * and lastly we check whether increasing pointer should not be lesser than 0 otherwise it will not be balanced.
     * */
    private static boolean isBalancedWithStar(String s) {
        int minOpen = 0; // minimum possible '{' open
        int maxOpen = 0; // maximum possible '{' open

        for (char c : s.toCharArray()) {
            if (c == '{') {
                minOpen++;
                maxOpen++;
            } else if (c == '}') {
                minOpen--;
                maxOpen--;
            } else if (c == '*') {
                // * can be { or } or empty
                minOpen--;   // treat as }
                maxOpen++;   // treat as {
            } else {
                return false; // invalid character
            }

            if (maxOpen < 0) return false;  // too many }
            if (minOpen < 0) minOpen = 0;   // clamp
        }
        return minOpen == 0;
    }
}