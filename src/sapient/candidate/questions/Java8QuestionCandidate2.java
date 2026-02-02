package sapient.candidate.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8QuestionCandidate2 {
    public static void main(String[] args) {
        String str = "i love my india";

        List<Character> l = new ArrayList<>();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) !=  ' '){
                l.add(str.charAt(i));
            }

        }
        Map<Character, Long> res = l.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("res : "+res);
    }
}
