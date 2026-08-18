import java.util.HashSet;
import java.util.Stack;

public class Aug18 {

    // ! =============== GFG. Count Substrings with a, b and c =========
    // https://www.geeksforgeeks.org/problems/count-substring/1
    // TODO : SOLVE THIS
    public static int countSubstringBrute(String s) {
        if (s == null || s.length() < 3)
            return 0;
        HashSet<String> subs = new HashSet<>();
        int n = s.length();
        for (int i = 0; i < 1 << n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0)
                    sb.append(s.charAt(j));
            }
            if (haveThree(sb.toString()))
                subs.add(sb.toString());
        }
        System.out.println(subs);
        return subs.size();
    }

    public static boolean haveThree(String s) {
        HashSet<Character> freq = new HashSet<>();
        for (int i = 0; i < s.length(); i++)
            freq.add(s.charAt(i));
        return freq.size() >= 3;

    }

    // ! =============== LC8. String to Integer (atoi) =========
    public static int myAtoiBetter(String s) {
        if (s == null || s.length() == 0)
            return 0;
        s = s.trim();
        if (s.length() == 0)
            return 0;
        int i = 0;
        int sign = 1;

        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+')
            i++;
        long res = 0;
        while (i < s.length() && isDigit(s.charAt(i))) {
            res = res * 10 + (s.charAt(i) - '0');
            if (sign == 1 && res > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (sign == -1 && -res < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            i++;
        }
        return (int) (sign * res);
    }

    public static int myAtoiWaste(String s) {
        // @ this is A Waste Approach But Good try !!
        if (s == null || s.equals(""))
            return 0;
        s = s.trim();
        int i;
        for (i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (isAlphabet(ch) || (i > 0 && ch == '-') || ch == '.')
                return 0;
            else if (ch == '0')
                continue;
            else if (isDigit(ch))
                break;
        }
        long res = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (!isDigit(ch))
                break;
            res = res * 10 + (int) ch - 48;
            i++;
        }
        if (s.charAt(0) == '-')
            res = -res;
        if (res < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        else if (res > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        return (int) res;
    }

    // * ============ HELPER FUNCTION for LC8 ===========
    public static boolean isAlphabet(char ch) {
        // return ((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122));
        return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z');
    }

    public static boolean isDigit(char ch) {
        // return (ch >= 48 && ch <= 57);
        return ch >= '0' && ch <= '9';
    }

    // ! =============== LC1614. Maximum Nesting Depth of the Parentheses =========
    // @ TC --> O(N)
    // @ SC --> O(1)
    public static int maxDepthBetter(String s) {
        if (s == null || s.equals(""))
            return 0;
        int depth = 0;
        int maxDepth = 0;
        for (int i = 0; i < s.length(); i++) {
            char elem = s.charAt(i);
            if (elem == '(')
                depth++;
            else if (elem == ')') {
                maxDepth = Math.max(maxDepth, depth);
                depth--;
            }
        }
        return maxDepth;
    }

    // @ TC --> O(N)
    // @ SC --> O(N)
    public static int maxDepthBrute(String s) {
        if (s == null || s.equals(""))
            return 0;
        int depth = 0;
        int maxDepth = 0;
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char elem = s.charAt(i);
            if (elem == '(') {
                st.push(elem);
                depth++;
            } else if (elem == ')') {
                if (!st.isEmpty() && st.peek() == '(') {
                    maxDepth = Math.max(depth, maxDepth);
                    depth--;
                }
            }
        }
        return maxDepth;
    }

    // ! =============== LC451. Sort Characters By Frequency =========
    public static String frequencySortMoreBetter(String s) {
        // TODO : FIX THE ISSUE of OTHER THAN ALPHABETS
        if (s == null || s.equals(""))
            return "";
        StringBuilder res = new StringBuilder();
        int[] freq = new int[52];
        for (int i = 0; i < s.length(); i++) {
            int asc = s.charAt(i);
            int idx;
            if (asc >= 65 && asc <= 90)
                idx = asc - 65;
            else
                idx = asc - 71;
            freq[idx]++;
        }
        int idx = getMaxIdx(freq);
        while (idx >= 0) {
            for (int i = 0; i < freq[idx]; i++) {
                char ch;
                if (idx >= 0 && idx <= 25)
                    ch = (char) (idx + 65);
                else
                    ch = (char) (idx + 71);
                res.append(ch);
            }
            freq[idx] = 0;
            idx = getMaxIdx(freq);
        }
        return res.toString();

    }

    // @ TC -> O(s) + O(256) + O(count * 256)
    // @ SC -> O(256)
    public static String frequencySortBetter(String s) {
        if (s == null || s.equals(""))
            return "";
        StringBuilder res = new StringBuilder();
        int[] freq = new int[256];
        for (int i = 0; i < s.length(); i++)
            freq[s.charAt(i)]++;
        int idx = getMaxIdx(freq);
        while (idx > 0) {
            for (int i = 0; i < freq[idx]; i++)
                res.append((char) idx);
            freq[idx] = 0;
            idx = getMaxIdx(freq);
        }
        return res.toString();
    }

    // * ============ HELPER FUNCTION for LC451 ===========
    public static int getMaxIdx(int[] nums) {
        int maxIdx = -1;
        int maxVal = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                maxIdx = i;
            }
        }
        return maxIdx;
    }
}