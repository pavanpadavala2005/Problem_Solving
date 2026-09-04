import java.util.*;

public class Sep04 {
    // ! ============== LC216. Combination Sum III =============
    public static List<List<Integer>> combinationSum3(int k, int n) {
        // List<List<Integer>> res = new ArrayList<>();
        // combinationSum3(k, new ArrayList<>(), n, res, new boolean[10]);
        // Set<List<Integer>> res = new HashSet<>();
        // combinationSum3Brute(k, new ArrayList<>(), n, res, new boolean[10]);
        // return new ArrayList<>(res);
        List<List<Integer>> res = new ArrayList<>();
        combinationSum3Optimal(k, 1, new ArrayList<>(), n, res);
        return res;
    }

    // @ TC --> O(9^N) -->
    public static void combinationSum3Optimal(
            int k,
            int num,
            ArrayList<Integer> elems,
            int target,
            List<List<Integer>> res) {

        if (k == 0) {
            if (target == 0)
                res.add(new ArrayList<>(elems));
            return;
        }
        for (int i = num; i <= 9; i++) {
            if (i > target && k <= 0)
                break;
            elems.add(i);
            combinationSum3Optimal(k - 1, i + 1, elems, target - i, res);
            elems.remove(elems.size() - 1);
        }
    }

    public static boolean combinationSum3Brute(int k, ArrayList<Integer> elems, int target, Set<List<Integer>> res,
            boolean[] track) {
        if (elems.size() == k) {
            if (target == 0) {
                List<Integer> result = new ArrayList<>(elems);
                Collections.sort(result);
                res.add(result);
                return true;
            }
            return false;
        }
        for (int i = 1; i < 10; i++) {
            if (!track[i] && i <= target) {
                elems.add(i);
                track[i] = true;
                boolean isFound = combinationSum3Brute(k, elems, target - i, res, track);
                track[i] = false;
                elems.remove(elems.size() - 1);
            }
        }
        return false;
    }

    // ! ⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️ NOT WORKING ⚠️⚠️⚠️⚠️⚠️⚠️⚠️
    public static boolean combinationSum3Testing(int k, ArrayList<Integer> elems, int target, List<List<Integer>> res,
            boolean[] track) {
        if (elems.size() == k) {
            if (target == 0) {
                res.add(new ArrayList<>(elems));
                return true;
            }
            return false;
        }
        for (int i = 1; i < 10; i++) {
            if (!track[i] && i <= target) {
                elems.add(i);
                track[i] = true;
                boolean isFound = combinationSum3Testing(k, elems, target - i, res, track);
                if (!isFound) {
                    track[i] = false;
                }
                elems.remove(elems.size() - 1);
            }
        }
        return false;
    }

    // ! ⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️ NOT WORKING ⚠️⚠️⚠️⚠️⚠️⚠️⚠️
    public static void combinationSum3VeryBrute(int k, ArrayList<Integer> elems, int target, List<List<Integer>> res,
            boolean[] track) {
        if (elems.size() == k) {
            if (target == 0)
                System.out.println(elems);
            return;
        }
        for (int i = 1; i < 10; i++) {
            if (!track[i] && i <= target) {
                elems.add(i);
                track[i] = true;
                combinationSum3VeryBrute(k, elems, target - i, res, track);
                elems.remove(elems.size() - 1);
                track[i] = false;
            }
        }
    }

    // ! ============== GFG. Consecutive 1's not allowed =============
    // * https://www.geeksforgeeks.org/problems/consecutive-1s-not-allowed1912/1
    public static int countStrings(int n) {
        return countStrings(n, new StringBuilder());
    }

    // @ TC --> O(2^N)
    // @ SC --> O(N) -- using a string builder of size N
    public static int countStrings(int n, StringBuilder sb) {
        if (n == 0) {
            System.out.println(sb);
            return 1;
        }
        sb.append('0');
        int right = countStrings(n - 1, sb);
        sb.deleteCharAt(sb.length() - 1);
        int left = 0;
        if (sb.isEmpty() || sb.charAt(sb.length() - 1) != '1') {
            sb.append('1');
            left = countStrings(n - 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        return left + right;
    }

    // ! ============== LC22. Generate Parentheses =============
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateParenthesis(n, 1, 0, new StringBuilder("("));
        return res;
    }

    public static void generateParenthesis(int n, int open, int close, StringBuilder sb) {
        if (open - close < 0)
            return;
        if (open == n && close == n) {
            System.out.println(sb);
            return;
        }
        if (open + 1 <= n) {
            sb.append("(");
            generateParenthesis(n, open + 1, close, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close + 1 <= n) {
            sb.append(")");
            generateParenthesis(n, open, close + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    // ! ============== GFG. Reverse a Stack =============
    // * https://www.geeksforgeeks.org/problems/reverse-a-stack/1

    public static void reverseStack(Stack<Integer> st) {
        System.out.println(st);
        reverseStackHelperBrute(st, new Stack<>());
        System.out.println(st);
    }

    // @ TC --> O(N)*O(N) -->O(N) --> recursion, O(N)--> inner loops
    // @ SC --> O(N) --> using extra space to store stack elements
    public static void reverseStackHelper(Stack<Integer> st, Stack<Integer> temp) {
        if (st.isEmpty())
            return;
        int elem = st.pop();
        reverseStackHelper(st, temp);
        while (!st.isEmpty())
            temp.push(st.pop());
        st.push(elem);
        while (!temp.isEmpty())
            st.push(temp.pop());
    }

    public static void reverseStackHelperBrute(Stack<Integer> st, Stack<Integer> temp) {
        if (st.isEmpty())
            return;
        int elem = st.pop();
        reverseStackHelper(st, temp);
        int size = st.size();
        int[] nums = new int[size];
        for (int i = 0; i < size; i++)
            nums[nums.length - i - 1] = st.pop();
        st.push(elem);
        for (int i = 0; i < nums.length; i++)
            st.push(nums[i]);
    }
}
// ! Target Min -> 3 , Max -> 5 (Quality Problems Only)
// 1. GFG. Reverse a Stack ✅
// 2. LC22. Generate Parentheses ✅
// 3. GFG. Consecutive 1's not allowed ✅ DP -- see in the DP Series
// 4. LC216. Combination Sum III ✅