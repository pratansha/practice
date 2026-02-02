package practice.general;

public class FirstNonRepeatCharacter {
    public static void main(String[] args) {

       String s="why sky is so high why sky";

       s.chars().mapToLong(x -> x)
               .filter(x -> s.indexOf((int) x) == s.lastIndexOf((int) x))
               .findFirst()
               .ifPresent(x ->
                       System.out.println((char)x)
               );

    }
}
