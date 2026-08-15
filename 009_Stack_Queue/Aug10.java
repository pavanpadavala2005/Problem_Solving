import java.util.HashMap;
import java.util.Stack;

public class Aug10 {

    public static boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (!st.isEmpty() && st.peek() == map.get(s.charAt(i)))
                st.pop();
            else
                st.push(s.charAt(i));
        }
        return st.isEmpty();
    }
}