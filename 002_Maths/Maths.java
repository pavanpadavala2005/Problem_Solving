import java.util.*;

public class Maths {
    // ! ============= GEN. Prime Factors of Number =============
    // @ TC --> O(√N) --> for all numbers
    // @ SC --> O(prime factors) --> storing all the for Answer so negligible
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

    // @ TC --> O(√N) or O(N)  * most of the times(NON PRIME Numbers) it was O(√N) for Larger Prime numbers it was O(N)
    // @ SC --> O(prime factors) --> storing all the for Answer so negligible
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

    // @ TC --> O(√N) * (O(√N)+O(√N)) --> outer loop is running for O(√N) and inside we are checking isPrime two times so X * (X+X)
    // @ SC --> O(prime factors) --> storing all the for Answer so negligible
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

    // @ TC --> O(N)*O(√N)) --> checking is Prime every time for a factor
    // @ SC --> O(prime factors) --> storing all the for Answer so negligible
    public static List<Integer> primeFactorsBrute(int num) {
        List<Integer> res = new ArrayList<>();
        for (int i = 2; i <= num; i++)
            if (num % i == 0 && isPrime(i))
                res.add(i);
        return res;
    }

    // ! ============= GEN. Checking Prime Number or Not =============

    // @ TC --> O(√N) --> we are getting factors till Sqrt(N)
    // @ SC --> O(1)
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

    // ! ============= GEN. Printing Factors of a Number =============
    // @ TC --> O(√N) --> we are getting factors till Sqrt(N)
    // @ SC --> O(1)
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
}

// ! Target Min -> 2 , Max -> 5 (Quality Problems Only
// 1. GEN. Printing Factors of a Number ✅
// 2. GEN. Checking Prime Number or Not ✅ 
// 3. GEN. Prime Factors of Number ✅