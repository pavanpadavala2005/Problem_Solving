public class July15 {
    // ! ==================== FIND MEDIAN OF MATRIX ====================

    // ! =============== GFG. Median in a Row-Wise Sorted Matrix ================
    // @ Time Complexity: O(log C)
    // @ Space Complexity: O(1)
    public static int upperBound(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] > target)
                j = mid - 1;
            else
                i = mid + 1;
        }
        return i;
    }

    // @ Time Complexity: O(R log C)
    // @ Space Complexity: O(1)
    public static int numsLessThanElement(int[][] mat, int mid) {
        int ctr = 0;
        for (int i = 0; i < mat.length; i++)
            ctr += upperBound(mat[i], mid);
        return ctr;
    }

    // @ Time Complexity: O(R log C log V)
    // @ Space Complexity: O(1)
    public static int medianOfMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int mi = Integer.MAX_VALUE;
        int mx = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            mi = Math.min(mat[i][0], mi);
            mx = Math.max(mat[i][m - 1], mx);
        }
        int i = mi;
        int j = mx;
        int md = (n * m) / 2;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            int elems = numsLessThanElement(mat, mid);
            if (elems <= md)
                i = mid + 1;
            else
                j = mid - 1;
        }
        return i;
    }

    // ! ==================== FIND K TH ELEMENT SORTED ARRAYS ====================

    // ! =============== GFG. K-th Element of Two Sorted Arrays ================
    // @ Time Complexity: O(N1 + N2)
    // @ Space Complexity: O(1)
    public static int kThElementOfSortedArrays(int[] nums1, int[] nums2, int k) {
        k = k - 1; // ! Because 1 Based Indexing
        int n1 = nums1.length;
        int n2 = nums2.length;
        int ctr = 0;
        int i = 0;
        int j = 0;
        while (i < n1 && j < n2) {
            if (nums1[i] < nums2[j]) {
                if (ctr == k)
                    return nums1[i];
                i++;
            } else {
                if (ctr == k)
                    return nums2[j];
                j++;
            }
            ctr++;
        }
        while (i++ < n1)
            if (ctr++ == k)
                return nums1[i];

        while (j++ < n2)
            if (ctr++ == k)
                return nums2[j];
        return -1;
    }

    // ! ==================== FIND ROWS WITH MAX 1's OPTIMAL ====================

    // ! =============== GFG. Row with Max 1s in Row-Wise Sorted Matrix ================
    // @ Time Complexity: O(R + C)
    // @ Space Complexity: O(1)
    public static int[] rowWithMax1s(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int i = 0;
        int j = n - 1;
        int rowIdx = -1;
        while (i < m && j >= 0) {
            if (mat[i][j] == 1) {
                rowIdx = i;
                j--;
            } else
                i++;
        }
        return new int[] { rowIdx };
    }
}
