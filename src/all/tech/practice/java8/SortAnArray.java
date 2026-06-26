package all.tech.practice.java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SortAnArray {
    public static void main(String[] args) {
        String a1 = "hello";
        String a2 = "hello";
        System.out.println(a1==a2);
        System.out.println(a1.equals(a2));

        int[] arr = {1, 3, 2, 20, 6, 8, 7};
        List<Integer> sorted = Arrays.stream(arr).boxed().sorted().toList();
        sorted.forEach(System.out::println);

        HashMap<Integer,Integer> hashMap = new HashMap<>();
        hashMap.put(null,1);
        hashMap.put(null,2);
        hashMap.put(null,3);
        hashMap.put(null,4);

        System.out.println(hashMap.get(null));
    }
}