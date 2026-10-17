
import java.util.HashMap;

public class Oct17 {

    // ! ============= GFG. Compute Before Matrix for Suffix ============
    public static int[][] computeBeforeMatrixSuffix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] before = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                before[i][j] = mat[i][j] + getValue(mat, i + 1, j + 1) - getValue(mat, i + 1, j)
                        - getValue(mat, i, j + 1);
        return before;
    }

    // ! ============= GFG. Compute Before Matrix for Prefix ============
    public static int[][] computeBeforeMatrixPrefix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] before = new int[m][n];
        for (int i = m - 1; i >= 0; i--)
            for (int j = n - 1; j >= 0; j--)
                before[i][j] = mat[i][j] + getValue(mat, i - 1, j - 1) - getValue(mat, i - 1, j)
                        - getValue(mat, i, j - 1);
        return before;
    }

    // ! ============= GEN. Generate Prefix Matrix ============
    public static int[][] generatePrefixMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] prefix = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                prefix[i][j] = getValue(prefix, i, j - 1) + getValue(prefix, i - 1, j) + mat[i][j]
                        - getValue(prefix, i - 1, j - 1);
        return prefix;
    }

    // ! ============= GEN. Generate Suffix Matrix ============
    public static int[][] generateSuffixMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] suffix = new int[m][n];
        for (int i = m - 1; i >= 0; i--)
            for (int j = n - 1; j >= 0; j--)
                suffix[i][j] = getValue(suffix, i + 1, j) + getValue(suffix, i, j + 1) + mat[i][j]
                        - getValue(suffix, i + 1, j + 1);
        return suffix;
    }

    public static int getValue(int[][] mat, int row, int col) {
        if (row < 0 || col < 0 || row > mat.length - 1 || col > mat[0].length - 1)
            return 0;
        return mat[row][col];
    }

    // ! ============= GEN. Generate Prefix Array ============
    public static int[] generatePrefixArray(int[] nums) {
        int n = 0;
        if (n <= 0)
            return new int[] {};
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++)
            prefix[i] = prefix[i - 1] + nums[i];
        return prefix;
    }

    // ! ============= GEN. Generate Suffix Array ============
    public static int[] generateSuffixArray(int[] nums) {
        int n = 0;
        if (n <= 0)
            return new int[] {};
        int[] suffix = new int[n];
        suffix[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--)
            suffix[i] = suffix[i + 1] + nums[i];
        return suffix;
    }

    // ! ============= LC560. Subarray Sum Equals K ============
    /*
    @ TC --> O(N)
    @ SC --> O(N)
    */
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum - k;
            if (map.containsKey(rem)) {
                count += map.get(rem);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}

// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC560. Subarray Sum Equals K ✅
// 2. GEN. Generate Suffix Array ✅
// 3. GEN. Generate Prefix Array ✅
// 4. GEN. Generate Suffix Matrix ✅
// 5. GEN. Generate Prefix Matrix  ✅
// 6. GFG. Compute Before Matrix for Suffix ✅ 
// 7. GFG. Compute Before Matrix for Prefix ✅