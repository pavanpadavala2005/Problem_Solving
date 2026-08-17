import java.util.*;

public class Aug17 {
    // ! =============== LC1021. Remove Outermost Parentheses ================
    public static String removeOuterParenthesesOptimal(String s) {
        // TODO : NEED TO FIX THIS ISSUE --> ()()()()(())
        if (s == null || s.equals(""))
            return "";
        StringBuilder res = new StringBuilder();
        int ctr = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (ctr > 0)
                    res.append('(');
                ctr++;
            } else if (s.charAt(i) == ')') {
                ctr--;
                if (ctr > 0)
                    res.append(')');
            }
        }
        return res.toString();
    }

    public static String removeOuterParenthesesBetter(String s) {
        if (s == null || s.equals(""))
            return "";
        Stack<Character> st = new Stack<>();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (!st.isEmpty())
                    res.append(s.charAt(i));
                st.push(s.charAt(i));
            } else {
                st.pop();
                if (!st.isEmpty())
                    res.append(s.charAt(i));
            }
        }
        return res.toString();
    }

    public static String removeOuterParenthesesBrute(String s) {
        // * Not Working Properly (Bad Approach)
        if (s == null || s.equals(""))
            return "";
        String res = "";
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                st.push(s.charAt(i));
            if (s.charAt(i) == ')') {
                if (st.size() > 1) {
                    res += st.pop();
                    res += s.charAt(i);
                } else
                    st.pop();
            }
            System.out.println(st);
        }
        return res;
    }

    // ! =============== LC796. Rotate String ================
    public static boolean rotateStringOptimal(String s, String goal) {
        if (s.length() != goal.length())
            return false;
        return (s + s).contains(goal);
    }

    public static boolean rotateStringBetter(String s, String goal) {
        if (s.length() != goal.length())
            return false;
        s = s + s;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == goal.charAt(0)) {
                int j = 0;
                int idx = i;
                while (idx < s.length() && j < goal.length()) {
                    if (s.charAt(idx) != goal.charAt(j))
                        break;
                    j++;
                    idx++;
                }
                if (j == goal.length())
                    return true;
            }
        }
        return false;
    }

    public static boolean rotateStringBrute(String s, String goal) {
        // * This is Not working Properly when we have Duplicates
        int n1 = s.length();
        int n2 = goal.length();
        if (n1 != n2)
            return false;
        int idx = 0;
        while (idx < goal.length() && goal.charAt(idx) != s.charAt(0))
            idx++;
        for (int i = 0; i < n1; i++)
            if (s.charAt(i) != goal.charAt(idx++ % n1))
                return false;
        return true;
    }

}