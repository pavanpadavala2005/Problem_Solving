
import java.util.Arrays;

public class Example1 {
    public static int uniqueElement(int[] arr) {
        int num = 0;
        for (int i = 0; i < arr.length; i++)
            num ^= arr[i];
        return num;
    }

    public static boolean isOdd(int num) {
        return (num & 1) == 1;
    }

    public static boolean checkIthBit(int num, int i) {
        // return (num & (1 << i)) != 0;
        return ((num >> i) & 1) != 0;
    }

    public static int setIthBit(int num, int i) {
        return (num | (1 << i));
    }

    public static int clearIthBit(int num, int i) {
        return num & (~(1 << i));
    }

    public static int toggleIthBit(int num, int i) {
        return (num ^ (1 << i));
    }

    public static boolean powOfTwo(int num) {
        // int ctr = 0;
        // while (num > 0) {
        // if ((num & 1) != 0)
        // ctr++;
        // if (ctr > 1)
        // return false;
        // num = num >> 1;
        // }
        // return true;
        return (num & (num - 1)) == 0;
    }

    public static int pow(int num, int exp) {
        // ! Tc --> O(log exp)
        int ans = 1;
        int pow = exp;
        int base = num;
        while (pow > 0) {
            if ((pow & 1) == 1)
                ans *= base;
            base *= base;
            pow >>= 1;
        }
        return ans;
    }

    public static int countSetBits(long num) {
        // int ctr = 0;
        // while (num > 0) {
        // if ((num & 1) == 1)
        // ctr++;
        // num >>= 1;
        // }
        // return ctr;

        int ctr = 0;
        while (num > 0) {
            ctr++;
            num = num & (num - 1);
        }
        return ctr;

    }
}
