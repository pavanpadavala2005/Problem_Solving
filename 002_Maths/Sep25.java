public class Sep25 {
    // ! ============= LC172. Factorial Trailing Zeroes =============
    /*
    @ TC --> O(log₅(N)) --> because the number is getting like 5 -> 25 -> 125 -> 625 -> ... multiplication with 5
                            if we do this like f(x) = 625 --> apply log --> log₅(625) --> log₅(5⁴)  --> 4log₅(5) --> 4(1) ==> 5  ,so O(log₅(N))
    @ SC --> O(1) --> not using any Extra Data Structure
    */

    public static int trailingZeroes(int n) {
        int mux = 5;
        int count = 0;
        while (mux <= n) {
            count += n / mux;
            mux = mux * 5;
        }
        return count;
    }

    // ! ============= LC2457. Minimum Addition to Make Integer Beautiful  =============
    /*
    @ TC --> O(log(log N) * log(N)) --> so we are not incrementing 1+1+1+.... like this instead of we are doing 
                            1's*n1 + 10's*n2 + 100's*n3 + .....  so that is O(log N) and at the same time in outer loop reducing the number from 1's to n's 
                            that is O(log N), so one inside another --> O(log(log N)) and finally checking helper function --> O(log N) so finally ==> O(log(log N) * log(N))
    @ SC --> (1) --> not using any Extra Data Structure   
    */

    public static long makeIntegerBeautifulBetter(long num, int target) {
        long inc = 10;
        long count = 0;
        while (helper(num, target)) {
            while (num % inc != 0) {
                num = num + inc / 10;
                count += inc / 10;
            }
            inc *= 10;
        }
        return count;
    }

    /*
    @ TC --> O(N * log(N)) --> incrementing 1 every time --> O(N), Checking helper Function --> O(log N) ==> O(N * log(N))
    @ SC --> (1) --> not using any Extra Data Structure   
    */

    public static long makeIntegerBeautiful(long num, int target) {
        long count = 0;
        while (helper(num, target)) {
            num++;
            count++;
        }
        return count;
    }

    public static boolean helper(long num, int target) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum > target;
    }

    // ! ============= LC326. Power of Three  =============
    public static boolean isPowerOfThreeOptimal(int n) {
        /*
        @ TC --> O(log3(N)) --> Same Like below Code but here we are following a rule that if number is Power of 3 it should divide by 3 and leave a reminder as 1 at last
                                Ex:- 1*3*3*3 = 27       --> can be represented like 1*3*3*3
                                       1*3*3 = 27/3 = 9
                                         1*3 = 9/3  = 3
                                           1 = 3/3  = 1
                                           1 == 1 (Finally)
        @ SC --> O(1) --> not using any Extra Data Structure
        */

        while (n % 3 == 0) {
            n = n / 3;
        }
        return n == 1;
    }

    /*
    @ TC --> O(log3(N)) --> so here we are simulating TRINARY representation in trinary we may get ->(0,1,2) also
                            EX:-(27)₁₀   --> (1000)₃        --> if it had only One return True
                                (33)₁₀   --> (1020)₃        --> if it had 2 in it return False
                                (1111)₁₀ --> (1112011)₃     --> if it had more 1's return False
    @ SC --> O(1) --> not using any Extra Data Structure
    */

    public static boolean isPowerOfThree(int n) {
        if (n <= 0)
            return false;
        int count = 0;
        while (n > 0) {
            int digit = n % 3;
            count += digit;
            if (count > 1)
                return false;
            n = n / 3;
        }
        return true;
    }
}
// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC326. Power of Three ✅
// 2. LC2457. Minimum Addition to Make Integer Beautiful ✅
// 3. LC172. Factorial Trailing Zeroes ✅