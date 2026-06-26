package all.tech.practice.ds.graph;

//Count number of Island in the grid. link: https://leetcode.com/problems/number-of-islands/description/
/*You’re given a 2D grid of characters:
'1' = land
'0' = water
An island is a group of connected '1' cells connected only horizontally or vertically (up/down/left/right).
Diagonals don’t count. The goal: count how many islands exist

Example :
    1 1 0 0
    1 0 0 1
    0 0 1 1
    0 0 0 0
Islands:
    top-left block = 1
    bottom-right block (two 1s connected) = 1
    single 1 at (1,3) connects to (2,3) etc depending on grid
    So the count = number of connected components of land.

This is essentially counting connected components in a grid-graph.
Approach: DFS/BFS “sink” the island.
Scan each cell.
When you find a '1', you found a new island → increment count.
Run DFS/BFS from that cell and mark all connected land as visited (often by turning '1' → '0'), so you don’t count it again. [algo.monster], [neetcode.io]
    Time Complexity: O(m*n) be  cause every cell is visited at most once.
    Space Complexity: O(m*n) worst-case for queue/stack/recursion depth.

We will use this concept:
int[] dr = {-1, 0, 1, 0}; // row movement so {up, right , down , left} for row.
int[] dc = {0, 1, 0, -1}; // column movement {up, right , down , left} for column.

let's say we are assuming from where first is row and second is column.
NOTE => when we move in a same row (left to right) then it is become (0,0),(0,1),(0,2) .i.e. row always fix as 0 and column changing to 0,1,2.
        when we move in a same column (up to down) then it is become (0,0),(1,0),(2,0) .i.e. column always fix as 0 and row changing to 0,1,2.
        So it becomes:
        Up    → (-1, 0)
        Right → (0, +1)
        Down  → (+1, 0)
        Left  → (0, -1)
*/
public class CountNumberOfIslandInGrid {
    public static void main(String[] args) {
        int[][] case1 = {
                {1, 1, 0, 0},
                {1, 0, 0, 1},
                {0, 0, 1, 1},
                {0, 0, 0, 0}
        };

        System.out.println("Case1-AllWater=" + numIslands(case1)); // expected: 2

        // 2) All water
        int[][] case2 = {
                {0, 0},
                {0, 0}
        };
        System.out.println("Case2-AllWater=" + numIslands(case2)); // expected: 0

        // 3) All land (entire grid is one connected component)
        int[][] case3 = {
                {1, 1, 1},
                {1, 1, 1}
        };
        System.out.println("Case3-AllWater=" + numIslands(case3)); //1

        // 4) Single cell land
        int[][] case4 = {
                {1}
        };
        System.out.println("Case4-AllWater=" + numIslands(case4)); //1

        // 5) Single cell water
        int[][] case5 = {
                {0}
        };
        System.out.println("Case5-AllWater=" + numIslands(case5)); //0

        // 6) Diagonal ones only (IMPORTANT: diagonals are NOT connected)
        int[][] case6 = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        System.out.println("Case6-AllWater=" + numIslands(case6)); //3

        // 7) One row (1D style)
        int[][] case7 = {
                {1, 0, 1, 1, 0, 1}
        };
        System.out.println("Case7-AllWater=" + numIslands(case7)); // 3

        // 8) One column (1D style)
        int[][] case8 = {
                {1},
                {1},
                {0},
                {1},
                {0},
                {1},
                {1}
        };
        System.out.println("Case8-AllWater=" + numIslands(case8)); //3

        // 9) Many small separate islands (checkerboard)
        int[][] case9 = {
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 1}
        };
        System.out.println("Case9-AllWater=" + numIslands(case9)); //8

        // 10) Two big islands separated by water column
        int[][] case10 = {
                {1, 1, 0, 1, 1},
                {1, 1, 0, 1, 1},
                {1, 1, 0, 1, 1}
        };
        System.out.println("Case10-AllWater=" + numIslands(case10)); //2
    }

    private static int numIslands(int[][] grid) {
        int rowsLength = grid.length;
        int columnLength = grid[0].length;

        int numberOfIsland = 0;
        for (int row = 0; row < rowsLength; row++) {
            for (int column = 0; column < columnLength; column++) {
                if (grid[row][column] == 1) {
                    numberOfIsland++;
                    makeAdjacentToZeroDFS(grid, rowsLength, columnLength, row, column);
                }
            }
        }
        return numberOfIsland;
    }

    private static void makeAdjacentToZeroDFS(int[][] grid, int rowsLength, int columnLength, int row, int column) {
        if (row >= rowsLength || row < 0 || column >= columnLength || column < 0 || grid[row][column] == 0)
            return;

        grid[row][column] = 0;
        makeAdjacentToZeroDFS(grid, rowsLength, columnLength, row - 1, column);  // up
        makeAdjacentToZeroDFS(grid, rowsLength, columnLength, row + 1, column);  // down
        makeAdjacentToZeroDFS(grid, rowsLength, columnLength, row, column - 1);  // left
        makeAdjacentToZeroDFS(grid, rowsLength, columnLength, row, column + 1);  // right
    }

    private static int numIslands1(int[][] grid) {
        int numberOfIslands = 0;
        int rowLength = grid.length;
        int columnLength = grid[0].length;

        for (int row = 0; row < grid.length; row++) {
            for (int column = row; column < grid[row].length; column++) {
                makeAdjacentToZeroDFS1(grid, rowLength, columnLength, row, column);
            }
        }
        return numberOfIslands;
    }

    private static void makeAdjacentToZeroDFS1(int[][] grid, int rowsLength, int columnLength, int row, int column) {
        if (row >= rowsLength || row < 0 || column >= columnLength || column < 0 || grid[row][column] == 0)
            return;

        grid[row][column] = 0;
        makeAdjacentToZeroDFS1(grid, rowsLength, columnLength, row + 1, column); //  down
        makeAdjacentToZeroDFS1(grid, rowsLength, columnLength, row - 1, column); // up
        makeAdjacentToZeroDFS1(grid, rowsLength, columnLength, row, column + 1); // right
        makeAdjacentToZeroDFS1(grid, rowsLength, columnLength, row, column - 1); // left
    }
}
