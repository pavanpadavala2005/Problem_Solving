public class Aug23 {

    // ! =============== Print from 1 --> N ================
    public static void printToN(int n) {
        if (n <= 0)
            return;
        printToN(n - 1);
        System.out.print(n + " ");
    }

    // ! =============== Print from N--> 1 ================
    public static void printTo1(int n) {
        if (n <= 0)
            return;
        System.out.print(n + " ");
        printTo1(n - 1);
    }

    // ! =============== Checking Palindrome ================
    public static boolean isPalindrome(String s, int left, int right) {
        if (left > right)
            return true;
        if (s.charAt(left) != s.charAt(right))
            return false;
        return isPalindrome(s, left + 1, right - 1);
    }

    // ! =============== Factorial ================
    public static int factorial(int n) {
        if (n < 2)
            return 1;
        return n * factorial(n - 1);
    }

    // ! =============== Nth Fibonacci ================
    public static int fib(int n) {
        if (n < 2)
            return n;
        int res = fib(n - 1) + fib(n - 2);
        return res;
    }

}
// Target Min -> 3 , Max -> 5 (Quality Problems Only)
// 1. Print from 1 --> N ✅
// 2. Print from N--> 1 ✅
// 3. Checking Palindrome ✅
// 4. Factorial ✅
// 5. Nth Fibonacci ✅