package all.tech.practice.logical.arrayProblems;

/* The total number of sub-arrays that contain only zeros
    Example:
    Array: [0, 0, 2, 0]
    Zero-filled sub-arrays are:
    [0] (index 0)
    [0] (index 1)
    [0,0] (index 0–1)
    [0] (index 3)
    Total = 4
    Formula will be use => 1+2+3 ...+ n = n*(n+1)/2 . (Arithmetic Progression (AP)).
*/
public class NumberOfZeroFilledSubArrays {
    public static void main(String[] args) {
        System.out.println("=====================================");
        calculateTotalNonZeroSubArrays(new int[]{0, 0, 0, 2, 0, 0}); // 5(1) + 3(2) + 1(3) = 9.
        System.out.println("=====================================");
        calculateTotalNonZeroSubArrays(new int[]{1, 2, 0, 0, 0, 0, 0, 0, 8, 9, 0, 0}); // 8(1) + 6(2)  + 4(3) + 3(4) + 2(5) + 1(6) = 24
        System.out.println("=====================================");
        calculateTotalNonZeroSubArrays(new int[]{2, 10, 2019}); // 0
        System.out.println("=====================================");
        calculateTotalNonZeroSubArrays(new int[]{0, 0, 0, 2, 0, 0}); // 
        System.out.println("=====================================");
    }

    public static void calculateTotalNonZeroSubArrays(int[] arr) {
        int counter = 0;
        int sum = 0;
        for (int j : arr) {
            if (j == 0) {
                counter++;
            } else {
                sum += counter * (counter + 1) / 2;
                counter = 0;
            }
        }
        sum += counter * (counter + 1) / 2;
        System.out.println("Result is " + sum);
    }
}
