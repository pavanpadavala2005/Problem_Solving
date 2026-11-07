import java.util.HashMap;
import java.util.List;

public class Nov07 {
    // ! ============= GFG. Frog Jump ============  
    /*
    @ TC --> O(N)
    @ SC --> O(1)
    */
    public static int minCostOptimal(int[] height) {
        int prev2 = 0;
        int prev1 = 0;
        for (int i = 1; i < height.length; i++) {
            int left = Math.abs(height[i] - height[i - 1]) + prev1;
            int right = Integer.MAX_VALUE;
            if (i > 1)
                right = Math.abs(height[i] - height[i - 2]) + prev2;
            prev2 = prev1;
            prev1 = Math.min(left, right);
        }
        return prev1;
    }

    /*
    @ TC --> O(N)
    @ SC --> O(N)
    */
    public static int minCostBetterV2(int[] height) {
        int n = height.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int left = Math.abs(height[i] - height[i - 1]) + dp[i - 1];
            int right = Integer.MAX_VALUE;

            if (i > 1)
                right = Math.abs(height[i] - height[i - 2]) + dp[i - 2];
            dp[i] = Math.min(left, right);
        }
        return dp[n - 1];
    }

    public static int minCostBetterV1(int[] height) {
        int n = height.length;
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++)
            dp[i] = -1;
        return minCostBetterV1Helper(height, n - 1, dp);
    }

    public static int minCostBetterV1Helper(int[] height, int i, int[] dp) {
        if (i == 0)
            return 0;

        if (dp[i] != -1)
            return dp[i];

        int left = Math.abs(height[i] - height[i - 1]) + minCostBetterV1Helper(height, i - 1, dp);
        int right = Integer.MAX_VALUE;

        if (i > 1)
            right = Math.abs(height[i] - height[i - 2]) + minCostBetterV1Helper(height, i - 2, dp);

        return dp[i] = Math.min(left, right);
    }

    /*
    @ TC --> O(2^N)
    @ SC --> O(2^N)
    */
    static int minVal = Integer.MAX_VALUE;

    public static int minCostBrute(int[] height) {
        if (height.length <= 0)
            return 0;
        HashMap<List, Integer> map = new HashMap<>();
        minCostBruteHelper(height, 0, 0, map);
        return minVal;
    }

    public static void minCostBruteHelper(int[] height, int i, int cost, HashMap<List, Integer> map) {
        if (i >= height.length - 1) {
            minVal = Math.min(minVal, cost);
            return;
        }
        if (i + 1 <= height.length - 1) {
            int leftCost = cost + Math.abs(height[i] - height[i + 1]);
            minCostBruteHelper(height, i + 1, leftCost, map);
        }
        if (i + 2 <= height.length - 1) {
            int rightCost = cost + Math.abs(height[i] - height[i + 2]);
            minCostBruteHelper(height, i + 2, rightCost, map);
        }
    }

    // ! ============= LC70. Climbing Stairs ============
    /*
    @ TC --> O(N)
    @ SC --> O(N) DP Array
    */
    public static int climbStairsOptimal(int n) {
        if (n <= 3)
            return n;
        int prev2 = 1;
        int prev1 = 2;
        for (int i = 3; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    /*
    @ TABULATION (BOTTOM-UP)
    @ TC --> O(N)
    @ SC --> O(N) DP Array
    */
    public static int climbStairsBetterV2(int n) {
        if (n <= 3)
            return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }

    /*
    @ MEMOIZATION (TOP-DOWN)
    @ TC --> O(N)
    @ SC --> O(N + N) Recursion Stack Space + DP Array
    */
    public static int climbStairsBetterV1(int n) {
        if (n <= 3)
            return n;
        int[] dp = new int[n + 1];
        for (int i = 0; i < n + 1; i++)
            dp[i] = -1;
        return climbStairsBetterV1Helper(n, dp);
    }

    public static int climbStairsBetterV1Helper(int n, int[] dp) {
        if (n <= 1)
            return 1;
        if (dp[n] != -1)
            return dp[n];
        return dp[n] = climbStairsBetterV1Helper(n - 1, dp) + climbStairsBetterV1Helper(n - 2, dp);
    }

    /*
    @ TC --> O(2^N)
    @ SC --> O(N)
    */
    public static int climbStairsBrute(int n) {
        if (n <= 3)
            return n;
        return climbStairsBrute(n - 1) + climbStairsBrute(n - 2);
    }

    // ! ============= LC509. Fibonacci Number ============
    /*
    * TABULATION ( BOTTOM-UP ) but Dynamically Updating Values
    @ TC --> O(N)
    @ SC --> O(1)
    */
    public static int fibOptimal(int n) {
        int prev2 = 0;
        int prev1 = 1;
        for (int i = 2; i <= n; i++) {
            int curr = prev2 + prev1;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    /*
    * TABULATION ( BOTTOM-UP )( ITERATIVE )
    @ TC --> O(N)
    @ SC --> O(N) --> Dp Array 
    */
    public static int fibBetterV2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++)
            dp[i] = dp[i - 2] + dp[i - 1];
        return dp[n];
    }

    /*
    * MEMOIZATION ( TOP-DOWN )( CACHING )
    @ TC --> O(N)
    @ SC --> O(N + N) --> recursive Stack space + Dp Array 
    */
    public static int fibBetterV1(int n) {
        if (n <= 0)
            return n;

        int[] dp = new int[n + 1];

        for (int i = 0; i < dp.length; i++)
            dp[i] = -1;
        return fibBetterV1Helper(n, dp);
    }

    public static int fibBetterV1Helper(int n, int[] dp) {
        if (n <= 1)
            return n;
        if (dp[n] != -1)
            return dp[n];

        // int ans = fibBetterV1Helper(n - 1, dp) + fibBetterV1Helper(n - 2, dp);
        // dp[n] = ans;
        // return ans;

        // @ this is same as Above Lines
        return dp[n] = fibBetterV1Helper(n - 1, dp) + fibBetterV1Helper(n - 2, dp);
    }

    /*
    @ TC --> O(2^n)
    @ SC --> O(N)
    */
    public static int fibBrute(int n) {
        if (n <= 0)
            return n;
        return fibBrute(n - 1) + fibBrute(n - 2);
    }

}

// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC509. Fibonacci Number ✅
// 2. LC70. Climbing Stairs ✅
// 3. GFG. Frog Jump ✅