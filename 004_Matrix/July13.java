public class July13 {
    // ! ==================== SEARCH IN 2D MATRIX ====================
    public static boolean SearchIn2DMatrixOptimal(int[][] mat, int target) {
        int n = mat.length;
        int m = mat[0].length;
        int i = 0;
        int j = (m * n) - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            int row = mid / m;
            int col = mid % m;
            if (mat[row][col] < target)
                i = mid + 1;
            else if (mat[row][col] > target)
                j = mid - 1;
            else
                return true;
        }
        return false;
    }

    public static boolean SearchIn2DMatrixBrute(int[][] mat, int target) {
        int n = mat.length;
        int m = mat[0].length;
        for (int i = 0; i < n; i++) {
            if (!(mat[i][0] <= target && target <= mat[i][m - 1]))
                continue;
            for (int j = 0; j < m; j++)
                if (mat[i][j] == target)
                    return true;
        }
        return false;
    }

    // ! ==================== FIND ROWS WITH MAX 1's ====================
    public static int firstOccurance(int[] nums, int target) {
        int n = nums.length, i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] >= target)
                j = mid - 1;
            else
                i = mid + 1;
        }
        return i >= n ? -1 : n - i;
    }
}
