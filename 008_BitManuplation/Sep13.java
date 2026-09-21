
public class Sep13 {
    // ! ============== LC67. Add Binary =============
    // @ TC --> O(max(a,b))+1+O(len(res)) --> max(a,b) --> running while loop,
    // len(res)--> reversing the resultant
    // @ SC --> O(res) --> storing in a stringbuffer for returning result
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = 0;
            if (i >= 0)
                sum += a.charAt(i--) - '0';
            if (j >= 0)
                sum += b.charAt(j--) - '0';
            sum += carry;
            carry = sum / 2;
            sb.insert(0, "" + (char) ('0' + sum % 2));
        }
        return sb.toString();
    }

    // ! ============== LC190. Reverse Bits =============
    // @ TC --> O(log N) --> number is being reduced by 2 every time
    // @ SC --> O(1) --> not using any extra variables
    public static int reverseBitsBetter(int num) {
        int count = 0;
        int res = 0;
        while (num > 0) {
            if ((num & 1) != 0)
                res = res | (1 << (31 - count));
            count++;
            num = num >> 1;
        }
        return res;
    }

    // @ TC --> O(31) --> iterating total 31 Bits every time
    // @ SC --> O(1) --> not using any extra variables
    public static int reverseBitsBrute(int num) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((num & (1 << i)) != 0)
                res = (res | (1 << (31 - i)));
        }
        return res;
    }

    // ! ============== LC338. Counting Bits =============
    public static int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int num = i;
            int count = 0;
            while (num > 0) {
                count += (num & 1);
                num = num >> 1;
            }
            res[i] = count;
        }
        return res;
    }

    // @ The Actual Problems
    // ! ============== GEN. Count set bits from 0 to Nth Bit =============
    public static int countSetBitsToN(int num, int n) {
        int count = 0;
        while (n >= 0) {
            count += num & 1;
            num = num >> 1;
            n--;
        }
        return count;
    }
    // ! ============== GEN. Find the number of set bits in a range [L, R]. =============

    public static int countSetBitsInRange(int num, int l, int r) {
        int count = 0;
        for (int i = l; i <= r; i++)
            if ((num & (1 << i)) != 0)
                count++;
        return count;
    }

    // @ Checking the Bits and Practice
    // ! ============== Check Ith Bit Set or Not =============
    public static boolean checkIthSetBit(int n, int i) {
        // return (n & (1 << i)) != 0;
        return ((n >> i) & 1) != 0;
    }

    // ! ============== Check Ith Bit is UnSet or Not =============
    public static boolean checkIthUnSetBit(int n, int i) {
        return (n & ~(1 << i)) == n;
    }

    // ! ============== Get Ith Bit =============
    public static int getIthBit(int n, int i) {
        // if ((n & (1 << i)) != 0)
        // return 1;
        // return 0;
        return ((n >> i) & 1);
    }

    // ! ============== Check MSB (-ve or +ve) SIGN =============
    public static int checkSign(int n) {
        if ((n & (1 << 31)) != 0)
            return -1;
        return 1;
    }

    // ! ============== Check LSB (EVEN or ODD) =============
    public static boolean isOdd(int n) {
        return (n & 1) == 0;
    }

    // ! ============== Set Ith Bit =============
    public static int setIthBit(int n, int i) {
        return (n | (1 << i));
    }

    // ! ============== Toggle Ith Bit =============
    public static int toggleIthBit(int n, int i) {
        return (n ^ (1 << i));
    }

    // ! ============== Clear Right Most Set Bit =============
    public static int ClearRightSetBit(int n, int i) {
        return n & (n - 1);
    }

    // ! ============== Turn On Right Most UnSet Bit =============
    public static int setRightUnSetBit(int n) {
        return (n | n + 1);
    }

    // ! ============== Clear Ith Bit =============
    public static int clearIthBit(int n, int i) {
        return (n & ~(1 << i));
    }

    // ! ============== Clear All Bits after Right Set Bit towards MSB =============
    public static int clearBitsAfterRightSetBit(int n) {
        return (n & ~(n - 1));
    }

    // ! ============== Toggle Right Most Set Bit =============
    public static int toggleRightSetBit(int n) {
        return (n ^ (n & -n));
    }

}

// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 0. GEN. Count set bits from 0 to Nth Bit ✅
// 0. GEN. Find the number of set bits in a range [L, R]. ✅
// 1. LC338. Counting Bits ✅
// 2. LC67. Add Binary ✅
// 3. LC190. Reverse Bits ✅
// 4. LC67. Add Binary ✅
