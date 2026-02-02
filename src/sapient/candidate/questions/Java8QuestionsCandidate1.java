package sapient.candidate.questions;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Java8QuestionsCandidate1 {
    public static void main(String[] args) {
        // Find the frequency of each character in a string using Java 8
        String str = "i love my india";


        Arrays.stream(str.split(" ")).collect(Collectors.toList()).forEach(System.out::println);
        str.chars().mapToObj(x -> (char) x).filter(x -> !x.equals(' ')).collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet().forEach(x -> System.out.println(x.getKey() + " : " + x.getValue()));


        //String[] arr= str.split("");
        // Arrays.stream(arr).filter(x ->!x.equals(" ")).collect(Collector.of(ArrayList::new,ArrayList::addAll))

        // print numbers which starts with 1.
        int[] num = {123, 456, 789, 145, 167, 890};
        List<Integer> numbers = Arrays.asList(123, 456, 789, 145, 167, 890);
        numbers.stream().map(Object::toString).filter(x -> x.startsWith("1"))
                .forEach(System.out::println);


        Map<String, Long> map = new TreeMap<>((a, b) -> b.compareTo(a));
        map.put("A", 10L);
        map.put("B", 20L);
        map.put("C", 30L);
        map.put("D", 40L);
        System.out.println(map);
    }
}
