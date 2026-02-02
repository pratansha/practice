package interview.ds;

/**
 * Problem Name is Optimal Path
 * Instructions to candidate.
 * 1) You are an avid rock collector who lives in southern California. Some rare
 * and desirable rocks just became available in New York, so you are planning
 * a cross-country road trip. There are several other rare rocks that you could
 * pick up along the way.
 * --
 * You have been given a grid filled with numbers, representing the number of
 * rare rocks available in various cities across the country.  Your objective
 * is to find the optimal path from So_Cal to New_York that would allow you to
 * accumulate the most rocks along the way.
 * --
 * Note: You can only travel either column orth (up) or east (right).
 * 2) Consider adding some additional tests in doTestsPass().
 * 3) Implement optimalPath() correctly.
 * 4) Here is an example:
 * ^
 * {{0,0,0,0,5}, New_York (finish)           N
 * {0,1,1,1,0},                         < W   E >
 * So_Cal (start) {2,0,0,0,0}}                             S
 * v
 * The total for this example would be 10 (2+0+1+1+1+0+5).
 */

public class OptimalPathInTwoDirectionArray {
    public static void main(String[] args) {
        int[][] twoDirArray = {
                {0, 0, 0, 0, 5}, {0, 1, 1, 1, 0}, {2, 0, 0, 0, 0}
        };
        /////////////////////
        System.out.println(optimalPath(twoDirArray));
    }

    private static int optimalPath(int[][] grid) {
        // {{0, 0, 0, 0, 5},
        // {0, 1, 1, 1, 0},
        // {2, 0, 0, 0, 0}};
        int row = grid.length;
        int column = grid[0].length;

        // Create a dp array to store the maximum rocks collected at each city
        int[][] dp = new int[row][column];

        // Initialize the starting point (bottom-left corner)
        dp[row - 1][0] = grid[row - 1][0];

        // Fill the last row (can only move right)
        for (int j = 1; j < column; j++) {
            dp[row - 1][j] = dp[row - 1][j - 1] + grid[row - 1][j];
        }

        // Fill the first column (can only move up)
        for (int i = row - 2; i >= 0; i--) {
            dp[i][0] = dp[i + 1][0] + grid[i][0];
        }

        // Fill the rest of the dp table
        for (int i = row - 2; i >= 0; i--) {
            for (int j = 1; j < column; j++) {
                dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        // The answer will be at dp[0][column-1] (top-right corner)
        return dp[0][column - 1];
    }
}

class TypeOfArray {
    static void typeOfArray() {
        int[][][] threeDirArray = {
                {{75, 87, 69}, {90, 87, 85}, {56, 67, 76}},
                {{78, 67, 75}, {87, 98, 76}, {67, 56, 66}}
        };
        System.out.println("threeDirArray :" + threeDirArray.length);

        int[][][][] fourDirArray = {
                {
                        {{75, 87, 69}, {90, 87, 85}, {56, 67, 76}},
                        {{78, 67, 75}, {87, 98, 76}, {67, 56, 66}}
                },
                {
                        {{75, 87, 69}, {90, 87, 85}, {56, 67, 76}},
                        {{78, 67, 75}, {87, 98, 76}, {67, 56, 66}}
                }
        };
        System.out.println("fourDirArray :" + fourDirArray.length);

        int[][][][][] fiveDirArray = {
                {
                        {
                                {{75, 87, 69}, {90, 87, 85}, {56, 67, 76}},
                                {{78, 67, 75}, {87, 98, 76}, {67, 56, 66}}
                        },
                        {
                                {{75, 87, 69}, {90, 87, 85}, {56, 67, 76}},
                                {{78, 67, 75}, {87, 98, 76}, {67, 56, 66}}
                        }
                },
                {
                        {
                                {{75, 87, 69}, {90, 87, 85}, {56, 67, 76}},
                                {{78, 67, 75}, {87, 98, 76}, {67, 56, 66}}
                        },
                        {
                                {{75, 87, 69}, {90, 87, 85}, {56, 67, 76}},
                                {{78, 67, 75}, {87, 98, 76}, {67, 56, 66}}
                        }
                }
        };
        System.out.println("fiveDirArray :" + fiveDirArray.length);
    }
}
