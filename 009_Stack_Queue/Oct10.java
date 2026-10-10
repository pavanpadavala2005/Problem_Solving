import java.util.*;

public class Oct10 {

    // ! ============= LC853. Car Fleet =============
    /*
    @ TC --> O(N + T) --> first computing with length N and Processing in Target(T) length of Array
    @ SC --> O(T)  --> where T = target and we are storing State in the length of Target Size 
    */
    public static int carFleetOptimal(int target, int[] position, int[] speed) {
        int n = position.length;
        float[] fleetArr = new float[target + 1];
        for (int i = 0; i < n; i++)
            fleetArr[position[i]] = (float) (target - position[i]) / speed[i];
        int count = 0;
        float prev = -1;
        int ptr = target - 1;
        while (ptr > 0) {
            if (fleetArr[ptr--] > prev) {
                prev = fleetArr[ptr];
                count++;
            }
        }
        return count;
    }

    /*
    @ TC --> O(2N) --> computing 2D Array and Processing
    @ SC --> O(2N + N) --> for Storing 2D array and Stack
    */
    public static int carFleetBetter(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] fleetArr = new double[n][2];

        for (int i = 0; i < n; i++) {
            int currPos = position[i];
            int currSpeed = speed[i];
            double timeReq = (double) (target - currPos) / currSpeed;
            fleetArr[i] = new double[] { position[i], timeReq }; // Pre Computation of 2D Array {POS, Time req from that Position}
        }

        Arrays.sort(fleetArr, (a, b) -> Double.compare(a[0], b[0]));
        int[] st = new int[n];
        int ptr = -1;

        for (int i = n - 1; i >= 0; i--) {
            double timeReq = fleetArr[i][1]; // Time require for i th Car in Sorted order

            if (ptr < 0 || timeReq > fleetArr[st[ptr]][1]) // Checking with the Top of the Stack
                st[++ptr] = i;
        }
        return ptr + 1;
    }

    // ! ============= LC962. Maximum Width Ramp =============
    /*
    @ TC --> O(2N) --> two pass Solution 
    @ SC --> O(N) --> storing in the stack 
    */
    public static int maxWidthRampBetter(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int[] st = new int[n];
        int ptr = -1;
        st[++ptr] = 0;
        for (int i = 1; i < n; i++)
            if (ptr >= 0 && nums[st[ptr]] > nums[i])
                st[++ptr] = i;
        for (int i = n - 1; i >= 0; i--)
            while (ptr >= 0 && nums[st[ptr]] <= nums[i])
                ans = Math.max(i - st[ptr--], ans);
        return ans;
    }

    /*
    @ TC --> O(N^2)
    @ SC --> O(1)
    */
    public static int maxWidthRamp(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                if (nums[i] <= nums[j])
                    ans = Math.max(ans, j - i);
        return ans;
    }
}

// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC962. Maximum Width Ramp ✅
// 2. LC853. Car Fleet ✅
