
public class Sep12 {
    // ! =============== LC.191. Number of 1 Bits ================
    public static int hammingWeight(int n) {
        int count = 0;
        while (n > 0) {
            count += (n & 1);
            n = n >> 1;
        }
        return count;
    }

    // ! =============== Convert form Integer to Any Base till 36 ================
    // @ We can do only till Base 36 Numbers
    public static String intToBase(int num, int base) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            char last;
            if (base < 10)
                last = (char) (48 + num % base);
            else {
                int dig = num % base;
                System.out.println(dig);
                if (dig < 10)
                    last = (char) ('0' + dig);
                else
                    last = (char) ('A' + dig - 10);
            }
            sb.insert(0, last);
            num = num / base;
        }
        return sb.toString();
    }

    // ! =============== Convert from Any Base till 36 to Integer ================
    // @ We can Only Convert the numbers Till Base 36
    public static int baseToInt(String num, int base) {
        int res = 0;
        int mux = 1;
        for (int i = num.length() - 1; i >= 0; i--) {
            char ch = num.charAt(i);
            if (ch != '0') {
                if (ch >= 'A' && ch <= 'Z')
                    res += mux * (ch - 'A' + 10);
                else
                    res += mux * (ch - '0');
            }
            mux *= base;
        }
        return res;
    }

    // ! =============== Integer to Binary ================
    public static String intToBin(int num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int rem = num % 2;
            sb.insert(0, (char) ('0' + rem));
            num = num / 2;
        }
        return sb.toString();
    }

    // ! =============== Binary to Integer ================
    public static int binToInt(String bin) {
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

// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC.191. Number of 1 Bits ✅