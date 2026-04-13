package all.tech.practice.logical.arrayProblems;

import java.util.Arrays;

// Asked in Sapient(Bank of America) questions.
public class ReverseAFrameInArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int frame = 3;
        //output ={3,2,1,  6,5,4,  9,8,7,  10,11};

        System.out.println("Before :" + Arrays.toString(arr));
        int iterations = arr.length / frame;
        int start = 0;
        for (int i = 1; i <= iterations; i++) {
            replace(arr, start, frame * i - 1);
            start = frame * i;
        }
        System.out.println("After :" + Arrays.toString(arr));
    }

    public static void replace(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }
}