package all.tech.practice.logical.bitwise;

/*
✅191. Number of 1 Bits (Hamming Weight)
🔎  What is the question?
    Given an integer n, return how many 1 bits are in its binary representation.

Example:
    n = 11
    Binary: 1011
    Number of 1 bit = 3
*/
public class HammingWeightProblem {
    public static void main(String[] args) {
        System.out.println(hammingWeight(11));  // expected =3
        System.out.println(hammingWeight(128)); // expected =1
        System.out.println(hammingWeight(0));  //  expected =0

        System.out.println("==================");

        System.out.println(hammingWeightShift(11));  // expected =3
        System.out.println(hammingWeightShift(128)); // expected =1
        System.out.println(hammingWeightShift(0));  //  expected =0
    }

    // First way to count using Brian Kernighan Algorithms.
    private static int hammingWeight(int n) {
        int counter = 0;
        System.out.println("hammingWeight is :" + n);
        while (n != 0) {
            n = n & (n - 1); // Brian Kernighan Algorithms.
            System.out.print("," + n);
            counter++;
        }
        System.out.println();
        return counter;
    }


    /*
    It examines all 32 bits of the integer n (because Java int is 32-bit signed) and counts how many bits are 1.
    Each iteration looks at one bit (the least significant bit).
    After checking that bit, it shifts n so the next bit becomes the least significant bit.
    After 32 steps, every original bit has been checked once.
    */
    private static int hammingWeightShift(int n) {
        int counter = 0;
        for (int i = 0; i < 32; i++) {
            counter += (n & 1);
            n >>>= 1; // unsigned shift (important for negative numbers)
        }
        return counter;
    }
}
