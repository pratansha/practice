package all.tech.practice.logical.arrayProblems;

// Given an integer array numbers, return true if there exists a triple of indices (i, j, k) such that i < j < k
// and numbers[i] < numbers[j] < numbers[k]. If no such indices exists, return false.

import java.util.Arrays;

public class IncreasingTripletSubsequence {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(checkTripletSequence(new int[]{1, 2, 1, 3, 2, 2, 3}));
        System.out.println("==================================================");
        System.out.println(checkTripletSequence(new int[]{1, 2, 3}));
        System.out.println("==================================================");
        System.out.println(checkTripletSequence(new int[]{3, 2, 1}));
        System.out.println("==================================================");
        System.out.println(checkTripletSequence(new int[]{1, 2, 1, 1, 1, 1, 1, 2}));
        System.out.println("==================================================");
        System.out.println(checkTripletSequence(new int[]{1, 2, 0, -1, -2, -3}));
        System.out.println("==================================================");
        System.out.println(checkTripletSequence(new int[]{1, 2, 1, 3, 2, 2, 3, 3, 4, 5}));
        System.out.println("==================================================");
        System.out.println("======================Test============================");
        System.out.println(checkTripletSequenceTest(new int[]{1, 2, 3}));
        System.out.println(checkTripletSequenceTest(new int[]{3, 2, 1}));
        System.out.println(checkTripletSequenceTest(new int[]{1, 2, 1, 1, 1, 1, 1, 2}));
        System.out.println(checkTripletSequenceTest(new int[]{1, 2, 0, -1, -2, -3}));
        System.out.println(checkTripletSequenceTest(new int[]{1, 2, 1, 3, 2, 2, 3, 3, 4, 5}));

        System.out.println(checkTripletSequenceTest2(new int[]{1, 2, 3}));
        System.out.println(checkTripletSequenceTest2(new int[]{3, 2, 1}));
        System.out.println(checkTripletSequenceTest2(new int[]{1, 2, 1, 1, 1, 1, 1, 2}));
        System.out.println(checkTripletSequenceTest2(new int[]{1, 2, 0, -1, -2, -3}));
        System.out.println(checkTripletSequenceTest2(new int[]{1, 2, 1, 3, 2, 2, 3, 3, 4, 5}));


    }

    public static boolean checkTripletSequence(int[] arr) {
        int counter = 1;
        int tripletRequiredCount = 3;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                counter++;
            } else counter = 1;
        }
        if (counter >= tripletRequiredCount) {
            return true;
        }
        return false;
    }

    public static boolean checkTripletSequenceTest(int[] arr) {
        int counter = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                counter++;
                if (counter == 3) {
                    return true;
                }
            } else counter = 1;
        }
        return false;
    }


    public static boolean checkTripletSequenceTest2(int[] arr) {
        int count = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                count++;
                if (count == 3) {
                    return true;
                }
            } else {
                count = 1;
            }
        }
        return false;
    }
}