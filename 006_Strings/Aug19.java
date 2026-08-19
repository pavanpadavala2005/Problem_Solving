import java.util.*;

public class Aug19 {
    // ! ============ LC5. Longest Palindromic Substring ==============
    public static String longestPalindromeOptimal(String s) {
        int n = s.length();
        if (n == 1)
            return s;
        int st = 0, ed = 0;
        for (int i = 0; i < n; i++) {
            int maxLen = Math.max(expand(s, i, i + 1), expand(s, i, i));
            if (maxLen > (ed - st)) {
                st = i - (maxLen - 1) / 2;
                ed = i + maxLen / 2;
            }
        }
        return s.substring(st, ed + 1);
    }

    public static int expand(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }

    public static String longestPalindromeBetter(String s) {
        if (s == null || s.length() <= 0)
            return "";
        int n = s.length();
        if (n == 1)
            return s;
        String res = "";
        StringBuilder sb = new StringBuilder();
        int j = 0;
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i));
            while (!isPalindromeHelper(sb.toString())) {
                sb.deleteCharAt(0);
            }
            res = sb.toString();
        }
        return res;
    }

    public static String longestPalindromeBrute(String s) {
        if (s == null || s.length() <= 0)
            return "";
        int n = s.length();
        if (n == 1)
            return s;
        String res = "";
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                StringBuilder sb = new StringBuilder();
                for (int k = i; k <= j; k++)
                    sb.append(s.charAt(k));
                if (isPalindromeHelper(sb.toString())) {
                    if (sb.length() > maxLen) {
                        maxLen = sb.length();
                        res = sb.toString();
                    }
                }
            }
        }
        return res;
    }

    // ! ============ Helper Function for LC5 ==============
    public static boolean isPalindromeHelper(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }

    // ! ============ LC125. Valid Palindrome ==============
    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (!isValid(s.charAt(i))) {
                i++;
                continue;
            } else if (!isValid(s.charAt(j))) {
                j--;
                continue;
            }
            if (getLower(s.charAt(i)) != getLower(s.charAt(j)))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static boolean isValid(char ch) {
        return (ch >= 'A' && ch <= 'Z') ||
                (ch >= 'a' && ch <= 'z') ||
                (ch >= '0' && ch <= '9');

    }

    public static char getLower(char ch) {
        if (ch >= '0' && ch <= '9')
            return ch;
        else if (ch >= 'a' && ch <= 'z')
            return ch;
        return (char) (ch + 32);
    }

    // ! ============ LC344. Reverse String ==============
    public static void reverseStringOptimal(char[] s) {
        int n = s.length;
        if (n <= 0)
            return;
        int i = 0, j = n - 1;
        while (i <= j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }

    }

    // ! ============ TUF. Count Number of Substrings ==============
    public static int countNumberOfSubstringsWithKCharacters(String s, int k) {
        return countNumberOfSubstringsWithKCharactersHelper(s, k) -
                countNumberOfSubstringsWithKCharactersHelper(s, k - 1);
    }

    public static int countNumberOfSubstringsWithKCharactersHelper(String s, int k) {
        if (k <= 0)
            return 0;
        int n = s.length();
        int count = 0;
        HashMap<Character, Integer> freq = new HashMap<>();
        int i = 0;
        for (int j = 0; j < n; j++) {
            freq.put(s.charAt(j), freq.getOrDefault(s.charAt(j), 0) + 1);
            while (freq.size() > k) {
                freq.put(s.charAt(i), freq.get(s.charAt(i)) - 1);
                if (freq.get(s.charAt(i)) == 0)
                    freq.remove(s.charAt(i));
                i++;
            }
            count += (j - i + 1);
        }
        return count;
    }

    // ! =========== ALREADY DONE IN AUG18 =========
    public static int countSubstringOptimal(String s) {
        int n = s.length();
        int count = 0;
        HashMap<Character, Integer> freq = new HashMap<>();
        int i = 0;
        for (int j = 0; j < n; j++) {
            freq.put(s.charAt(j), freq.getOrDefault(s.charAt(j), 0) + 1);
            while (freq.getOrDefault('a', 0) > 0 &&
                    freq.getOrDefault('a', 0) > 0 &&
                    freq.getOrDefault('a', 0) > 0) {
                count += (n - j);
                freq.put(s.charAt(i), freq.get(s.charAt(i)) - 1);
                if (freq.get(s.charAt(i)) == 0)
                    freq.remove(s.charAt(i));
                i++;
            }
        }
        return count;
    }

    public static int countSubstringBrute(String s) {
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            HashSet<Character> freq = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < s.length(); j++) {
                freq.add(s.charAt(j));
                if (freq.size() == 3) {
                    for (int k = i; k <= j; k++)
                        sb.append(s.charAt(k));
                    res.add(sb.toString());
                } else
                    sb.setLength(0);
            }
        }
        return res.size();
    }
}