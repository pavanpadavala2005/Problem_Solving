
import java.util.ArrayList;
import java.util.List;

public class Aug24 {
    // ! =============== LC78. Subsets ================
    public static ArrayList<ArrayList<Integer>> printSubSetsFunctional(int[] arr, int i, ArrayList<Integer> res) {
        if (i >= arr.length) {
            return new ArrayList<>(List.of(new ArrayList<>(res)));
        }
        res.add(arr[i]);
        ArrayList<ArrayList<Integer>> left = printSubSetsFunctional(arr, i + 1, res);
        res.removeLast();
        ArrayList<ArrayList<Integer>> right = printSubSetsFunctional(arr, i + 1, res);
        left.addAll(right);
        return left;
    }

    public static void printSubSets(int[] arr, int i, ArrayList<Integer> res) {
        if (i >= arr.length) {
            System.out.println(res);
            return;
        }
        res.add(arr[i]);
        printSubSets(arr, i + 1, res);
        res.removeLast();
        printSubSets(arr, i + 1, res);
    }

    // ! =============== Fibonacci Number ================
    // @ TC --> O(N) --> Calling Recursion N times
    // @ SC --> O(N) --> Using recursion Stack Space only
    public static int nthFibonacciRec(int n) {
        if (n < 2)
            return n;
        return nthFibonacciRec(n - 1) + nthFibonacciRec(n - 2);
    }

    // @ TC --> O(N) -> iterating just in N times
    // @ SC --> O(2) --> O(1) ==> we are not using any extra space other than 2
    public static int nthFibonacci(int n) {
        if (n >= 0 && n < 2)
            return n;
        int[] res = new int[2];
        res[0] = 0;
        res[1] = 1;
        for (int i = 2; i <= n; i++) {
            int next = res[0] + res[1];
            int temp = res[0];
            res[0] = res[1];
            res[1] = temp;
            res[1] = next;
        }
        return res[1];
    }

    // ! =============== Count of Digits ================
    public static int countDigits(int num) {
        if (num < 10)
            return 1;
        return 1 + countDigits(num / 10);
    }

    // ! =============== Sum of Digits ================
    public static int sumOfDigits(int num) {
        if (num < 10)
            return num;
        return num % 10 + sumOfDigits(num / 10);
    }

    // ! =============== Reverse Number ================

    // @ In recursion we are taking extra Stack Space
    public static int reverseNumberMethod3(int num) {
        if (num < 10)
            return num;
        int res = (int) Math.pow(10, (int) Math.log10(num)) * (num % 10);
        return res + reverseNumberMethod3(num / 10);
    }

    public static int reverseNumberMethod2(int num) {
        int rev = 0;
        while (num > 0) {
            // int digits = (int) Math.log10(num);
            rev += ((int) Math.pow(10, (int) Math.log10(num))) * (num % 10);
            num = num / 10;
        }
        return rev;
    }

    public static int reverseNumberMethod1(int num) {
        int rev = num % 10;
        num = num / 10;
        while (num > 0) {
            int last = num % 10;
            rev = rev * 10 + last;
            num /= 10;
        }
        return rev;
    }

    // ! =============== Check Palindrome ================
    public static boolean isPalindromeBetter(String s, int left) {
        if (left > s.length() / 2)
            return true;
        if (s.charAt(left) != s.charAt(s.length() - left - 1))
            return false;
        return isPalindromeBetter(s, left + 1);
    }

    public static boolean isPalindrome(String s, int left, int right) {
        if (left > right)
            return true;
        if (s.charAt(left) != s.charAt(right))
            return false;
        return isPalindrome(s, left + 1, right - 1);
    }

    // ! =============== Reverse Array ================
    // @ Checking with Functional Recursion
    public static int[] reverseArrayFunctional(int[] arr, int left) {
        if (left == arr.length)
            return new int[0];
        int[] res = reverseArrayFunctional(arr, left + 1);
        int[] newArr = new int[res.length + 1];
        for (int i = 0; i < res.length; i++)
            newArr[i] = res[i];
        newArr[newArr.length - 1] = arr[left];
        return newArr;
    }

    // @ Checking with Only One parameter
    public static int[] reverseArray(int[] arr, int left) {
        if (left > arr.length / 2)
            return arr;
        // int temp = arr[left];
        // arr[left] = arr[arr.length - left - 1];
        // arr[arr.length - left - 1] = temp;
        swapArray(arr, left, arr.length - left - 1);
        return reverseArray(arr, left + 1);
    }

    public static void reverseArray(int[] arr, int left, int right) {
        if (left > right)
            return;
        swapArray(arr, left, right);
        reverseArray(arr, left + 1, right - 1);
    }

    // ! =============== Parameterized Recursion ================
    public static void sumOfNumber(int n, int res) {
        if (n <= 0) {
            System.out.println(res);
            return;
        }
        sumOfNumber(n - 1, res + n);
    }

    // ! =============== Functional Recursion ================
    public static int sumOfNumber(int n) {
        if (n <= 0) {
            return n;
        }
        return n + sumOfNumber(n - 1);
    }

    public static void swapArray(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
