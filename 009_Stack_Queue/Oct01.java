import java.util.*;

public class Oct01 {
    // ! ============= LC2227. Basic Calculator II =============
    /*
    @ TC --> O(N) --> we are using only one Single For loop so O(N)
    @ SC --> O(1) --> As we are dealing with Prev and Ans so it won't be matter NO STACK here
    */
    public static int calculateIIBetter(String s) {
        int ans = 0;
        int prev = 0;
        char sign = '+';
        int num = 0;
        for (int i = 0; i <= s.length(); i++) {
            char ch = i == s.length() ? '+' : s.charAt(i);
            if (isDigit(ch))
                num = num * 10 + (ch - '0');
            else if (ch != ' ') {
                if (sign == '+') {
                    ans += prev;
                    prev = num;
                } else if (sign == '-') {
                    ans += prev;
                    prev = -num;
                } else if (sign == '/')
                    prev = prev / num;
                else if (sign == '*')
                    prev = prev * num;

                num = 0;
                sign = ch;
            }
        }
        return ans + prev;
    }

    /*
    @ TC --> O(N) --> we are using only one Single For loop so O(N)
    @ SC --> O(N) --> Using a Stack to Store the numbers computes so worst case we may store O(N)
    */
    public static int calculateII(String s) {
        Stack<Integer> st = new Stack<>();
        char sign = '+';
        int num = 0;
        s += "+";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (isDigit(ch))
                num = num * 10 + (ch - '0');
            else if (ch != ' ') {
                if (sign == '+')
                    st.push(num);
                else if (sign == '-')
                    st.push(-num);
                else if (sign == '/')
                    st.push(st.pop() / num);
                else if (sign == '*')
                    st.push(st.pop() * num);
                num = 0;
                sign = ch;
            }
        }
        int sum = 0;
        while (!st.isEmpty())
            sum += st.pop();
        return sum;
    }

    // ! ============= LC224. Basic Calculator =============
    /* 
    @ TC --> O(N) --> 
    @ SC --> O(N) --> Storing data in the stack
    */
    public int calculate(String s) {
        int sign = 1;
        int num = 0;
        int ans = 0;
        Stack<Integer> st = new Stack<>();
        int i = 0;
        int n = s.length();
        while (i < n) {
            char ch = s.charAt(i);
            if (isDigit(ch)) {
                num = num * 10 + (s.charAt(i) - '0');
            } else if (ch == '+') {
                ans = ans + (num * sign);
                sign = 1;
                num = 0;
            } else if (ch == '-') {
                ans = ans + (num * sign);
                sign = -1;
                num = 0;
            } else if (ch == '(') {
                st.push(ans);
                st.push(sign);
                sign = 1;
                ans = 0;
            } else if (ch == ')') {
                ans = ans + (num * sign);
                num = 0;
                int prevSign = st.pop();
                int prevAns = st.pop();
                ans = (ans * prevSign) + prevAns;
                sign = 1;
            }
            i++;
        }
        return ans + (num * sign);
    }

    public static boolean isDigit(char ch) {
        return (ch >= 48 && ch <= 57) && (ch != ' ');
    }
}

// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC224. Basic Calculator ✅
// 2. LC2227. Basic Calculator II ✅