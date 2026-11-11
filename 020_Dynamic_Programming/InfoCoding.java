// Source --> https://drive.google.com/drive/u/0/folders/1UslSYCnN4nx8VinVvlq7gGdWlnbwtm4z

public class InfoCoding {
    // ! ============= INFOSYS_01_03. Metro Line Construction Budget ============
    public static int metroConstruction(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++)
            dp[i] = -1;
        return metroHelper(nums, n - 1, k, dp);
    }

    public static int metroHelper(int[] nums, int idx, int k, int[] dp) {
        if (idx < k)
            return nums[idx];
        if (dp[idx] != -1)
            return dp[idx];
        int minVal = Integer.MAX_VALUE;
        for (int i = idx - 1; i > idx - k - 1; i--) {
            minVal = Math.min(minVal, metroHelper(nums, i, k, dp));
        }
        return dp[idx] = nums[idx] + minVal;
    }

    // ! ============= INFOSYS_02_02. Longest Subarray with Sum at Most K ============
    public static int longestSubArraySumK(int[] nums, int k) {
        int maxLen = 0;
        int sum = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum > k) {
                sum -= nums[j];
                j++;
            }
            maxLen = Math.max(maxLen, i - j + 1);
        }
        return maxLen;
    }

    // ! ============= INFOSYS_02_03 Shortest Path in an Unweighted Grid ============
    public static int shortestPathGrid(char[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] visited = new boolean[m][n];
        return shortestPathHelper(mat, m - 1, n - 1, visited);
    }

    public static int shortestPathHelper(char[][] mat, int row, int col, boolean[][] visited) {
        if (row < 0 || col < 0 || row > mat.length - 1 || col > mat[0].length - 1)
            return Integer.MAX_VALUE;

        if (mat[row][col] == '#')
            return Integer.MAX_VALUE;

        if (visited[row][col])
            return Integer.MAX_VALUE;

        if (row == 0 && col == 0)
            return 1;

        visited[row][col] = true;

        int left = shortestPathHelper(mat, row, col - 1, visited);
        int top = shortestPathHelper(mat, row - 1, col, visited);
        int right = shortestPathHelper(mat, row, col + 1, visited);
        int down = shortestPathHelper(mat, row + 1, col, visited);

        visited[row][col] = false;

        int min = Math.min(Math.min(left, top), Math.min(right, down));

        if (min == Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        return 1 + min;
    }

    // ! ============= INFOSYS_03_03 Count Subsets with XOR Equal to K ============

    public static int countSubSetsXorK(int[] nums, int k) {
        int n = nums.length;
        return countXorHelper(nums, n - 1, 0, k);
    }

    public static int countXorHelper(int[] nums, int idx, int xor, int k) {
        if (idx < 0) {
            if (xor == k)
                return 1;
            return 0;
        }

        if (xor == k)
            return 1;

        xor ^= nums[idx];
        int left = countXorHelper(nums, idx - 1, xor, k);
        xor ^= nums[idx];

        int right = countXorHelper(nums, idx - 1, xor, k);

        return left + right;
    }
}

// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. INFOSYS_01_03. Metro Line Construction Budget ✅
// 2. INFOSYS_02_02. Longest SubArray with Sum at Most K ✅
// 3. INFOSYS_02_03 Shortest Path in an Unweighted Grid 🔃
// 4. INFOSYS_03_03 Count Subsets with XOR Equal to K ✅