
public class Sep23 {
    // ! ============= LC204. Count Primes =============
    /*  
    @ TC --> O(n log(log (N))) --> here i am using Sieve of Eratosthenes so TC would be log(log N) only but Super fast and efficient one
    @ SC --> O(N+1) --> we are storing state because in multiples of 2 --> 4,6,8,10,12,14,16,18,20, ..
                                                     in multiples of 3 --> 9,12,15, ...
                                                     so 12 and 15 are common so Duplicate State So we need A state to Differentiate
    */
    public static int countPrimes(int n) {
        if (n <= 2)
            return 0;
        boolean[] track = new boolean[n];
        int count = n - 2;
        for (int i = 2; i * i < n; i++) {
            if (track[i] == false) {
                for (int j = i * i; j < n; j += i)
                    if (track[j] == false) {
                        track[j] = true;
                        count--;
                    }
            }
        }
        return count;
    }

    // ! ============= GEN. Power Exponentiation Bit Manipulation =============
    public static int powerExponentiation(int num, int exp) {
        int ans = 1;
        int base = num;
        while (exp > 0) {
            if ((exp & 1) == 1)
                ans = ans * base;
            base = base * base;
            exp = exp >> 1;
        }
        return ans;
    }

    // ! ============= GEN. Newton Raphson Square Root method =============
    /*
    @ TC --> O(log N) --> it would be Complicated Refer -> https://en.wikipedia.org/wiki/Newton%27s_method
                          SUPER FAST for calculating SQRT
    @ SC --> O(1)
    */
    public static double newtonSquareRootBetter(int num) {
        boolean isNeg = num < 0;
        double x = num;
        if (isNeg) {
            x = -x;
            num = -num;
        }
        double error = 0.000000001;
        int count = 0;
        while (true) {
            double root = 0.5 * (x + (num / x));
            if (Math.abs(root - x) < error)
                break;
            x = root;
            count++;
        }
        if (isNeg)
            x = -x;
        System.out.println(count);
        return x;
    }

    /*
    * Both Are Same but Approach is different 
    */
    public static double newtonSquareRootBrute(int num) {
        boolean isNeg = num < 0;
        double error = 0.00001;
        double x = 1.0;
        if (isNeg) {
            x = -x;
            num = -num;
        }
        while (Math.abs((x + (num / x) * 0.5) - x) > error) {
            x = (x + (num / x)) * 0.5;
        }
        if (isNeg)
            x = -x;
        return x;
    }

}
// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. GEN. Power Exponentiation Bit Manipulation ✅
// 2. GEN. Newton Raphson Square Root method ✅
// 3. LC204. Count Primes ✅