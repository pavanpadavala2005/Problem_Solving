public class Nov10 {
    // ! ============= LC62. Unique Paths ============
    public int uniquePathsHelper(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                dp[i][j] = -1;

        return uniquePathsHelperHelper(m - 1, n - 1, dp);
    }

    public int uniquePathsHelperHelper(int row, int col, int[][] dp) {
        if (row < 0 || col < 0)
            return 0;
        if (row == 0 && col == 0)
            return 1;

        if (dp[row][col] != -1)
            return dp[row][col];

        return dp[row][col] = uniquePathsHelperHelper(row, col - 1, dp) + uniquePathsHelperHelper(row - 1, col, dp);
    }

    // ! ============= GFG. Geek's Training ============
    /*
     * @ TC --> O(N * 4 * 3)
     * 
     * @ SC --> O(4)
     */
    public static int maximumPointsOptimalV2(int mat[][]) {
        int n = mat.length;
        int[] dp = new int[4];
        dp[0] = Math.max(mat[0][1], mat[0][2]);
        dp[1] = Math.max(mat[0][0], mat[0][2]);
        dp[2] = Math.max(mat[0][0], mat[0][1]);
        dp[3] = Math.max(mat[0][0], Math.max(mat[0][1], mat[0][2]));

        for (int day = 1; day < n; day++) {
            int[] dummyDp = new int[4];
            for (int prev = 0; prev < 4; prev++) {
                int maxi = Integer.MIN_VALUE;
                for (int task = 0; task < 3; task++)
                    if (prev != task)
                        maxi = Math.max(maxi, mat[day][task] + dp[day - 1]);

                dummyDp[prev] = maxi;
            }
            dp = dummyDp;
        }
        return dp[3];
    }

    /*
     * @ TC --> O(N * 4 * 3)
     * 
     * @ SC --> O(N * 4)
     */
    public static int maximumPointsOptimalV1(int mat[][]) {
        int n = mat.length;
        int[][] dp = new int[n][4];
        dp[0][0] = Math.max(mat[0][1], mat[0][2]);
        dp[0][1] = Math.max(mat[0][0], mat[0][2]);
        dp[0][2] = Math.max(mat[0][0], mat[0][1]);
        dp[0][3] = Math.max(mat[0][0], Math.max(mat[0][1], mat[0][2]));

        for (int day = 1; day < n; day++) {
            for (int prev = 0; prev < 4; prev++) {

                int maxi = Integer.MIN_VALUE;
                for (int task = 0; task < 3; task++)
                    if (prev != task)
                        maxi = Math.max(maxi, mat[day][task] + dp[day - 1][task]);

                dp[day][prev] = maxi;
            }
        }
        return dp[n - 1][3];
    }

    /*
     * @ TC --> O(N * 4 * 3)
     * 
     * @ SC --> O(N + N * 4)
     */
    public static int maximumPointsBetterV3(int mat[][]) {
        int n = mat.length;
        int[][] dp = new int[n][4];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < 4; j++)
                dp[i][j] = -1;

        int res = maximumPointsBetterV3Helper(mat, n - 1, 3, dp);
        return res;
    }

    public static int maximumPointsBetterV3Helper(int[][] mat, int day, int prev, int[][] dp) {
        if (day < 0)
            return 0;

        if (dp[day][prev] != -1)
            return dp[day][prev];

        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            if (prev != i)
                maxi = Math.max(maxi, mat[day][i] + maximumPointsBetterV3Helper(mat, day - 1, i, dp));
        }
        return dp[day][prev] = maxi;
    }
}
// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. GFG. Geek's Training ✅
// 2. LC62. Unique Paths ✅