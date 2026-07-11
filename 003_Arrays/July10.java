
public class July10 {

    public static int kThMissingNumber(int[] nums, int k) {
        int[] freq = new int[1001];
        for (int i : nums)
            freq[i] = 1;
        int ctr = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 1)
                ctr++;
            if (ctr == k)
                return freq[i];
        }
        return -1;
    }

    public static int daysCaluclator(int[] nums, int capacity) {
        int days = 1, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > capacity) {
                days++;
                sum = nums[i];
            } else
                sum += nums[i];
        }
        return days;
    }

    public static int shipWithinDaysOptimal(int[] nums, int days) {
        int mi = Integer.MAX_VALUE;
        int ma = 0;
        for (int i : nums) {
            mi = Math.min(mi, i);
            ma += i;
        }
        int i = mi, j = ma;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (daysCaluclator(nums, mid) > days)
                i = mid + 1;
            else
                j = mid - 1;
        }
        return i;
    }

    public static int shipWithinDaysBrute(int[] nums, int days) {
        int mi = Integer.MAX_VALUE;
        int ma = 0;
        for (int i : nums) {
            mi = Math.min(mi, i);
            ma += i;
        }
        for (int i = mi; i <= ma; i++) {
            if (daysCaluclator(nums, i) <= days)
                return i;
        }
        return -1;
    }

    public static int smallestDivisorHelper(int[] nums, int divisor) {
        int sum = 0;
        for (int i : nums)
            sum += (i + divisor - 1) / divisor;
        return sum;
    }

    public static int smallestDivisorOptimal(int[] nums, int threshold) {
        int mx = Integer.MIN_VALUE;
        for (int i : nums)
            mx = Math.max(mx, i);
        int i = 1;
        int j = mx;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (smallestDivisorHelper(nums, mid) > threshold)
                i = mid + 1;
            else
                j = mid - 1;
        }
        return i;
    }

    public static int smallestDivisorBrute(int[] nums, int threshold) {
        int mx = Integer.MIN_VALUE;
        for (int i : nums)
            mx = Math.max(mx, i);
        for (int i = 1; i <= mx; i++) {
            if (smallestDivisorHelper(nums, i) <= threshold)
                return i;
        }
        return -1;
    }

    public static int bouquetsCounter(int[] nums, int day, int k) {
        int bouquets = 0, ctr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= day)
                ctr++;
            else {
                bouquets += ctr / k;
                ctr = 0;
            }
        }
        bouquets += ctr / k;
        return bouquets;
    }

    public static int minDaysToBloom(int[] nums, int m, int k) {
        int mi = Integer.MAX_VALUE;
        int mx = Integer.MIN_VALUE;
        for (int i : nums) {
            mi = Math.min(mi, i);
            mx = Math.max(mx, i);
        }
        // for (int i = mi; i <= mx; i++) {
        // if (bouquetsCounter(nums, i, k) >= m)
        // return i;
        // }
        // return -1;

        int i = mi;
        int j = mx;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            int bouquets = bouquetsCounter(nums, i, k);
            if (bouquets < m)
                i = mid + 1;
            else
                j = mid - 1;
        }
        return i;
    }

    public static int calcTime(int[] nums, int speed) {
        int totalTime = 0;
        for (int i = 0; i < nums.length; i++) {
            totalTime += (int) (nums[i] + speed - 1) / speed;
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
            int perHour = calcTime(nums, i);
            if (perHour <= h)
                return i;
        }
        return -1;
    }
}
