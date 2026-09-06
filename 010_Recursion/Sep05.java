import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Sep05 {
    // ! ============== LC17. Letter Combinations of a Phone Number =============
    // @ Works for GFG and LC
    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        HashMap<Character, String> map = new HashMap<>();
        map.put('0', " ");
        map.put('1', " ");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        letterCombinations(map, digits, 0, new StringBuilder(), res);
        return res;
    }

    // @ TC --> O(4^n) --> because every time multiplying and calling recursion
    // @ SC ---> O(10) --> numbers stored in HashMap
    public static void letterCombinations(HashMap<Character, String> map, String s, int i, StringBuilder sb,
            List<String> res) {
        if (i >= s.length()) {
            res.add(sb.toString());
            return;
        }
        if (map.get(s.charAt(i)).equals(" ")) {
            letterCombinations(map, s, i + 1, sb, res);
        } else {
            for (char ch : map.get(s.charAt(i)).toCharArray()) {
                sb.append(ch);
                letterCombinations(map, s, i + 1, sb, res);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

}

// ! Target Min -> 3 , Max -> 5 (Quality Problems Only)
// 1. LC17. Letter Combinations of a Phone Number ✅