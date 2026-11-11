import java.util.Arrays;

public class Nov11 {
    // ! ============= LC63. Unique Paths II ============
    /*
    * More Space Optimized
    @ TC --> O(M * N)
    @ SC --> O(N)
    */
    public static int uniquePathsWithObstaclesOptimal(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 1)
                dp[i] = 0;
            else
                dp[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            int[] dummyDp = new int[n];

            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    if (grid[i][j] == 1)
                        dummyDp[j] = 0;
                    else
                        dummyDp[j] = 1;
                } else {
                    if (grid[i][j] == 1)
                        dummyDp[j] = 0;
                    else
                        dummyDp[j] = dummyDp[j - 1] + dp[j];
                }
            }
            dp = dummyDp;
        }
        return dp[n - 1];

    }

    /*
    @ SC --> O(M * N)
    @ SC --> O(M * N)
    */
    public static int uniquePathsWithObstaclesBetterV2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 1)
                dp[0][i] = 0;
            else
                dp[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    if (grid[i][j] == 1)
                        dp[i][j] = 0;
                    else
                        dp[i][j] = 1;
                } else {
                    if (grid[i][j] == 1)
                        dp[i][j] = 0;
                    else
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    /*
    @ TC --> O(M * N)
    @ SC --> O(M * N  + (M-1)+(N-1))
    */
    public int uniquePathsWithObstaclesBetterV1(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                dp[i][j] = -1;
        return uniquePathsWithObstaclesBetterV1Helper(obstacleGrid, m - 1, n - 1, dp);
    }

    public int uniquePathsWithObstaclesBetterV1Helper(int[][] grid, int row, int col, int[][] dp) {
        if (row < 0 || col < 0)
            return 0;

        if (dp[row][col] != -1)
            return dp[row][col];

        if (grid[row][col] == 1)
            return 0;

        if (row == 0 && col == 0)
            return 1;

        return dp[row][col] = uniquePathsWithObstaclesBetterV1Helper(grid, row - 1, col, dp)
                + uniquePathsWithObstaclesBetterV1Helper(grid, row, col - 1, dp);
    }

    public int uniquePathsWithObstaclesBrute(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        return uniquePathsWithObstaclesBruteHelper(obstacleGrid, m - 1, n - 1);
    }

    public int uniquePathsWithObstaclesBruteHelper(int[][] grid, int row, int col) {
        if (row < 0 || col < 0)
            return 0;

        if (grid[row][col] == 1)
            return 0;

        if (row == 0 && col == 0)
            return 1;

        return uniquePathsWithObstaclesBruteHelper(grid, row - 1, col)
                + uniquePathsWithObstaclesBruteHelper(grid, row, col - 1);
    }

    // ! ============= LC62. Unique Paths ============
    /*
    * USing Space Optimization
    @ TC --> O( M * N )
    @ SC --> O( M * N )
    */
    public static int uniquePathsOptimal(int m, int n) {
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++)
            dp[i] = 1;

        for (int i = 1; i < m; i++) {
            int[] dummyDp = new int[n];
            for (int j = 0; j < n; j++) {
                if (j == 0)
                    dummyDp[j] = 1;
                else
                    dummyDp[j] = dummyDp[j - 1] + dp[j];
            }
            dp = dummyDp;
            System.out.println(Arrays.toString(dp));
        }
        return dp[n - 1];
    }

    /*
    * USing Tabulation
    @ TC --> O( M * N )
    @ SC --> O( M * N )
    */
    public int uniquePathsBetterV2(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    /*
    @ TC --> O(N * M)
    @ SC --> O(N * M)
    */
    public static int uniquePathsBetterV1(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                dp[i][j] = -1;
        return uniquePathsBetterV1Helper(m - 1, n - 1, dp);
    }

    public static int uniquePathsBetterV1Helper(int m, int n, int[][] dp) {
        if (m == 0 || n == 0)
            return 1;
        if (dp[m][n] != -1)
            return dp[m][n];
        return dp[m][n] = uniquePathsBetterV1Helper(m, n - 1, dp) + uniquePathsBetterV1Helper(m - 1, n, dp);
    }

    /*
    @ TC --> O(2 ^ (M+N))
    @ SC --> O(M + N)
    */
    public static int uniquePathsBrute(int m, int n) {
        return uniquePathsBruteHelper(m - 1, n - 1);
    }

    public static int uniquePathsBruteHelper(int m, int n) {
        if (m == 0 || n == 0)
            return 1;
        return uniquePathsBruteHelper(m, n - 1) + uniquePathsBruteHelper(m - 1, n);
    }
}

// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC62. Unique Paths ✅
// 2. LC63. Unique Paths II ✅