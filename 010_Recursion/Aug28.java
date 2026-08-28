
public class Aug28 {
    // ! =============== LC70. climbStairs ================
    // @ TC --> O(N) --> Using only Loop
    // @ SC --> O(1) --> Using only Variables
    public static int climbStairsItr(int n) {
        if (n < 3)
            return n;
        int prev1 = 1;
        int prev2 = 2;
        for (int i = 3; i <= n; i++) {
            int temp = prev1 + prev2;
            prev1 = prev2;
            prev2 = temp;
        }
        return prev2;
    }

    // @ TC --> This is Recursive Approach will get TLE --> because 2^30 == 10^8
    // @ SC --> Recursive Stack Space
    public static int climbStairsRec(int n) {
        if (n <= 3)
            return n;
        int left = climbStairsRec(n - 1);
        int right = climbStairsRec(n - 2);
        return left + right;
    }

    // ! =============== LC50. Pow(x, n) ================
    // @ TC --> O(log N) --> Every Time / 2
    // @ SC --> O(log N) --> recursive Stack Space

    public static double myPowRec(double x, int n) {
        if (n == 1)
            return x;
        double res = myPowRec(x, n / 2);
        if (n % 2 != 0)
            return x * res * res;
        return res * res;
    }

    // @ TC --> O(N) --> Every Time calling a function until reach Base case
    // @ SC --> O(N) --> Recursive Stack Space
    public static double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return (double) ((1 / x) * myPow(x, n + 1));
        else
            return (double) ((x) * myPow(x, n - 1));
    }

    // @ TC --> O(N) --> Loop
    // @ SC --> O(1)
    public static double myPowBrute(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double res = 1d;
        for (int i = 0; i < n; i++)
            res *= res;
        return res;
    }
}

// Target Min -> 3 , Max -> 5 (Quality Problems Only)
// 1. LC50. Pow(x, n) ✅
// 2. LC70. Climbing Stairs ✅