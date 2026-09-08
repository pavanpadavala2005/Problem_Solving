
public class Sep07 {
    // ! ============== The Knight's tour Generator =============
    // * PERSONAL
    public static int[][] knightTourGenerator(int n) {
        int[][] board = new int[n][n];
        knightTourGenerator(board, 0, 0, 0);
        return board;
    }

    public static boolean knightTourGenerator(int[][] board, int row, int col, int count) {
        if (row < 0 || col < 0 || row > board.length - 1 || col > board.length - 1)
            return false;
        if (board[row][col] != 0)
            return false;
        board[row][col] = count;

        if (count == board.length * board.length)
            return true;
        boolean c1 = knightTourGenerator(board, row - 2, col - 1, count + 1);
        if (c1)
            return true;
        boolean c2 = knightTourGenerator(board, row - 1, col - 2, count + 1);
        if (c2)
            return true;
        boolean c3 = knightTourGenerator(board, row - 2, col + 1, count + 1);
        if (c3)
            return true;
        boolean c4 = knightTourGenerator(board, row + 1, col - 2, count + 1);
        if (c4)
            return true;
        boolean c5 = knightTourGenerator(board, row - 1, col + 2, count + 1);
        if (c5)
            return true;
        boolean c6 = knightTourGenerator(board, row + 1, col + 2, count + 1);
        if (c6)
            return true;
        boolean c7 = knightTourGenerator(board, row + 2, col - 1, count + 1);
        if (c7)
            return true;
        boolean c8 = knightTourGenerator(board, row + 2, col + 1, count + 1);
        if (c8)
            return true;
        board[row][col] = 0;
        return false;
    }
    // ! ============== LC2596. Check Knight Tour Configuration =============

    public static boolean checkValidGrid(int[][] grid) {
        return checkValidGrid(grid, 0, 0, 0, 0, new boolean[grid.length][grid[0].length]);
    }

    public static boolean checkValidGrid(int[][] grid, int row, int col, int val, int count, boolean[][] path) {
        if (row < 0 || col < 0 || row > grid.length - 1 || col > grid[0].length - 1 || path[row][col])
            return false;
        if (grid[row][col] != val)
            return false;
        if (count == grid.length * grid[0].length - 1)
            return true;
        path[row][col] = true;
        boolean b = checkValidGrid(grid, row - 2, col - 1, val + 1, count + 1, path) || // C1
                checkValidGrid(grid, row - 1, col - 2, val + 1, count + 1, path) || // C2
                checkValidGrid(grid, row - 2, col + 1, val + 1, count + 1, path) || // C3
                checkValidGrid(grid, row + 1, col - 2, val + 1, count + 1, path) || // C4
                checkValidGrid(grid, row + 2, col - 1, val + 1, count + 1, path) || // C5
                checkValidGrid(grid, row - 1, col + 2, val + 1, count + 1, path) || // C6
                checkValidGrid(grid, row + 1, col + 2, val + 1, count + 1, path) || // C7
                checkValidGrid(grid, row + 2, col + 1, val + 1, count + 1, path); // C8
        path[row][col] = false;
        return b;
    }
    // public static boolean checkValidGrid(int[][] grid) {
    // checkValidGrid(grid, 0, 0, 0, 0);
    // return true;
    // }

    // public static void checkValidGrid(int[][] grid, int row, int col, int val,
    // int count) {
    // if (row < 0 || col < 0 || row > grid.length - 1 || col > grid.length - 1)
    // return;
    // if (grid[row][col] != val)
    // return;
    // if (count == grid.length * grid.length - 1) {
    // System.out.println("found");
    // return;
    // }
    // System.out.println(count);
    // checkValidGrid(grid, row - 2, col - 1, val + 1, count + 1);// C11
    // checkValidGrid(grid, row - 1, col - 2, val + 1, count + 1);// C12

    // checkValidGrid(grid, row - 2, col + 1, val + 1, count + 1);// C21
    // checkValidGrid(grid, row - 1, col - 2, val + 1, count + 1);// C22

    // checkValidGrid(grid, row - 1, col + 2, val + 1, count + 1);// C31
    // checkValidGrid(grid, row - 2, col - 1, val + 1, count + 1);// C32

    // checkValidGrid(grid, row - 1, col + 2, val + 1, count + 1);// C41
    // checkValidGrid(grid, row - 2, col + 1, val + 1, count + 1); // C42
    // // return b;
    // }

}
// ! Target Min -> 3 , Max -> 5 (Quality Problems Only)
// 1. LC2596. Check Knight Tour Configuration ✅
// 2.