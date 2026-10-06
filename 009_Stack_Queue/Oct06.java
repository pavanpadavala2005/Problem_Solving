import java.util.Stack;

public class Oct06 {
    // ! ============= LC85. Maximal Rectangle =============
    public static int maximalRectangle(char[][] matrix) {
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
            ans = Math.max(ans, largestRectangleAreaOptimalV2(arr));
        }
        return ans;
    }

    // ! ============= LC84. Largest Rectangle in Histogram =============
    /*
    @ TC --> O(2N) --> inner loop is not running for every i
    @ SC --> O(N) --> in worst case we store all elements in Array that is Fixed so O(1) 
    */
    public static int largestRectangleAreaOptimalV2(int[] heights) {
        int n = heights.length;
        int[] st = new int[n + 1];
        int ptr = -1;
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            int elem = i < n ? heights[i] : 0;
            while (ptr >= 0 && heights[st[ptr]] > elem) {
                int idx = st[ptr--];
                int j = ptr < 0 ? -1 : st[ptr];
                ans = Math.max(heights[idx] * (i - j - 1), ans);
            }
            st[++ptr] = i;
        }
        return ans;
    }

    /*
    @ TC --> O(2N) --> inner loop is not running for every i
    @ SC --> O(N) --> in worst case we store all elements in Stack 
    */
    public static int largestRectangleAreaOptimalV1(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            int elem = i < n ? heights[i] : 0;
            while (st.peek() != -1 && heights[st.peek()] > elem) {
                int idx = st.pop();
                int j = st.peek();
                ans = Math.max(heights[idx] * (i - j - 1), ans);
            }
            st.push(i);
        }
        return ans;
    }

    /*
    @ TC --> O(2N + 2N + N) --> for computing prev and next and answer
    @ SC --> O(2N) --> storing prev and next
    */
    public static int largestRectangleAreaBetter(int[] heights) {
        int n = heights.length;
        int[] prev = new int[n];
        int[] next = new int[n];
        for (int i = 0; i < n; i++) {
            int temp = i - 1;
            while (temp >= 0 && heights[temp] >= heights[i])
                temp--;
            prev[i] = i - temp - 1;
        }
        for (int i = n - 1; i >= 0; i--) {
            int temp = i + 1;
            while (temp < n && heights[temp] >= heights[i])
                temp++;
            prev[i] = temp - i - 1;
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
            ans = Math.max((prev[i] + next[i] + 1) * heights[i], ans);
        return ans;
    }

    /*
    @ TC --> O(N^2) --> running outer loop and inner loop for every i
    @ SC --> O(1) --> not using any Extra Data Structure
    */
    public static int largestRectangleAreaBrute(int[] heights) {
        int ans = Integer.MIN_VALUE;
        int n = heights.length;
        for (int i = 0; i < n; i++) {
            int left = 0;
            int j = i - 1;
            while (j >= 0 && heights[j] >= heights[i]) {
                left++;
                j--;
            }
            int right = 0;
            int k = i + 1;
            while (k < n && heights[k] >= heights[i]) {
                right++;
                k++;
            }
            ans = Math.max(ans, (left + right + 1) * heights[i]);
        }
        return ans;
    }
}
// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC84. Largest Rectangle in Histogram ✅
// 2. LC85. Maximal Rectangle ✅
