
import java.util.Arrays;

public class July12 {
    // ! ==================== SPLIT ARRAY CORRECT ====================
    public static boolean splitArrayPossible(int[] nums, int max, int k) {
        int ctr = 1;
        int sm = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sm + nums[i] <= max) {
                sm += nums[i];
            } else {
                ctr++;
                sm = nums[i];
            }
        }
        return ctr <= k;
    }

    // ! ==================== SPLIT ARRAY WASTED ====================
    public static int splitArrayHelper(int[] prefix, int limit) {
        int n = prefix.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < limit; i++) {
            ans = Math.min(Math.max(prefix[n - 1] - prefix[i], prefix[i]), ans);
        }
        return ans;
    }

    public static int splitArrayBrute(int[] nums, int k) {
        int n = nums.length;
        if (k > n)
            return -1;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++)
            prefix[i] = prefix[i - 1] + nums[i];
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= n - 1; i++) {
            ans = Math.min(splitArrayHelper(prefix, i), ans);
        }
        return ans;
    }

    // ! ==================== BOOK ALLOCATION ====================
    public static int bookAllocationHelper(int[] nums, long max) {
        int ctr = 1;
        long sm = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sm + nums[i] <= max)
                sm += nums[i];
            else {
                ctr++;
                sm = nums[i];
            }
        }
        return ctr;
    }

    public static int bookAllocationOptimal(int[] nums, int k) {
        int n = nums.length;
        if (k > n)
            return -1;
        int mi = Integer.MIN_VALUE;
        long sm = 0;
        for (int elem : nums) {
            mi = Math.max(mi, elem);
            sm += elem;
        }
        long i = mi;
        long j = sm;
        while (i <= j) {
            long mid = i + (j - i) / 2;
            if (bookAllocationHelper(nums, mid) <= k)
                j = mid - 1;
            else
                i = mid + 1;
        }
        return (int) i;
    }

    public static int bookAllocationBrute(int[] nums, int k) {
        int n = nums.length;
        if (k > n)
            return -1;
        int mi = Integer.MIN_VALUE;
        int sm = 0;
        for (int elem : nums) {
            mi = Math.max(mi, elem);
            sm += elem;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= sm; i++) {
            if (bookAllocationHelper(nums, i) == k) {
                res = i;
                break;
            }
        }
        return res;
    }

    // ! ==================== AGGRESSIVE COWS ====================
    public static boolean aggressiveCowsHelper(int[] nums, int distance, int cows) {
        int cowCtr = 1, prev = 0;
        for (int i = 1; i < nums.length; i++) {
            if (distance <= nums[i] - nums[prev]) {
                cowCtr++;
                prev = i;
            }
        }
        if (cowCtr >= cows)
            return true;
        return false;
    }

    public static int aggressiveCowsOptimal(int nums[], int cows) {
        Arrays.sort(nums);
        int mx = Integer.MIN_VALUE, mi = Integer.MAX_VALUE;
        for (int elem : nums) {
            mi = Math.min(elem, mi);
            mx = Math.max(elem, mx);
        }
        int i = 1;
        int j = mx - mi;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (aggressiveCowsHelper(nums, mid, cows))
                i = mid + 1;
            else
                j = mid - 1;
        }
        return j;
    }

    public static int aggressiveCowsBrute(int nums[], int cows) {
        Arrays.sort(nums);
        int mx = Integer.MIN_VALUE, res = Integer.MIN_VALUE;
        for (int i : nums)
            mx = Math.max(i, mx);
        for (int i = 1; i <= mx; i++)
            if (aggressiveCowsHelper(nums, i, cows))
                res = Math.max(res, i);
        return res;
    }

}
