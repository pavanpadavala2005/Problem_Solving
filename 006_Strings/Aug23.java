
import java.util.ArrayList;
import java.util.HashMap;

public class Aug23 {
    public static ArrayList<Integer> findSubstringBetter(String s, String[] words) {
        ArrayList<Integer> res = new ArrayList<>();
        if (words.length <= 0)
            return res;
        HashMap<String, Integer> freq1 = new HashMap<>();
        HashMap<String, Integer> freq2 = new HashMap<>();
        for (int i = 0; i < words.length; i++)
            freq1.put(words[i], freq1.getOrDefault(words[i], 0) + 1);
        int len = words[0].length();
        int left = 0, count = 0;
        int window = len * words.length;
        for (int right = len - 1; right < s.length(); right += len) {
            String rightStr = s.substring(right - len + 1, right + 1);
            freq2.put(rightStr, freq2.getOrDefault(rightStr, 0) + 1);
            if (freq1.containsKey(rightStr) && freq2.get(rightStr) <= freq1.get(rightStr))
                count++;
            while (right - left + 1 > window) {
                String leftStr = s.substring(left, left + len);
                freq2.put(leftStr, freq2.get(leftStr) - 1);
                if (freq1.containsKey(leftStr) && freq2.get(leftStr) < freq1.get(leftStr))
                    count--;
                left += len;
            }
            if (count == words.length)
                res.add(left);
        }
        return res;
    }
}

// Target Min -> 3 , Max -> 5 (Quality Problems Only)
// 1. LC76. Minimum Window Substring ✅
// 2. LC30. Substring with Concatenation of All Words ❌
// 3. 1781. Sum of Beauty of All Substrings ✅