package practice.general;

import java.util.*;
import java.util.stream.Stream;

public class TwoSum {
    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 3, 6, 9, 0, 0};
        int target = 9;
        String[] res = twoSum(numbers, target);
        Stream.of(res).filter(Objects::nonNull).forEach(System.out::println);
    }

    public static String[] twoSum(int[] numbers, int target) {
        Map<Integer, String> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                list.add(map.get(numbers[i]).split(",")[1] + "," + i);
            } else {
                map.put(target - numbers[i], numbers[i] + "," + i);
            }
        }

        String[] arr = new String[list.size()];
        return list.toArray(arr);
    }

    public int[] twoSumOnLet(int[] numbers, int target) {
        Map<Integer, String> map = new HashMap<>();

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                list.add(Integer.parseInt(map.get(numbers[i]).split(",")[1]));
                list.add(i);
            } else {
                map.put(target - numbers[i], numbers[i] + "," + i);
            }
        }

        int[] arr = new int[list.size()];
        for (int j = 0; j < list.size(); j++) {
            arr[j] = list.get(j);
        }
        return arr;
    }
}