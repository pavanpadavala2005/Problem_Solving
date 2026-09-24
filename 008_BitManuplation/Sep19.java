
public class Sep19 {

    // ! ============== LC1404. Number of Steps to Reduce a Number in Binary
    // Representation to One =============
    /*
     @ TC --> O(N)
     @ SC --> O(1)
    */
    // * GOOD problem took 2 hrs
    public static int numStepsBetter(String s) {
        int steps = 0;
        int carry = 0;
        for (int i = s.length() - 1; i > 0; i--) {
            int bit = s.charAt(i) - 48 + carry;
            if (bit == 1) {
                steps += 2;
                carry = 1;
            } else
                steps++;
        }
        if (carry == 1)
            steps++;
        return steps;
    }

    /*
     @ TC --> O(N^2) --> two loops
     @ SC --> O(N)
    */
    public static int numStepsBrute(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() != 1) {
            if (sb.charAt(sb.length() - 1) == '0') {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                int carry = 1;
                for (int i = sb.length() - 1; i >= 0; i--) {
                    int digit = sb.charAt(i) - '0';
                    int sum = digit + carry;
                    sb.setCharAt(i, (char) ('0' + sum % 2));
                    carry = sum / 2;
                    if (carry == 0)
                        break;
                }
                if (carry > 0)
                    sb.insert(0, "1");
            }
            count++;
        }
        return count;
    }

    // * Helper Functions for LC1404
    public static void addOne(StringBuilder sb) {
        int carry = 0;
        int i = sb.length() - 1;
        while (i >= 0) {
            int sum = 0;
            if (i == sb.length() - 1)
                sum = sb.charAt(i) - '0' + 1;
            else
                sum = sb.charAt(i) - '0';
            sum += carry;
            carry = sum / 2;
            int digit = sum % 2;
            sb.replace(i, i + 1, "" + (char) ('0' + digit));
            i--;
        }
        if (carry > 0)
            sb.insert(0, "1");
    }

    // * Helper Functions for LC1404
    public static void divideByTwo(StringBuilder sb) {
        for (int i = sb.length() - 1; i >= 0; i--)
            if (i > 0)
                sb.replace(i, i + 1, sb.substring(i - 1, i));
        sb.replace(0, 1, "0");
        System.out.println(sb);
    }

    // ! ============== LC2864. Maximum Odd Binary Number =============
    /*
     @ TC --> O(N + N) -- counting and putting elements
     @ SC --> O(N) --> for returning answer so negligible
    */
    public static String maximumOddBinaryNumber(String s) {
        int count = 0;
        for (char ch : s.toCharArray())
            if (ch == '1')
                count++;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length() - 1; i++) {
            if (count - 1 > 0) {
                sb.append('1');
                count--;
            } else
                sb.append('0');
        }
        sb.append('1');
        return sb.toString();
    }

    // ! ============== LC1342. Number of Steps to Reduce a Number to Zero =============
    /*
     @ TC --> O(log N)
     @ SC --> O(1)
    */
    public int numberOfSteps(int num) {
        int count = 0;
        while (num > 0) {
            if ((num & 1) == 0)
                num = num >> 1;
            else
                num = num - 1;
            count++;
        }
        return count;
    }

    // ! ============== LC477. Total Hamming Distance =============
    /*
     @ TC --> O(32 * O(N)) -->we can say Linear because every time 32*
     @ SC --> O(1)
    */
    public static int totalHammingDistance(int[] nums) {
        int count = 0;
        for (int bit = 0; bit < 32; bit++) {
            int zeros = 0;
            int ones = 0;
            for (int i = 0; i < nums.length; i++) {
                if ((nums[i] & (1 << bit)) != 0)
                    ones++;
                else
                    zeros++;
            }
            count += ones * zeros;
        }
        return count;
    }

    // @ TC --> O( N * N * log N) --> two loops for permutation of 2 and counting
    // difference bits -->O(log N)
    // @ SC --> O(1);
    public static int totalHammingDistanceBrute(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int num = nums[i] ^ nums[j];
                while (num > 0) {
                    count += num & 1;
                    num = num >> 1;
                }
            }
        }
        return count;
    }

    // ! ============== LC231. Power of Two =============
    public static boolean powerOfTwo(int num) {
        return (num > 0) && (num & (num - 1)) == 0;
    }

    // ! ============== LC342. Power of Four =============
    public static boolean powerOfFour(int num) {
        return (num > 0) && (num & (num - 1)) == 0 && (num & 0xAAAAAAAA) == 0;
    }

    // ! ============== GFG. Check Power of 8 =============
    // *https://www.geeksforgeeks.org/problems/check-if-a-integer-is-power-of-8-or-not2537/1
    public static boolean powerOfEight(int num) {
        return (num > 0) && (num & (num - 1)) == 0 && (num & 0x44444444) == 0;
    }
}

// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC477. Total Hamming Distance ✅
// 2. LC1342. Number of Steps to Reduce a Number to Zero ✅
// 3. LC2864. Maximum Odd Binary Number ✅
// 4. LC1404. Number of Steps to Reduce a Number in Binary Representation to ✅
