// ! Basic Operations
// -->isEven(int n)
// -->isOdd(int n)
// -->multiplyBy2(int n)
// -->divideBy2(int n)
// -->isPowerOfTwo(int n)
// -->isPowerOfFour(int n)
// !Counting Operations
// -->countSetBits(int n) (Brian Kernighan)
// -->countSetBitsBrute(int n)
// -->countUnsetBits(int n, int totalBits)
// -->parity(int n) (Even/Odd number of set bits)
// -->hammingDistance(int a, int b)
// ! Bit Position Operations
// -->findLeftMostSetBitPosition(int n)
// -->findRightMostSetBitPosition(int n) ✅ (already have)
// -->findOnlySetBitPosition(int n) (return -1 if multiple set bits)
// -->countTrailingZeros(int n)
// -->countLeadingZeros(int n)
// ! Mask Operations
// -->extractBits(int n, int start, int length)
// -->replaceBits(int n, int value, int start, int length)
// -->clearRange(int n, int start, int length)
// -->setRange(int n, int start, int length)
// -->toggleRange(int n, int start, int length)
// ! Bit Rotation
// -->rotateLeft(int n, int k)
// -->rotateRight(int n, int k)
// ! Number Utilities
// -->reverseBits(int n)
// -->swapOddEvenBits(int n)
// -->nextPowerOfTwo(int n)
// -->highestPowerOfTwo(int n)
// -->lowestPowerOfTwo(int n)
// ! XOR Utilities
// -->swap(int a, int b) (XOR swap)
// -->findSingleNumber(int[] arr)
// -->findTwoUniqueNumbers(int[] arr)
// -->missingNumber(int[] arr)
// ! Binary Conversion
// -->getBinary(int n) ✅
// -->getBinary(int n, int bits) (fixed-width like 8/16/32 bits)
// -->getInteger(String bin) ✅
// ! Advanced Bit Tricks
// --> subsetsUsingBitMask(int[] arr)
// --> hasAlternatingBits(int n)
// --> grayCode(int n)
// --> binaryToGray(int n)
// --> grayToBinary(int n)
// ! Java Built-in Wrappers
// -->bitCount(int n) → Integer.bitCount()
// -->highestOneBit(int n)
// -->lowestOneBit(int n)
// -->numberOfLeadingZeros(int n)
// -->numberOfTrailingZeros(int n)
// -->reverse(int n)
// -->reverseBytes(int n)
// -->rotateLeft(int n, int distance)
// -->rotateRight(int n, int distance)
// -->signum(int n)

public class BitManipulationUtils {
    // * ==== GENERAL UTILS =====
    public static boolean isOdd(int n) {
        return (n & 1) == 1;
    }

    public static boolean isEven(int n) {
        return (n & 1) == 0;
    }

    public static boolean multiplyBy2(int n) {
        return (n & 1) == 0;
    }

    public static boolean divideBy2(int n) {
        return (n & 1) == 0;
    }

    // * ==== SET BIT UTILS =====

    public static boolean checkIthBit(int n, int i) {
        return (n & (1 << i)) != 0;
    }

    public static int setIthBit(int n, int i) {
        return (n | (1 << i));
    }

    public static int clearIthBit(int n, int i) {
        return (n & ~(1 << i));
    }

    public static int toggleIthBit(int n, int i) {
        return (n ^ (1 << i));
    }

    public static int removeRightSetBit(int n) {
        return (n & (n - 1));
    }

    public static int setRightMostUnsetBit(int n) {
        return (n | (n + 1));
    }

    public static int findRightMostSetBitPosition(int n) {
        // return (n & (~(n - 1)));
        return (n & n - 1) ^ n;
        // return n & -n;
    }

    // ! ========== BIT MASKING ============
    // * SINGLE BIT MASK
    public static int singleBitMask(int i) {
        return 1 << i;
    }

    // * MULTIPLE BIT MASK (RANGE MASK)
    public static int rangeMaskBrute(Integer... positions) {
        // ! Ex : 1,2,3,4 --> O(N) TC
        // !==> 0 | (1<<1) | (1<<2) | (1<<3) | (1<<4)
        int res = 0;
        for (int i : positions)
            res |= (1 << i);
        return res;
    }

