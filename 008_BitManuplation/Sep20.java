import java.util.*;

public class Sep20 {
    // ! ============= GEN. Prime Factors of Number =============
    /*
     @ TC --> O(√N) --> for all numbers
     @ SC --> O(prime factors) --> storing all the for Answer so negligible
    */
    public static List<Integer> primeFactorsOptimal2(int num) {
        List<Integer> res = new ArrayList<>();
        for (int i = 2; i * i <= num; i++)
            if (num % i == 0) {
                res.add(i);
                while (num % i == 0)
                    num = num / i;
            }
        if (num > 1)
            res.add(num);
        return res;
    }

    /*
     @ TC --> O(√N) or O(N)  * most of the times(NON PRIME Numbers) it was O(√N) for Larger Prime numbers it was O(N)
     @ SC --> O(prime factors) --> storing all the for Answer so negligible
    */
    public static List<Integer> primeFactorsOptimal(int num) {
        List<Integer> res = new ArrayList<>();
        int i = 2;
        while (i <= num) {
            if (num % i == 0) {
                res.add(i);
                while (num % i == 0)
                    num = num / i;
            }
            i++;
        }
        return res;
    }

    /*
     @ TC --> O(√N) * (O(√N)+O(√N)) --> outer loop is running for O(√N) and inside we are checking isPrime two times so X * (X+X)
     @ SC --> O(prime factors) --> storing all the for Answer so negligible
    */
    public static List<Integer> primeFactorsBetter(int num) {
        List<Integer> res = new ArrayList<>();
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                if (isPrime(i))
                    res.add(i);
                if (i != num / i && isPrime(num / i))
                    res.add(num / i);
            }
            i++;
        }
        return res;
    }

    /*
     @ TC --> O(N)*O(√N)) --> checking is Prime every time for a factor
     @ SC --> O(prime factors) --> storing all the for Answer so negligible
    */
    public static List<Integer> primeFactorsBrute(int num) {
        List<Integer> res = new ArrayList<>();
        for (int i = 2; i <= num; i++)
            if (num % i == 0 && isPrime(i))
                res.add(i);
        return res;
    }

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

    // ! ============= LC762. Prime Number of Set Bits in Binary Representation =============
    /*
     @ TC --> O(N log N) --> outer loop and Inner While loop
     @ SC --> O(1)
    */
    public static int countPrimeSetBits(int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            int bits = 0;
            int num = i;
            while (num > 0) {
                bits += (num & 1);
                num = num >> 1;
            }
            if (bits == 2 || bits == 17 || bits == 5 || bits == 23 ||
                    bits == 3 || bits == 19 || bits == 7 || bits == 29 ||
                    bits == 11 || bits == 31 || bits == 13)
                count++;
        }
        return count;
    }

    /*
     @ TC --> O(N * (O(log N) + O(√N))) --> running all the things inside
     @ SC --> O(1) --> not using any Extra space
    */
    public static int countPrimeSetBitsBrute(int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            int num = i;
            int bits = 0;
            while (num > 0) {
                bits += (num & 1);
                num = num >> 1;
            }
            if (isPrime(bits))
                count++;
        }
        return count;
    }

    /*
     @ TC --> O(√N) --> we are getting factors till Sqrt(N)
     @ SC --> O(1)
    */
    public static boolean isPrime(int num) {
        if (num <= 1)
            return false;
        int i = 2;
        while (i * i <= num) {
            if (num % i == 0)
                return false;
            i++;
        }
        return true;
    }

    /*
     @ TC --> O(√N) --> we are getting factors till Sqrt(N)
     @ SC --> O(1)
    */
    public static void printFactors(int num) {
        int i = 1;
        while (i * i <= num) {
            if (num % i == 0) {
                System.out.println(i);
                if (num / i != i)
                    System.out.println(num / i);
            }
            i++;
        }
    }

    // ! ============= LC397. Integer Replacement =============
    /*
     @ TC --> O(log N) --> Number is get reduced by 2 every time
     @ SC --> O(1)
    */
    public static int integerReplacementBest(int n) {
        int count = 0;
        while (n != 1) {
            if ((n & 1) == 0)
                n = n >> 1;
            else {
                if (n == Integer.MAX_VALUE) {
                    n--;
                    continue;
                }
                if (n == 3 || n % 4 == 1)
                    n--;
                else
                    n++;
            }
            count++;
        }
        return count;
    }

    /*
     @ TC --> O(log N) --> but unnecessary recursion calls
     @ SC --> O(Log N) --> recursive Stack Space ignorable
    */
    public static int integerReplacementBetter(int n) {
        if (n == 1)
            return 0;
        if ((n & 1) == 0) {
            return 1 + integerReplacementBetter(n >> 1);
        }
        if (n == Integer.MAX_VALUE) {
            return integerReplacementBetter(n - 1);
        }
        return 1 + Math.min(
                integerReplacementBetter(n + 1),
                integerReplacementBetter(n - 1));
    }

    /*
     @ TC --> O(log N)
     @ SC --> O(Log N) --> recursive Stack Space ignorable
    */
    public static int integerReplacementBrute(int n) {
        if (n == 1)
            return 0;
        int even = 0;
        int odd = 0;
        if ((n & 1) == 1) {
            int left = Integer.MAX_VALUE;
            if (!(n == Integer.MAX_VALUE)) {
                left = integerReplacementBrute(n + 1);
            }
            int right = integerReplacementBrute(n - 1);
            odd = Math.min(left, right);
        } else
            even = integerReplacementBrute(n >> 1);
        return 1 + even + odd;
    }
}

// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC397. Integer Replacement ✅
// 2. LC762. Prime Number of Set Bits in Binary Representation ✅
// 3. GFG. Largest Prime Factors of Number ✅
// 4. GFG. Prime Factors Powers Sum for Range✅
// 5. GEN. Prime Factors of Number ✅