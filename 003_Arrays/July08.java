
public class July08 {

    // ! =============== LC69. Sqrt(x) ================
    /*
     @ TC --> O(log X)
     @ SC --> O(1)
    */
    public static int sqrtOptimal(int x) {
        int i = 1;
        int j = x;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (mid * mid <= x)
                i = mid + 1;
            else
                j = mid - 1;
        }
        return j;
    }

    // ! =============== LC540. Single Element in a Sorted Array ================
    /*
     @ TC --> O(log N)
     @ SC --> O(1)
    */
    public static int singleNonDuplicateOptimal(int[] nums) {
        int n = nums.length;
        if (n == 1 || nums[0] != nums[1])
            return nums[0];
        if (nums[n - 1] != nums[n - 2])
            return nums[n - 1];
        int i = 1;
        int j = n - 2;
        int val = -1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid - 1] != nums[mid] && nums[mid] != nums[mid + 1]) {
                val = nums[mid];
                break;
            }
            if (mid % 2 == 0 && nums[mid] == nums[mid - 1])
                j = mid - 1;
            else if (mid % 2 != 0 && nums[mid] == nums[mid - 1])
                i = mid + 1;
        }
        return 0;
    }

    /*
     @ TC --> O(log N)
     @ SC --> O(1)
    */
    public static int singleNonDuplicateBetter(int[] nums) {
        int n = nums.length;
        if (n == 1 || nums[0] != nums[1])
            return nums[0];
        if (nums[n - 1] != nums[n - 2])
            return nums[n - 1];
        int i = 1;
        int j = n - 2;
        int val = 0;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid - 1] != nums[mid] && nums[mid] != nums[mid + 1])
                val = nums[mid];
            // If Odd Idx check for Back
            if (mid % 2 != 0) {
                if (nums[mid] == nums[mid - 1])
                    i = mid + 1;
                else
                    j = mid - 1;
            }
            // If Even Idx check for Back
            else if (mid % 2 == 0) {
                if (nums[mid] == nums[mid - 1])
                    j = mid - 1;
                else
                    i = mid + 1;
            }
        }
        return val;
    }

    /*
     @ TC --> O(N)
     @ SC --> O(1)
    */
    public static int singleNonDuplicateBrute(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        if (nums[n - 1] != nums[n - 2])
            return nums[n - 1];
        if (nums[0] != nums[1])
            return nums[0];
        int elem = 0;
        for (int i = 1; i < n - 1; i++) {
            if (nums[i - 1] != nums[i] && nums[i] != nums[i + 1]) {
                elem = nums[i];
                break;
            }
        }
        return elem;
    }

    // ! =============== LC367. Valid Perfect Square ================
    /*
     @ TC --> O(log X)
     @ SC --> O(1)
    */
    public static boolean perfcetSquare(int x) {
        if (x == 0 || x == 1)
            return true;
        int i = 2;
        int j = x;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            long sqr = (long) mid * mid;
            if (sqr > x)
                j = mid - 1;
            else if (sqr < x)
                i = mid + 1;
            else
                return true;
        }
        return false;
    }

    // ! =============== LC69. Sqrt(x) ================
    /*
     @ TC --> O(log X)
     @ SC --> O(1)
    */
    public static int sqrt(int x) {
        if (x == 0 || x == 1)
            return x;
        int i = 0;
        int j = x;
        int ans = 0;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            long sqr = (long) mid * mid;
            if (sqr < x) {
                ans = mid;
                i = mid + 1;
            } else if (sqr > x)
                j = mid - 1;
            else
                return mid;
        }
        return ans;
    }
}