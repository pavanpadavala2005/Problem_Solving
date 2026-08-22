
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Aug22 {
    // ! ============ LC1781. Sum of Beauty of All Substrings ==============
    public static int beautySumBrute(String s) {
        if (s.length() == 1)
            return 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++)
            for (int j = i; j < s.length(); j++) {
                int beauty = calcBeauty(s, i, j);
                if (beauty > 0)
                    count += beauty;
            }
        return count;
    }

    public static int calcBeauty(String s, int left, int right) {
        int[] arr = new int[26];
        for (int i = left; i <= right; i++)
            arr[s.charAt(i) - 'a']++;
        int mx = Integer.MIN_VALUE, mi = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            mx = Math.max(mx, arr[i]);
            if (arr[i] > 0)
                mi = Math.min(mi, arr[i]);
        }
        if (mx == Integer.MIN_VALUE || mi == Integer.MAX_VALUE)
            return 0;
        return mx - mi;
    }

    // ! ============ LC30. Substring with Concatenation of All Words ==============
    public static List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> res = new ArrayList<>();
        if (words.length <= 0)
            return res;
        int i = 0;
        int j = words.length * words[0].length() - 1;
        int incr = words[0].length();
        while (j < s.length()) {
            System.out.println(s.substring(i, j + 1));
            if (findSubstringHelper(s.substring(i, j + 1), words))
                res.add(i);
            j += incr;
            i += incr;
        }
        return res;
    }

    public static boolean findSubstringHelper(String s, String[] words) {
        int frame = words[0].length();
        for (int i = 0; i < s.length(); i += frame) {
            boolean isFound = false;
            for (int j = 0; j < words.length; j++)
                if (s.substring(i, i + frame).equals(words[j]))
                    isFound = true;
            if (!isFound)
                return false;
        }
        return true;
    }

    // ! ============ LC76. Minimum Window Substring ==============
    // @ TC --> O(S) * O(S) --> in worst case while loop may be runs for O(S) times
    // RARE
    // @ SC --> O(128) --> we are using an Array fixed size --> O(1) ultimately
    public static String minWindowSuperOptimal(String s, String t) {
        if (s.length() < t.length())
            return "";
        int[] freq = new int[128];
        for (int i = 0; i < t.length(); i++)
            freq[t.charAt(i)]++;
        int left = 0, count = 0;
        int st = -1, ed = -1;
        for (int right = 0; right < s.length(); right++) {
            char rightCh = s.charAt(right);
            freq[rightCh]--;
            if (freq[rightCh] >= 0)
                count++;
            while (count == t.length()) {
                if (st == -1 || right - left + 1 < ed - st + 1) {
                    st = left;
                    ed = right;
                }
                char leftCh = s.charAt(left);
                freq[leftCh]++;
                if (freq[leftCh] > 0)
                    count--;
                left++;
            }
        }
        if (st == -1)
            return "";
        return s.substring(st, ed + 1);
    }

    // @ TC --> O(S) * O(S) --> in worst case while loop may be runs for O(S) times
    // RARE
    // @ SC --> O(S) --> it is atchually O(T) but in worst case we may be store all
    // Chars of S
    public static String minWindowOptimal(String s, String t) {
        if (s.length() < t.length())
            return "";
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++)
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        int left = 0, count = 0;
        int st = -1, ed = -1;
        for (int right = 0; right < s.length(); right++) {
            char rightCh = s.charAt(right);
            tMap.put(rightCh, tMap.getOrDefault(rightCh, 0) - 1);
            if (tMap.get(rightCh) >= 0)
                count++;
            while (count >= t.length()) {
                if (st == -1 || right - left + 1 < ed - st + 1) {
                    st = left;
                    ed = right;
                }
                char leftCh = s.charAt(left);
                tMap.put(leftCh, tMap.get(leftCh) + 1);
                if (tMap.get(leftCh) > 0)
                    count--;
                left++;
            }
        }
        return s.substring(st, ed + 1);
    }

    // @ TC --> O(S) * O(S) --> in worst case while loop may be runs for O(S) times
    // RARE
    // @ SC --> O(T) + O(S) + O(subString) --> in worst case we may be store all
    // chars of S in freqMap
    public static String minWindowBetter(String s, String t) {
        if (s.length() < t.length())
            return "";
        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++)
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        String res = "";
        int left = 0, count = 0;
        for (int right = 0; right < s.length(); right++) {
            char rightCh = s.charAt(right);
            sMap.put(rightCh, sMap.getOrDefault(rightCh, 0) + 1);
            if (tMap.containsKey(rightCh) && sMap.get(rightCh) <= tMap.get(rightCh))
                count++;
            while (count >= t.length()) {
                if (res.equals("") || right - left + 1 < res.length())
                    res = s.substring(left, right + 1);
                char leftCh = s.charAt(left);
                sMap.put(leftCh, sMap.get(leftCh) - 1);
                if (tMap.containsKey(leftCh) && sMap.get(leftCh) < tMap.get(leftCh))
                    count--;
                left++;
            }
        }
        return res;
    }

    // @ TC --> O(S^2) * O(T) --> every time we are checking that Math or not
    // @ SC --> O(T) + O(S) --> may be in the worst case we will store all chars in
    // String
    public static String minWindowVeryBrute(String s, String t) {
        if (s.length() < t.length())
            return "";
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++)
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            HashMap<Character, Integer> sMap = new HashMap<>();
            for (int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);
                sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
                if (minWindowHelper(sMap, tMap)) {
                    String sub = s.substring(i, j + 1);
                    if (res.equals("") || sub.length() < res.length())
                        res = sub;
                }
            }
        }
        return res;
    }

    public static boolean minWindowHelper(HashMap<Character, Integer> sMap, HashMap<Character, Integer> tMap) {
        for (char ch : tMap.keySet())
            if (!sMap.containsKey(ch) || sMap.get(ch) < tMap.get(ch))
                return false;
        return true;
    }
}

// Target Min -> 3 , Max -> 5 (Quality Problems Only)
// 1. LC76. Minimum Window Substring ✅
// 2. 30. Substring with Concatenation of All Words ❌
// 3. 1781. Sum of Beauty of All Substrings