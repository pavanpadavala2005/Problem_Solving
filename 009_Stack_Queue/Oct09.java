public class Oct09 {

    // ! ============= LC2289. Steps to Make Array Non-decreasing =============
    /*
    @ TC --> O(N) --> inner loop is not Running for every i 
    @ SC --> O(N * 2)
    */
    public static int totalStepsBetter(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int[][] st = new int[n][2];
        int ptr = -1;
        st[++ptr] = new int[] { nums[n - 1], 0 };
        for (int i = n - 2; i >= 0; i--) {
            int count = 0;
            int val = nums[i];
            while (ptr >= 0 && st[ptr][0] < val) {
                count = Math.max(count + 1, st[ptr][1]);
                ptr--;
            }
            ans = Math.max(count, ans);
            st[++ptr] = new int[] { val, count };
        }

        return ans;
    }

    /*
        @ NOT WORKING PROPERLY
    */
    public static int totalSteps(int[] nums) {
        int count = 0;
        int n = nums.length;
        int[] st = new int[n];
        int ptr = -1;
        int i = 0;
        while (i < n) {
            int ctr = 0;
            while (ptr >= 0 && st[ptr] > nums[i]) {
                i++;
                ctr++;
            }
            if (ctr > 0)
                count++;
            st[++ptr] = nums[i++];
        }

        return count;
    }

    // ! ============= LC456. 132 Pattern =============
    /*
    @ TC --> O(N) --> inner while loop is not running for every i
    @ SC --> O(N) --> taking  a stack
    */
    public static boolean find132patternBetterV1(int[] nums) {
        int n = nums.length;
        int[] st = new int[n];
        int ptr = -1;
        int KVal = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            int iVal = nums[i];
            if (iVal < KVal)
                return true;
            while (ptr >= 0 && st[ptr] < iVal)
                KVal = st[ptr--];
            st[++ptr] = iVal;
        }
        return false;
    }

    /*
    @ TC --> O(N) --> inner while loop is not running for every i
    @ SC --> O(N * 2) --> we are storing [currElem, PrevMin] so at max we store O(2N)
    */
    public static boolean find132patternBetterV2(int[] nums) {
        int n = nums.length;
        int[][] st = new int[n][2];
        int ptr = -1;
        int prevMin = nums[0];
        for (int i = 1; i < n; i++) {
            int kVal = nums[i];
            while (ptr >= 0 && st[ptr][0] <= kVal)
                ptr--;
            if (ptr >= 0 && st[ptr][0] > kVal && st[ptr][1] < kVal)
                return true;
            st[++ptr] = new int[] { kVal, prevMin };
            prevMin = Math.min(prevMin, kVal);
        }
        return false;
    }

    /*
    @ NOT WORKING --> Not a Good Approach
    */
    public static boolean find132patternBrute(int[] nums) {
        int n = nums.length;
        int[] st = new int[n];
        int ptr = -1;
        for (int k = 0; k < n; k++) {
            int kVal = nums[k];
            if (ptr > 0 && st[ptr] > kVal) {
                int j = ptr;
                int i = ptr - 1;
                while (i > 0 && st[i] >= st[j])
                    i--;
                if (st[i] < kVal && kVal < st[j])
                    return true;
                else
                    st[++ptr] = kVal;
            } else {
                st[++ptr] = kVal;
            }
        }
        return false;
    }
}

// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC456. 132 Pattern ✅
// 2. LC2289. Steps to Make Array Non-decreasing ✅ 