    public static int rangeMaskOptimal(int start, int length) {
        // ! O(1) TC
        return ((1 << length) - 1) << start;
    }

    public static String getBinary(int n) {
        StringBuilder res = new StringBuilder();
        while (n > 0) {
            int last = n & 1;
            res.append(Integer.toString(last));
            n >>= 1;
        }
        return res.reverse().toString();
    }

    public static int getInteger(String bin) {
        int res = 0;
        int base = 1;
        for (int i = bin.length() - 1; i >= 0; i--) {
            if (bin.charAt(i) == '1')
                res += base;
            base *= 2;
        }
        return res;
    }

}

class BitManipulationUtilsToBeImplemented {
    // ==========================
    // Basic Operations
    // ==========================
    public static boolean isEven(int n) {
        return false;
    }

    public static boolean isOdd(int n) {
        return false;
    }

    public static int multiplyBy2(int n) {
        return 0;
    }

    public static int divideBy2(int n) {
        return 0;
    }

    public static boolean isPowerOfTwo(int n) {
        return false;
    }

    public static boolean isPowerOfFour(int n) {
        return false;
    }

    // ==========================
    // Counting Operations
    // ==========================

    public static int countSetBits(int n) {
        return 0;
    }

    public static int countSetBitsBrute(int n) {
        return 0;
    }

    public static int countUnsetBits(int n, int totalBits) {
        return 0;
    }

    public static boolean parity(int n) {
        return false;
    }

    public static int hammingDistance(int a, int b) {
        return 0;
    }

    // ==========================
    // Bit Position Operations
    // ==========================

    public static int findLeftMostSetBitPosition(int n) {
        return 0;
    }

    public static int findRightMostSetBitPosition(int n) {
        return 0;
    }

    public static int findOnlySetBitPosition(int n) {
        return 0;
    }

    public static int countTrailingZeros(int n) {
        return 0;
    }

    public static int countLeadingZeros(int n) {
        return 0;
    }

    // ==========================
    // Mask Operations
    // ==========================

    public static int extractBits(int n, int start, int length) {
        return 0;
    }

    public static int replaceBits(int n, int value, int start, int length) {
        return 0;
    }

    public static int clearRange(int n, int start, int length) {
        return 0;
    }

    public static int setRange(int n, int start, int length) {
        return 0;
    }

    public static int toggleRange(int n, int start, int length) {
        return 0;
    }

    // ==========================
    // Bit Rotation
    // ==========================

    public static int rotateLeft(int n, int k) {
        return 0;
    }

    public static int rotateRight(int n, int k) {
        return 0;
    }

    // ==========================
    // Number Utilities
    // ==========================

    public static int reverseBits(int n) {
        return 0;
    }

    public static int swapOddEvenBits(int n) {
        return 0;
    }

    public static int nextPowerOfTwo(int n) {
        return 0;
    }

    public static int highestPowerOfTwo(int n) {
        return 0;
    }

    public static int lowestPowerOfTwo(int n) {
        return 0;
    }

    // ==========================
    // XOR Utilities
    // ==========================

    public static int[] swap(int a, int b) {
        return new int[2];
    }

    public static int findSingleNumber(int[] arr) {
        return 0;
    }

    public static int[] findTwoUniqueNumbers(int[] arr) {
        return new int[2];
    }

    public static int missingNumber(int[] arr) {
        return 0;
    }

    // ==========================
    // Binary Conversion
    // ==========================

    public static String getBinary(int n) {
        return "";
    }

    public static String getBinary(int n, int bits) {
        return "";
    }

    public static int getInteger(String bin) {
        return 0;
    }

    // ==========================
    // Advanced Bit Tricks
    // ==========================

    public static void subsetsUsingBitMask(int[] arr) {
    }

    public static boolean hasAlternatingBits(int n) {
        return false;
    }

    public static int[] grayCode(int n) {
        return new int[0];
    }

    public static int binaryToGray(int n) {
        return 0;
    }

    public static int grayToBinary(int n) {
        return 0;
    }
}