
public class July14 {
    // ! ==================== MEDIAN OF TWO SORTED ARRAYS ==================
    public static double MedianOfSortedArraysOptimal(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int n = n1 + n2;
        int idx1 = n / 2, elem1 = -1;
        int idx2 = (n / 2) - 1, elem2 = -1;
        int ctr = 0;
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (nums1[i] <= nums2[j]) {
                if (ctr == idx1)
                    elem1 = nums1[i];
                if (ctr == idx2)
                    elem2 = nums1[i];
                i++;
            } else {
                if (ctr == idx1)
                    elem1 = nums2[j];
                if (ctr == idx2)
                    elem2 = nums2[j];
                j++;
            }
            ctr++;
        }
        while (i < n1) {
            if (ctr == idx1)
                elem1 = nums1[i];
            else if (ctr == idx2)
                elem2 = nums1[i];
            i++;
            ctr++;
        }
        while (j < n2) {
            if (ctr == idx1)
                elem1 = nums2[j];
            else if (ctr == idx2)
                elem2 = nums2[j];
            j++;
            ctr++;
        }
        if (n % 2 == 0)
            return (double) (elem1 + elem2) / 2;
        return (double) elem1;
    }

    public static double MedianOfSortedArraysBrute(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int n = n1 + n2;
        int[] res = new int[n1 + n2];
        int i = 0, j = 0, idx = 0;
        while (i < n1 && j < n2) {
            if (nums1[i] < nums2[j])
                res[idx++] = nums1[i++];
            else
                res[idx++] = nums2[j++];
        }
        while (i < n1)
            res[idx++] = nums1[i++];
        while (j < n2)
            res[idx++] = nums2[j++];
        if (n % 2 == 0)
            return (double) (res[n / 2] + res[(n / 2) - 1]) / 2;
        return (double) res[n / 2];
    }

    // ! ==================== FIND PEAK ELEMENT II OPTIMAL ==================
    public static int peakIndex(int[] nums) {
        int n = nums.length;
        if (n == 0 || nums[0] > nums[1])
            return 0;
        if (nums[n - 1] > nums[n - 2])
            return n - 1;
        int i = 1;
        int j = n - 2;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
                return mid;
            else if (nums[mid] < nums[mid + 1])
                i = mid + 1;
            else
                j = mid - 1;
        }
        return -1;
    }

    public static int[] findPeakGrid(int[][] mat) {
        int i = 0;
        int j = mat.length - 1;
        while (i <= j) {
            int row = i = (j - i) / 2;
            int col = peakIndex(mat[row]);
            int val = mat[row][col];
            int top = getVal(mat, row - 1, col);
            int bottom = getVal(mat, row + 1, col);
            if (top > val)
                j = row - 1;
            else if (bottom > val)
                i = row + 1;
            else
                return new int[] { row, col };
        }
        return new int[] { -1, -1 };
    }

    // ! ==================== FIND PEAK ELEMENT II BRUTE ====================
    public static int getLeft(int[][] mat, int row, int col) {
        if (col <= 0)
            return -1;
        return mat[row][col - 1];
    }

    public static int getTop(int[][] mat, int row, int col) {
        if (row <= 0)
            return -1;
        return mat[row - 1][col];
    }

    public static int getRight(int[][] mat, int row, int col) {
        if (col >= mat[0].length - 1)
            return -1;
        return mat[row][col + 1];
    }

    public static int getBottom(int[][] mat, int row, int col) {
        if (row >= mat.length - 1)
            return -1;
        return mat[row + 1][col];
    }

    // ! We can Combine All the 4 Functions to make One Function
    public static int getVal(int[][] mat, int row, int col) {
        if (row < 0 || row >= mat.length || col < 0 || col >= mat[0].length)
            return -1;
        return mat[row][col];
    }

    public static void findPeakElementIIHelper(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.println(mat[row][col] + "=>" + getRight(mat, row, col));
            }
        }
    }

    public static int[] findPeakElementIIBrute(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int elem = mat[i][j];
                if (elem > getLeft(mat, i, j - 1) &&
                        elem > getTop(mat, i - 1, j) &&
                        elem > getRight(mat, i, j + 1) &&
                        elem > getBottom(mat, i + 1, j)) {
                    res[0] = i;
                    res[1] = j;
                    break;
                }
            }
        }
        return res;
    }

    // ! ==================== SEARCH IN 2D MATRIX II ====================
    public static boolean binarySearch(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] > target)
                j = mid - 1;
            else if (nums[mid] < target)
                i = mid + 1;
            else
                return true;
        }
        return false;
    }

    public static boolean SearchIn2DMatrixIIOptimal(int[][] mat, int target) {
        int m = mat.length;
        int n = mat[0].length;
        int row = 0;
        int col = n - 1;
        while (row < m && col >= 0) {
            System.out.println("[" + row + "," + col + "]");
            if (mat[row][col] == target)
                return true;
            if (mat[row][col] > target)
                col--;
            else
                row++;
        }
        return false;
    }

    public static boolean SearchIn2DMatrixIIBetter(int[][] mat, int target) {
        int m = mat.length;
        int n = mat[0].length;
        int i = 0;
        int j = m - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            System.out.println("mid --> " + mid);
            if (mat[mid][0] == target)
                return true;
            if (mat[mid][0] > target)
                j = mid - 1;
            else {
                boolean isFound = binarySearch(mat[mid], target);
                if (isFound)
                    return true;
                if (mat[mid][0] < target) {
                    if (mid > 0 && mat[mid - 1][0] < target) {
                        if (binarySearch(mat[mid - 1], target))
                            return true;
                    } else {
                        i = mid + 1;
                    }
                } else
                    j = mid - 1;
            }
        }
        return false;
    }

    public static boolean SearchIn2DMatrixIIBrute(int[][] mat, int target) {
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            if (n != 0 || mat[i][0] <= target && target <= mat[i][n - 1])
                if (binarySearch(mat[i], target))
                    return true;
        }
        return false;
    }

    // ! ==================== FIND ROWS WITH MAX 1's ====================
    public static int lastOccurance(int[] nums, int target) {
        int n = nums.length, i = 0, j = n - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] > target)
                j = mid - 1;
            else
                i = mid + 1;
        }
        return n - i;
    }

    public static int countOnes(int[] nums) {
        int n = nums.length;
        int i = 0, j = n - 1;

        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (nums[mid] == 0)
                i = mid + 1;
            else
                j = mid - 1;
        }

        return n - i;
    }

    public static int[] rowAndMaximumOnes(int[][] mat) {
        int idx = 0;
        int max = -1;
        for (int i = 0; i < mat.length; i++) {
            int count = countOnes(mat[i]);
            if (count > max) {
                max = count;
                idx = i;
            }
        }
        return new int[] { idx, max };
    }
}
