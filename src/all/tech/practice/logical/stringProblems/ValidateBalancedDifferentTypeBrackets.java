package all.tech.practice.logical.stringProblems;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ValidateBalancedDifferentTypeBrackets {
    public static void main(String[] args) {
        System.out.println(isValid("[{()}]"));      // true
        System.out.println(isValid("[{[([)]}"));    // false
        System.out.println(isValid("()[]{}"));      // true
        System.out.println(isValid("([)]"));        // false
        System.out.println(isValid("{[]}"));        // true
        System.out.println(isValid("{[}"));         // false
    }

    /* Explanation : Idea is if it starts with any closing then it will be invalid.
     And If for every closing bracket we will pop the stack and the value using the pop should be equal to the value exist in the Map.
     if we will push o
     */
    public static boolean isValid(String s) {
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');

        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            // if it's a closing bracket
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty()) return false;              // nothing to match
                char top = stack.pop();
                if (top != pairs.get(ch)) return false;         // wrong order/mismatch
            }
            // if it's an opening bracket
            else if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            // if other characters exist, either ignore or return false
            else {
                return false; // strict mode
            }
        }
        return stack.isEmpty(); // no leftover openings
    }
}
