public class Nov08 {
    // ! ============= LC198. House Robber ============
    /*
    * Done using Memoization
    @ TC --> O(N)
    @ SC --> O(N + N)
    */
    public static int robBrute(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++)
            dp[i] = -1;
        return robBruteHelper(nums, n - 1, dp);
    }

    public static int robBruteHelper(int[] nums, int n, int[] dp) {
        if (n == 0)
            return nums[0];
        if (n < 0)
            return 0;

        if (dp[n] != -1)
            return dp[n];

        int pk = nums[n] + robBruteHelper(nums, n - 2, dp);
        int npk = 0 + robBruteHelper(nums, n - 1, dp);

        return dp[n] = Math.max(pk, npk);
    }

    // ! ============= Code360. Maximum sum of non-adjacent elements  ============
    /*
    * Space Optimization
    @ TC --> O(N)
    @ SC --> O(1)
    */
    public static int maximumNonAdjacentSumOptimal(int[] nums) {
        int n = nums.length;
        int prev2 = 0;
        int prev1 = nums[0];
        for (int i = 1; i < n; i++) {
            int pick = nums[i] + prev2;
            int notPick = 0 + prev1;

            int maxSum = Math.max(pick, notPick);

            prev2 = prev1;
            prev1 = maxSum;
        }
        return prev1;
    }

    /*
    * Done Using Tabulation
    @ TC --> O(N) 
    @ SC --> O(N)
    */
    public static int maximumNonAdjacentSumBetterV2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            int pick = nums[i];
            if (i > 1)
                pick += dp[i - 2];
            int notPick = 0 + dp[i - 1];
            dp[i] = Math.max(pick, notPick);
        }
        return dp[n - 1];
    }

    /*
    * Done using Memoization
    @ TC --> O(N)
    @ SC --> O(N + N) 
    */
    public static int maximumNonAdjacentSumBetterV1(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++)
            dp[i] = -1;
        return maximumNonAdjacentSumBetterV1Helper(nums, n - 1, dp);
    }

    public static int maximumNonAdjacentSumBetterV1Helper(int[] nums, int n, int[] dp) {
        if (n < 0)
            return 0;
        if (n == 0)
            return nums[0];
        if (dp[n] != -1)
            return dp[n];

        int pick = nums[n] + maximumNonAdjacentSumBetterV1Helper(nums, n - 2, dp);
        int notPick = 0 + maximumNonAdjacentSumBetterV1Helper(nums, n - 1, dp);

        return dp[n] = Math.max(pick, notPick);
    }

    /*
    @ TC --> O(2^N)
    @ SC --> O(N)
    */
    public static int maximumNonAdjacentSumBrute(int[] nums) {
        return maximumNonAdjacentSumBruteHelper(nums, nums.length - 1);
    }

    public static int maximumNonAdjacentSumBruteHelper(int[] nums, int n) {
        if (n < 0)
            return 0;
        if (n == 0)
            return nums[0];

        int pick = nums[n] + maximumNonAdjacentSumBruteHelper(nums, n - 2);
        int notPick = 0 + maximumNonAdjacentSumBruteHelper(nums, n - 1);

        return Math.max(pick, notPick);
    }

    // ! ============= TUF714. Frog jump with K distances  ============  
    /*
    * Space Optimization
    @ TC --> O(N * K) --> if K was given as N so it will run till O(N^2)(Worst)
    @ SC --> O(K) --> in worst case we may take O(N) if K = N 
    */
    public static int frogJumpOptimal(int[] heights, int k) {
        if (k <= 0)
            return 0;
        int n = heights.length;
        int[] state = new int[k];
        for (int i = 1; i < n; i++) {
            int res = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int minCost = state[k - j] + Math.abs(heights[i] - heights[i - j]);
                    res = Math.min(res, minCost);
                } else
                    break;
            }

            for (int st = 1; st < k; st++)
                state[st - 1] = state[st];
            state[k - 1] = res;
        }
        return state[k - 1];
    }

    /*
    * Done Using Tabulation
    @ TC --> O(N);
    @ SC --> O(N);
    */
    public static int frogJumpBetterV2(int[] heights, int k) {
        if (k <= 0)
            return 0;
        int n = heights.length;
        int[] dp = new int[n];
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int res = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int minCost = dp[i - j] + Math.abs(heights[i] - heights[i - j]);
                    res = Math.min(minCost, res);
                } else
                    break;
                System.out.println(i + " " + res);
            }
            dp[i] = res;
        }
        return dp[n - 1];
    }

    /*
    * Done using Memoization
    @ TC --> O(N)
    @ SC --> O(N + N)
    */
    public static int frogJumpBetterV1(int[] heights, int k) {
        if (k <= 0)
            return 0;
        int n = heights.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++)
            dp[i] = -1;
        return frogJumpBetterV1Helper(heights, n - 1, k, dp);
    }

    public static int frogJumpBetterV1Helper(int[] heights, int n, int k, int[] dp) {
        if (n == 0)
            return 0;

        if (dp[n] != -1)
            return dp[n];

        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (n - i >= 0) {
                int jumpCost = frogJumpBetterV1Helper(heights, n - i, k, dp) + Math.abs(heights[n] - heights[n - i]);
                res = Math.min(jumpCost, res);
            } else
                break;
        }

        return dp[n] = res;
    }

    /*
    @ TC --> O(2^N)
    @ SC --> O(N)
    */
    public static int frogJumpBrute(int[] heights, int k) {
        if (k <= 0)
            return 0;
        int n = heights.length;
        return frogJumpBruteHelper(heights, n - 1, k);
    }

    public static int frogJumpBruteHelper(int[] heights, int n, int k) {
        if (n == 0)
            return 0;
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (n - i >= 0) {
                int jumpCost = frogJumpBruteHelper(heights, n - i, k) + Math.abs(heights[n] - heights[n - i]);
                res = Math.min(jumpCost, res);
            } else
                break;
        }
        return res;
    }
}

// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. TUF714. Frog jump with K distances ✅
// 2. Code360. Maximum sum of non-adjacent elements ✅
// 3. LC198. House Robber ✅