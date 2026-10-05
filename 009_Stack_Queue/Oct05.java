import java.util.Stack;

public class Oct05 {
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
    public static String removeKdigitsBetter(String num, int k) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        int n = num.length();
        while (i < n && k > 0) {
            char ch = num.charAt(i);
            if (!sb.isEmpty() && sb.charAt(sb.length() - 1) > ch) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            i++;
            if (sb.isEmpty() && ch == '0')
                continue;
            sb.append(ch);
        }
        while (i < n)
            sb.append(num.charAt(i++));
        if (sb.isEmpty())
            sb.append('0');
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