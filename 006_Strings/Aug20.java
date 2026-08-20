import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Aug20 {
    // ! ============ LC438. Find All Anagrams in a String ==============
    public static List<Integer> findAnagramsOptimalV1(String s, String p) {
        ArrayList<Integer> res = new ArrayList<>();
        if (s.length() < p.length())
            return res;
        HashMap<Character, Integer> pMap = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < p.length(); i++)
            pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0) + 1);
        int left = 0, count = p.length();
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            sMap.put(rightChar, sMap.getOrDefault(rightChar, 0) + 1);
            if (pMap.containsKey(rightChar) && sMap.get(rightChar) <= pMap.get(rightChar))
                count--;
            while (right - left + 1 > p.length()) {
                char leftChar = s.charAt(left);
                sMap.put(leftChar, sMap.get(leftChar) - 1);
                if (pMap.containsKey(leftChar) && sMap.get(leftChar) < pMap.get(leftChar))
                    count++;
                left++;
            }
            if (count == 0)
                res.add(left);
        }
        return res;
    }

    public static List<Integer> findAnagramsOptimal(String s, String p) {
        if (s == null || s.length() == 0 || p == null || p.length() == 0)
            return new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0;
        int j = p.length() - 1;
        while (j < s.length()) {
            if (isAnagramModified(s, i, j, p))
                res.add(i);
            j++;
            i++;
        }
        return res;
    }

    public static boolean isAnagramModified(String s1, int left, int right, String s2) {
        if (right - left + 1 != s2.length())
            return false;
        int[] res = new int[26];
        for (int i = left; i <= right; i++) {
            res[s1.charAt(i) - 'a']++;
            res[s2.charAt(i - left) - 'a']--;
        }
        for (int i = 0; i < 26; i++)
            if (res[i] != 0)
                return false;
        return true;
    }

    // @ TC --> O(N*M) + O(M) -> Checking for ANAGRAM or not size of(p)
    // @ SC --> O(M) --> every time creating a (p) size Sub String
    public static List<Integer> findAnagramsBetter(String s, String p) {
        if (s == null || s.length() == 0 || p == null || p.length() == 0)
            return new ArrayList<>();
        int n = s.length();
        int m = p.length();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n - m + 1; i++) {
            if (isAnagram(s.substring(i, i + m), p))
                res.add(i);
        }
        return res;
    }

    // @ TC --> O(N*M) + O(2M) -> Checking for ANAGRAM or not size of(p)
    // @ SC --> O(M) --> every time creating a (p) size Sub String
    public static List<Integer> findAnagramsBrute(String s, String p) {
        if (s == null || s.length() == 0 || p == null || p.length() == 0)
            return new ArrayList<>();
        int n = s.length();
        int m = p.length();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n - m + 1; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < i + m; j++)
                sb.append(s.charAt(j));
            System.out.println(sb);
            if (isAnagram(sb.toString(), p))
                res.add(i);
        }
        return res;
    }

    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        if (s1.equals(s2))
            return true;
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

    // ! ============ LC647. Palindromic Substrings ==============
    public static int countSubstringsOtimalV2(String s) {
        int n = s.length();
        if (n == 1)
            return 1;
        int ctr = 0;
        for (int i = 0; i < n; i++)
            ctr += palindromicLength(s, i, i) + palindromicLength(s, i, i + 1);
        return ctr;
    }

    public static int palindromicLength(String s, int left, int right) {
        int ctr = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            ctr++;
            left--;
            right++;
        }
        return ctr;
    }

    public static int countSubstringsOtimal(String s) {
        // * This Wont Work (BAD APPROACH)
        int n = s.length();
        if (n == 1)
            return 1;
        int ctr = 0;
        int i = 0;
        for (int j = 0; j < n; j++) {
            while (!isPalindrome(s, i, j))
                i++;
            ctr += (j - i + 1);
        }
        return ctr;
    }

    // @ TC --> O(N ^ 2)
    // @ SC --> O(1) --> Not using Extra String
    public static int countSubstringsBetter(String s) {
        int n = s.length();
        if (n == 1)
            return 1;
        int ctr = 0;
        for (int i = 0; i < n; i++)
            for (int j = i; j < n; j++)
                if (isPalindrome(s, i, j))
                    ctr++;
        return ctr;
    }

    // @ TC --> O(N ^ 2)
    // @ SC --> O(N) --> Using a String Builder to Store Every String
    public static int countSubstringsBrute(String s) {
        int n = s.length();
        if (n == 1)
            return 1;
        int ctr = 0;
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < n; j++) {
                sb.append(s.charAt(j));
                if (isPalindrome(sb.toString()))
                    ctr++;
            }
        }
        return ctr;
    }

    // ! ============ LC680. Valid Palindrome II ==============
    // @ TC --> O(N)
    // @ SC --> O(1) --> Not using Extra Space
    public static boolean validPalindromeOptimal(String s) {
        int n = s.length();
        if (n == 1)
            return true;
        int i = 0;
        int j = n - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            i++;
            j--;
        }
        return true;
    }

    // @ TC --> O(N^2) --> Outer and Inner Loops
    // @ SC --> O(1) --> Done Using pointers
    public boolean validPalindromeBetter(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, i))
                return true;
        }
        return false;
    }

    // @ TC --> O(N^2)+O(N)
    // @ SC --> O(N) --> ultimately we are storing n-1 Chars
    public static boolean validPalindromeBrute(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                if (i != j)
                    sb.append(s.charAt(j));
            if (isPalindrome(sb.toString()))
                return true;
            sb.setLength(0);
        }
        return false;
    }

    public static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindrome(String s, int idx) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (i == idx) {
                i++;
                continue;
            } else if (j == idx) {
                j--;
                continue;
            }
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}

// Target Min0 -> 3 , Max -> 5 (Quality Problems Only)
// 1. LC647. Palindromic Substrings ✅
// 2. LC438. Find All Anagrams in a String