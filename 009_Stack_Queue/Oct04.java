import java.util.*;

public class Oct04 {

    // ! ============= LC735. Asteroid Collision =============
    /*
    @ TC --> O(N)
    @ SC --> O(N)
    */
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0)
                st.push(asteroids[i]);
            else {
                while (!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(asteroids[i]))
                    st.pop();
                if (st.isEmpty() || st.peek() < Math.abs(asteroids[i]))
                    st.push(asteroids[i]);
                else if (!st.isEmpty() && st.peek() - asteroids[i] == 0)
                    st.pop();
            }
        }
        int i = st.size() - 1;
        int[] res = new int[st.size()];
        while (!st.isEmpty())
            res[i--] = st.pop();
        return res;
    }

    // ! ============= LC907. Sum of Subarray Minimums =============
    public static int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] leftArr = new int[n];
        int[] rightArr = new int[n];
        Stack<int[]> leftStack = new Stack<>();
        Stack<int[]> rightStack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int count = 1;
            while (!leftStack.isEmpty() && leftStack.peek()[0] > arr[i])
                count += leftStack.pop()[1];
            leftStack.push(new int[] { arr[i], count });
            leftArr[i] = count;
        }
        for (int i = n - 1; i >= 0; i--) {
            int count = 1;
            while (!rightStack.isEmpty() && rightStack.peek()[0] >= arr[i])
                count += rightStack.pop()[1];
            rightStack.push(new int[] { arr[i], count });
            rightArr[i] = count;
        }
        long sum = 0;
        long MOD = 1_000_000_007;
        for (int i = 0; i < n; i++) {
            sum = (sum + ((long) leftArr[i] * rightArr[i] * arr[i]) % MOD) % MOD;
        }
        return (int) sum;
    }

    /*
    @ TC --> (N^2) --> running two for loops so that O(n^2)
    @ SC --> O(1) --> not using any Extra Data Structure 
    */
    public static int sumSubarrayMinsBetter(int[] arr) {
        int n = arr.length;
        int sum = 0;
        int MOD = 1_000_000_007;
        for (int i = 0; i < n; i++) {
            int left = i;
            int right = i;
            while (left >= 0 && arr[left] >= arr[i])
                left--;
            while (right < n && arr[right] >= arr[i])
                right++;
            System.out.println(left + " " + right);
            sum = (sum + ((i - left) * (right - i) * arr[i])) % MOD;
        }
        return sum;
    }
    /*
    @ TC --> (N^2) --> running two for loops so that O(n^2)
    @ SC --> O(1) --> not using any Extra Data Structure 
    */

    public static int sumSubarrayMinsBrute(int[] arr) {
        int sum = 0;
        int MOD = 1_000_000_007;
        for (int i = 0; i < arr.length; i++) {
            int minVal = Integer.MAX_VALUE;
            for (int j = i; j < arr.length; j++) {
                minVal = Math.min(minVal, arr[j]);
                sum = (sum + minVal) % MOD;
            }
        }
        return sum;
    }
}

// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC907. Sum of Subarray Minimums ✅
// 2. LC735. Asteroid Collision ✅