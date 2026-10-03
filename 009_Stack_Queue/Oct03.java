import java.util.*;

public class Oct03 {
    // ! ============= LC42. Trapping Rain Water =============
    /*
    @ TC --> O(N)
    @ SC --> O(1)
    */
    public static int trapOptimal(int[] height) {
        int res = 0;
        int i = 0, j = height.length - 1;
        int lMax = 0, rMax = 0;
        while (i < j) {
            if (height[i] <= height[j]) {
                if (lMax > height[i])
                    res += lMax - height[i];
                else
                    lMax = height[i];
                i++;
            } else {
                if (rMax > height[j])
                    res += rMax - height[j];
                else
                    rMax = height[j];
                j--;
            }
        }
        return res;
    }

    /*
    @ TC --> O(N+N) --> two consecutive loops so O(2N)
    @ SC --> O(N+N) --< because using two States to Store the Prefix and Suffix max
    */
    public static int trapBetter(int[] height) {
        int n = height.length;
        int[] preMax = new int[n];
        int[] sufMax = new int[n];
        preMax[0] = height[0];
        sufMax[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            preMax[i] = Math.max(preMax[i - 1], height[i]);
            sufMax[n - i - 1] = Math.max(sufMax[n - i], height[n - i - 1]);
        }
        int res = 0;
        for (int i = 0; i < n; i++)
            res += Math.min(preMax[i], sufMax[i]) - height[i];
        return res;
    }

    /*
    @ TC --> O(N) -> using loop inside another makes O(N) * (0.5N + 0.5N) --> O(N^2)
    @ SC --> O(1)
    */
    public static int trapBrute(int[] height) {
        int res = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int left = Integer.MIN_VALUE;
            int right = Integer.MIN_VALUE;
            for (int l = i - 1; l >= 0; l--)
                left = Math.max(left, height[l]);
            for (int r = i + 1; r < height.length; r++)
                right = Math.max(right, height[r]);
            if (left >= height[i] && right >= height[i])
                res += Math.min(left, right) - height[i];
        }
        return res;
    }

    // * https://www.geeksforgeeks.org/problems/previous-smaller-element/1
    // ! ============= GFG. Previous Smaller Element =============
    /*
    @ TC --> O(N)
    @ SC --> O(N)
    */
    public static ArrayList<Integer> prevSmaller(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        res.add(-1);
        st.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            while (!st.isEmpty() && st.peek() >= arr[i])
                st.pop();
            if (!st.isEmpty())
                res.add(st.peek());
            else
                res.add(-1);
            st.push(arr[i]);
        }
        return res;
    }
}

// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. GFG. Previous Smaller Element ✅
// 2. LC42. Trapping Rain Water ✅