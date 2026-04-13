package all.tech.practice.logical.arrayProblems;

//Given an integer array number, return an array answer such that answer[i] is equal to the product
// of all the elements of numbers except numbers[i].
//The product of any prefix or suffix

public class ProductOfArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};    // expected = [24,12,8,6]  => 1,2,2,6 =>
        calculateProductOfAnArray(arr);
        calculateProductOfAnArray(new int[]{-1, 1, 0, -3, 3});
        //===========================================================
        System.out.println("\n =========================================================== ");
    }

    public static void calculateProductOfAnArray(int[] arr) {
        int[] prefix = new int[arr.length];
        int[] suffix = new int[arr.length];

        // 1 2 3 4
        int fact = 1;
        for (int i = 0; i < arr.length; i++) {
            prefix[i] = fact;
            fact = fact * arr[i];
        }
        fact = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            suffix[i] = fact;
            fact = fact * arr[i];
        }
        for (int i = 0; i < arr.length; i++)
            arr[i] = prefix[i] * suffix[i];
        System.out.println();
        for (int i : arr) System.out.print(" " + i);
    }
}
