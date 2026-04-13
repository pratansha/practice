package all.tech.practice.logical.bitwise;

/* Given an integer num, count how many steps are required to reduce it to 0 using:
    If num is even → num = num / 2
    If num is odd → num = num - 1
  Return the number of steps.
------------------------------------------------------------
Example: num = 14
Steps:
    14 is even → 14 / 2 = 7
    7 is odd → 7 - 1 = 6
    6 is even → 6 / 2 = 3
    3 is odd → 3 - 1 = 2
    2 is even → 2 / 2 = 1
    1 is odd → 1 - 1 = 0
✅ Answer = 6 steps
*/
public class NumberOfStepsToReduceANumberToZero {
    public static void main(String[] args) {
        System.out.println("Number of steps are :" + numberOfStepsUsingDivide(14));
        System.out.println("Number of steps are :" + numberOfStepsUsingDivide(15));
        System.out.println("Number of steps are :" + numberOfStepsUsingDivide(0));
        System.out.println("Number of steps are :" + numberOfStepsUsingDivide(9));
        System.out.println("Number of steps are :" + numberOfStepsUsingDivide(4));
        System.out.println("-------------------------------");

        System.out.println("Number of steps using 2nd way are :" + numberOfStepsUsingBitwiseOperator(14));
        System.out.println("Number of steps using 2nd way are :" + numberOfStepsUsingBitwiseOperator(15));
        System.out.println("Number of steps using 2nd way are :" + numberOfStepsUsingBitwiseOperator(0));
        System.out.println("Number of steps using 2nd way are :" + numberOfStepsUsingBitwiseOperator(9));
        System.out.println("Number of steps using 2nd way are :" + numberOfStepsUsingBitwiseOperator(4));


        System.out.println("-------------------------------");

        System.out.println("Number of steps using 3rd way are :" + numberOfStepsFast(14));
        System.out.println("Number of steps using 3rd way are :" + numberOfStepsFast(15));
        System.out.println("Number of steps using 3rd way are :" + numberOfStepsFast(0));
        System.out.println("Number of steps using 3rd way are :" + numberOfStepsFast(9));
        System.out.println("Number of steps using 3rd way are :" + numberOfStepsFast(4));

    }

    //  Using 2nd way where we will use right bitwise('>>') operator.
    public static int numberOfStepsUsingBitwiseOperator(int num) {
        int step = 0;
        if ((num & 1) == 1) {
            num = num - 1;
            step++;
        }
        while (num > 0) {
            num = num >> 1;  // This is also dividing but with Right bitwise shifting by 1 bit.
            num = num - 1;
            step = step + 2;
        }
        return step;
    }

    // Using one way where we will use divide ('/').
    // Concept is If number will be odd then steps will one more.
    // when we divide a even number then it always gives is odd number so we can minus it in the same loop itself instead of checking again whether number is odd or even.
    public static int numberOfStepsUsingDivide(int num) {
        int steps = 0;
        if ((num & 1) == 1) {
            num = num - 1;
            steps++;
        }

        while (num > 0) {
            num = num / 2;  // 1110 & 0010   0010
            num = num - 1;
            steps = steps + 2;
        }
        return steps;
    }

    //(Imp)  For a positive number num:
    public static int numberOfStepsFast(int num) {
        //Formula steps = (number of bits in num - 1) + (number of set bits in num)
        if (num == 0) return 0;

        int bitLength = 32 - Integer.numberOfLeadingZeros(num);
        int ones = Integer.bitCount(num);
        return bitLength - 1 + ones;
    }

}