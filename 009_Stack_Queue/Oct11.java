
import java.util.HashMap;

public class Oct11 {
    // ! ============= LC20. Valid Parentheses =============
    /*
    @ TC --> O(N) --> Running a Sting Loop
    @ SC --> O(6 + N) --> because We are Storing the Braces, and in Stack We may Store All Characters In String
    */
    public static boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');
        int n = s.length();
        char[] st = new char[n];
        int ptr = -1;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                if (ptr < 0 || st[ptr] != map.get(ch))
                    return false;
                else
                    ptr--;
            } else {
                st[++ptr] = ch;
            }
        }
        return ptr == -1;

    }

    // ! ============= LC1544. Make The String Great =============
    /*
    @ TC --> O(N) 
    @ SC --> O(N) for returning answer so negligible
    */
    public static String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!sb.isEmpty() && Math.abs(ch - sb.charAt(sb.length() - 1)) == 32)
                sb.setLength(sb.length() - 1);
            else
                sb.append(ch);
        }
        return sb.toString();
    }

}
// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC1544. Make The String Great ✅  
// 2. LC20. Valid Parentheses ✅