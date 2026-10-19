
public class Oct19 {

    // ! ============= LC53. Maximum Subarray ============
    /*
    @ TC --> O(N)
    @ SC --> O(1)
    */
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (currSum < 0)
                currSum = 0;
            currSum += nums[i];

            if (currSum > maxSum)
                maxSum = currSum;
        }
        return maxSum;
    }

    // ! ============= LC2428. Maximum Sum of an Hourglass ============
    /*
    @ TC --> O(N*M + N-2*M-2)
    @ SC --> O(N*M)
    */
    public static int maxSumOptimal(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] prefix = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                prefix[i][j] = getValue(prefix, i - 1, j) + getValue(prefix, i, j - 1) - getValue(prefix, i - 1, j - 1)
                        + grid[i][j];

        int res = Integer.MIN_VALUE;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                int sum = getValue(prefix, i + 1, j + 1) -
                        getValue(prefix, i + 1, j - 2) -
                        getValue(prefix, i - 2, j + 1) +
                        getValue(prefix, i - 2, j - 2);
                sum -= grid[i][j - 1] - grid[i][j + 1];
                res = Math.max(res, sum);
            }
        }
        return res;
    }

    /*
    @ TC --> O(N^2)
    @ SC --> O(1)
    */
    public static int maxSumBetter(int[][] grid) {
        int res = Integer.MIN_VALUE;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                int sum = grid[i - 1][j - 1] + grid[i - 1][j] +
                        grid[i - 1][j + 1] + grid[i][j] +
                        grid[i + 1][j - 1] + grid[i + 1][j] +
                        grid[i + 1][j + 1];
                res = Math.max(sum, res);
            }
        }
        return res;
    }

    /*
    @ TC --> O(N^3)
    @ SC --> O(1)
    */
    public static int maxSumBrute(int[][] grid) {
        int res = Integer.MIN_VALUE;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                int sum = 0;
                for (int k = j - 1; k < j - 1 + 3; k++)
                    sum += grid[i - 1][k];
                sum += grid[i][j];
                for (int k = j - 1; k < j - 1 + 3; k++)
                    sum += grid[i + 1][k];
                res = Math.max(res, sum);
            }
        }
        return res;
    }

    public static int getValue(int[][] mat, int row, int col) {
        if (row < 0 || col < 0 || row > mat.length - 1 || col > mat[0].length - 1)
            return 0;
        return mat[row][col];
    }

    // ! ============= LC724. Find Pivot Index ============
    /*
    @ TC --> O(N + N)
    @ SC --> O(1)
    */
    public int pivotIndex(int[] nums) {
        int right = 0;
        for (int i = 0; i < nums.length; i++)
            right += nums[i];

        int left = 0;

        for (int j = 0; j < nums.length; j++) {
            right -= nums[j];
            if (left == right)
                return j;
            left += nums[j];
        }
        return -1;
    }

    // ! ============= LC974. Subarray Sums Divisible by K ============
    /*
    @ TC --> O(N)
    @ SC --> O(K) --> because when we do % K the result will never cross K
    */
    public static int subarraysDivByK(int[] nums, int k) {
        int[] map = new int[k + 1];
        map[0] = 1;
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum % k;
            if (rem < 0)
                rem += k;
            count += map[rem];
            map[rem]++;
        }
        return count;
    }
}
// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC974. Subarray Sums Divisible by K ✅
// 2. LC2428. Maximum Sum of an Hourglass ✅
// 3. LC724. Find Pivot Index ✅
// 4. LC53. Maximum Subarray ✅