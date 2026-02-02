import java.util.Optional;

public class Test2 {
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15}; //{3, 3};// {3,2,4};//{2, 3, 4, 7, 11, 15};
        int target = 9;
        getIndices(arr, target).ifPresent(result -> System.out.println(result[0] + " & " + result[1]));
    }
    public static Optional<int[]> getIndices(int[] arr, int target) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if ((arr[i] + arr[j]) == target) {
                    return Optional.of(new int[]{i, j});
                }
            }
        }
        return Optional.empty();
    }
   /* public static void testInputs(int[] arr) throws Exception {
        if(arr.length==0){
            throw new Exception("");
        }
    }*/
}

