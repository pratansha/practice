import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
        (9+1)
        (8+2)
        (5+4+1)
        (5+3+2)
        (1+2+3+4)
 */

public class PossibleCombinationOfSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 8, 9, 12, 15};
        int reference = 10;
        List<List<Integer>> result = new ArrayList<>();
        findCombinations(arr, reference, 0, new ArrayList<>(), result);
        result.forEach(combination ->
                System.out.println(
                        combination.stream().map(String::valueOf).collect(Collectors.joining(",", "(", ")"))
                ));
    }

    private static List<int[]> combinationOfSum(int[] arr, int reference) {
        List<int[]> list = new ArrayList<>();
        int temp;
        for (int i = 0; i < arr.length; i++) {
            List<Integer> tempList = new ArrayList<>();
            tempList.add(temp = arr[i]);
            for (int j = i + 1; j < arr.length; j++) {
                tempList.add(arr[j]);
                temp = temp + arr[j];
                if (temp > reference) {
                    tempList.clear();
                    break;
                }

                if (temp == reference) {
                    list.add(tempList.stream().mapToInt(x -> x).toArray());
                    tempList.clear();
                    break;
                }
            }
        }
        return list;
    }

    private static void findCombinations(int[] arr, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));  // Add the current combination to the result
            return;
        }
        for (int i = start; i < arr.length; i++) {
            if (arr[i] <= target) {
                current.add(arr[i]);
                findCombinations(arr, target - arr[i], i + 1, current, result); // Recursive call
                current.remove(current.size() - 1);
            }
        }
    }
}
