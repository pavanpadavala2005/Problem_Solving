public class Oct16 {
    // ! ============= LC2024. Maximize the Confusion of an Exam =============
    /*
    @ TC --> O(N + N)
    @ SC --> O(1) --> not using any Data Structure
    */
    public static int maxConsecutiveAnswers(String answerKey, int k) {
        int t = 0;
        int f = 0;
        int i = 0;
        int ans = Integer.MIN_VALUE;
        for (int j = 0; j < answerKey.length(); j++) {
            char right = answerKey.charAt(j);
            if (right == 'T')
                t++;
            else
                f++;

            while (j - i + 1 - (Math.max(f, t)) > k) {
                char left = answerKey.charAt(i);
                if (left == 'T')
                    t--;
                else
                    f--;
                i++;
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }

    // ! ============= GFG. Minimum Window Subsequence =============
    /*
    @ TC --> O(N + (M + N))  --> N for Outer Loop and (M + N [inner SubString]) for inner checking for SUBSEQUENCE
    @ SC --> O(1)
    */
    public static String minWindow(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int sIdx = 0;
        int minLen = Integer.MAX_VALUE;
        int i = 0;
        for (int j = 0; j < n; j++) {
            if (j - i + 1 < m)
                continue;
            while (isSubSequence(s2, s1.substring(i, j + 1))) {
                if (j - i + 1 < minLen) {
                    minLen = j - i + 1;
                    sIdx = i;
                }
                i++;
            }
        }
        if (minLen == Integer.MAX_VALUE)
            minLen = 0;
        return s1.substring(sIdx, sIdx + minLen);
    }

    /*
    @ TC --> O(N + M) --> at max we iterate throughout s1 and s2
    @ SC --> O(1)
    */
    public static boolean isSubSequence(String s1, String s2) {
        int i = 0;
        int j = 0;
        while (i < s1.length() && j < s2.length())
            if (s1.charAt(i) == s2.charAt(j++))
                i++;
        if (i < s1.length())
            return false;
        return true;
    }

    // ! ============= LC76. Minimum Window Substring =============
    /*
    @ TC --> O(M + N + N) --> M is Running once and after that j Loop is Running for N and inner while loop is not running for every j
    @ SC --> O(256)
    */
    public static String minWindowBetter(String s, String t) {
        int n = s.length();
        int[] map = new int[256];
        for (int i = 0; i < t.length(); i++)
            map[t.charAt(i)]++;

        int sIdx = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int i = 0;
        for (int j = 0; j < n; j++) {
            int right = s.charAt(j);
            if (map[right] > 0)
                count++;
            map[right]--;

            while (count >= t.length()) {
                if (j - i + 1 < minLen) {
                    sIdx = i;
                    minLen = Math.min(minLen, j - i + 1);
                }

                int left = s.charAt(i);
                map[left]++;
                if (map[left] > 0)
                    count--;
                i++;
            }
        }

        if (minLen == Integer.MAX_VALUE)
            minLen = 0;
        return s.substring(sIdx, sIdx + minLen);
    }

    /*
    @ TC --> O(N * (M + N)) --> inner we creating a Freq Array for Every and inner J loop 
    @ SC --> O(256)
    */

    public static String minWindowBrute(String s, String t) {
        int sIdx = 0;
        int minLen = Integer.MAX_VALUE;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int[] map = new int[256];
            int count = 0;
            for (int j = 0; j < t.length(); j++)
                map[t.charAt(j)]++;
            for (int j = i; j < n; j++) {
                if (map[s.charAt(j)] > 0)
                    count++;
                map[s.charAt(j)]--;
                if (count == t.length()) {
                    sIdx = i;
                    minLen = Math.min(minLen, j - i + 1);
                }
            }
        }
        if (minLen == Integer.MAX_VALUE)
            minLen = 0;
        return s.substring(sIdx, sIdx + minLen);
    }
}
// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC76. Minimum Window Substring ✅
// 2. GFG. Minimum Window Subsequence ✅
// 3. LC2024. Maximize the Confusion of an Exam ✅