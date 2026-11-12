public class Nov12 {

    // ! ============= LC2304. Minimum Path Cost in a Grid ============
    // ! ============= LC120. Triangle ============

    // ! ============= LC64. Minimum Path Sum ============
    /*
    @ TC --> O(M * N)
    @ SC --> O((M*N) + (M-1)+(N-1)) --> for DP + PATH form (0,0) --> (m-1,n-1)
    */
    public int minPathSumBetterV1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                dp[i][j] = -1;
        return minPathSumBetterV1Helper(grid, m - 1, n - 1, dp);
    }

    public int minPathSumBetterV1Helper(int[][] grid, int row, int col, int[][] dp) {
        if (row < 0 || col < 0)
            return Integer.MAX_VALUE;

        if (row == 0 && col == 0)
            return grid[row][col];

        if (dp[row][col] != -1)
            return dp[row][col];

        int left = minPathSumBetterV1Helper(grid, row, col - 1, dp);
        int right = minPathSumBetterV1Helper(grid, row - 1, col, dp);

        return dp[row][col] = grid[row][col] + Math.min(left, right);
    }

    public int minPathSumBrute(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return minPathSumBruteHelper(grid, m - 1, n - 1);
    }

    public int minPathSumBruteHelper(int[][] grid, int row, int col) {
        if (row < 0 || col < 0)
            return Integer.MAX_VALUE;

        if (row == 0 && col == 0)
            return grid[row][col];

        int left = minPathSumBruteHelper(grid, row, col - 1);
        int right = minPathSumBruteHelper(grid, row - 1, col);

        return grid[row][col] + Math.min(left, right);
    }
}
// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC64. Minimum Path Sum ✅