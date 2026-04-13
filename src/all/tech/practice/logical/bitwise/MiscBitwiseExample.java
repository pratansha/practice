package all.tech.practice.logical.bitwise;

public class MiscBitwiseExample {
    public static void main(String[] args) {
        int n1 = convertToDecimalFromBinary("111110001010101");
        int n2 = convertToDecimalFromBinary("11111000101010111111");
        System.out.println("count of 1's is :" + n1);
        System.out.println("count of 1's is :" + n2);

        // Check how many 1's in this number
        checkHowMany1sNumbers(n1);
        checkHowMany1sNumbers(n2);

        // check if a number if Power of 2 or not.
        System.out.println("This number is power of 2 or no :" + isPowerOfTwo(64));
        System.out.println("This number is power of 2 or no :" + isPowerOfTwo(128));
        System.out.println("This number is power of 2 or no :" + isPowerOfTwo(81));

        // Check Remainder of 2.
        checkRemainderIs1Or0();

        // Check number is odd or even.
        System.out.println("Number is Odd or Even :" + checkNumberIsOddOrEven(2));
        System.out.println("Number is Odd or Even :" + checkNumberIsOddOrEven(4));
        System.out.println("Number is Odd or Even :" + checkNumberIsOddOrEven(10));
        System.out.println("Number is Odd or Even :" + checkNumberIsOddOrEven(21));

        // Get the Binary number of Integer.
        System.out.println(" Binary number is : " + convertToBinaryFromDecimal(8));
        System.out.println(" Binary number is : " + convertToBinaryFromDecimal(21));
        System.out.println(" Binary number is : " + convertToBinaryFromDecimal(15));
        System.out.println(" Binary number is : " + convertToBinaryFromDecimal(128));
    }

    // Convert to Decimal Number...
    private static int convertToDecimalFromBinary(String binaryString) {
        return Integer.parseInt(binaryString, 2);
    }

    // Convert to Decimal Number...
    private static String convertToBinaryFromDecimal(int number) {
        return Integer.toString(number, 2);
    }

    // Count the 1s Digit or remove number of 1s from the Binary number.
    private static void checkHowMany1sNumbers(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1); // (Brian Kernighan's algo) => n = n&(n-1) = 1011 & 1010 = 1010=10 , 1010 & 1001 = 1000 =8 , 1000 & 0111 = 0
            count++;
        }
        System.out.println("number of 1s is :" + count);
    }

    // Check Power of 2s.
    private static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    // Check Remainder is 1 or 0.
    private static void checkRemainderIs1Or0() {
        // Check Remainder of 2.
        System.out.println("Check Remainder is 1 or 0 :-");
        System.out.println(2 & 1); // 0010 AND 0001 = 0
        System.out.println(3 & 1); // 0011 AND 0001 = 1
        System.out.println(4 & 1); // 0100 AND 0001 = 0
        System.out.println(5 & 1); // 0101 AND 0001 = 1
        System.out.println(15 & 1);// 1111 AND 0001 = 1
    }

    // Check number is odd or even without Remainder.
    private static String checkNumberIsOddOrEven(int n) {
        if ((n & 1) == 0)
            return "even";
        return "odd";
    }


}
