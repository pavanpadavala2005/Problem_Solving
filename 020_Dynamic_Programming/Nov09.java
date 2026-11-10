
public class Nov09 {
    // ! ============= GFG. Geek's Training ============
    /*
    * Same like V1 But approaching form ( n-1 --> 0  ) 
    @ TC --> O(N * 3)
    @ SC --> O(N + N*4)
    */
    public static int maximumPointsBetterV2(int mat[][]) {
        int n = mat.length;
        int[][] dp = new int[n][4];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < 4; j++)
                dp[i][j] = -1;
        return maximumPointsBetterV2Helper(mat, n - 1, 3, dp);
    }

    public static int maximumPointsBetterV2Helper(int[][] mat, int day, int prev, int[][] dp) {
        if (day < 0)
            return 0;

        if (dp[day][prev] != -1)
            return dp[day][prev];

        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++)
            if (i != prev)
                maxi = Math.max(mat[day][i] + maximumPointsBetterV2Helper(mat, day - 1, i, dp), maxi);

        return dp[day][prev] = maxi;
    }

    /*
    @ TC --> O(N * 3)
    @ SC --> O(N + N*4)
    */
    public static int maximumPointsBetterV1(int mat[][]) {
        int n = mat.length;
        int[][] dp = new int[n][4];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < 4; j++)
                dp[i][j] = -1;
        int res = maximumPointsBetterV1Helper(mat, 0, 3, dp);
        return res;
    }

    public static int maximumPointsBetterV1Helper(int[][] mat, int day, int prev, int[][] dp) {
        if (day > mat.length - 1)
            return 0;
        int maxVal = Integer.MIN_VALUE;

        if (dp[day][prev] != -1)
            return dp[day][prev];

        for (int i = 0; i < 3; i++)
            if (i != prev)
                maxVal = Math.max(maxVal, mat[day][i] + maximumPointsBetterV1Helper(mat, day + 1, i, dp));

        return dp[day][prev] = maxVal;
    }

    /*
    @ TC --> O(N * 3 * 3)
    @ SC --> O(N)
    */

    public static int maximumPointsBrute(int mat[][]) {
        int res = maximumPointsBruteHelper(mat, 0, 3);
        return res;
    }

    public static int maximumPointsBruteHelper(int[][] mat, int day, int prev) {
        if (day > mat.length - 1)
            return 0;

        int maxVal = Integer.MIN_VALUE;

        for (int i = 0; i < 3; i++)
            if (i != prev)
                maxVal = Math.max(maxVal, mat[day][i] + maximumPointsBruteHelper(mat, day + 1, i));

        return maxVal;
    }

    // ! ============= LC322. Coin Change ============
    /*
    @ TC --> O(N * Amount)
    @ SC --> O(Amount)
    */
    public static int coinChangeBetterV2(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        for (int i = 0; i <= amount; i++)
            dp[i] = Integer.MAX_VALUE;
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int minCost = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                int idx = i - coins[j];
                if (idx >= 0 && dp[idx] != Integer.MAX_VALUE)
                    minCost = Math.min(dp[idx] + 1, minCost);
            }
            dp[i] = minCost;
        }
        return dp[amount];
    }

    /*
    @ TC --> O(N)
    @ SC --> O(N + Target)
    */
    public static int coinChangeBetterV1(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 0; i <= amount; i++)
            dp[i] = -1;

        int res = coinChangeBetterV1Helper(coins, amount, dp);
        return res;
    }

    public static int coinChangeBetterV1Helper(int[] coins, int target, int[] dp) {
        if (target == 0)
            return 0;
        if (target < 0)
            return Integer.MAX_VALUE;

        if (dp[target] != -1)
            return dp[target];

        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            int res = coinChangeBetterV1Helper(coins, target - coins[i], dp);
            if (res != Integer.MAX_VALUE)
                minLen = Math.min(res + 1, minLen);
        }

        return dp[target] = minLen;
    }

    /*
    @ TC --> O(N!)
    @ SC --> O(N!)
    */
    public static int coinChangeBrute(int[] coins, int amount) {
        return coinChangeBruteHelper(coins, amount);
    }

    public static int coinChangeBruteHelper(int[] coins, int target) {
        if (target == 0)
            return 0;
        if (target < 0)
            return Integer.MAX_VALUE;

        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int res = coinChangeBruteHelper(coins, target - coins[i]);
            if (res != Integer.MAX_VALUE)
                minCost = Math.min(minCost, res);
        }
        return minCost;
    }

    // ! ============= LC213. House Robber II ============
    /*
    @ TC --> O(N + N) --> Running two Recursions
    @ SC --> O(( N + N ) + ( N + N )) --> Recursive Stack Space + Dp Array
    */
    public static int robII(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        for (int i = 0; i < n; i++) {
            dp1[i] = -1;
            dp2[i] = -1;
        }

        return Math.max(
                robIIHelper(nums, 0, n - 2, dp1),
                robIIHelper(nums, 1, n - 1, dp2)
        // 
        );
    }

    public static int robIIHelper(int[] nums, int low, int n, int[] dp) {
        if (n == low)
            return nums[low];
        if (n < low)
            return 0;
        if (dp[n] != -1)
            return dp[n];

        int pick = nums[n] + robIIHelper(nums, low, n - 2, dp);
        int notPick = 0 + robIIHelper(nums, low, n - 1, dp);

        return dp[n] = Math.max(pick, notPick);
    }
}

// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC213. House Robber II  ✅
// 2. LC322. Coin Change ✅
// 3. GFG. Geek's Training ✅