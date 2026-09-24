import java.util.HashSet;
import java.util.Set;

public class Sep24 {

    // ! ============= LC202. Happy Number =============
    /*
    @ TC --> O(log N) --> using Fast and Slow Pointers
    @ SC --> O(1) --> not using any extra Data structure
    */
    public static boolean isHappyBetter(int n) {
        int slow = n;
        int fast = getNumber(n);
        while (slow != fast) {
            if (slow == 1)
                return true;
            slow = getNumber(slow);
            fast = getNumber(getNumber(fast));
        }
        return slow == 1;
    }

    public static int getNumber(int n) {
        int res = 0;
        while (n > 0) {
            int last = n % 10;
            res += (last * last);
            n = n / 10;
        }
        return res;
    }

    /*
    @ TC --> O(log(N) * log(N)) --> so loop inside another loop so first loop getting reduced and inner loop is also reducing (Approx)
    @ SC --> O(loop) --> we are storing the number from number A(first appearance) to the again A(second appearance) so loop number of elements we are storing 
    */
    public static boolean isHappyBrute(int n) {
        Set<Integer> freq = new HashSet<>();
        while (n > 1) {
            if (freq.contains(n))
                return false;
            freq.add(n);
            System.out.println(n + " " + freq);
            int num = n;
            int sum = 0;
            while (num > 0) {
                int last = num % 10;
                sum += last * last;
                num = num / 10;
            }
            n = sum;
        }
        return n == 1;
    }

    // ! ============= GEN. Euclidean Algorithm for GCD =============
    /*
    @ TC --> O(log(min(X,Y))) --> because every time we are doing Max % Min so we are reducing max by min Times
    @ SC --> O(1)
    */
    public static int euclideanAlgorithmOptimal(int x, int y) {
        while (x > 0 && y > 0) {
            if (x > y)
                x = x % y;
            else
                y = y % x;
        }
        if (x == 0)
            return y;
        return x;
    }

    /*
    @ TC --> O(max(X,Y)) --> because when x = 10000,y=1 so that y need to subtract from x 10000 times
    @ SC --> O(1)
    */
    public static int euclideanAlgorithm(int x, int y) {
        while (x > 0 && y > 0) {
            if (x >= y)
                x = x - y;
            else
                y = y - x;
        }
        if (x == 0)
            return y;
        return x;
    }

    // ! ============= GEN. Finding GCD of Two Numbers =============
    /*
    @ TC --> O(min(X,Y)) --> because at most our loop is running 
    @ SC --> O(1) --> not using extra data structure
    */
    public static int gcdBetter(int x, int y) {
        for (int i = Math.min(x, y); i > 1; i--) {
            if (x % i == 0 && y % i == 0)
                return i;
        }
        return 1;
    }

    /*
    @ TC --> O(min(X,Y)) --> because at most our loop is running 
    @ SC --> O(1) --> not using extra data structure
    */
    public static int gcdBrute(int x, int y) {
        int i = 1;
        int gcd = 1;
        while (i <= x && i <= y) {
            if (x % i == 0 && y % i == 0)
                gcd = i;
            i++;
        }
        return gcd;
    }
}

// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. GEN. Finding GCD of Two Numbers ✅
// 2. GEN. Euclidean Algorithm for GCD ✅
// 3. LC202. Happy Number ✅