import java.util.Stack;

public class Oct05 {

    // ! ============= LC901. Online Stock Span =============
    /*
    @ TC --> O(N) --> in worst case
    @ SC --> O(10000) --> because there are max 10^4 Calls so the stack should never exceed 10^5
    */
    class StockSpanner {
        int[] st;
        int i;

        public StockSpanner() {
            this.st = new int[10000];
            this.i = 0;
        }

        public int next(int price) {
            int count = 1;
            int idx = this.i;
            while (idx > 0 && st[idx - 1] <= price) {
                count++;
                idx--;
            }
            st[this.i++] = price;
            return count;
        }
    }

    // ! ============= LC739. Daily Temperatures =============
    /*
    @ TC --> O(N) --> 
    @ SC --> O(N+N) --> and that first N is for returning answer so ignorable 
    */
    public int[] dailyTemperaturesOptimal(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        int[] st = new int[n];
        int top = -1;
        for (int i = n - 1; i >= 0; i--) {
            while (top >= 0 && temperatures[st[top]] <= temperatures[i])
                st[top--] = 0;
            if (top >= 0)
                res[i] = st[top] - i;
            else
                res[i] = 0;
            st[++top] = i;
        }
        return res;
    }

    /*
    @ TC --> O(N) --> the inner while loop not running for every i
    @ SC --> O(N + N) --> Storing in Stack and Answer also 
    */
    public int[] dailyTemperaturesBetter(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && temperatures[st.peek()] <= temperatures[i])
                st.pop();
            if (st.isEmpty())
                res[i] = 0;
            else
                res[i] = st.peek() - i;
            st.push(i);
        }
        return res;
    }

    // ! ============= LC2104. Sum of Subarray Ranges =============
    /*
    @ TC --> O(2N) --> calculating the MAX and MIN 
    @ SC --> O(N) --> using single stack for two operations
    */
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long sum = 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        for (int i = 0; i <= n; i++) {
            int val = i < n ? nums[i] : Integer.MAX_VALUE;
            while (st.peek() != -1 && val > nums[st.peek()]) {
                int idx = st.pop();
                int j = st.peek();
                sum += ((long) (i - idx) * (idx - j) * nums[idx]);
            }
            st.push(i);
        }

        st.clear();
        st.push(-1);

        for (int i = 0; i <= n; i++) {
            int val = i < n ? nums[i] : Integer.MIN_VALUE;
            while (st.peek() != -1 && val < nums[st.peek()]) {
                int idx = st.pop();
                int j = st.peek();
                sum -= ((long) (i - idx) * (idx - j) * nums[idx]);
            }
            st.push(i);
        }
        return sum;
    }

    // * https://www.geeksforgeeks.org/problems/sum-of-max-of-subarrays/1
    // ! ============= GFG. Sum of Max of Subarrays =============
    /*
    @ TC --> O(N) --> at max the inner loop will run only once not for every i so O(N)
    @ SC --> O(N) --> We Only Using a Stack to Store all the elements 
    */
    public int sumOfMax(int[] arr) {
        int ans = 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int n = arr.length;
        for (int i = 0; i <= n; i++) {
            int val = i < n ? arr[i] : Integer.MAX_VALUE;
            while (st.peek() != -1 && val > arr[st.peek()]) {
                int idx = st.pop();
                int j = st.peek();
                ans += ((idx - j) * (i - idx) * arr[idx]);
            }
            st.push(i);
        }
        return ans;
    }

    // ! ============= LC402. Remove K Digits =============
    /*
    @ TC --> O(N) --> inner while loop is not running for Every i so O(N)
    @ SC --> O(N) --> for returning Answer so Ignorable
    */
    public static String removeKdigitsBetter(String num, int k) {
        int n = num.length();
        if (n == k)
            return "0";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char ch = num.charAt(i);
            while (!sb.isEmpty() && k > 0 && sb.charAt(sb.length() - 1) > ch) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            if (sb.isEmpty() && ch == '0')
                continue;
            sb.append(ch);
        }
        while (!sb.isEmpty() && k > 0) {
            sb.deleteCharAt(sb.length() - 1);
            k--;
        }
        if (sb.isEmpty())
            return "0";
        return sb.toString();
    }

    public static String removeKdigits(String num, int k) {
        int n = num.length();
        Stack<Character> st = new Stack<>();
        int i = 0;
        while (i < n && k > 0) {
            while (!st.isEmpty() && st.peek() > num.charAt(i)) {
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
            i++;
        }
        System.out.println(st + " " + i);
        return " ";
    }
}

// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. GFG. Sum of Max of Subarrays ✅
// 2. Remove K Digits ✅
// 3. LC2104. Sum of Subarray Ranges ✅
// 4. LC739. Daily Temperatures ✅
// 5. LC901. Online Stock Span ✅