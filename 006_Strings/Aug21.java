import java.util.HashMap;
import java.util.HashSet;

public class Aug21 {

    // ! ============ LC567. Permutation in String ==============
    // @ TC --> O(N) --> We are using only one For Loop and Pointers
    // @ SC --> O(M) or O(N) --> because in worst case we will be storing all the
    // characters in it
    public static boolean checkInclusionOptimal(String s1, String s2) {
        if (s2.length() < s1.length())
            return false;
        HashMap<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < s1.length(); i++)
            freq.put(s1.charAt(i), freq.getOrDefault(s1.charAt(i), 0) + 1);
        int left = 0, count = 0;
        for (int right = 0; right < s2.length(); right++) {
            char rightCh = s2.charAt(right);
            freq.put(rightCh, freq.getOrDefault(rightCh, 0) - 1);
            if (freq.get(rightCh) >= 0)
                count++;
            if (right - left + 1 > s1.length()) {
                char leftCh = s2.charAt(left);
                freq.put(leftCh, freq.get(leftCh) + 1);
                if (freq.get(leftCh) > 0)
                    count--;
                left++;
            }
            if (right - left + 1 == s1.length() && count == s1.length())
                return true;
        }
        return false;
    }
    // @ TC --> O(N) --> Only one For loop
    // @ SC --> O(M)+O(N) --> in worst case M == N we are storing O(2N)

    public static boolean checkInclusionBetterV2(String s1, String s2) {
        if (s2.length() < s1.length())
            return false;
        HashMap<Character, Integer> freq1 = new HashMap<>();
        HashMap<Character, Integer> freq2 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++)
            freq1.put(s1.charAt(i), freq1.getOrDefault(s1.charAt(i), 0) + 1);
        int left = 0, count = 0;
        for (int right = 0; right < s2.length(); right++) {
            char rightCh = s2.charAt(right);
            freq2.put(rightCh, freq2.getOrDefault(rightCh, 0) + 1);
            if (freq1.containsKey(rightCh) && freq2.get(rightCh) <= freq1.get(rightCh))
                count++;
            if (right - left + 1 > s1.length()) // ! Look Here in V1 We are using Loop and here we are using a If
            // ! statement so what happens is that when length is greater "right"
            // ! stops and "left" pointer shrinks every time so "left++" and
            // !"right++" at the same time so TC --> O(N)
            // ! at the same time when length is greater we are running only One for
            // ! Loop But in V1 we are stopping at "right" at one place and
            // ! shrinking "left" until we met Size
            {
                char leftCh = s2.charAt(left);
                freq2.put(leftCh, freq2.get(leftCh) - 1);
                if (freq1.containsKey(leftCh) && freq2.get(leftCh) < freq1.get(leftCh))
                    count--;
                left++;
            }
            if (right - left + 1 == s1.length() && count == s1.length())
                return true;
        }
        return false;
    }

    // @ TC --> O(N)+O(N) --> using nested loop inner while loop running for once
    // for every i
    // @ SC --> O(M)+O(N) --> in worst case M == N we are storing O(2N)
    public static boolean checkInclusionBetterV1(String s1, String s2) {
        if (s2.length() < s1.length())
            return false;
        HashMap<Character, Integer> freq1 = new HashMap<>();
        HashMap<Character, Integer> freq2 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++)
            freq1.put(s1.charAt(i), freq1.getOrDefault(s1.charAt(i), 0) + 1);
        int left = 0, count = 0;
        for (int right = 0; right < s2.length(); right++) {
            char rightCh = s2.charAt(right);
            freq2.put(rightCh, freq2.getOrDefault(rightCh, 0) + 1);
            if (freq1.containsKey(rightCh) && freq2.get(rightCh) <= freq1.get(rightCh))
                count++;
            while (right - left + 1 > s1.length()) {
                char leftCh = s2.charAt(left);
                freq2.put(leftCh, freq2.get(leftCh) - 1);
                if (freq1.containsKey(leftCh) && freq2.get(leftCh) < freq1.get(leftCh))
                    count--;
                left++;
            }
            if (right - left + 1 == s1.length() && count == s1.length())
                return true;
        }
        return false;
    }

    public static boolean checkInclusionBrute(String s1, String s2) {
        if (s2.length() < s1.length())
            return false;
        int i = 0, j = s1.length() - 1;
        while (j < s2.length()) {
            if (isValid(s2.substring(i, j + 1), s1))
                return true;
            i++;
            j++;
        }
        return false;
    }

    public static boolean isValid(String s1, String s2) {
        if (s1.length() < s2.length())
            return false;
        int[] res = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            res[s1.charAt(i) - 'a']++;
            res[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++)
            if (res[i] != 0)
                return false;
        return true;
    }

    // ! ============ GFG. Longest Substring with K Uniques ==============
    // @ TC --> O(N) + O(N) --> We are running While loop once i stop so O(2N)
    // @ SC --> O(N) --> We are Using HashMap to store chars(if all Unique --> O(N))
    public static int longestKSubstrBetter(String s, int k) {
        int maxLen = -1;
        int ctr = 0;
        int j = 0;
        HashMap<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char rightCh = s.charAt(i);
            if (!freq.containsKey(rightCh)) {
                freq.put(rightCh, 1);
                ctr++;
            } else
                freq.put(rightCh, freq.get(rightCh) + 1);
            while (ctr > k) {
                char leftCh = s.charAt(j);
                freq.put(leftCh, freq.get(leftCh) - 1);
                if (freq.get(leftCh) <= 0) {
                    freq.remove(leftCh);
                    ctr--;
                }
                j++;
            }
            if (ctr == k)
                maxLen = Math.max(maxLen, i - j + 1);
        }
        return maxLen;
    }

    // @ TC --> O(N^2)*O(N) --> for checking num of characters
    // @ SC --> O(N) --> for storing num of characters
    public static int longestKSubstrBrute(String s, int k) {
        int maxLen = -1;
        for (int i = 0; i < s.length(); i++)
            for (int j = i; j < s.length(); j++)
                if (hasKElements(s, i, j, k))
                    maxLen = Math.max(j - i + 1, maxLen);
        return maxLen;
    }

    public static boolean hasKElements(String s, int st, int ed, int k) {
        HashSet<Character> freq = new HashSet<>();
        for (int i = st; i <= ed; i++)
            freq.add(s.charAt(i));
        return freq.size() == k;
    }
}

// Target Min -> 3 , Max -> 5 (Quality Problems Only)
// 1. GFG. Longest Substring with K Uniques ✅
// 2. LC567. Permutation in String ✅