
import java.util.HashMap;

public class Oct18 {

    // ! ============= LC523. Continuous Subarray Sum ============
    /*
    @ TC --> O(N)
    @ SC --> O(N)
    */
    public static boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum % k;
            if (map.containsKey(rem))
                if (i - map.get(rem) >= 2)
                    return true;
            if (!map.containsKey(rem))
                map.put(rem, i);
        }
        return false;
    }

    // ! ============= LC238. Product of Array Except Self ============
    /*
    @ TC --> O(N + N)
    @ SC --> O(N) --> for returning answer so ignorable 
    */
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 1; i < n; i++)
            ans[i] = ans[i - 1] * nums[i - 1];
        int prev = 1;
        for (int j = n - 1; j >= 0; j--) {
            ans[j] = ans[j] * prev;
            prev *= nums[j];
        }
        return ans;
    }

    // ! ============= LC1314. Matrix Block Sum ============
    /*
    @ TC --> O(M * N) + O(M * N)
    @ SC --> O(M * N) + O(M * N) --> one for Prefix and one for returning Answer (Ignorable)
    */
    public static int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] prefix = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                prefix[i][j] = getValue(prefix, i - 1, j) + getValue(prefix, i, j - 1) + mat[i][j]
                        - getValue(prefix, i - 1, j - 1);

        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r1 = Math.max(i - k, 0);
                int c1 = Math.max(j - k, 0);

                int r2 = Math.min(i + k, m - 1);
                int c2 = Math.min(j + k, n - 1);

                res[i][j] = getValue(prefix, r2, c2) - getValue(prefix, r1 - 1, c2) - getValue(prefix, r2, c1 - 1)
                        + getValue(prefix, r1 - 1, c1 - 1);
            }
        }

        return res;
    }

    public static int getValue(int[][] mat, int row, int col) {
        if (row < 0 || col < 0 || row > mat.length - 1 || col > mat[0].length - 1)
            return 0;
        return mat[row][col];
    }
}
// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC1314. Matrix Block Sum ✅
// 2. LC238. Product of Array Except Self ✅
// 3. LC523. Continuous Subarray Sum ✅