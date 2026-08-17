public class July11 {

    // ! =============== LC 1539. Kth Missing Positive Number ================
    // @ Time Complexity: O(log N)
    // @ Space Complexity: O(1)
    public static int findKthMisingNumberOptimal(int[] nums, int k) {
        int n = nums.length;
        if (n > 0 && nums[0] > k)
            return k;
        int i = 0;
        int j = n - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            int atchual = nums[mid] - mid - 1;
            if (atchual < k)
                i = mid + 1;
            else
                j = mid - 1;
        }
        // return nums[i] - nums[j] + k;
        // return nums[j] + (k - (nums[j] - (j + 1)));

        // ! -------------------

        // int atchualAti = nums[i] - (i + 1);
        // System.out.println(atchualAti);
        // int atchualAtj = nums[j] - (j + 1);
        // System.out.println(atchualAtj);
        // return (k + atchualAti) - atchualAtj;

        // ! Instead of Above Logics Below Return will justify that

        return k + j + 1;
    }

    // @ Time Complexity: O(N)
    // @ Space Complexity: O(1)
    public static int findKthMisingNumberBrute(int[] nums, int k) {
        int n = nums.length;
        if (n > 0 && nums[0] > k)
            return k;
        for (int i : nums) {
            if (nums[i] > k)
                break;
            k++;
        }
        return k;
    }

    // ! =============== LC 1011. Capacity To Ship Packages Within D Days
    // ================
    // @ Time Complexity: O(N)
    // @ Space Complexity: O(1)
    public static boolean shipHelper(int[] nums, int capacity, int days) {
        int sm = 0, day = 1;
        for (int i = 0; i < nums.length; i++) {
            if (sm + nums[i] > capacity) {
                day++;
                sm = nums[i];
            } else
                sm += nums[i];
        }
        return day >= days;
    }

    // @ Time Complexity: O(N log S)
    // @ Space Complexity: O(1)
    public static int minDaysToShip(int[] nums, int days) {
        int i = Integer.MIN_VALUE;
        int j = 0;
        for (int elem : nums) {
            i = Math.max(i, elem);
            j += elem;
        }
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (shipHelper(nums, mid, days)) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }

    // ! =============== LC 1482. Minimum Number of Days to Make m Bouquets
    // ================
    // @ Time Complexity: O(N)
    // @ Space Complexity: O(1)
    public static boolean isBoquetsPossible(int[] nums, int day, int m, int k) {
        int ctr = 0, bouqets = 0;
        for (int i : nums) {
            if (i <= day)
                ctr++;
            else {
                bouqets += ctr / k;
                ctr = 0;
            }
        }
        if (ctr > 0)
            bouqets += ctr / k;
        return bouqets >= m;
    }

    // @ Time Complexity: O(N log M)
    // @ Space Complexity: O(1)
    public static int minBoquetsOptimal(int[] nums, int m, int k) {
        int n = nums.length;
        if ((long) m * n > n)
            return -1;
        int mx = Integer.MIN_VALUE;
        for (int i : nums)
            mx = Math.max(mx, i);
        int i = 1;
        int j = mx;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (isBoquetsPossible(nums, mid, m, k))
                j = mid - 1;
            else
                i = mid + 1;
        }
        return i;
    }

    // @ Time Complexity: O(N * M)
    // @ Space Complexity: O(1)
    public static int minBoquetsBrute(int[] nums, int m, int k) {
        int n = nums.length;
        if ((long) m * n > n)
            return -1;
        int mx = Integer.MIN_VALUE;
        for (int i : nums)
            mx = Math.max(mx, i);
        for (int i = 1; i <= mx; i++) {
            if (isBoquetsPossible(nums, i, m, k))
                return i;
        }
        return -1;
    }

    // ! =============== GFG. Aggressive Cows ================
    // @ Time Complexity: O(N)
    // @ Space Complexity: O(1)
    public static boolean aggressiveCowsCanDo(int[] nums, int k, int dist) {
        int cows = 1;
        int prev = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            int distance = nums[i] - nums[prev];
            if (dist <= distance) {
                System.out.println("Cow Placed At : " + i);
                min = Math.min(min, distance);
                cows++;
                prev = i;
            }
            System.out.println(min + "-" + cows + "=" + i);
            if (cows == k)
                return true;
        }
        return false;
    }

    // @ Time Complexity: O(N * R)
    // @ Space Complexity: O(1)
    public static int aggressiveCountHelper(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int mi = Integer.MAX_VALUE;
        int mx = Integer.MIN_VALUE;
        for (int i : nums) {
            mi = Math.min(mi, i);
            mx = Math.max(mx, i);
        }
        for (int i = mi; i <= mx; i++) {
            int cows = k;
            int prev = 0;
            for (int j = 0; j < nums.length; j++) {
                int dist = nums[j] - nums[prev];
                if (j == 0 || i <= dist) {
                    cows--;
                    prev = j;
                    min = Math.min(min, dist);
                }
            }
        }
        return min;
    }

}