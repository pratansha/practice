package all.tech.practice.logical.arrayProblems;

//Given an integer array numbers, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
// link : https://leetcode.com/problems/move-zeroes/description/
public class MoveZeroesToEnd {
    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 0, 3, 12, 0};
        int emptyPos = 0;

        // Shift non-zero elements forward
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[emptyPos++] = arr[i];
            }
        }

        // Fill remaining positions with zero
        while (emptyPos < arr.length) {
            arr[emptyPos++] = 0;
        }

        // Print result
        for (int num : arr) {
            System.out.print(num + " ");
        }

        moveZeroToEndWithTwoCounters(1, 0, 1, 0, 3, 12, 0);
        moveZeroToEndFastWay(1, 0, 1, 0, 3, 12, 0);
        moveZeroToEndFastWay(0, 0, 0, 1, 2, 3, 4, 5);
    }

    public static void moveZeroToEndWithTwoCounters(int... arr) {
        int rightCounter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                rightCounter = i;
                while (arr[rightCounter] == 0 && rightCounter < arr.length - 1) {
                    rightCounter++;
                }
                arr[i] = arr[rightCounter];
                arr[rightCounter] = 0;
            }
        }
        // Print result
        System.out.println();
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void moveZeroToEndFastWay(int... arr) {
        // 1 2 0 0 4
        int zero = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[zero];
                arr[zero++] = arr[i];
                arr[i] = temp;
            }
        }
        // Print result ..
        System.out.println();
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}