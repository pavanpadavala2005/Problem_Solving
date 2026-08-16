public class Example1 {

    // ! =============== Unique Element ================
    public static int uniqueElement(int[] arr) {
        int num = 0;
        for (int i = 0; i < arr.length; i++)
            num ^= arr[i];
        return num;
    }

    // ! =============== Check Odd Number ================
    public static boolean isOdd(int num) {
        return (num & 1) == 1;
    }

    // ! =============== Check Ith Bit ================
    public static boolean checkIthBit(int num, int i) {
        // return (num & (1 << i)) != 0;
        return ((num >> i) & 1) != 0;
    }

    // ! =============== Set Ith Bit ================
    public static int setIthBit(int num, int i) {
        return (num | (1 << i));
    }

    // ! =============== Clear Ith Bit ================
    public static int clearIthBit(int num, int i) {
        return num & (~(1 << i));
    }

    // ! =============== Toggle Ith Bit ================
    public static int toggleIthBit(int num, int i) {
        return (num ^ (1 << i));
    }

    // ! =============== Power of Two ================
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

    // ! =============== Power ================
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

    // ! =============== Count Set Bits ================
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