package all.tech.practice.logical.arrayProblems;

import java.util.*;
import java.util.stream.Collectors;

/*
✅ Problem Statement
Given an array/list of words and an integer k, return the top k most frequent words.

✅ Sorting Rules
    Higher frequency first
    If frequencies are equal → lexicographical (dictionary) order ascending
So you sort by:
    frequency DESC
    word ASC (when tie)

Example : input = ["i","love","let-code","i","love","coding"], k = 2
Output : ["i","love"]
*/
public class MostFrequentWordsK {
    public static void main(String[] args) {
        System.out.println(topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2)); // [i, love]
        System.out.println(topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4)); // [the, is, sunny, day]
    }

    private static List<String> topKFrequent(String[] strings, int i) {
        return Arrays.stream(strings).collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder())
                        .thenComparing(Map.Entry.comparingByKey())) // lexicographic
                .limit(i)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}