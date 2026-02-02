import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TT {
    public static void main(String[] args) {
       List<String> coun = Arrays.asList("Gey , DEmark , Englnad , na");

      Optional<String> data = coun.stream().reduce((c1, c2)-> c1.length()>c2.length()? c1:c2);
       data.ifPresent(System.out::println);
    }
}
class P{
    int d;
}
