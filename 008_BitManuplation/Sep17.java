import java.util.*;

public class Sep17 {

    // ! ============== LC201. Bitwise AND of Numbers Range [L to R] =============
    // @ TC --> O(log N) --> every time number is Getting half right shift
    // @ SC --> O(1)
    public static int rangeBitwiseAndOptimal(int left, int right) {
        int count = 0;
        while (left != right) {
            left = left >> 1;
            right = right >> 1;
            count++;
        }
        return left << count;
    }

    // @ TC --> O(right-left)
    // @ SC --> O(1)
    public static int printRangeAndBetter(int left, int right) {
        int res = left;
        for (int i = left + 1; i <= right; i++)
            left &= i;
        return res;
    }

    // @ TC --> O(2 ^ right-left)
    // @ SC --> O(2 ^ right-left)
    public static int rangeBitwiseAndHelper(int low, int high) {
        if (low > high)
            return -1;
        if (low == high)
            return low;
        int mid = low + (high - low) / 2;
        int left = rangeBitwiseAndHelper(low, mid - 1);
        int right = rangeBitwiseAndHelper(mid + 1, high);
        return mid & left & right;
    }

    // ! ============== LC89. Gray Code =============
    // @ TC --> O(2^N)
    // @ SC --> O(2^N) --> returning answer
    public static List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++)
            res.add(i ^ (i >> 1));
        return res;
    }

    // @ TC --> O(2^N)
    // @ SC --> O(2^N) --> stack Space
    public static void subSets(int num, int i, int n, List<Integer> res) {
        if (i >= n)
            return;
        res.add(num);
        for (int idx = i; idx < n; idx++) {
            num = num | (1 << idx);
            subSets(num, idx + 1, n, res);
            num = num & ~(1 << idx);
        }
    }

    // ! ============== LC137. Single Number II =============
    // @ TC -- O(N) --> only one loop
    // @ SC --> O(1) --> manipulating bits
    // * Done with Concept of Buckets
    public static int singleNumberIIOptimal(int[] nums) {
        int ones = 0;
        int twos = 0;
        for (int i : nums) {
            // * ones^i --> add the the ones
            // * ~twos --> not in twos

            ones = (ones ^ i) & ~twos;
            twos = (twos ^ i) & ~ones;
        }
        return twos;

    }

    public static void conceptOfBuckets(int[] nums) {
        Set<Integer> b1 = new HashSet<>();
        Set<Integer> b2 = new HashSet<>();
        Set<Integer> b3 = new HashSet<>();

        for (int num : nums) {
            if (b3.contains(num))
                // if 4 th time Don't Add
                continue;
            else if (b2.contains(num)) {
                // B2 --> B3
                b2.remove(num);
                b3.add(num);
            } else if (b1.contains(num)) {
                // B1 --> B2
                b1.remove(num);
                b2.add(num);
            } else // --> B1
                b1.add(num);

        }
    }

    // @ TC --> O(32 * N) --> nested Loop
    // @ SC --> O(1)
    public static int singleNumberIIBettr(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums)
                if ((num & (1 << i)) != 0)
                    count++;
            if (count % 3 != 0)
                res = res | (1 << i);
        }
        return res;
    }

    // ! ============== GFG. XOR of Numbers Range L to R =============
    public static int findXOR(int l, int r) {
        return getXor(l - 1) ^ getXor(r);
    }

    // @ TC --> O(1)
    // @ SC --> O(1)
    public static int getXor(int num) {
        switch (num % 4) {
            case 0:
                return num;
            case 1:
                return 1;
            case 2:
                return num + 1;
            case 3:
                return 0;
            default:
                return -1;
        }
    }

    // ! ============== LC29. Divide Two Integers =============
    // @ TC --> O(log N * log N) --> outer number reduced by inner number maximum
    // times inner number was incremented by n*2^p where p--> 0,1,2,3... so log
    // increment and outer also log decrement
    // @ SC --> O(1)
    public static int divideBetter(int dividend, int divisor) {
        if (dividend == divisor)
            return 1;
        boolean sign = (dividend < 0) == (divisor < 0);
        long n = dividend;
        long d = divisor;
        if (dividend < 0)
            n = -n;
        if (divisor < 0)
            d = -d;
        long ans = 0;
        while (n >= d) {
            n -= d;
            ans++;
        }
        if (!sign)
            ans = -ans;
        if (ans > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        return (int) ans;
    }

    // @ TC --> O(divided) --> if divisor is 1 then it should run for dividend times
    // @ SC --> O(1)
    public static int divideBrute(int dividend, int divisor) {
        if (dividend == divisor)
            return 1;
        boolean sign = (dividend < 0) == (divisor < 0);
        long n = dividend;
        long d = divisor;
        if (dividend < 0)
            n = -n;
        if (divisor < 0)
            d = -d;
        long ans = 0;
        while (n >= d) {
            int pow = 0;
            while ((d << (pow + 1)) < n)
                pow++;
            n = n - (d << pow);
            ans = ans + (1 << pow);
        }
        if (!sign)
            ans = -ans;
        if (ans > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        return (int) ans;
    }
}

// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC29. Divide Two Integers ✅
// 2. GFG. XOR of a Number Range L to R ✅
// 3. LC137. Single Number II ✅
// 4. LC89. Gray Code ✅
// 5. LC201. Bitwise AND of Numbers Range ✅