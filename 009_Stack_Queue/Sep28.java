import java.util.*;

public class Sep28 {
    // * https://www.geeksforgeeks.org/problems/infix-to-prefix-notation/1
    // ! ============= GFG. Infix to PreFix Notation =============
    /*
    @ TC --> O(N) --> because the inner while loops are not running for every i value
    @ SC --> O(N) --> for returning answer so ignorable
    */
    public static String infixToPrefix(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == ' ')
                continue;
            if (isOperand(ch))
                sb.append(ch);
            else if (ch == ')')
                st.push(ch);
            else if (ch == '(') {
                while (!st.isEmpty() && st.peek() != ')')
                    sb.append(st.pop());
                if (!st.isEmpty())
                    st.pop();
            } else {
                while (!st.isEmpty() && st.peek() != ')' && (getPrecedence(st.peek()) > getPrecedence(ch)
                        || getPrecedence(st.peek()) == getPrecedence(ch) && ch == '^'))
                    sb.append(st.pop());
                st.push(ch);
            }
        }
        while (!st.isEmpty())
            sb.append(st.pop());
        return sb.reverse().toString();
    }

    // ! ============= GFG.Infix to PostFix Notation =============
    // *https://www.geeksforgeeks.org/problems/infix-to-postfix-1587115620/1
    /*
    @ TC --> O(N) --> because the inner while loops are not running for every i value
    @ SC --> O(N) --> for returning answer so ignorable
    */
    public static String infixToPostFix(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ')
                continue;
            if (isOperand(ch))
                sb.append(ch);
            else if (ch == '(')
                st.push(ch);
            else if (ch == ')') {
                while (!st.isEmpty() && st.peek() != '(')
                    sb.append(st.pop());
                if (!st.isEmpty())
                    st.pop();
            } else {
                // * Checking for Operator Precedence  
                while (!st.isEmpty()
                        && st.peek() != '('
                        && (getPrecedence(st.peek()) > getPrecedence(ch)
                                || (getPrecedence(st.peek()) == getPrecedence(ch) && ch != '^')
                        // 
                        ))
                    sb.append(st.pop());
                st.push(ch);
            }
        }
        while (!st.isEmpty())
            sb.append(st.pop());
        return sb.toString();
    }

    public static boolean isOperand(char ch) {
        return (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z' || ch >= '0' && ch <= '9');
    }

    public static int getPrecedence(char ch) {
        if (ch == '^')
            return 4;
        else if (ch == '/' || ch == '*' || ch == '%')
            return 3;
        else if (ch == '+' || ch == '-')
            return 2;
        return 1;
    }
}
// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. GFG.Infix to PostFix Notation ✅
// 2. GFG. Infix to PreFix Notation ✅