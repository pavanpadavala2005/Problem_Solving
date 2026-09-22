public class Sep22 {
    // ! ============= LC263. Ugly Number =============
    /*
    @ TC --> O(log N) --> we are not checking anything extra than 2,3,5
    @ SC --> O(1) --> not using any Data Structure Extra
    */
    public static boolean isUglyV2(int num) {
        if (num < 0)
            return false;
        while (num % 2 == 0)
            num = num / 2;
        while (num % 3 == 0)
            num = num / 3;
        while (num % 5 == 0)
            num = num / 5;
        return num == 1;
    }

    /*
    @ TC --> O(log N) --> because we are dividing the number by Prime numbers every time 
                          N/2 + N/3 + N/5 + .... N/p   --> n(1/2 + 1/3 + 1/5 + ... + 1/P) 
                          --> sum of primes was a harmonic series was given by O(log(log N))
    @ SC --> O(1) --> not using any Data Structure Extra
    */
    public static boolean isUglyV1(int num) {
        if (num <= 0)
            return false;
        for (int i = 2; i * i <= num; i++) {
            if (i > 5)
                return false;
            if (num % i == 0) {
                while (num % i == 0)
                    num = num / i;
            }
        }
        if (num > 5)
            return false;
        return true;
    }

    // ! ============= GEN. Square Root of Number =============
    /*
    @ TC --> O(log N) + O(P * 10^P) --> we are using Binary Search on Answers so log N
                                        and for calculating precision run loop for P times and every time precision /10 
                                        because first glace D.X --> 0.1, 0.2, 0.3 ... 0.9,1.0 --> 10 Values
                                        next glance D.0X --> 0.01, 0.02, ...... 0.99  --> 100 Values
                                        so 10^P
    @ SC --> O(1) --> not using any extra Data Structure
    */
    public static double sqrtBrute(int num, int p) {
        int l = 0;
        int r = num;
        double res = 0.0;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (mid * mid > num)
                r = mid - 1;
            else if (mid * mid < num)
                l = mid + 1;
            else
                return mid;
        }
        res = r;
        double pre = 0.1;
        for (int i = 0; i < p; i++) {
            while ((res + pre) * (res + pre) < num)
                res += pre;
            pre = pre / 10;
        }
        return res;
    }

    // ! ============= GEN. Sieve of Eratosthenes =============
    /* 
    @ TC --> O(N log(log N)) --> because when i=2 we are marking n/2 elements when i=3 marking n/3
                                like this n/2 + n/3 + .... n/n ==> n(1/2 + 1/3 + 1/5 + 1/7 + ... Nth prime) --> O(log(log N))
                                Math Proof --> https://en.wikipedia.org/wiki/Meissel%E2%80%93Mertens_constant
    @ SC --> O(N)  --> we are using a Tracker to tack is Prime or Not
    */
    public static void sieveOfEratosthenes(int num) {
        boolean[] sieve = new boolean[num + 1];
        for (int i = 2; i * i <= num; i++) {
            if (!sieve[i]) {
                for (int j = i * i; j <= num; j += i)
                    sieve[j] = true;
            }
        }
        for (int i = 2; i <= num; i++)
            if (!sieve[i])
                System.out.println(i);
    }
}
// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. GEN. sieve of eratosthenes ✅
// 2. LC263. Ugly Number ✅