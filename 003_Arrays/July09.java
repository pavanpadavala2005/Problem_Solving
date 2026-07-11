
public class July09 {

    public static int findPeakElementOptimal(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return 0;
        if (nums[0] > nums[1])
            return 0;
        if (nums[n - 2] < nums[n - 1])
            return n - 1;
        int i = 1;
        int j = n - 2;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] > nums[mid + 1])
                j = mid - 1;
            else
                i = mid + 1;
        }
        return -1;
    }

    public static int findPeakElementBetter(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return 0;
        for (int i = 0; i < n; i++)
            if ((i == 0 || nums[i - 1] < nums[i]) && (i == n - 1 || nums[i] > nums[i + 1]))
                return i;
        return -1;
    }

    public static int findPeakElementBrute(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return 0;
        if (nums[0] > nums[1])
            return 0;
        if (nums[n - 1] > nums[n - 2])
            return n - 1;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1])
                return i;
        }
        return -1;
    }

    //
    // =====================================================================
    //

    public static int calcTime(int[] nums, int speed) {
        int totalTime = 0;
        for (int i = 0; i < nums.length; i++) {
            totalTime += (nums[i] + speed - 1) / speed;
        }
        return totalTime;
    }

    public static int kokoEatingBananasOptimal(int[] nums, int h) {
        int mx = -1;
        for (int i : nums)
            mx = Math.max(mx, i);
        int i = 1;
        int j = mx;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (calcTime(nums, mid) <= h)
                j = mid - 1;
            else
                i = mid + 1;
        }
        return i;
    }

    public static int kokoEatingBananasBrute(int[] nums, int h) {
        int mx = -1;
        for (int i : nums)
            mx = Math.max(mx, i);
        for (int i = 1; i <= mx; i++) {
            int reqTime = calcTime(nums, i);
            if (reqTime <= h)
                return i;
        }
        return -1;
    }
    // public static int calcTime(int[] nums, int perHour) {
    // int totalTime = 0;
    // for (int i : nums) {
    // totalTime += Math.ceil(i / perHour);
    // }
    // return totalTime;
    // }

    // public static int kokoEatingBananas(int[] nums, int h) {
    // for (int i = 0; i < nums.length; i++) {
    // int reqTime = calcTime(nums, nums[i]);
    // if (reqTime <= h) {
    // return reqTime;
    // }
    // }
    // }

    public static int nThRootOptimal(int n, int m) {
        if (n <= 1)
            return m;
        int i = 1;
        int j = m;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            long sqr = 1;
            for (int k = 1; k <= n; k++)
                sqr *= k;
            if (sqr == m)
                return mid;
            else if (sqr < m)
                i = mid + 1;
            else
                j = mid - 1;
        }
        return -1;
    }

    public static int nThRootBrute(int n, int m) {
        for (int i = 1; i <= n; i++) {
            int sqr = 1;
            for (int j = 1; j <= n; j++) {
                sqr *= i;
            }
            if (sqr == m)
                return i;
            else if (sqr > m)
                return -1;
        }
        return -1;
    }

}

class BsOnAnswers {
    public static int getVal() {
        return 10;
    }
}