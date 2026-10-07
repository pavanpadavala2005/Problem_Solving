import java.util.Stack;

public class Oct07 {
    // ! ============= LC503. Next Greater Element II =============
    /*
    @ TC --> O(N+N) --> constructing Stack and Processing Stack to get Answer
    @ SC --> O(2N) --> at worst case we may store all the elements in the stack and we are using Array as stack so More Optimized 
    */
    public int[] nextGreaterElementsOptimal(int[] nums) {
        int n = nums.length;
        int[] st = new int[2 * n];
        int idx = -1;
        for (int i = n - 1; i >= 0; i--)
            st[++idx] = nums[i];
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (idx >= 0 && st[idx] <= nums[i])
                idx--;
            if (idx < 0)
                res[i] = -1;
            else
                res[i] = st[idx];
            st[++idx] = nums[i];
        }
        return res;
    }

    /*
    @ TC --> O(N+N) --> constructing Stack and Processing Stack to get Answer
    @ SC --> O(2N) --> at worst case we may store all the elements in the stack
    */
    public int[] nextGreaterElementsBetter(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--)
            st.push(nums[i]);
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums[i])
                st.pop();
            if (st.isEmpty())
                res[i] = -1;
            else
                res[i] = st.peek();
            st.push(nums[i]);
        }
        return res;
    }

    // ! ============= LC1475. Final Prices With a Special Discount in a Shop =============
    /*
    @ TC --> O(N) --> inner while loop is not running for every i
    @ SC --> O(N+N) --> for returning answer O(N) ignorable and Stack -> O(N)
    */
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] res = new int[n];
        int[] st = new int[n];
        int idx = -1;
        for (int i = n - 1; i >= 0; i--) {
            int price = prices[i];
            while (idx >= 0 && st[idx] > price)
                idx--;
            if (idx < 0)
                res[i] = price;
            else
                res[i] = price - st[idx];

            st[++idx] = price;
        }
        return res;
    }

    // ! ============= LC221. Maximal Square =============
    /*
    @ TC --> O(N * (N+N)) --> outer loop + (Histogram construction loop + helper Function)
    @ SC --> O(N + N) --> histogram Arr and stack in Helper function 
    */
    public static int maximalSquare(char[][] matrix) {
        int ans = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[] arr = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                if (matrix[i][j] == '1')
                    arr[j]++;
                else
                    arr[j] = 0;
            ans = Math.max(ans, maximalSquareHelper(arr));
        }
        return ans;
    }

    public static int maximalSquareHelper(int[] nums) {
        int n = nums.length;
        int[] st = new int[n + 1];
        int ptr = -1;
        int res = 0;
        for (int i = 0; i <= n; i++) {
            int val = i < n ? nums[i] : 0;
            while (ptr >= 0 && nums[st[ptr]] > val) {
                int idx = st[ptr--];
                int j = ptr < 0 ? -1 : st[ptr];
                int width = (i - j - 1);
                int side = Math.min(width, nums[idx]);
                res = Math.max(res, side * side);
            }
            st[++ptr] = i;
        }
        return res;
    }
}
// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC221. Maximal Square ✅
// 2. LC1475. Final Prices With a Special Discount in a Shop ✅ 
// 3. LC503. Next Greater Element II ✅