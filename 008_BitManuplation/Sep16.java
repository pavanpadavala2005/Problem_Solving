import java.util.*;

public class Sep16 {
    // ! ============== LC1545. Find Kth Bit in Nth Binary String =============
    public static char findKthBit(int n, int k) {
        StringBuilder sb = new StringBuilder();
        findKthBitHelper(n - 1, sb);
        return sb.charAt(k - 1);
    }

    // @ TC --> O(N) --> recursion
    // @ SC --> O(1) --> Stack Space
    public static void findKthBitHelper(int n, StringBuilder sb) {
        if (n == 0) {
            sb.append('0');
            return;
        }
        findKthBitHelper(n - 1, sb);
        sb.append(1);
        int ln = sb.length();
        for (int i = ln - 2; i >= 0; i--)
            sb.append(sb.charAt(i) == '0' ? '1' : '0');
    }

    public static String findKthBitHelperBrute(int n) {
        if (n == 0)
            return "0";
        String res = findKthBitHelperBrute(n - 1);
        StringBuilder sb = new StringBuilder();
        sb.append(res).append(1);
        for (int i = res.length() - 1; i >= 0; i--)
            sb.append(res.charAt(i) == '0' ? '1' : '0');
        return sb.toString();
    }

    // ! ============== LC2442. Count Number of Distinct Integers After Reverse
    // Operations =============
    public static int countDistinctIntegers(int[] nums) {
        Set<Integer> unq = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int rev = 0;
            while (num > 0) {
                rev = (rev * 10) + (num % 10);
                num = num / 10;
            }
            unq.add(nums[i]);
            unq.add(rev);
        }
        return unq.size();
    }

    // ! ============== LC2119. A Number After a Double Reversal =============
    // @ TC --> O(1)
    // @ SC ---> O(1)
    public static boolean isSameAfterReversals(int num) {
        if (num == 0)
            return true;
        return (num % 10) != 0;
    }

    // ! ============== LC7. Reverse Integer =============
    // @ TC --> O(log 10 (N)) --> every time number / 10
    // @ SC --> O(1)
    public static int reverse(int x) {
        int num = x;
        if (x < 0)
            num = -x;
        long rev = 0;
        while (num > 0) {
            int last = num % 10;
            rev = rev * 10 + last;
            if (rev > Integer.MAX_VALUE)
                return 0;
            num = num / 10;
        }
        if (x < 0)
            rev = -rev;
        return (int) rev;
    }

    // ! ============== LC1018. Binary Prefix Divisible By 5 =============
    public static List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> res = new ArrayList<>();
        long num = 0;
        for (int i = 0; i < nums.length; i++) {
            num = (num * 2 + nums[i]) % 5;
            System.out.println(num);
        }
        return res;
    }

    // ! ============== LC868. Binary Gap =============
    // @ TC --> O(log N) --> reducing by 2 every time
    // @ SC --> O(1) --> nothing other than variablesd
    public static int binaryGapBetter(int num) {
        int i = 0;
        while ((num & 1) == 0) {
            num = num >> 1;
            i++;
        }
        int prev = i;
        num = num >> 1;
        i++;
        int mx = 0;
        while (num > 0) {
            if ((num & 1) == 1) {
                mx = Math.max(i - prev, mx);
                prev = i;
            }
            i++;
            num = num >> 1;
        }
        return mx;
    }

    // @ TC --> o(32) --> running a loop
    // @ SC --> O(1) --> using only variables
    public static int binaryGap(int num) {
        int i = 0;
        int mx = 0;
        while ((num & (1 << i)) == 0) {
            i++;
        }
        int prev = i;
        for (int idx = i + 1; idx < 32; idx++) {
            if ((num & (1 << prev)) != 0 && (num & (1 << idx)) == 0)
                continue;
            mx = Math.max(idx - prev, mx);
            prev = idx;
        }
        return mx;
    }
}

// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC868. Binary Gap ✅
// 2. LC1018. Binary Prefix Divisible By 5 ✅
// 3. LC7. Reverse Integer ✅
// 4. LC2119. A Number After a Double Reversal ✅
// 5. LC2442. Count Number of Distinct Integers After Reverse Operations ✅
// 6. LC1545. Find Kth Bit in Nth Binary String ✅
