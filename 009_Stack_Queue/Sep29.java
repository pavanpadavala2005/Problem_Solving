import java.util.*;

public class Sep29 {
    // ! ============= LC150. Evaluate Reverse Polish Notation =============
    /*
    @ TC --> O(N)
    @ SC --> O(N)
    */
    public static int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (isOperator(tokens[i])) {
                int op2 = st.pop();
                int op1 = st.pop();
                st.push(eval(op1, op2, tokens[i]));
            } else
                st.push(Integer.valueOf(tokens[i]));
        }
        return st.pop();
    }

    // * https://www.geeksforgeeks.org/problems/postfix-to-prefix-conversion/1
    // ! ============= GFG. Postfix to Prefix Conversion =============
    /*
    @ TC --> O(N)
    @ SC --> O(N)
    */
    public static String postToPre(String s) {
        Stack<String> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String ch = s.substring(i, i + 1);
            if (isOperator(ch)) {
                String op2 = st.pop();
                String op1 = st.pop();
                st.push(ch + op1 + op2);
            } else
                st.push(ch);
        }
        return st.pop();
    }

    // * https://www.geeksforgeeks.org/problems/prefix-to-postfix-conversion/1
    // ! ============= GFG. Prefix to Postfix Conversion =============
    /*
    @ TC --> O(N)
    @ SC --> O(N)
    */
    public static String preToPost(String s) {
        Stack<String> st = new Stack<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            String ch = s.substring(i, i + 1);
            if (isOperator(ch)) {
                st.push(st.pop() + st.pop() + ch);
            } else
                st.push(ch);
        }
        return st.pop();
    }

    // * https://www.geeksforgeeks.org/problems/prefix-to-infix-conversion/1
    // ! ============= GFG. Prefix Expression to Infix Expression =============
    /*
    @ TC --> O(N) --> using Stack so that TC will be O(N) and Stack Operations O(1) so no need to worry
    @ SC --> O(N) --> Using Stack to Store Final Expression
    */
    public static String preToInfix(String s) {
        Stack<String> st = new Stack<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            String sb = s.substring(i, i + 1);
            if (isOperator(sb))
                st.push("(" + st.pop() + sb + st.pop() + ")");
            else
                st.push(sb);
        }
        return st.pop();
    }

    // * https://www.geeksforgeeks.org/problems/postfix-to-infix-conversion/1
    // ! ============= GFG. Postfix Expression to Infix Expression =============
    /*
    @ TC --> O(N) --> using Stack so that TC will be O(N) and Stack Operations O(1) so no need to worry
    @ SC --> O(N) --> Using Stack to Store Final Expression
    */
    public static String postToInfix(String s) {
        Stack<String> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String sb = s.substring(i, i + 1);
            if (isOperator(sb)) {
                String op1 = st.pop();
                String op2 = st.pop();
                st.push("(" + op2 + sb + op1 + ")");
            } else
                st.push(sb);
        }
        return st.pop();
    }

    // * https://www.geeksforgeeks.org/problems/evaluation-of-postfix-expression1735/1
    // ! ============= GFG. Postfix Expression Evaluation =============
    /*  
    @ TC --> O(N) --> using Stack so that TC will be O(N) and Stack Operations O(1) so no need to worry
    @ SC --> O(N) --> Using Stack to Store operands so it may reach O(N) in worst case
    */
    public static int postfixEvaluation(String[] postfix) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < postfix.length; i++) {
            String ch = postfix[i];
            if (isOperator(ch)) {
                int val1 = st.pop();
                int val2 = st.pop();
                st.push(eval(val2, val1, ch));
            } else
                st.push(Integer.valueOf(ch));
        }
        return st.pop();
    }

    // * https://www.geeksforgeeks.org/problems/prefix-evaluation/1
    // ! ============= GFG. Prefix Expression Evaluation =============
    /*
    @ TC --> O(N) --> using Stack so that TC will be O(N) and Stack Operations O(1) so no need to worry
    @ SC --> O(N) --> Using Stack to Store operands so it may reach O(N) in worst case
    */
    public static int prefixEvaluation(String[] prefix) {
        Stack<Integer> st = new Stack<>();
        for (int i = prefix.length - 1; i >= 0; i--) {
            String ch = prefix[i];
            if (isOperator(ch)) {
                st.push(eval(st.pop(), st.pop(), ch));
            } else
                st.push(Integer.valueOf(ch));
        }
        return st.pop();
    }

    // * ============= Helper Functions =============
    public static int eval(int val1, int val2, String ch) {
        switch (ch) {
            case "+":
                return val1 + val2;
            case "-":
                return val1 - val2;
            case "*":
                return val1 * val2;
            case "/":
                // return Math.floorDiv(val1, val2);
                return val1 / val2;
            case "%":
                return val1 % val2;
            default:
                return (int) Math.pow(val1, val2);
        }
    }

    public static boolean isOperator(String ch) {
        return (ch.equals("+") || ch.equals("-") ||
                ch.equals("*") || ch.equals("%") ||
                ch.equals("^") || ch.equals("/"));
    }
}

// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. GFG. Prefix Expression Evaluation ✅
// 2. GFG. Postfix Expression Evaluation ✅
// 3. GFG. Postfix Expression to Infix Expression ✅
// 4. GFG. Prefix Expression to Infix Expression ✅
// 5. GFG. Prefix to Postfix Conversion ✅
// 6. GFG. Postfix to Prefix Conversion ✅
// 7. LC150. Evaluate Reverse Polish Notation ✅