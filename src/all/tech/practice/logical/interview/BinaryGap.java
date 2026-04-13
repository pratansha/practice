package all.tech.practice.logical.interview;

//link : https://codility-solutions.com/lessons/lesson-1-iterations/binarygap/
//link : https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
public class BinaryGap {
    public static void main(String[] args) {
        solution(9); //1001
        solution(137); //10001001
        solution(10); // 1010
        solution(8); //0001000
        solution(33); // 100001
        solution(15); //1111
        solution(41); //00101001
        System.out.println();
    }

    private static void solution(int number) {
        int max = 0;
        String binary = Integer.toBinaryString(number);
        System.out.println("String value is :" + binary);
        int n = binary.length();
        int[] res = new int[binary.length()];

        int pre = -1;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (binary.charAt(i) == '1') {
                int diff = i - pre - 1;
                pre = i;
                if (diff > 0 && diff <= i) {
                    res[j++] = diff;
                    max = Math.max(max, diff);
                }
            }
        }
        for (int re : res)
            System.out.print(" " + re);
        System.out.print(" , & max is :" + max);
        System.out.println();
    }

    private static void solution1(int number) {
        String binaryString = Integer.toBinaryString(number);
        System.out.println("String value is :" + binaryString);
        int n = binaryString.length();

        int prePos;
        int pos = 0;
        while (pos < binaryString.length() && binaryString.charAt(pos) == '1')
            pos++;

        int[] res = new int[binaryString.length()];
        prePos = --pos;

        int zerCount;
        int max = 0;
        int j = 0;
        for (int i = pos; i < n; i++) {
            if (binaryString.charAt(pos) == '1') {
                zerCount = pos - prePos - 1;
                prePos = pos;
                if (zerCount > 0) res[j++] = zerCount;
                max = Math.max(max, zerCount);
            }
            pos++;
        }

        for (int re : res)
            System.out.print(" " + re);
        System.out.print(" , & max is :" + max);
        System.out.println();
    }
}