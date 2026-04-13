package all.tech.practice.logical.arrayProblems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Given an unsorted integer array numbers. Return the smallest positive integer that is not present in numbers.
public class FirstMissingPositive {
    public static void main(String[] args) {
        System.out.println("========= 1st Series ===========");
        System.out.println(checkMissingFromHashSet(-1, 2, 3, 1, 4));
        System.out.println(checkMissingFromHashSet(7, 8, 9, 10, -1));
        System.out.println(checkMissingFromHashSet(0, 1, 2, 3, 4));
        System.out.println("========= 2nd Series ===========");
        System.out.println(checkMissingUsingSortingApproach(-1, 2, 1, 4));
        System.out.println(checkMissingUsingSortingApproach(7, 8, 9, 10, -1));
        System.out.println(checkMissingUsingSortingApproach(0, 1, 3, 4));
        System.out.println("========= =========== ===========");
        missingTestPractice(-1, 2, 1, 4);
        missingTestPractice(7, 8, 9, 10, -1);
        missingTestPractice(0, 1, 3, 4);
        missingTestPractice2(-1, 2, 1, 4);
        missingTestPractice2(7, 8, 9, 10, -1);
        missingTestPractice2(0, 1, 3, 4);
    }

    public static int checkMissingFromHashSet(int... arr) {
        Set<Integer> hashset = new HashSet<>();
        for (int j : arr)
            hashset.add(j);
        for (int i = 1; i <= arr.length + 1; i++)
            if (!hashset.contains(i))
                return i;
        return -1;
    }

    public static int checkMissingUsingSortingApproach(int... arr) {
        Arrays.sort(arr);
        int counterStart = 1;
        for (int j : arr)
            if (j > 0 && counterStart++ != j)
                return counterStart - 1;
        return counterStart;
    }

    public static void missingTestPractice(int... arr) {
        int counter = 1;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0 && arr[i] != counter++) {
                counter--;
                break;
            }
        }
        System.out.println("Missing param is : " + counter);
    }


    public static void missingTestPractice2(int... arr) {
        Arrays.sort(arr);
        int countStart = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0 && countStart++ != arr[i]) {
                countStart--;
                break;
            }
        }
        System.out.println(countStart);
    }
}
