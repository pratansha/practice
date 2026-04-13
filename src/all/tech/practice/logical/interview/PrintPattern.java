package all.tech.practice.logical.interview;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
Pattern Example (n = 5)
"       *****
        *   *
        *   *
        *   *
        *****
"
Pattern Example (n = 4)
"       ****
        *  *
        *  *
        ****
"
Pattern Example (n = 3)
"       ***
        * *
        ***
"
Pattern Example (n = 2)
"       **
        **
"
Not allow less than 2.
*/
public class PrintPattern {
    public static void main(String[] args) {
        printPattern(5);
        System.out.println();
        printPattern(4);
        System.out.println();
        printPattern(3);
        System.out.println();
        printPattern(2);
    }

    private static void printPattern(int n) {
        if (n <= 1) {
            throw new IllegalArgumentException("number not allow lesser than 2.");
        }

        String[] res = new String[n];
        String topAndBottom = IntStream.range(0, n).mapToObj(x -> "*").collect(Collectors.joining());
        String middleRow = "*" + IntStream.range(0, n - 2).mapToObj(x -> " ").collect(Collectors.joining()) + "*";

        res[0] = topAndBottom;
        res[n - 1] = topAndBottom;
        for (int i = 1; i <= n - 2; i++) {
            res[i] = middleRow;
        }

        for (String s : res) {
            System.out.println(s);
        }
    }
}
