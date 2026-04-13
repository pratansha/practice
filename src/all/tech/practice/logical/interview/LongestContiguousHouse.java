package all.tech.practice.logical.interview;

/*
Problem : https://leetcode.com/discuss/post/5106948/oa-assessment-of-us-company-multiple-que-3bb8/

You are monitoring the building density in a district.
The district is represented as a number line, where a house can be built at an integer position.
Rules:
    1.Initially, there are no houses.
    2.You are given an array queries[] where queries[i] is the position of the house built at step i.
    3.After each house is built, you must determine the length of the longest segment of contiguous houses (consecutive integer positions containing houses).
Return an array ans[] where ans[i] is the longest contiguous segment length after placing the i-th house.
Note (from screenshot):
    1.All house locations in queries are unique.
    2.It is guaranteed that no house is built at a position whose immediate left and right neighbors are both already occupied.
i.e., when placing at x, it will never happen that both (x-1) and (x+1) already have houses.
Assume array indices are 0-based.

✅ Example:
Input:
queries = [2, 1, 3]
Step-by-step:
-------------
Build at 2 → longest segment = 1 ([2])
Build at 1 → longest segment = 2 ([1,2])
Build at 3 → longest segment = 3 ([1,2,3])

Output:
---------
[1, 2, 3]
=========
*/

import java.util.HashMap;
import java.util.Map;

public class LongestContiguousHouse {
    public static void main(String[] args) {
        int[] queries1 = {2, 1, 3}; // expected 3
        int[] queries2 = {5, 1, 2, 4, 3}; // expected 5
        int[] queries3 = {10, 12, 11, 14, 13}; // expected 3
        int[] queries4 = {2, -1, 2, 1, 0}; // expected 4
        int[] queries5 = {3, 4, 1, 2, 5, 6, 7}; // expected 7
        solution(queries1);
        solution(queries2);
        solution(queries3);
        solution(queries4);
        solution(queries5);
        solution(2, 3, 4, 5, 1); //5
    }

    public static void solution(int... queries) {
        int n = queries.length;
        int[] ans = new int[n];

        // Map stores segment length for boundaries and for inserted points
        Map<Integer, Integer> map = new HashMap<>();

        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            int x = queries[i];

            int leftLen = map.getOrDefault(x - 1, 0);
            int rightLen = map.getOrDefault(x + 1, 0);

            int newLen = leftLen + 1 + rightLen;
            // Update the max answer
            maxLen = Math.max(maxLen, newLen);
            ans[i] = maxLen;

            // Determine boundaries of the merged segment
            int leftBoundary = x - leftLen;
            int rightBoundary = x + rightLen;

            // Store new length at boundaries
            map.put(leftBoundary, newLen);
            map.put(rightBoundary, newLen);

            // Store at x too (optional but useful)
            map.put(x, newLen);
        }

        for (int r : ans)
            System.out.print(" " + r);
        System.out.println();
    }
}