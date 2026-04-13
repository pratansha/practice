package all.tech.practice.logical.arrayProblems;

// Given an integer array numbers, rotate the array to the right by k steps, where k is non-negative.
public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        // right rotate=> 7,1,2,3,4,5,6 => 6,7,1,2,3,4,5 => 5,6,7,1,2,3,4
        // expected output when rotate by 3 is : [5,6,7,1,2,3,4]
        RotateArray.sufflingWithNewArrayToRight(arr, k);

        int[] arr2 = {-1, -100, 3, 99};
        int k2 = 2;
        //expected output when rotate by 2 is : [3,99,-1,-100]
        RotateArray.sufflingWithNewArrayToRight(arr2, k2);
        //===========================================================
        System.out.println("\n ===========================================================");
        rotateAnArrayWithoutNewArrayToRight(new int[]{1, 2, 3, 4, 5, 6, 7}, k);
        rotateAnArrayWithoutNewArrayToRight(new int[]{-1, -100, 3, 99}, k2);

        //===========================================================
        System.out.println("\n ===========================================================");
        rotateAnArrayWithoutNewArrayToLeft(new int[]{1, 2, 3, 4, 5, 6, 7}, k);
        rotateAnArrayWithoutNewArrayToLeft(new int[]{-1, -100, 3, 99}, k2);
    }

    // This method have an extra space complexity of log(k).
    public static void sufflingWithNewArrayToRight(int[] arr, int k) {
        int[] newArray = new int[k];
        int counter = 1;
        int suffle = arr.length - 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (counter <= k) {
                newArray[--k] = arr[i];
            } else
                arr[suffle--] = arr[i];
        }

        System.arraycopy(newArray, 0, arr, 0, newArray.length);
        System.out.println("\n Result is :");
        for (int i : arr) {
            System.out.print(" " + i);
        }
    }

    public static void rotateAnArrayWithoutNewArrayToRight(int[] arr, int k) {
        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, arr.length - 1);
        System.out.println("\n Second Result is :");
        for (int i : arr) {
            System.out.print(" " + i);
        }
    }

    public static void rotateAnArrayWithoutNewArrayToLeft(int[] arr, int k) {
        // input = {1, 2, 3, 4, 5, 6, 7}
        // expected = {4,5,6,7,1,2,3}
        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, k);
        reverse(arr, k + 1, arr.length - 1);
        System.out.println("\n Second Result is :");
        for (int i : arr) {
            System.out.print(" " + i);
        }
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }
}
