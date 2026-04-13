package all.tech.practice.logical.arrayProblems;

// Reverse an Array without any additional Array .
public class ReverseAnArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        ReverseAnArray.reverseAnArrayWithoutNewArray(arr);
    }
    public static void reverseAnArrayWithoutNewArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
        System.out.println(" Output is :");
        for (int j : arr) {
            System.out.print(" " + j);
        }
    }
}
