package all.tech.practice.ds.array;

public class TwoDArrayPrint {
    public static void main(String[] args) {
        int[][] array2D = {{1, 2, 3, 4}, {5, 7, 8}, {9, 10, 11, 12}};

        for (int column = 0; column < array2D.length; column++) {
            for (int row = 0; row < array2D[column].length; row++) {
                System.out.print(" " + array2D[column][row]);
            }
            System.out.println();
        }

        //int[][][] array3D = {{{1, 2, 3}, {4, 5, 6}}, {{7, 8, 9}, {10, 11, 12}}, {{13}}};
    }
}