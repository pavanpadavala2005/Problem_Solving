
import java.util.Arrays;

public class Sep15 {
    // * Actual Problems

    // ! ============== LC645. Set Mismatch =============
    public static int[] findErrorNumsBetter(int[] nums) {
        int n = nums.length;
        int[] freq = new int[n + 1];
        for (int i = 0; i < n; i++)
            freq[nums[i]]++;
        int missing = -1;
        int repeated = -1;
        for (int i = 1; i <= n + 1; i++) {
            if (freq[i] == 2)
                repeated = i;
            if (freq[i] == 0)
                missing = i;
        }
        return new int[] { repeated, missing };
    }

    // @ TC --> O(N log N) + O(N)
    // @ SC --> O(1)
    public static int[] findErrorNumsBrute(int[] nums) {
        int n = nums.length;
        int sum = (n * (n + 1)) / 2;
        int elem = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && (nums[i] ^ nums[i - 1]) == 0) {
                elem = nums[i];
            }
            sum -= nums[i];
        }
        return new int[] {
                elem,
                sum + elem
        };
    }

    // ! ============== LC461. Hamming Distance =============
    // @ TC --> O(log N) --> reducing by 2 every time
    // @ SC --> O(1) --> nothing other than variables
    public static int hammingDistance(int x, int y) {
        int num = x ^ y;
        int count = 0;
        while (num > 0) {
            count += num & 1;
            num = num >> 1;
        }
        return count;
    }

    // ! ============== LC693. Binary Number with Alternating Bits =============
    // @ TC --> O(log N) --> number reducing by 2 every time
    // @ SC --> O(1) --> nothing other than variables
    public static boolean hasAlternatingBits(int num) {
        int prev = num & 1;
        num = num >> 1;
        while (num > 0) {
            int curr = num & 1;
            if (prev == curr)
                return false;
            prev = curr;
            num = num >> 1;
        }
        return true;
    }

    // * Introduction to Bit Masking
    // ! ============== Mask of the LSB k Bits =============
    public static int getLSBkBits(int num, int k) {
        return num & ((1 << k) - 1);
    }

    // ! ============== Mask of the MSB k Bits =============
    public static int getMSBkBits(int num, int k) {
        int range = 8;
        return num & (~((1 << (range - k)) - 1));
    }

    // ! ============== Mask form L to R =============
    public static int maskFromLtoR(int num, int l, int r) {
        // int mask = 0;
        // for (int i = l; i <= r; i++)
        // mask = mask | (1 << i);
        // return num & mask;
        // * Best
        return num & (((1 << r) - 1) & (~((1 << l) - 1)));
    }

    // ! ============== Clear Bits form L to R =============
    public static int clearBitsFromLtoR(int num, int l, int r) {
        return num & (~(((1 << r + 1) - 1) & (~((1 << l) - 1))));
    }

    // ! ============== Set Bits form L to R =============
    public static int setBitsFromLtoR(int num, int l, int r) {
        return num | (((1 << r + 1) - 1) & (~((1 << l) - 1)));
    }

    // ! ============== Toggle Bits form L to R =============
    public static int toggleBitsFromLtoR(int num, int l, int r) {
        return num ^ ((1 << r + 1) - 1) & (~((1 << l) - 1));
    }

}

// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC693. Binary Number with Alternating Bits ✅
// 2. LC461. Hamming Distance ✅
// 3. LC645. Set Mismatch ✅