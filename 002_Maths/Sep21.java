public class Sep21 {

    // ! ============= GFG. Largest Prime Factors of Number =============
    /*
    @ TC --> O(√N) --> for all numbers
    @ SC --> O(1)
    */
    public static int largestPrimeFactor(int num) {
        for (int i = 2; i * i <= num; i++) {
            while (num % i == 0) {
                if (num / i == 1)
                    return i;
                num = num / i;
            }
        }
        return num;
    }

    // ! ============= GFG. Prime Factors Powers Sum for Range =============
    /*
    @ TC --> O(√N) --> for all numbers
    @ SC --> O(1)
    */
    public static long sumOfPowers(long a, long b) {
        int count = 0;
        for (long i = a; i <= b; i++) {
            long num = i;
            for (int j = 2; j * j <= num; j++) {
                while (num % j == 0) {
                    count++;
                    num = num / j;
                }
            }
            if (num > 1)
                count++;
        }
        return count;
    }

    // ! ============= GEN. Power Exponentiation =============
    /*
    @ TC --> O(log N) --> every time number getting half so that log N
    @ SC --> O(1)
    */
    public static int powerExponentiationV2(int b, long n) {
        if (n == 0)
            return 1;
        if ((n & 1) == 1)
            return b * powerExponentiationV2(b, n - 1);
        int res = powerExponentiationV2(b, n >> 1);
        return res * res;
    }

    /*
    @ TC -->
    @ SC -->
    */
    public static double powerExponentiationV1(double b, int n) {
        long pow = n;
        if (pow < 0)
            pow = -pow;
        double ans = 1;
        while (pow > 0) {
            if ((pow & 1) == 1) {
                ans = ans * b;
                pow--;
            } else {
                b = b * b;
                pow = pow >> 1;
            }
        }
        if (n < 0)
            ans = 1.0 / ans;
        return ans;
    }
}

// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. GEN. Power Exponentiation ✅
// 2. GFG. Prime Factors Powers Sum for Range ✅
// 3. GFG. Largest Prime Factors of Number ✅